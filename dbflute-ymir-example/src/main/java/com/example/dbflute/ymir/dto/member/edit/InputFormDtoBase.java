package com.example.dbflute.ymir.dto.member.edit;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Date;

import org.seasar.ymir.annotation.Meta;
import org.seasar.ymir.render.html.Select;

@Meta(name = "conversion", value = "com.example.dbflute.ymir.dbflute.exentity.Member")
public class InputFormDtoBase
    implements Serializable {
    private static final long serialVersionUID = 1L;

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    protected Integer memberId;

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    protected String memberName;

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    protected String memberAccount;

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    protected Date birthdate;

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    protected Select memberStatusCodeSelect = new Select();

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    protected Date formalizedDatetime;

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    protected Date latestLoginDatetime;

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    protected Date updateDatetime;

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    protected Integer versionNo;


    public InputFormDtoBase() {
    }

    public InputFormDtoBase(Date birthdate, Date formalizedDatetime, Date latestLoginDatetime, String memberAccount, Integer memberId, String memberName, Select memberStatusCodeSelect, Date updateDatetime, Integer versionNo) {
        this.birthdate = birthdate;
        this.formalizedDatetime = formalizedDatetime;
        this.latestLoginDatetime = latestLoginDatetime;
        this.memberAccount = memberAccount;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberStatusCodeSelect = memberStatusCodeSelect;
        this.updateDatetime = updateDatetime;
        this.versionNo = versionNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append('(');
        append(sb.append("memberId="), memberId).append(", ");
        append(sb.append("memberName="), memberName).append(", ");
        append(sb.append("memberAccount="), memberAccount).append(", ");
        append(sb.append("birthdate="), birthdate).append(", ");
        append(sb.append("memberStatusCodeSelect="), memberStatusCodeSelect).append(", ");
        append(sb.append("formalizedDatetime="), formalizedDatetime).append(", ");
        append(sb.append("latestLoginDatetime="), latestLoginDatetime).append(", ");
        append(sb.append("updateDatetime="), updateDatetime).append(", ");
        append(sb.append("versionNo="), versionNo);
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

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    public Integer getMemberId() {
        return this.memberId;
    }

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    public String getMemberName() {
        return this.memberName;
    }

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    public String getMemberAccount() {
        return this.memberAccount;
    }

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    public Date getBirthdate() {
        return this.birthdate;
    }

    @Meta(name = "bornOf", value = {"/member/edit/confirm.html", "/member/edit/input.html"})
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public Select getMemberStatusCodeSelect() {
        return this.memberStatusCodeSelect;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public Date getFormalizedDatetime() {
        return this.formalizedDatetime;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public void setFormalizedDatetime(Date formalizedDatetime) {
        this.formalizedDatetime = formalizedDatetime;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public Date getLatestLoginDatetime() {
        return this.latestLoginDatetime;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public void setLatestLoginDatetime(Date latestLoginDatetime) {
        this.latestLoginDatetime = latestLoginDatetime;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public Date getUpdateDatetime() {
        return this.updateDatetime;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public Integer getVersionNo() {
        return this.versionNo;
    }

    @Meta(name = "bornOf", value = "/member/edit/input.html")
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
}
