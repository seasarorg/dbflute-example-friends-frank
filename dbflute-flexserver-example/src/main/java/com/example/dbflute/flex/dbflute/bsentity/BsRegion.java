package com.example.dbflute.flex.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.AbstractEntity;
import org.seasar.dbflute.dbmeta.accessory.DomainEntity;
import com.example.dbflute.flex.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.flex.dbflute.exentity.*;

/**
 * The entity of REGION as TABLE. <br />
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
 * [foreign table]
 *     
 * 
 * [referrer table]
 *     MEMBER_ADDRESS
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     memberAddressList
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer regionId = entity.getRegionId();
 * String regionName = entity.getRegionName();
 * entity.setRegionId(regionId);
 * entity.setRegionName(regionName);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsRegion extends AbstractEntity implements DomainEntity {

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

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "REGION";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "region";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(getTableDbName());
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        if (getRegionId() == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** MEMBER_ADDRESS by REGION_ID, named 'memberAddressList'. */
    protected List<MemberAddress> _memberAddressList;

    /**
     * [get] MEMBER_ADDRESS by REGION_ID, named 'memberAddressList'.
     * @return The entity list of referrer property 'memberAddressList'. (NotNull: even if no loading, returns empty list)
     */
    public List<MemberAddress> getMemberAddressList() {
        if (_memberAddressList == null) { _memberAddressList = newReferrerList(); }
        return _memberAddressList;
    }

    /**
     * [set] MEMBER_ADDRESS by REGION_ID, named 'memberAddressList'.
     * @param memberAddressList The entity list of referrer property 'memberAddressList'. (NullAllowed)
     */
    public void setMemberAddressList(List<MemberAddress> memberAddressList) {
        _memberAddressList = memberAddressList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsRegion) {
            BsRegion other = (BsRegion)obj;
            if (!xSV(_regionId, other._regionId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, _regionId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_memberAddressList != null) { for (MemberAddress et : _memberAddressList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "memberAddressList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_regionId));
        sb.append(dm).append(xfND(_regionName));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_memberAddressList != null && !_memberAddressList.isEmpty())
        { sb.append(dm).append("memberAddressList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Region clone() {
        return (Region)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] REGION_ID: {PK, NotNull, INTEGER(10)} <br />
     * 地域ID: 地域を識別するID。<br />
     * 珍しく(固定的な)マスタテーブルとしては数値だが、<br />
     * Exampleなのでやはり色々なパターンがないと。
     * @return The value of the column 'REGION_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getRegionId() {
        checkSpecifiedProperty("regionId");
        return _regionId;
    }

    /**
     * [set] REGION_ID: {PK, NotNull, INTEGER(10)} <br />
     * 地域ID: 地域を識別するID。<br />
     * 珍しく(固定的な)マスタテーブルとしては数値だが、<br />
     * Exampleなのでやはり色々なパターンがないと。
     * @param regionId The value of the column 'REGION_ID'. (basically NotNull if update: for the constraint)
     */
    public void setRegionId(Integer regionId) {
        registerModifiedProperty("regionId");
        _regionId = regionId;
    }

    /**
     * [get] REGION_NAME: {NotNull, VARCHAR(50)} <br />
     * 地域名称: 地域を表す名称。
     * @return The value of the column 'REGION_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getRegionName() {
        checkSpecifiedProperty("regionName");
        return _regionName;
    }

    /**
     * [set] REGION_NAME: {NotNull, VARCHAR(50)} <br />
     * 地域名称: 地域を表す名称。
     * @param regionName The value of the column 'REGION_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setRegionName(String regionName) {
        registerModifiedProperty("regionName");
        _regionName = regionName;
    }
}
