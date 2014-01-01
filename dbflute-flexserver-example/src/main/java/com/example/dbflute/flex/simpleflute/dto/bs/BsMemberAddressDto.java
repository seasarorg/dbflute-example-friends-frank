package com.example.dbflute.flex.simpleflute.dto.bs;

import java.io.Serializable;
import java.util.*;

import com.example.dbflute.flex.simpleflute.dto.*;

/**
 * The simple DTO of MEMBER_ADDRESS as TABLE. <br />
 * 会員住所情報: 会員の住所に関する情報で、同時に有効期間ごとに履歴管理されている。<br />
 * 会員を基点に考えた場合、構造的にはone-to-many だが、業務的な定型条件でone-to-one になる。このような構造を「業務的one-to-one」と呼ぶ。<br />
 * 有効期間は隙間なく埋められるが、ここでは住所情報のない会員も存在し、厳密には(業務的な) "1 : 0...1" である。
 * <pre>
 * [primary-key]
 *     MEMBER_ADDRESS_ID
 * 
 * [column]
 *     MEMBER_ADDRESS_ID, MEMBER_ID, VALID_BEGIN_DATE, VALID_END_DATE, ADDRESS, REGION_ID, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_ADDRESS_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER, REGION
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, region
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberAddressDto implements Serializable {

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
    /** MEMBER_ADDRESS_ID: {PK, ID, NotNull, INTEGER(10)} */
    protected Integer _memberAddressId;

    /** MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER} */
    protected Integer _memberId;

    /** VALID_BEGIN_DATE: {UQ+, NotNull, DATE(8)} */
    protected java.util.Date _validBeginDate;

    /** VALID_END_DATE: {NotNull, DATE(8)} */
    protected java.util.Date _validEndDate;

    /** ADDRESS: {NotNull, VARCHAR(200)} */
    protected String _address;

    /** REGION_ID: {IX, NotNull, INTEGER(10), FK to REGION} */
    protected Integer _regionId;

    /** REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp _registerDatetime;

    /** REGISTER_USER: {NotNull, VARCHAR(200)} */
    protected String _registerUser;

    /** UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp _updateDatetime;

    /** UPDATE_USER: {NotNull, VARCHAR(200)} */
    protected String _updateUser;

    /** VERSION_NO: {NotNull, BIGINT(19)} */
    protected Long _versionNo;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this DTO. */
    protected final Set<String> __modifiedProperties = new LinkedHashSet<String>();

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberAddressDto() {
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

    protected RegionDto _region;

    public RegionDto getRegion() {
        return _region;
    }

    public void setRegion(RegionDto region) {
        this._region = region;
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
        if (other == null || !(other instanceof BsMemberAddressDto)) { return false; }
        final BsMemberAddressDto otherEntity = (BsMemberAddressDto)other;
        if (!helpComparingValue(getMemberAddressId(), otherEntity.getMemberAddressId())) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    public int hashCode() {
        int result = 17;
        result = xCH(result, "MEMBER_ADDRESS");
        result = xCH(result, getMemberAddressId());
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
        sb.append(c).append(getMemberAddressId());
        sb.append(c).append(getMemberId());
        sb.append(c).append(xfUD(getValidBeginDate()));
        sb.append(c).append(xfUD(getValidEndDate()));
        sb.append(c).append(getAddress());
        sb.append(c).append(getRegionId());
        sb.append(c).append(getRegisterDatetime());
        sb.append(c).append(getRegisterUser());
        sb.append(c).append(getUpdateDatetime());
        sb.append(c).append(getUpdateUser());
        sb.append(c).append(getVersionNo());
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String xfUD(java.util.Date date) { // formatUtilDate()
        return date != null ? new java.text.SimpleDateFormat(xgDP()).format(date) : null;
    }
    protected String xgDP() { // getDatePattern
        return "yyyy-MM-dd";
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] MEMBER_ADDRESS_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     * 会員住所ID: 会員住所を識別するID。<br />
     * 履歴分も含むテーブルなので、これ自体はFKではない。
     * @return The value of the column 'MEMBER_ADDRESS_ID'. (NullAllowed)
     */
    public Integer getMemberAddressId() {
        return _memberAddressId;
    }

    /**
     * [set] MEMBER_ADDRESS_ID: {PK, ID, NotNull, INTEGER(10)} <br />
     * 会員住所ID: 会員住所を識別するID。<br />
     * 履歴分も含むテーブルなので、これ自体はFKではない。
     * @param memberAddressId The value of the column 'MEMBER_ADDRESS_ID'. (NullAllowed)
     */
    public void setMemberAddressId(Integer memberAddressId) {
        __modifiedProperties.add("memberAddressId");
        this._memberAddressId = memberAddressId;
    }

    /**
     * [get] MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * 会員ID: 会員を参照するID。<br />
     * 履歴分を含むため、これだけではユニークにはならない。<br />
     * 有効開始日と合わせて複合ユニーク制約となるが、<br />
     * 厳密には完全な制約にはなっていない。<br />
     * 有効期間の概念はRDBでは表現しきれないのである。
     * @return The value of the column 'MEMBER_ID'. (NullAllowed)
     */
    public Integer getMemberId() {
        return _memberId;
    }

    /**
     * [set] MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * 会員ID: 会員を参照するID。<br />
     * 履歴分を含むため、これだけではユニークにはならない。<br />
     * 有効開始日と合わせて複合ユニーク制約となるが、<br />
     * 厳密には完全な制約にはなっていない。<br />
     * 有効期間の概念はRDBでは表現しきれないのである。
     * @param memberId The value of the column 'MEMBER_ID'. (NullAllowed)
     */
    public void setMemberId(Integer memberId) {
        __modifiedProperties.add("memberId");
        this._memberId = memberId;
    }

    /**
     * [get] VALID_BEGIN_DATE: {UQ+, NotNull, DATE(8)} <br />
     * 有効開始日: 一つの有効期間の開始を示す日付。<br />
     * 前の有効終了日の次の日の値が格納される。
     * @return The value of the column 'VALID_BEGIN_DATE'. (NullAllowed)
     */
    public java.util.Date getValidBeginDate() {
        return _validBeginDate;
    }

    /**
     * [set] VALID_BEGIN_DATE: {UQ+, NotNull, DATE(8)} <br />
     * 有効開始日: 一つの有効期間の開始を示す日付。<br />
     * 前の有効終了日の次の日の値が格納される。
     * @param validBeginDate The value of the column 'VALID_BEGIN_DATE'. (NullAllowed)
     */
    public void setValidBeginDate(java.util.Date validBeginDate) {
        __modifiedProperties.add("validBeginDate");
        this._validBeginDate = validBeginDate;
    }

    /**
     * [get] VALID_END_DATE: {NotNull, DATE(8)} <br />
     * 有効終了日: 有効期間の終了日。<br />
     * 次の有効開始日の一日前の値が格納される。<br />
     * ただし、次の有効期間がない場合は 9999/12/31 となる。
     * @return The value of the column 'VALID_END_DATE'. (NullAllowed)
     */
    public java.util.Date getValidEndDate() {
        return _validEndDate;
    }

    /**
     * [set] VALID_END_DATE: {NotNull, DATE(8)} <br />
     * 有効終了日: 有効期間の終了日。<br />
     * 次の有効開始日の一日前の値が格納される。<br />
     * ただし、次の有効期間がない場合は 9999/12/31 となる。
     * @param validEndDate The value of the column 'VALID_END_DATE'. (NullAllowed)
     */
    public void setValidEndDate(java.util.Date validEndDate) {
        __modifiedProperties.add("validEndDate");
        this._validEndDate = validEndDate;
    }

    /**
     * [get] ADDRESS: {NotNull, VARCHAR(200)} <br />
     * 住所: まるごと住所
     * @return The value of the column 'ADDRESS'. (NullAllowed)
     */
    public String getAddress() {
        return _address;
    }

    /**
     * [set] ADDRESS: {NotNull, VARCHAR(200)} <br />
     * 住所: まるごと住所
     * @param address The value of the column 'ADDRESS'. (NullAllowed)
     */
    public void setAddress(String address) {
        __modifiedProperties.add("address");
        this._address = address;
    }

    /**
     * [get] REGION_ID: {IX, NotNull, INTEGER(10), FK to REGION} <br />
     * 地域ID: 地域を参照するID。<br />
     * ここでは特に住所の内容と連動しているわけではない。<br />
     * （業務的one-to-oneの親テーブルの表現したかっ...）
     * @return The value of the column 'REGION_ID'. (NullAllowed)
     */
    public Integer getRegionId() {
        return _regionId;
    }

    /**
     * [set] REGION_ID: {IX, NotNull, INTEGER(10), FK to REGION} <br />
     * 地域ID: 地域を参照するID。<br />
     * ここでは特に住所の内容と連動しているわけではない。<br />
     * （業務的one-to-oneの親テーブルの表現したかっ...）
     * @param regionId The value of the column 'REGION_ID'. (NullAllowed)
     */
    public void setRegionId(Integer regionId) {
        __modifiedProperties.add("regionId");
        this._regionId = regionId;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'REGISTER_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getRegisterDatetime() {
        return _registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (NullAllowed)
     */
    public void setRegisterDatetime(java.sql.Timestamp registerDatetime) {
        __modifiedProperties.add("registerDatetime");
        this._registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'REGISTER_USER'. (NullAllowed)
     */
    public String getRegisterUser() {
        return _registerUser;
    }

    /**
     * [set] REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @param registerUser The value of the column 'REGISTER_USER'. (NullAllowed)
     */
    public void setRegisterUser(String registerUser) {
        __modifiedProperties.add("registerUser");
        this._registerUser = registerUser;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'UPDATE_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getUpdateDatetime() {
        return _updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (NullAllowed)
     */
    public void setUpdateDatetime(java.sql.Timestamp updateDatetime) {
        __modifiedProperties.add("updateDatetime");
        this._updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'UPDATE_USER'. (NullAllowed)
     */
    public String getUpdateUser() {
        return _updateUser;
    }

    /**
     * [set] UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @param updateUser The value of the column 'UPDATE_USER'. (NullAllowed)
     */
    public void setUpdateUser(String updateUser) {
        __modifiedProperties.add("updateUser");
        this._updateUser = updateUser;
    }

    /**
     * [get] VERSION_NO: {NotNull, BIGINT(19)} <br />
     * @return The value of the column 'VERSION_NO'. (NullAllowed)
     */
    public Long getVersionNo() {
        return _versionNo;
    }

    /**
     * [set] VERSION_NO: {NotNull, BIGINT(19)} <br />
     * @param versionNo The value of the column 'VERSION_NO'. (NullAllowed)
     */
    public void setVersionNo(Long versionNo) {
        __modifiedProperties.add("versionNo");
        this._versionNo = versionNo;
    }

}
