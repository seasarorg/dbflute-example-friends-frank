package com.example.dbflute.ymir.web.member.edit;

import java.util.Date;

import org.seasar.ymir.Response;
import org.seasar.ymir.annotation.Meta;
import org.seasar.ymir.annotation.Metas;
import org.seasar.ymir.conversation.annotation.Begin;
import org.seasar.ymir.id.action.GetAction;
import org.seasar.ymir.id.action.PostAction;
import org.seasar.ymir.render.html.Select;
import org.seasar.ymir.response.PassthroughResponse;
import org.seasar.ymir.scope.annotation.Inject;
import org.seasar.ymir.scope.annotation.RequestParameter;

import com.example.dbflute.ymir.converter.member.edit.InputFormConverter;
import com.example.dbflute.ymir.dto.member.edit.InputFormDto;
import com.example.dbflute.ymir.web.PageBase;

public class InputPageBase extends PageBase {
    public static final String PACKAGE = "com.example.dbflute.ymir.web.member.edit";

    public static final String NAME = "input";

    public static final String PATH = "/member/edit/input.html";

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public static final String P_memberId = "memberId";

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public static final String P_memberName = "memberName";

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public static final String P_memberAccount = "memberAccount";

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public static final String P_birthdate = "birthdate";

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public static final String P_memberStatusCodeSelect$value = "memberStatusCodeSelect.value";

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public static final String P_formalizedDatetime = "formalizedDatetime";

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public static final String P_latestLoginDatetime = "latestLoginDatetime";

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public static final String P_updateDatetime = "updateDatetime";

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public static final String P_versionNo = "versionNo";

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "property", value = "inputForm")})
    protected InputFormDto inputForm = new InputFormDto();

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    protected boolean updated;

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    protected InputFormConverter inputFormConverter;

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    public Integer getMemberId() {
        return this.inputForm.getMemberId();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    @RequestParameter
    public void setMemberId(Integer memberId) {
        this.inputForm.setMemberId(memberId);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    public String getMemberName() {
        return this.inputForm.getMemberName();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    @RequestParameter
    public void setMemberName(String memberName) {
        this.inputForm.setMemberName(memberName);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    public String getMemberAccount() {
        return this.inputForm.getMemberAccount();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    @RequestParameter
    public void setMemberAccount(String memberAccount) {
        this.inputForm.setMemberAccount(memberAccount);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    public Date getBirthdate() {
        return this.inputForm.getBirthdate();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    @RequestParameter
    public void setBirthdate(Date birthdate) {
        this.inputForm.setBirthdate(birthdate);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    @RequestParameter
    public Select getMemberStatusCodeSelect() {
        return this.inputForm.getMemberStatusCodeSelect();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    public Date getFormalizedDatetime() {
        return this.inputForm.getFormalizedDatetime();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    @RequestParameter
    public void setFormalizedDatetime(Date formalizedDatetime) {
        this.inputForm.setFormalizedDatetime(formalizedDatetime);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    public Date getLatestLoginDatetime() {
        return this.inputForm.getLatestLoginDatetime();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    @RequestParameter
    public void setLatestLoginDatetime(Date latestLoginDatetime) {
        this.inputForm.setLatestLoginDatetime(latestLoginDatetime);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    public Date getUpdateDatetime() {
        return this.inputForm.getUpdateDatetime();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    @RequestParameter
    public void setUpdateDatetime(Date updateDatetime) {
        this.inputForm.setUpdateDatetime(updateDatetime);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    public Integer getVersionNo() {
        return this.inputForm.getVersionNo();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "formProperty", value = "inputForm")})
    @RequestParameter
    public void setVersionNo(Integer versionNo) {
        this.inputForm.setVersionNo(versionNo);
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public boolean isUpdated() {
        return this.updated;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    @Inject
    public void setInputFormConverter(InputFormConverter inputFormConverter) {
        this.inputFormConverter = inputFormConverter;
    }

    public static interface _get_retry extends GetAction {
        public static final String NAME = "_get_retry";

        public static final String KEY = "retry";

        public static final Class<? extends GetAction> method = _get_retry.class;
    }

    @Meta(name = "bornOf", value = "request:/member/edit/input.html")
    public void _get_retry() {

    }

    public static interface _post_research extends PostAction {
        public static final String NAME = "_post_research";

        public static final String KEY = "research";

        public static final Class<? extends PostAction> method = _post_research.class;
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "source", value = "return new PassthroughResponse();", classValue = PassthroughResponse.class)})
    public Response _post_research() {
        return new PassthroughResponse();
    }

    public static interface _post_confirm extends PostAction {
        public static final String NAME = "_post_confirm";

        public static final String KEY = "confirm";

        public static final Class<? extends PostAction> method = _post_confirm.class;
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "source", value = "return new PassthroughResponse();", classValue = PassthroughResponse.class)})
    public Response _post_confirm() {
        return new PassthroughResponse();
    }

    public static interface _post_back extends PostAction {
        public static final String NAME = "_post_back";

        public static final String KEY = "back";

        public static final Class<? extends PostAction> method = _post_back.class;
    }

    @Metas({@Meta(name = "bornOf", value = "/member/edit/input.html"), @Meta(name = "source", value = "return new PassthroughResponse();", classValue = PassthroughResponse.class)})
    public Response _post_back() {
        return new PassthroughResponse();
    }

    public static interface _get extends GetAction {
        public static final String NAME = "_get";

        public static final String KEY = "";

        public static final Class<? extends GetAction> method = _get.class;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    @Begin
    public void _get() {

    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public void _prerender() {

    }
}
