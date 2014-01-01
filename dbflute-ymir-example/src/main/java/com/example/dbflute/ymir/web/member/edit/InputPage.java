package com.example.dbflute.ymir.web.member.edit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.exception.EntityAlreadyDeletedException;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.ymir.Response;
import org.seasar.ymir.constraint.ConstraintType;
import org.seasar.ymir.constraint.annotation.Datetime;
import org.seasar.ymir.constraint.annotation.Length;
import org.seasar.ymir.constraint.annotation.Lengths;
import org.seasar.ymir.constraint.annotation.Required;
import org.seasar.ymir.constraint.annotation.SuppressConstraints;
import org.seasar.ymir.conversation.IllegalTransitionRuntimeException;
import org.seasar.ymir.conversation.annotation.Begin;
import org.seasar.ymir.conversation.annotation.Conversation;
import org.seasar.ymir.conversation.annotation.End;
import org.seasar.ymir.conversation.impl.ConversationScope;
import org.seasar.ymir.handler.annotation.ExceptionHandler;
import org.seasar.ymir.render.html.Option;
import org.seasar.ymir.render.html.Select;
import org.seasar.ymir.scope.annotation.In;
import org.seasar.ymir.scope.annotation.Out;

import com.example.dbflute.ymir.dbflute.cbean.MemberCB;
import com.example.dbflute.ymir.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.ymir.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.ymir.dbflute.exbhv.MemberBhv;
import com.example.dbflute.ymir.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.ymir.dbflute.exentity.Member;
import com.example.dbflute.ymir.dbflute.exentity.MemberStatus;
import com.example.dbflute.ymir.dto.member.edit.InputFormDto;
import com.example.dbflute.ymir.ymir.util.Proceed;
import com.example.dbflute.ymir.ymir.util.Redirect;

/**
 * @author moon51
 * @author jflute
 * @since 0.9.0 (2009/01/24 Saturday)
 */
@Conversation(name = InputPage.PACKAGE, phase = InputPage.NAME, followAfter = { ConfirmPage.NAME })
public class InputPage extends InputPageBase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                              Behavior
    //                                              --------
    @Binding(bindingType = BindingType.MUST)
    protected MemberBhv memberBhv;

    @Binding(bindingType = BindingType.MUST)
    protected MemberStatusBhv memberStatusBhv;

    // ===================================================================================
    //                                                                                 Get
    //                                                                                 ===
    @Override
    @Begin
    public void _get() {
        if (getMemberId() == null) {
            String msg = "The member ID should be required in get-parameter at " + getClass();
            throw new IllegalTransitionRuntimeException(msg);
        }
        setupInputFormBySelect();
    }

    /**
     * This method was implemented by manual(not generated) 
     * because the identity 'updated' is specified on Java Program.
     * {Proceed.to(..., "updated", "") in ConfirmPage.handle()}
     */
    public void _get_updated() { // mainly from confirm page when the entity have been already updated.
        updated = true;
    }

    /**
     * This method was implemented by manual(not generated) 
     * because the identity 'deleted' is specified on Java Program.
     * {Proceed.to(..., "deleted", "") in InputPage.handle()}
     */
    public void _get_deleted() { // mainly from self page when the entity have been already deleted.
        updated = true; // It's a simplistic approach that is the same action as updated.
    }

    // ===================================================================================
    //                                                                                Post
    //                                                                                ====
    @Override
    @Required(value = { P_memberName // 
            , P_memberAccount //
            , P_memberStatusCodeSelect$value //
    })
    @Lengths( { @Length(property = P_memberName, max = 50) //
            , @Length(property = P_memberAccount, max = 50) //
            , @Length(property = P_memberStatusCodeSelect$value, min = 3, max = 3) //
    })
    public Response _post_confirm() {
        return Redirect.to(ConfirmPage.class);
    }

    @Override
    @SuppressConstraints(ConstraintType.VALIDATION)
    @End
    public Response _post_back() {
        // It goes to the 'reenter' page actually.
        // Because this is the end point of conversation.
        return Redirect.to("/index.html"); // It's default result.
    }

    @Override
    public Response _post_research() {
        updated = false;
        setupInputFormBySelect();
        return super._post_research();
    }

    // ===================================================================================
    //                                                                          Pre-render
    //                                                                          ==========
    @Override
    public void _prerender() {
        setupMemberStatusCodeSelect();
    }

    // ===================================================================================
    //                                                                  Exception Handling
    //                                                                  ==================
    @ExceptionHandler(EntityAlreadyDeletedException.class)
    public Response handle(EntityAlreadyDeletedException handled) {
        addNote("error.entityAlreadyDeleted");
        return Proceed.to(InputPage.class, new Object[] { "deleted" });
    }

    // ===================================================================================
    //                                                                               Logic
    //                                                                               =====
    // -----------------------------------------------------
    //                                                 Logic
    //                                                 -----
    protected void setupInputFormBySelect() {
        Member member = selectMember();
        if (member.isMemberStatusCodeWithdrawal()) {
            String msg = "The edited member should not be withdrawal: " + getMemberId();
            throw new IllegalTransitionRuntimeException(msg);
        }
        inputForm = inputFormConverter.copyEntityToDto(member, new InputFormDto());
    }

    /**
     * Select the corresponding member.
     * @return The entity of member. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted.
     */
    protected Member selectMember() {
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(getMemberId());

        // (Specify)DerivedRefererの機能により最終ログイン日時（会員テーブルの
        // 子テーブルの会員ログインテーブルよりログイン日時の最大値）を取得する。
        cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
            }
        }, Member.LATEST_LOGIN_DATETIME);

        return memberBhv.selectEntityWithDeletedCheck(cb);
    }

    protected void setupMemberStatusCodeSelect() {
        Select select = getMemberStatusCodeSelect();
        if (select.getOptions() != null) { // when conversation scope has this
            return;
        }

        // 【会員ステータスのリストボックス構築】
        // Value = 会員ステータスコード
        // Label = 会員ステータス名
        // ※ここでは取得カラムを明示的に指定(限定)している。{specify()}
        MemberStatusCB cb = new MemberStatusCB();
        cb.specify().columnMemberStatusCode();
        cb.specify().columnMemberStatusName();
        cb.query().addOrderBy_DisplayOrder_Asc();
        List<MemberStatus> memberStatusList = memberStatusBhv.selectList(cb);

        List<Option> optionList = new ArrayList<Option>();
        for (MemberStatus entity : memberStatusList) {
            optionList.add(new Option(entity.getMemberStatusCode(), entity.getMemberStatusName()));
        }
        select.setOptions(optionList);

        // ※他のところでも同じロジックがあるがExampleなので特に共通化はしていない
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    // -----------------------------------------------------
    //                                        for Constraint
    //                                        --------------
    @Override
    @Datetime(FMT_slash_yyyyMMdd)
    public void setBirthdate(Date birthdate) {
        super.setBirthdate(birthdate);
    }

    // -----------------------------------------------------
    //                                      for Conversation
    //                                      ----------------
    @In(scopeClass = ConversationScope.class)
    public void setInputForm(InputFormDto inputForm) {
        this.inputForm = inputForm;
    }

    @Out(scopeClass = ConversationScope.class)
    public InputFormDto getInputForm() {
        return this.inputForm;
    }
}
