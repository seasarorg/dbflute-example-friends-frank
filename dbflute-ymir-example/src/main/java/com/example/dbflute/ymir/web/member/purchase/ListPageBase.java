package com.example.dbflute.ymir.web.member.purchase;

import java.util.ArrayList;
import java.util.List;

import org.seasar.ymir.Response;
import org.seasar.ymir.annotation.Meta;
import org.seasar.ymir.annotation.Metas;
import org.seasar.ymir.constraint.PermissionDeniedException;
import org.seasar.ymir.conversation.annotation.Begin;
import org.seasar.ymir.id.action.GetAction;
import org.seasar.ymir.id.action.PostAction;
import org.seasar.ymir.message.Notes;
import org.seasar.ymir.response.PassthroughResponse;
import org.seasar.ymir.scope.annotation.Inject;
import org.seasar.ymir.scope.annotation.RequestParameter;

import com.example.dbflute.ymir.converter.member.purchase.PurchaseConverter;
import com.example.dbflute.ymir.dto.member.purchase.PurchaseDto;
import com.example.dbflute.ymir.web.PageBase;

public class ListPageBase extends PageBase {
    public static final String PACKAGE = "com.example.dbflute.ymir.web.member.purchase";

    public static final String NAME = "list";

    public static final String PATH = "/member/purchase/list.html";

    @Meta(name = "bornOf", value = {"/member/purchase/list.html", "/member/search/list.html"})
    public static final String P_memberId = "memberId";

    @Meta(name = "bornOf", value = {"/member/purchase/list.html", "/member/search/list.html"})
    protected Integer memberId;

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    protected String memberName;

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    protected PurchaseConverter purchaseConverter;

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    protected List<PurchaseDto> purchaseItems = new ArrayList<PurchaseDto>();

    @Meta(name = "bornOf", value = {"/member/purchase/list.html", "/member/search/list.html"})
    public Integer getMemberId() {
        return this.memberId;
    }

    @Meta(name = "bornOf", value = {"/member/purchase/list.html", "/member/search/list.html"})
    @RequestParameter
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public String getMemberName() {
        return this.memberName;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    @Inject
    public void setPurchaseConverter(PurchaseConverter purchaseConverter) {
        this.purchaseConverter = purchaseConverter;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public List<PurchaseDto> getPurchaseItems() {
        return this.purchaseItems;
    }

    public static interface _get extends GetAction {
        public static final String NAME = "_get";

        public static final String KEY = "";

        public static final Class<? extends GetAction> method = _get.class;
    }

    @Metas({@Meta(name = "bornOf", value = {"/member/purchase/list.html", "/member/search/list.html"}), @Meta(name = "source", value = "return new org.seasar.ymir.response.PassthroughResponse();")})
    public Response _get() {
        return new org.seasar.ymir.response.PassthroughResponse();
    }

    @Meta(name = "bornOf", value = {"/member/purchase/list.html", "/member/search/list.html"})
    public void _prerender() {

    }

    @Meta(name = "source", value = {"throw ex;", "ex"})
    @Begin
    public void _permissionDenied(PermissionDeniedException ex)
        throws PermissionDeniedException {
        throw ex;
    }

    public static interface _post_delete extends PostAction {
        public static final String NAME = "_post_delete";

        public static final String KEY = "delete[0]";

        public static final Class<? extends PostAction> method = _post_delete.class;
    }

    @Metas({@Meta(name = "bornOf", value = "/member/purchase/list.html"), @Meta(name = "source", value = {"return new PassthroughResponse();", "index"}, classValue = PassthroughResponse.class)})
    public Response _post_delete(int index) {
        return new PassthroughResponse();
    }

    @Meta(name = "source", value = {"", "notes"})
    public void _validationFailed(Notes notes) {
        
    }
}
