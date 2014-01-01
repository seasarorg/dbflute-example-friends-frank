package com.example.dbflute.flex.simpleflute.dto.bs;

import java.io.Serializable;
import java.util.*;

import com.example.dbflute.flex.simpleflute.dto.*;

/**
 * The simple DTO of MEMBER_LOGIN as TABLE. <br />
 * 会員ログイン: ログインするたびに登録されるログイン履歴。<br />
 * 登録されたら更新されるも削除されることもない。さらには登録する人もプログラムもはっきりしているので、ここでは共通カラムは(紙面の都合上もあって)省略している。
 * <pre>
 * [primary-key]
 *     MEMBER_LOGIN_ID
 * 
 * [column]
 *     MEMBER_LOGIN_ID, MEMBER_ID, LOGIN_DATETIME, MOBILE_LOGIN_FLG, LOGIN_MEMBER_STATUS_CODE
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_LOGIN_ID
 * 
 * [version-no]
 *     
 * 
 * [foreign-table]
 *     MEMBER, MEMBER_STATUS
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, memberStatus
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberLoginDto implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _memberLoginId;

    /** MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER} */
    protected Integer _memberId;

    /** LOGIN_DATETIME: {UQ+, IX, NotNull, TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp _loginDatetime;

    /** MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} */
    protected Integer _mobileLoginFlg;

    /** LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS} */
    protected String _loginMemberStatusCode;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this DTO. */
    protected final Set<String> __modifiedProperties = new LinkedHashSet<String>();

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberLoginDto() {
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    protected MemberDto _member;

    public MemberDto getMember() {
        return _member;
    }

    public void setMember(MemberDto member) {
        this._member = member;
    }

    protected MemberStatusDto _memberStatus;

    public MemberStatusDto getMemberStatus() {
        return _memberStatus;
    }

    public void setMemberStatus(MemberStatusDto memberStatus) {
        this._memberStatus = memberStatus;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    public Set<String> modifiedProperties() {
        return __modifiedProperties;
    }

    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsMemberLoginDto)) { return false; }
        final BsMemberLoginDto otherEntity = (BsMemberLoginDto)other;
        if (!helpComparingValue(getMemberLoginId(), otherEntity.getMemberLoginId())) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    public int hashCode() {
        int result = 17;
        result = xCH(result, "MEMBER_LOGIN");
        result = xCH(result, getMemberLoginId());
        return result;
    }
    protected int xCH(int result, Object value) { // calculateHashcode()
        if (value == null) {
            return result;
        }
        return (31 * result) + (value instanceof byte[] ? ((byte[]) value).length : value.hashCode());
    }

    public int instanceHash() {
        return super.hashCode();
    }

    public String toString() {
        String c = ", ";
        StringBuilder sb = new StringBuilder();
        sb.append(c).append(getMemberLoginId());
        sb.append(c).append(getMemberId());
        sb.append(c).append(getLoginDatetime());
        sb.append(c).append(getMobileLoginFlg());
        sb.append(c).append(getLoginMemberStatusCode());
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * 会員ログインID:
     * @return The value of the column 'MEMBER_LOGIN_ID'. (NullAllowed)
     */
    public Long getMemberLoginId() {
        return _memberLoginId;
    }

    /**
     * [set] MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * 会員ログインID:
     * @param memberLoginId The value of the column 'MEMBER_LOGIN_ID'. (NullAllowed)
     */
    public void setMemberLoginId(Long memberLoginId) {
        __modifiedProperties.add("memberLoginId");
        this._memberLoginId = memberLoginId;
    }

    /**
     * [get] MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * 会員ID:
     * @return The value of the column 'MEMBER_ID'. (NullAllowed)
     */
    public Integer getMemberId() {
        return _memberId;
    }

    /**
     * [set] MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * 会員ID:
     * @param memberId The value of the column 'MEMBER_ID'. (NullAllowed)
     */
    public void setMemberId(Integer memberId) {
        __modifiedProperties.add("memberId");
        this._memberId = memberId;
    }

    /**
     * [get] LOGIN_DATETIME: {UQ+, IX, NotNull, TIMESTAMP(23, 10)} <br />
     * ログイン日時: ログインした瞬間の日時。
     * @return The value of the column 'LOGIN_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getLoginDatetime() {
        return _loginDatetime;
    }

    /**
     * [set] LOGIN_DATETIME: {UQ+, IX, NotNull, TIMESTAMP(23, 10)} <br />
     * ログイン日時: ログインした瞬間の日時。
     * @param loginDatetime The value of the column 'LOGIN_DATETIME'. (NullAllowed)
     */
    public void setLoginDatetime(java.sql.Timestamp loginDatetime) {
        __modifiedProperties.add("loginDatetime");
        this._loginDatetime = loginDatetime;
    }

    /**
     * [get] MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * モバイルログインフラグ: モバイル機器からのログインか否か。
     * @return The value of the column 'MOBILE_LOGIN_FLG'. (NullAllowed)
     */
    public Integer getMobileLoginFlg() {
        return _mobileLoginFlg;
    }

    /**
     * [set] MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * モバイルログインフラグ: モバイル機器からのログインか否か。
     * @param mobileLoginFlg The value of the column 'MOBILE_LOGIN_FLG'. (NullAllowed)
     */
    public void setMobileLoginFlg(Integer mobileLoginFlg) {
        __modifiedProperties.add("mobileLoginFlg");
        this._mobileLoginFlg = mobileLoginFlg;
    }

    /**
     * [get] LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS} <br />
     * ログイン会員ステータスコード: ログイン時の会員ステータス
     * @return The value of the column 'LOGIN_MEMBER_STATUS_CODE'. (NullAllowed)
     */
    public String getLoginMemberStatusCode() {
        return _loginMemberStatusCode;
    }

    /**
     * [set] LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS} <br />
     * ログイン会員ステータスコード: ログイン時の会員ステータス
     * @param loginMemberStatusCode The value of the column 'LOGIN_MEMBER_STATUS_CODE'. (NullAllowed)
     */
    public void setLoginMemberStatusCode(String loginMemberStatusCode) {
        __modifiedProperties.add("loginMemberStatusCode");
        this._loginMemberStatusCode = loginMemberStatusCode;
    }

}
