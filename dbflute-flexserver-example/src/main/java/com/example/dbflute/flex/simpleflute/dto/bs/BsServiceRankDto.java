package com.example.dbflute.flex.simpleflute.dto.bs;

import java.io.Serializable;
import java.util.*;

import com.example.dbflute.flex.simpleflute.dto.*;

/**
 * The simple DTO of SERVICE_RANK as TABLE. <br />
 * サービスランク: 会員のサービスレベルを表現するランク。<br />
 * （ゴールドとかプラチナとか）
 * <pre>
 * [primary-key]
 *     SERVICE_RANK_CODE
 * 
 * [column]
 *     SERVICE_RANK_CODE, SERVICE_RANK_NAME, SERVICE_POINT_INCIDENCE, NEW_ACCEPTABLE_FLG, DESCRIPTION, DISPLAY_ORDER
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
 *     MEMBER_SERVICE
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberServiceList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsServiceRankDto implements Serializable {

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
    /** SERVICE_RANK_CODE: {PK, NotNull, CHAR(3)} */
    protected String _serviceRankCode;

    /** SERVICE_RANK_NAME: {NotNull, VARCHAR(50)} */
    protected String _serviceRankName;

    /** SERVICE_POINT_INCIDENCE: {NotNull, DECIMAL(5, 3)} */
    protected java.math.BigDecimal _servicePointIncidence;

    /** NEW_ACCEPTABLE_FLG: {NotNull, INTEGER(10), classification=Flg} */
    protected Integer _newAcceptableFlg;

    /** DESCRIPTION: {NotNull, VARCHAR(200)} */
    protected String _description;

    /** DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} */
    protected Integer _displayOrder;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this DTO. */
    protected final Set<String> __modifiedProperties = new LinkedHashSet<String>();

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsServiceRankDto() {
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    protected List<MemberServiceDto> _memberServiceList;

    public List<MemberServiceDto> getMemberServiceList() {
        if (_memberServiceList == null) { _memberServiceList = new ArrayList<MemberServiceDto>(); }
        return _memberServiceList;
    }

    public void setMemberServiceList(List<MemberServiceDto> memberServiceList) {
        this._memberServiceList = memberServiceList;
    }

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
        if (other == null || !(other instanceof BsServiceRankDto)) { return false; }
        final BsServiceRankDto otherEntity = (BsServiceRankDto)other;
        if (!helpComparingValue(getServiceRankCode(), otherEntity.getServiceRankCode())) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    public int hashCode() {
        int result = 17;
        result = xCH(result, "SERVICE_RANK");
        result = xCH(result, getServiceRankCode());
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
        sb.append(c).append(getServiceRankCode());
        sb.append(c).append(getServiceRankName());
        sb.append(c).append(getServicePointIncidence());
        sb.append(c).append(getNewAcceptableFlg());
        sb.append(c).append(getDescription());
        sb.append(c).append(getDisplayOrder());
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] SERVICE_RANK_CODE: {PK, NotNull, CHAR(3)} <br />
     * サービスランクコード: サービスランクを識別するコード。
     * @return The value of the column 'SERVICE_RANK_CODE'. (NullAllowed)
     */
    public String getServiceRankCode() {
        return _serviceRankCode;
    }

    /**
     * [set] SERVICE_RANK_CODE: {PK, NotNull, CHAR(3)} <br />
     * サービスランクコード: サービスランクを識別するコード。
     * @param serviceRankCode The value of the column 'SERVICE_RANK_CODE'. (NullAllowed)
     */
    public void setServiceRankCode(String serviceRankCode) {
        __modifiedProperties.add("serviceRankCode");
        this._serviceRankCode = serviceRankCode;
    }

    /**
     * [get] SERVICE_RANK_NAME: {NotNull, VARCHAR(50)} <br />
     * サービスランク名称: サービスランクの名称。<br />
     * （ゴールドとかプラチナとか基本的には威厳のある名前）
     * @return The value of the column 'SERVICE_RANK_NAME'. (NullAllowed)
     */
    public String getServiceRankName() {
        return _serviceRankName;
    }

    /**
     * [set] SERVICE_RANK_NAME: {NotNull, VARCHAR(50)} <br />
     * サービスランク名称: サービスランクの名称。<br />
     * （ゴールドとかプラチナとか基本的には威厳のある名前）
     * @param serviceRankName The value of the column 'SERVICE_RANK_NAME'. (NullAllowed)
     */
    public void setServiceRankName(String serviceRankName) {
        __modifiedProperties.add("serviceRankName");
        this._serviceRankName = serviceRankName;
    }

    /**
     * [get] SERVICE_POINT_INCIDENCE: {NotNull, DECIMAL(5, 3)} <br />
     * サービスポイント発生率: 購入ごとのサービスポイントの発生率。<br />
     * 購入価格にこの値をかけた数が発生ポイント。<br />
     * ExampleDBとして数少ない貴重な小数点ありのカラム。
     * @return The value of the column 'SERVICE_POINT_INCIDENCE'. (NullAllowed)
     */
    public java.math.BigDecimal getServicePointIncidence() {
        return _servicePointIncidence;
    }

    /**
     * [set] SERVICE_POINT_INCIDENCE: {NotNull, DECIMAL(5, 3)} <br />
     * サービスポイント発生率: 購入ごとのサービスポイントの発生率。<br />
     * 購入価格にこの値をかけた数が発生ポイント。<br />
     * ExampleDBとして数少ない貴重な小数点ありのカラム。
     * @param servicePointIncidence The value of the column 'SERVICE_POINT_INCIDENCE'. (NullAllowed)
     */
    public void setServicePointIncidence(java.math.BigDecimal servicePointIncidence) {
        __modifiedProperties.add("servicePointIncidence");
        this._servicePointIncidence = servicePointIncidence;
    }

    /**
     * [get] NEW_ACCEPTABLE_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * 新規受け入れ可能フラグ: このランクへの新規受け入れができるかどうか。
     * @return The value of the column 'NEW_ACCEPTABLE_FLG'. (NullAllowed)
     */
    public Integer getNewAcceptableFlg() {
        return _newAcceptableFlg;
    }

    /**
     * [set] NEW_ACCEPTABLE_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * 新規受け入れ可能フラグ: このランクへの新規受け入れができるかどうか。
     * @param newAcceptableFlg The value of the column 'NEW_ACCEPTABLE_FLG'. (NullAllowed)
     */
    public void setNewAcceptableFlg(Integer newAcceptableFlg) {
        __modifiedProperties.add("newAcceptableFlg");
        this._newAcceptableFlg = newAcceptableFlg;
    }

    /**
     * [get] DESCRIPTION: {NotNull, VARCHAR(200)} <br />
     * 説明: ランクに関する業務的な説明。
     * @return The value of the column 'DESCRIPTION'. (NullAllowed)
     */
    public String getDescription() {
        return _description;
    }

    /**
     * [set] DESCRIPTION: {NotNull, VARCHAR(200)} <br />
     * 説明: ランクに関する業務的な説明。
     * @param description The value of the column 'DESCRIPTION'. (NullAllowed)
     */
    public void setDescription(String description) {
        __modifiedProperties.add("description");
        this._description = description;
    }

    /**
     * [get] DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * 表示順: UI上の表示順を表現する番号。
     * @return The value of the column 'DISPLAY_ORDER'. (NullAllowed)
     */
    public Integer getDisplayOrder() {
        return _displayOrder;
    }

    /**
     * [set] DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * 表示順: UI上の表示順を表現する番号。
     * @param displayOrder The value of the column 'DISPLAY_ORDER'. (NullAllowed)
     */
    public void setDisplayOrder(Integer displayOrder) {
        __modifiedProperties.add("displayOrder");
        this._displayOrder = displayOrder;
    }

}
