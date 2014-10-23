package com.example.dbflute.flex.simpleflute.dto.bs;

import java.io.Serializable;
import java.util.*;

import com.example.dbflute.flex.simpleflute.dto.*;

/**
 * The simple DTO of REGION as TABLE. <br />
 * 地域: 主に会員の住所に対応する地域。<br />
 * かなりざっくりした感じではある。<br />
 * 業務的one-to-oneの親テーブル。
 * <pre>
 * [primary-key]
 *     REGION_ID
 * 
 * [column]
 *     REGION_ID, REGION_NAME
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     
 * 
 * [foreign-table]
 *     
 * 
 * [referrer-table]
 *     MEMBER_ADDRESS
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberAddressList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsRegionDto implements Serializable {

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
    /** REGION_ID: {PK, NotNull, INTEGER(10)} */
    protected Integer _regionId;

    /** REGION_NAME: {NotNull, VARCHAR(50)} */
    protected String _regionName;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this DTO. */
    protected final Set<String> __modifiedProperties = new LinkedHashSet<String>();

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsRegionDto() {
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    protected List<MemberAddressDto> _memberAddressList;

    public List<MemberAddressDto> getMemberAddressList() {
        if (_memberAddressList == null) { _memberAddressList = new ArrayList<MemberAddressDto>(); }
        return _memberAddressList;
    }

    public void setMemberAddressList(List<MemberAddressDto> memberAddressList) {
        this._memberAddressList = memberAddressList;
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    public Set<String> mymodifiedProperties() {
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
        if (other == null || !(other instanceof BsRegionDto)) { return false; }
        final BsRegionDto otherEntity = (BsRegionDto)other;
        if (!helpComparingValue(getRegionId(), otherEntity.getRegionId())) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    public int hashCode() {
        int result = 17;
        result = xCH(result, "REGION");
        result = xCH(result, getRegionId());
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
        sb.append(c).append(getRegionId());
        sb.append(c).append(getRegionName());
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] REGION_ID: {PK, NotNull, INTEGER(10)} <br />
     * 地域ID: 地域を識別するID。<br />
     * 珍しく(固定的な)マスタテーブルとしては数値だが、<br />
     * Exampleなのでやはり色々なパターンがないと。
     * @return The value of the column 'REGION_ID'. (NullAllowed)
     */
    public Integer getRegionId() {
        return _regionId;
    }

    /**
     * [set] REGION_ID: {PK, NotNull, INTEGER(10)} <br />
     * 地域ID: 地域を識別するID。<br />
     * 珍しく(固定的な)マスタテーブルとしては数値だが、<br />
     * Exampleなのでやはり色々なパターンがないと。
     * @param regionId The value of the column 'REGION_ID'. (NullAllowed)
     */
    public void setRegionId(Integer regionId) {
        __modifiedProperties.add("regionId");
        this._regionId = regionId;
    }

    /**
     * [get] REGION_NAME: {NotNull, VARCHAR(50)} <br />
     * 地域名称: 地域を表す名称。
     * @return The value of the column 'REGION_NAME'. (NullAllowed)
     */
    public String getRegionName() {
        return _regionName;
    }

    /**
     * [set] REGION_NAME: {NotNull, VARCHAR(50)} <br />
     * 地域名称: 地域を表す名称。
     * @param regionName The value of the column 'REGION_NAME'. (NullAllowed)
     */
    public void setRegionName(String regionName) {
        __modifiedProperties.add("regionName");
        this._regionName = regionName;
    }

}
