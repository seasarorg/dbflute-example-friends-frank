package com.example.dbflute.ymir.web.member.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.ymir.Response;
import org.seasar.ymir.annotation.Bool;
import org.seasar.ymir.annotation.Include;
import org.seasar.ymir.constraint.annotation.Datetime;
import org.seasar.ymir.constraint.annotation.Numeric;
import org.seasar.ymir.conversation.annotation.Begin;
import org.seasar.ymir.conversation.annotation.BeginSubConversation;
import org.seasar.ymir.conversation.annotation.Conversation;
import org.seasar.ymir.conversation.impl.ConversationScope;
import org.seasar.ymir.render.Selector;
import org.seasar.ymir.render.html.Option;
import org.seasar.ymir.render.html.Select;
import org.seasar.ymir.scope.annotation.In;
import org.seasar.ymir.scope.annotation.Out;

import com.example.dbflute.ymir.dbflute.cbean.MemberCB;
import com.example.dbflute.ymir.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.ymir.dbflute.cbean.PurchaseCB;
import com.example.dbflute.ymir.dbflute.exbhv.MemberBhv;
import com.example.dbflute.ymir.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.ymir.dbflute.exentity.Member;
import com.example.dbflute.ymir.dbflute.exentity.MemberStatus;
import com.example.dbflute.ymir.dto.member.search.ConditionFormDto;
import com.example.dbflute.ymir.dto.member.search.UnpaidCandidateDto;
import com.example.dbflute.ymir.web.included.PagingNaviPage;
import com.example.dbflute.ymir.web.member.edit.InputPage;
import com.example.dbflute.ymir.ymir.util.Redirect;

/**
 * @author moon51
 * @author jflute
 * @since 0.9.0 (2009/01/24 Saturday)
 */
@Include(PagingNaviPage.class)
@Conversation(name = ListPage.PACKAGE, phase = ListPage.NAME, acceptBrowsersBackButton = Bool.TRUE)
public class ListPage extends ListPageBase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                              Included
    //                                              --------
    @Binding(bindingType = BindingType.MUST)
    protected PagingNaviPage pagingNaviPage;

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
    }

    @Override
    public void _get_paging() { // for Paging Search
        if (current != null) {
            doSelect();
        }
    }

    @Override
    @BeginSubConversation(reenter = SCHEME_REDIRECT + PATH + PARAM_PAGING)
    public Response _get_edit() {
        return Redirect.to(InputPage.class, InputPage.P_memberId, selectedId);
    }

    // ===================================================================================
    //                                                                                Post
    //                                                                                ====
    @Override
    public Response _post_search() {
        current = 1; // Set the first page number.
        doSelect();
        return super._post_search();
    }

    // ===================================================================================
    //                                                                          Pre-render
    //                                                                          ==========
    @Override
    public void _prerender() {
        setupMemberStatusSelect();
        setupUnpaidSelector();
    }

    // ===================================================================================
    //                                                                              Set up
    //                                                                              ======
    protected void doSelect() {
        PagingResultBean<Member> pagingResult = selectMember();
        setupMemberItems(pagingResult);

        // The paging result is passed to the included page. 
        pagingNaviPage.setPagingResult(pagingResult);
    }

    protected void setupMemberItems(PagingResultBean<Member> pagingResult) {
        memberItems = memberConverter.toDtoList(pagingResult);
    }

    // ===================================================================================
    //                                                                               Logic
    //                                                                               =====
    /**
     * Select member as paging result.
     * @return The result bean of paging. (NotNull)
     */
    protected PagingResultBean<Member> selectMember() {
        MemberCB cb = new MemberCB();

        // 【関連テーブルの取得】
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberWithdrawalAsOne().withWithdrawalReason();

        // 【会員名の中間一致】
        cb.query().setMemberName_LikeSearch(getMemberName(), new LikeSearchOption().likeContain().escapeByPipeLine());

        // 【購入商品名の中間一致 & 未払いの有無】
        final String purchaseProductName = getPurchaseProductName();
        final boolean unpaid = Boolean.valueOf(getUnpaidSelector().getSelectedValue());
        if ((purchaseProductName != null && purchaseProductName.length() > 0) || unpaid) {
            cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
                public void query(PurchaseCB subCB) {
                    LikeSearchOption option = new LikeSearchOption().likeContain().escapeByPipeLine();
                    subCB.query().queryProduct().setProductName_LikeSearch(purchaseProductName, option);
                    if (unpaid) {
                        subCB.query().setPaymentCompleteFlg_Equal_False();
                    }
                }
            });
        }

        // 【会員ステータスの絞込み】
        cb.query().setMemberStatusCode_Equal(getMemberStatusCodeSelect().getSelectedValue());

        // 【正式会員日時の日付範囲】
        cb.query().setFormalizedDatetime_DateFromTo(getFormalizedDateFrom(), getFormalizedDateTo());

        // 【会員の購入履歴の数（子テーブルの集計）】
        // (Specify)DerivedReferrerの機能を用いて、子テーブルである購入情報テーブルを集計
        cb.specify().derivedPurchaseList().count(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseId();
            }
        }, Member.COUNT_OF_PURCHASE);

        // 【並び順：更新日時の降順, 会員IDの昇順】
        cb.query().addOrderBy_UpdateDatetime_Desc();
        cb.query().addOrderBy_MemberId_Asc();

        // 【Paging条件】
        // Paging条件を設定する。
        // “1PageのSize”は、画面において固定である。
        // “検索対象Page番号”は、Parameterで取得した値を指定する。
        // Normally for example the value is 20 but here is example.
        int pageSize = 3; // It prefers to get the one from configuration actually.
        cb.paging(pageSize, current);

        // 【Paging検索】
        // Pagingの検索を実行する。
        // 
        // /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 【☆TIPS】
        // BehaviorのselectPageを利用することにより、以下の処理が一気に行われます。
        // 
        //   1. Paging条件無しの時の全件Record数の検索 → select count(*) from xxx
        //   2. Paging条件ありでの検索 → select ... from xxx limit 20 offset 40
        //   3. {1}と{2}の結果から総Page数や次Page存在判定などの計算
        // 
        // 検索から結果のHandlingまで全て自動生成されたBehaviorのMethod内にて解決されるため、
        // Application開発者がこの部分でBUGを発生させることはなくなります。
        // (特に{3}の処理は一般にBUGが発生しやすい領域である)
        // - - - - - - - - - -/
        return memberBhv.selectPage(cb);
    }

    protected void setupMemberStatusSelect() {
        Select memberStatusSelect = getMemberStatusCodeSelect();
        if (memberStatusSelect.getOptions() != null) { // when conversation scope has this
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
        memberStatusSelect.setOptions(optionList);

        // ※他のところでも同じロジックがあるがExampleなので特に共通化はしていない
    }

    protected void setupUnpaidSelector() {
        Selector unpaidSelector = getUnpaidSelector();
        if (unpaidSelector.getCandidates() != null) { // when conversation scope has this
            return;
        }

        List<UnpaidCandidateDto> candidateList = new ArrayList<UnpaidCandidateDto>();
        candidateList.add(createUnpaidCandidateDto(Boolean.FALSE, "条件なし"));
        candidateList.add(createUnpaidCandidateDto(Boolean.TRUE, "未払いあり"));
        unpaidSelector.setCandidateList(candidateList);
        if (unpaidSelector.getSelectedValue() == null) { // when initializing the form
            unpaidSelector.setSelectedValue(Boolean.FALSE.toString());
        }
    }

    protected UnpaidCandidateDto createUnpaidCandidateDto(Boolean value, String label) {
        UnpaidCandidateDto unpaidCandidateDto = new UnpaidCandidateDto();
        unpaidCandidateDto.setValue(value.toString());
        unpaidCandidateDto.setName(label);
        return unpaidCandidateDto;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    // -----------------------------------------------------
    //                                        for Constraint
    //                                        --------------
    @Override
    @Datetime(FMT_slash_yyyyMMdd)
    public void setFormalizedDateFrom(Date formalizedDateFrom) {
        super.setFormalizedDateFrom(formalizedDateFrom);
    }

    @Override
    @Datetime(FMT_slash_yyyyMMdd)
    public void setFormalizedDateTo(Date formalizedDateTo) {
        super.setFormalizedDateTo(formalizedDateTo);
    }

    // -----------------------------------------------------
    //                                      for Conversation
    //                                      ----------------
    @Override
    @Numeric
    @In(scopeClass = ConversationScope.class)
    public void setCurrent(Integer current) {
        super.setCurrent(current);
    }

    @Override
    @Out(scopeClass = ConversationScope.class)
    public Integer getCurrent() {
        return super.getCurrent();
    }

    @In(scopeClass = ConversationScope.class)
    public void setConditionForm(ConditionFormDto conditionForm) {
        this.conditionForm = conditionForm;
    }

    @Out(scopeClass = ConversationScope.class)
    public ConditionFormDto getConditionForm() {
        return conditionForm;
    }
}
