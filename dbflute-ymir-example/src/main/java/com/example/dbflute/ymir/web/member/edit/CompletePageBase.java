package com.example.dbflute.ymir.web.member.edit;

import org.seasar.ymir.annotation.Meta;
import org.seasar.ymir.constraint.PermissionDeniedException;
import org.seasar.ymir.conversation.annotation.Begin;
import org.seasar.ymir.id.action.GetAction;
import org.seasar.ymir.message.Notes;

import com.example.dbflute.ymir.web.PageBase;

public class CompletePageBase extends PageBase {
    public static final String PACKAGE = "com.example.dbflute.ymir.web.member.edit";

    public static final String NAME = "complete";

    public static final String PATH = "/member/edit/complete.html";

    @Meta(name = "source", value = {"throw ex;", "ex"})
    @Begin
    public void _permissionDenied(PermissionDeniedException ex)
        throws PermissionDeniedException {
        throw ex;
    }

    public void _post_list() {

    }

    @Meta(name = "source", value = {"", "notes"})
    public void _validationFailed(Notes notes) {
        
    }

    public static interface _get extends GetAction {
        public static final String NAME = "_get";

        public static final String KEY = "";

        public static final Class<? extends GetAction> method = _get.class;
    }

    @Meta(name = "bornOf", value = "/member/edit/complete.html")
    public void _get() {

    }

    @Meta(name = "bornOf", value = "/member/edit/complete.html")
    public void _prerender() {

    }
}
