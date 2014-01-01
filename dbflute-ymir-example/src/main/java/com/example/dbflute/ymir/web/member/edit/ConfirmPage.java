package com.example.dbflute.ymir.web.member.edit;

import org.seasar.dbflute.exception.EntityAlreadyUpdatedException;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.ymir.Response;
import org.seasar.ymir.conversation.annotation.Conversation;
import org.seasar.ymir.conversation.impl.ConversationScope;
import org.seasar.ymir.handler.annotation.ExceptionHandler;
import org.seasar.ymir.scope.annotation.In;
import org.seasar.ymir.token.constraint.annotation.TokenRequired;

import com.example.dbflute.ymir.dbflute.exbhv.MemberBhv;
import com.example.dbflute.ymir.dbflute.exentity.Member;
import com.example.dbflute.ymir.dto.member.edit.InputFormDto;
import com.example.dbflute.ymir.ymir.util.Proceed;
import com.example.dbflute.ymir.ymir.util.Redirect;

/**
 * @author moon51
 * @author jflute
 * @since 0.9.0 (2009/01/24 Saturday)
 */
@Conversation(name = ConfirmPage.PACKAGE, phase = ConfirmPage.NAME, followAfter = InputPage.NAME)
public class ConfirmPage extends ConfirmPageBase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                              Behavior
    //                                              --------
    @Binding(bindingType = BindingType.MUST)
    protected MemberBhv memberBhv;

    // ===================================================================================
    //                                                                                 Get
    //                                                                                 ===
    @Override
    public void _get() {
        // Set up member status name from its select tag in conversation.
        memberStatusName = inputForm.getMemberStatusCodeSelect().getSelectedContent();
    }

    // ===================================================================================
    //                                                                                Post
    //                                                                                ====
    @Override
    @TokenRequired
    public Response _post_update() {
        Member member = inputFormConverter.copyDtoToEntity(inputForm, new Member());
        memberBhv.update(member); // with Optimistic Lock.
        return Redirect.to(CompletePage.class);
    }

    @Override
    public Response _post_back() {
        return Redirect.to(InputPage.class, "retry");
    }

    // ===================================================================================
    //                                                                  Exception Handling
    //                                                                  ==================
    @ExceptionHandler(EntityAlreadyUpdatedException.class)
    public Response handle(EntityAlreadyUpdatedException handled) {
        addNote("error.entityAlreadyUpdated");
        return Proceed.to(InputPage.class, new Object[] { "updated" });
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    // -----------------------------------------------------
    //                                      for Conversation
    //                                      ----------------
    @In(scopeClass = ConversationScope.class)
    public void setInputForm(InputFormDto inputForm) {
        this.inputForm = inputForm;
    }
}
