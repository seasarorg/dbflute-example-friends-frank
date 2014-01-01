package com.example.dbflute.ymir.web.member.edit;

import org.seasar.ymir.conversation.annotation.Conversation;
import org.seasar.ymir.conversation.annotation.End;

/**
 * @author moon51
 * @author jflute
 * @since 0.9.0 (2009/01/24 Saturday)
 */
@Conversation(name = CompletePage.PACKAGE, phase = CompletePage.NAME, followAfter = { ConfirmPage.NAME })
public class CompletePage extends CompletePageBase {

    // ===================================================================================
    //                                                                                 Get
    //                                                                                 ===
    @End
    public String _get_list() {
        // It goes to the 'reenter' page actually.
        // Because this is the end point of conversation.
        return "/index.html"; // It's default result.
    }
}
