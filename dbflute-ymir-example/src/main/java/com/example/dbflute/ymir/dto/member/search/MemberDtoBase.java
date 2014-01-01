package com.example.dbflute.ymir.dto.member.search;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Date;

import org.seasar.ymir.annotation.Meta;

@Meta(name = "conversion", value = "com.example.dbflute.ymir.dbflute.exentity.Member")
public class MemberDtoBase
    implements Serializable {
    private static final long serialVersionUID = 1L;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected String memberId;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected String memberName;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected String memberStatusName;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected Date formalizedDatetime;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected Date updateDatetime;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected boolean editable;

    @Meta(name = "bornOf", value = "/member/search/list.html")
    protected boolean purchaseLinkVisible;


    public MemberDtoBase() {
    }

    public MemberDtoBase(boolean editable, Date formalizedDatetime, String memberId, String memberName, String memberStatusName, boolean purchaseLinkVisible, Date updateDatetime) {
        this.editable = editable;
        this.formalizedDatetime = formalizedDatetime;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberStatusName = memberStatusName;
        this.purchaseLinkVisible = purchaseLinkVisible;
        this.updateDatetime = updateDatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append('(');
        append(sb.append("memberId="), memberId).append(", ");
        append(sb.append("memberName="), memberName).append(", ");
        append(sb.append("memberStatusName="), memberStatusName).append(", ");
        append(sb.append("formalizedDatetime="), formalizedDatetime).append(", ");
        append(sb.append("updateDatetime="), updateDatetime).append(", ");
        append(sb.append("editable="), editable).append(", ");
        append(sb.append("purchaseLinkVisible="), purchaseLinkVisible);
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

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public String getMemberId() {
        return this.memberId;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setMemberId(String memberId) {
        this.memberId = memberId;
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
    public String getMemberStatusName() {
        return this.memberStatusName;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setMemberStatusName(String memberStatusName) {
        this.memberStatusName = memberStatusName;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public Date getFormalizedDatetime() {
        return this.formalizedDatetime;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setFormalizedDatetime(Date formalizedDatetime) {
        this.formalizedDatetime = formalizedDatetime;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public Date getUpdateDatetime() {
        return this.updateDatetime;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public boolean isEditable() {
        return this.editable;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public boolean isPurchaseLinkVisible() {
        return this.purchaseLinkVisible;
    }

    @Meta(name = "bornOf", value = "/member/search/list.html")
    public void setPurchaseLinkVisible(boolean purchaseLinkVisible) {
        this.purchaseLinkVisible = purchaseLinkVisible;
    }
}
