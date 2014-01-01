package com.example.dbflute.ymir.dto.member.edit;

import java.io.Serializable;

@org.seasar.ymir.annotation.Meta(name="conversion",value="com.example.dbflute.ymir.dbflute.exentity.MemberStatus")
public class MemberStatusDtoBase
    implements Serializable
{
    private static final long serialVersionUID = 1L;

    protected String memberStatusCode;

    protected String memberStatusName;


    public MemberStatusDtoBase()
    {
    }

    public MemberStatusDtoBase(String memberStatusCode, String memberStatusName)
    {
        this.memberStatusCode = memberStatusCode;
        this.memberStatusName = memberStatusName;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder().append('(');
        append(sb.append("memberStatusCode="), memberStatusCode).append(", ");
        append(sb.append("memberStatusName="), memberStatusName);
        sb.append(')');
        return toString(sb);
    }

    protected StringBuilder append(StringBuilder sb, Object obj)
    {
        if (obj != null && obj.getClass().isArray()) {
            sb.append('{');
            int len = java.lang.reflect.Array.getLength(obj);
            String delim = "";
            for (int i = 0; i < len; i++) {
                sb.append(delim);
                delim = ", ";
                append(sb, java.lang.reflect.Array.get(obj, i));
            }
            sb.append('}');
        } else {
            sb.append(obj);
        }
        return sb;
    }

    protected String toString(StringBuilder sb)
    {
        return sb.toString();
    }

    public String getMemberStatusCode()
    {
        return this.memberStatusCode;
    }

    public void setMemberStatusCode(String memberStatusCode)
    {
        this.memberStatusCode = memberStatusCode;
    }

    public String getMemberStatusName()
    {
        return this.memberStatusName;
    }

    public void setMemberStatusName(String memberStatusName)
    {
        this.memberStatusName = memberStatusName;
    }
}
