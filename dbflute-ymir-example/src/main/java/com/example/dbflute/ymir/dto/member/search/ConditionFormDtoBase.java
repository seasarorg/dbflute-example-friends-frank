package com.example.dbflute.ymir.dto.member.search;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Date;

import org.seasar.ymir.annotation.Meta;
import org.seasar.ymir.render.Selector;
import org.seasar.ymir.render.html.Select;

public class ConditionFormDtoBase
    implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String memberTestName;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected String memberName;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected String purchaseProductName;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected Select memberStatusCodeSelect = new Select();

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected Selector unpaidSelector = new Selector();

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected Date formalizedDateFrom;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected Date formalizedDateTo;


    public ConditionFormDtoBase() {
    }

    public ConditionFormDtoBase(Date formalizedDateFrom, Date formalizedDateTo, String memberName, Select memberStatusCodeSelect, String memberTestName, String purchaseProductName, Selector unpaidSelector) {
        this.formalizedDateFrom = formalizedDateFrom;
        this.formalizedDateTo = formalizedDateTo;
        this.memberName = memberName;
        this.memberStatusCodeSelect = memberStatusCodeSelect;
        this.memberTestName = memberTestName;
        this.purchaseProductName = purchaseProductName;
        this.unpaidSelector = unpaidSelector;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append('(');
        append(sb.append("memberTestName="), memberTestName).append(", ");
        append(sb.append("memberName="), memberName).append(", ");
        append(sb.append("purchaseProductName="), purchaseProductName).append(", ");
        append(sb.append("memberStatusCodeSelect="), memberStatusCodeSelect).append(", ");
        append(sb.append("unpaidSelector="), unpaidSelector).append(", ");
        append(sb.append("formalizedDateFrom="), formalizedDateFrom).append(", ");
        append(sb.append("formalizedDateTo="), formalizedDateTo);
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

    public String getMemberTestName() {
        return this.memberTestName;
    }

    public void setMemberTestName(String memberTestName) {
        this.memberTestName = memberTestName;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public String getMemberName() {
        return this.memberName;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public String getPurchaseProductName() {
        return this.purchaseProductName;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setPurchaseProductName(String purchaseProductName) {
        this.purchaseProductName = purchaseProductName;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public Select getMemberStatusCodeSelect() {
        return this.memberStatusCodeSelect;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public Selector getUnpaidSelector() {
        return this.unpaidSelector;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public Date getFormalizedDateFrom() {
        return this.formalizedDateFrom;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setFormalizedDateFrom(Date formalizedDateFrom) {
        this.formalizedDateFrom = formalizedDateFrom;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public Date getFormalizedDateTo() {
        return this.formalizedDateTo;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setFormalizedDateTo(Date formalizedDateTo) {
        this.formalizedDateTo = formalizedDateTo;
    }
}
