package com.example.dbflute.ymir.dto.member.purchase;

import java.io.Serializable;
import java.lang.reflect.Array;

import org.seasar.ymir.annotation.Meta;

@Meta(name = "conversion", value = "com.example.dbflute.ymir.dbflute.exentity.Purchase")
public class PurchaseDtoBase
    implements Serializable {
    private static final long serialVersionUID = 1L;

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    protected String purchaseDatetime;

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    protected String productName;

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    protected String purchasePrice;

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    protected String purchaseCount;

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    protected boolean isPaymentComplete;

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    protected String purchaseId;


    public PurchaseDtoBase() {
    }

    public PurchaseDtoBase(boolean isPaymentComplete, String productName, String purchaseCount, String purchaseDatetime, String purchaseId, String purchasePrice) {
        this.isPaymentComplete = isPaymentComplete;
        this.productName = productName;
        this.purchaseCount = purchaseCount;
        this.purchaseDatetime = purchaseDatetime;
        this.purchaseId = purchaseId;
        this.purchasePrice = purchasePrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append('(');
        append(sb.append("purchaseDatetime="), purchaseDatetime).append(", ");
        append(sb.append("productName="), productName).append(", ");
        append(sb.append("purchasePrice="), purchasePrice).append(", ");
        append(sb.append("purchaseCount="), purchaseCount).append(", ");
        append(sb.append("isPaymentComplete="), isPaymentComplete).append(", ");
        append(sb.append("purchaseId="), purchaseId);
        sb.append(')');
        return toString(sb);
    }

    protected StringBuilder append(StringBuilder sb, Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            sb.append('{');
            int len = Array.getLength(obj);
            String delim = "";
            for (int i = 0; i < len; i++) {
                sb.append(delim);
                delim = ", ";
                append(sb, Array.get(obj, i));
            }
            sb.append('}');
        } else {
            sb.append(obj);
        }
        return sb;
    }

    protected String toString(StringBuilder sb) {
        return sb.toString();
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public String getPurchaseDatetime() {
        return this.purchaseDatetime;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public void setPurchaseDatetime(String purchaseDatetime) {
        this.purchaseDatetime = purchaseDatetime;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public String getProductName() {
        return this.productName;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public String getPurchasePrice() {
        return this.purchasePrice;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public String getPurchaseCount() {
        return this.purchaseCount;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public void setPurchaseCount(String purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public boolean isIsPaymentComplete() {
        return this.isPaymentComplete;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public void setIsPaymentComplete(boolean isPaymentComplete) {
        this.isPaymentComplete = isPaymentComplete;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public String getPurchaseId() {
        return this.purchaseId;
    }

    @Meta(name = "bornOf", value = "/member/purchase/list.html")
    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }
}
