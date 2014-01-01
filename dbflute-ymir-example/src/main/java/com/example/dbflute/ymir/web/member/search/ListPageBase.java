package com.example.dbflute.ymir.web.member.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.seasar.ymir.Response;
import org.seasar.ymir.annotation.Meta;
import org.seasar.ymir.annotation.Metas;
import org.seasar.ymir.id.action.GetAction;
import org.seasar.ymir.id.action.PostAction;
import org.seasar.ymir.render.Selector;
import org.seasar.ymir.render.html.Select;
import org.seasar.ymir.response.PassthroughResponse;
import org.seasar.ymir.scope.annotation.Inject;
import org.seasar.ymir.scope.annotation.RequestParameter;

import com.example.dbflute.ymir.converter.member.search.MemberConverter;
import com.example.dbflute.ymir.dto.member.search.ConditionFormDto;
import com.example.dbflute.ymir.dto.member.search.MemberDto;
import com.example.dbflute.ymir.web.PageBase;

public class ListPageBase extends PageBase {
    public static final String PACKAGE = "com.example.dbflute.ymir.web.member.search";

    public static final String NAME = "list";

    public static final String PATH = "/member/search/list.html";

    public static final String P_current = "current";

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public static final String P_memberName = "memberName";

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public static final String P_purchaseProductName = "purchaseProductName";

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public static final String P_memberStatusCodeSelect$value = "memberStatusCodeSelect.value";

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public static final String P_unpaidSelector$selectedValues = "unpaidSelector.selectedValues";

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public static final String P_formalizedDateFrom = "formalizedDateFrom";

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public static final String P_formalizedDateTo = "formalizedDateTo";

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public static final String P_selectedId = "selectedId";

    @Meta(name = "bornOf", value = "request:/member/search/list.html")
    protected Integer current;

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "property", value = "conditionForm")})
    protected ConditionFormDto conditionForm = new ConditionFormDto();

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected List<MemberDto> memberItems = new ArrayList<MemberDto>();

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected String selectedId;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected MemberConverter memberConverter;

    @Meta(name = "bornOf", value = "request:/member/search/list.html")
    public Integer getCurrent() {
        return this.current;
    }

    @Meta(name = "bornOf", value = "request:/member/search/list.html")
    @RequestParameter
    public void setCurrent(Integer current) {
        this.current = current;
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    public String getMemberName() {
        return this.conditionForm.getMemberName();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    @RequestParameter
    public void setMemberName(String memberName) {
        this.conditionForm.setMemberName(memberName);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    public String getPurchaseProductName() {
        return this.conditionForm.getPurchaseProductName();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    @RequestParameter
    public void setPurchaseProductName(String purchaseProductName) {
        this.conditionForm.setPurchaseProductName(purchaseProductName);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    @RequestParameter
    public Select getMemberStatusCodeSelect() {
        return this.conditionForm.getMemberStatusCodeSelect();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    @RequestParameter
    public Selector getUnpaidSelector() {
        return this.conditionForm.getUnpaidSelector();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    public Date getFormalizedDateFrom() {
        return this.conditionForm.getFormalizedDateFrom();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    @RequestParameter
    public void setFormalizedDateFrom(Date formalizedDateFrom) {
        this.conditionForm.setFormalizedDateFrom(formalizedDateFrom);
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    public Date getFormalizedDateTo() {
        return this.conditionForm.getFormalizedDateTo();
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "formProperty", value = "conditionForm")})
    @RequestParameter
    public void setFormalizedDateTo(Date formalizedDateTo) {
        this.conditionForm.setFormalizedDateTo(formalizedDateTo);
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public List<MemberDto> getMemberItems() {
        return this.memberItems;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public String getSelectedId() {
        return this.selectedId;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    @RequestParameter
    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    @Inject
    public void setMemberConverter(MemberConverter memberConverter) {
        this.memberConverter = memberConverter;
    }

    public static interface _get extends GetAction {
        public static final String NAME = "_get";

        public static final String KEY = "";

        public static final Class<? extends GetAction> method = _get.class;
    }

    @Meta(name = "bornOf", value = {"/member/purchase/list.html", "/member/search/list.html"})
    public void _get() {

    }

    @Meta(name = "bornOf", value = {"/member/purchase/list.html", "/member/search/list.html"})
    public void _prerender() {

    }

    public static interface _get_paging extends GetAction {
        public static final String NAME = "_get_paging";

        public static final String KEY = "paging";

        public static final Class<? extends GetAction> method = _get_paging.class;
    }

    @Meta(name = "bornOf", value = "request:/member/search/list.html")
    public void _get_paging() {

    }

    public static interface _post_search extends PostAction {
        public static final String NAME = "_post_search";

        public static final String KEY = "search";

        public static final Class<? extends PostAction> method = _post_search.class;
    }

    @Metas({@Meta(name = "bornOf", value = "/member/search/list.html"), @Meta(name = "source", value = "return new PassthroughResponse();", classValue = PassthroughResponse.class)})
    public Response _post_search() {
        return new PassthroughResponse();
    }

    public static interface _get_edit extends GetAction {
        public static final String NAME = "_get_edit";

        public static final String KEY = "edit";

        public static final Class<? extends GetAction> method = _get_edit.class;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public Response _get_edit() {

        return null;
    }
}
