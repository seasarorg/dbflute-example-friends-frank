package com.example.dbflute.ymir.web.member.edit;

import org.seasar.ymir.Response;
import org.seasar.ymir.annotation.Meta;
import org.seasar.ymir.annotation.Metas;
import org.seasar.ymir.id.action.GetAction;
import org.seasar.ymir.id.action.PostAction;
import org.seasar.ymir.response.PassthroughResponse;
import org.seasar.ymir.scope.annotation.Inject;

import com.example.dbflute.ymir.converter.member.edit.InputFormConverter;
import com.example.dbflute.ymir.dto.member.edit.InputFormDto;
import com.example.dbflute.ymir.web.PageBase;

public class ConfirmPageBase extends PageBase {
    public static final String PACKAGE = "com.example.dbflute.ymir.web.member.edit";

    public static final String NAME = "confirm";

    public static final String PATH = "/member/edit/confirm.html";

    public static final String P_inputForm = "inputForm";

    public static final String P_memberStatusName = "memberStatusName";

    public static final String P_inputFormConverter = "inputFormConverter";

    @Meta(name = "bornOf", value = "/member/edit/confirm.html")
    protected InputFormDto inputForm = new InputFormDto();

    @Meta(name = "bornOf", value = "/member/edit/confirm.html")
    protected String memberStatusName;

    @Meta(name = "bornOf", value = "/member/edit/confirm.html")
    protected InputFormConverter inputFormConverter;

    @Meta(name = "bornOf", value = "/member/edit/confirm.html")
    public InputFormDto getInputForm() {
        return this.inputForm;
    }

    @Meta(name = "bornOf", value = "/member/edit/confirm.html")
    public String getMemberStatusName() {
        return this.memberStatusName;
    }

    @Meta(name = "bornOf", value = "/member/edit/confirm.html")
    @Inject
    public void setInputFormConverter(InputFormConverter inputFormConverter) {
        this.inputFormConverter = inputFormConverter;
    }

    public static interface _post_update extends PostAction {
        public static final String NAME = "_post_update";

        public static final String KEY = "update";

        public static final Class<? extends PostAction> method = _post_update.class;
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/confirm.html"), @Meta(name = "source", value = "return new PassthroughResponse();", classValue = PassthroughResponse.class)})
    public Response _post_update() {
        return new PassthroughResponse();
    }

    public static interface _post_back extends PostAction {
        public static final String NAME = "_post_back";

        public static final String KEY = "back";

        public static final Class<? extends PostAction> method = _post_back.class;
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/confirm.html"), @Meta(name = "source", value = "return new PassthroughResponse();", classValue = PassthroughResponse.class)})
    public Response _post_back() {
        return new PassthroughResponse();
    }

    public static interface _get extends GetAction {
        public static final String NAME = "_get";

        public static final String KEY = "";

        public static final Class<? extends GetAction> method = _get.class;
    }

    @Meta(name = "bornOf", value = "/member/edit/confirm.html")
    public void _get() {

    }

    @Meta(name = "bornOf", value = "/member/edit/confirm.html")
    public void _prerender() {

    }
}
