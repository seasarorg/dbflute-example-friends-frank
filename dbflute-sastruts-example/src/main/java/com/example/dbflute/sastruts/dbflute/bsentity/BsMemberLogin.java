/*
 * Copyright 2004-2013 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.dbflute.sastruts.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.AbstractEntity;
import org.seasar.dbflute.dbmeta.accessory.DomainEntity;
import com.example.dbflute.sastruts.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.sastruts.dbflute.allcommon.CDef;
import com.example.dbflute.sastruts.dbflute.exentity.*;

/**
 * The entity of (会員ログイン)MEMBER_LOGIN as TABLE. <br />
 * ログインするたびに登録されるログイン履歴。<br />
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
 * [foreign table]
 *     MEMBER, MEMBER_STATUS
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     member, memberStatus
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long memberLoginId = entity.getMemberLoginId();
 * Integer memberId = entity.getMemberId();
 * java.sql.Timestamp loginDatetime = entity.getLoginDatetime();
 * Integer mobileLoginFlg = entity.getMobileLoginFlg();
 * String loginMemberStatusCode = entity.getLoginMemberStatusCode();
 * entity.setMemberLoginId(memberLoginId);
 * entity.setMemberId(memberId);
 * entity.setLoginDatetime(loginDatetime);
 * entity.setMobileLoginFlg(mobileLoginFlg);
 * entity.setLoginMemberStatusCode(loginMemberStatusCode);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberLogin extends AbstractEntity implements DomainEntity {

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
    /** (会員ログインID)MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _memberLoginId;

    /** (会員ID)MEMBER_ID: {UQ+, IX, NotNull, INTEGER(10), FK to MEMBER} */
    protected Integer _memberId;

    /** (ログイン日時)LOGIN_DATETIME: {+UQ, IX, NotNull, TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp _loginDatetime;

    /** (モバイルログインフラグ)MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} */
    protected Integer _mobileLoginFlg;

    /** (ログイン会員ステータスコード)LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} */
    protected String _loginMemberStatusCode;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "MEMBER_LOGIN";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "memberLogin";
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
        if (getMemberLoginId() == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br />
     * You can update the entity by the key when entity update (NOT batch update).
     * @param memberId (会員ID): UQ+, IX, NotNull, INTEGER(10), FK to MEMBER. (NotNull)
     * @param loginDatetime (ログイン日時): +UQ, IX, NotNull, TIMESTAMP(23, 10). (NotNull)
     */
    public void uniqueBy(Integer memberId, java.sql.Timestamp loginDatetime) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("memberId");
        __uniqueDrivenProperties.addPropertyName("loginDatetime");
        setMemberId(memberId);setLoginDatetime(loginDatetime);
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of mobileLoginFlg as the classification of Flg. <br />
     * (モバイルログインフラグ)MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * フラグを示す
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Flg getMobileLoginFlgAsFlg() {
        return CDef.Flg.codeOf(getMobileLoginFlg());
    }

    /**
     * Set the value of mobileLoginFlg as the classification of Flg. <br />
     * (モバイルログインフラグ)MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * フラグを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setMobileLoginFlgAsFlg(CDef.Flg cdef) {
        setMobileLoginFlg(cdef != null ? toNumber(cdef.code(), Integer.class) : null);
    }

    /**
     * Set the value of mobileLoginFlg as boolean. <br />
     * (モバイルログインフラグ)MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * フラグを示す
     * @param determination The determination, true or false. (NullAllowed: if null, null value is set to the column)
     */
    public void setMobileLoginFlgAsBoolean(Boolean determination) {
        setMobileLoginFlgAsFlg(CDef.Flg.codeOf(determination));
    }

    /**
     * Get the value of loginMemberStatusCode as the classification of MemberStatus. <br />
     * (ログイン会員ステータスコード)LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.MemberStatus getLoginMemberStatusCodeAsMemberStatus() {
        return CDef.MemberStatus.codeOf(getLoginMemberStatusCode());
    }

    /**
     * Set the value of loginMemberStatusCode as the classification of MemberStatus. <br />
     * (ログイン会員ステータスコード)LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setLoginMemberStatusCodeAsMemberStatus(CDef.MemberStatus cdef) {
        setLoginMemberStatusCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of mobileLoginFlg as True (1). <br />
     * はい: 有効を示す
     */
    public void setMobileLoginFlg_True() {
        setMobileLoginFlgAsFlg(CDef.Flg.True);
    }

    /**
     * Set the value of mobileLoginFlg as False (0). <br />
     * いいえ: 無効を示す
     */
    public void setMobileLoginFlg_False() {
        setMobileLoginFlgAsFlg(CDef.Flg.False);
    }

    /**
     * Set the value of loginMemberStatusCode as 正式会員 (FML). <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     */
    public void setLoginMemberStatusCode_正式会員() {
        setLoginMemberStatusCodeAsMemberStatus(CDef.MemberStatus.正式会員);
    }

    /**
     * Set the value of loginMemberStatusCode as 退会会員 (WDL). <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     */
    public void setLoginMemberStatusCode_退会会員() {
        setLoginMemberStatusCodeAsMemberStatus(CDef.MemberStatus.退会会員);
    }

    /**
     * Set the value of loginMemberStatusCode as 仮会員 (PRV). <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     */
    public void setLoginMemberStatusCode_仮会員() {
        setLoginMemberStatusCodeAsMemberStatus(CDef.MemberStatus.仮会員);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of mobileLoginFlg True? <br />
     * はい: 有効を示す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMobileLoginFlgTrue() {
        CDef.Flg cdef = getMobileLoginFlgAsFlg();
        return cdef != null ? cdef.equals(CDef.Flg.True) : false;
    }

    /**
     * Is the value of mobileLoginFlg False? <br />
     * いいえ: 無効を示す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMobileLoginFlgFalse() {
        CDef.Flg cdef = getMobileLoginFlgAsFlg();
        return cdef != null ? cdef.equals(CDef.Flg.False) : false;
    }

    /**
     * Is the value of loginMemberStatusCode 正式会員? <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isLoginMemberStatusCode正式会員() {
        CDef.MemberStatus cdef = getLoginMemberStatusCodeAsMemberStatus();
        return cdef != null ? cdef.equals(CDef.MemberStatus.正式会員) : false;
    }

    /**
     * Is the value of loginMemberStatusCode 退会会員? <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isLoginMemberStatusCode退会会員() {
        CDef.MemberStatus cdef = getLoginMemberStatusCodeAsMemberStatus();
        return cdef != null ? cdef.equals(CDef.MemberStatus.退会会員) : false;
    }

    /**
     * Is the value of loginMemberStatusCode 仮会員? <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isLoginMemberStatusCode仮会員() {
        CDef.MemberStatus cdef = getLoginMemberStatusCodeAsMemberStatus();
        return cdef != null ? cdef.equals(CDef.MemberStatus.仮会員) : false;
    }

    /**
     * サービスが利用できる会員 <br />
     * The group elements:[正式会員, 仮会員]
     * @return The determination, true or false.
     */
    public boolean isLoginMemberStatusCode_ServiceAvailable() {
        CDef.MemberStatus cdef = getLoginMemberStatusCodeAsMemberStatus();
        return cdef != null && cdef.isServiceAvailable();
    }

    /**
     * まだ正式会員に達してない会員 <br />
     * The group elements:[仮会員]
     * @return The determination, true or false.
     */
    public boolean isLoginMemberStatusCode_ShortOfFormalized() {
        CDef.MemberStatus cdef = getLoginMemberStatusCodeAsMemberStatus();
        return cdef != null && cdef.isShortOfFormalized();
    }

    // ===================================================================================
    //                                                           Classification Name/Alias
    //                                                           =========================
    /**
     * Get the value of the column 'mobileLoginFlg' as classification name.
     * @return The string of classification name. (NullAllowed: when the column value is null)
     */
    public String getMobileLoginFlgName() {
        CDef.Flg cdef = getMobileLoginFlgAsFlg();
        return cdef != null ? cdef.name() : null;
    }

    /**
     * Get the value of the column 'mobileLoginFlg' as classification alias.
     * @return The string of classification alias. (NullAllowed: when the column value is null)
     */
    public String getMobileLoginFlgAlias() {
        CDef.Flg cdef = getMobileLoginFlgAsFlg();
        return cdef != null ? cdef.alias() : null;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** (会員)MEMBER by my MEMBER_ID, named 'member'. */
    protected Member _member;

    /**
     * [get] (会員)MEMBER by my MEMBER_ID, named 'member'.
     * @return The entity of foreign property 'member'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public Member getMember() {
        return _member;
    }

    /**
     * [set] (会員)MEMBER by my MEMBER_ID, named 'member'.
     * @param member The entity of foreign property 'member'. (NullAllowed)
     */
    public void setMember(Member member) {
        _member = member;
    }

    /** (会員ステータス)MEMBER_STATUS by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'. */
    protected MemberStatus _memberStatus;

    /**
     * [get] (会員ステータス)MEMBER_STATUS by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'.
     * @return The entity of foreign property 'memberStatus'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public MemberStatus getMemberStatus() {
        return _memberStatus;
    }

    /**
     * [set] (会員ステータス)MEMBER_STATUS by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'.
     * @param memberStatus The entity of foreign property 'memberStatus'. (NullAllowed)
     */
    public void setMemberStatus(MemberStatus memberStatus) {
        _memberStatus = memberStatus;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsMemberLogin) {
            BsMemberLogin other = (BsMemberLogin)obj;
            if (!xSV(_memberLoginId, other._memberLoginId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, _memberLoginId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_member != null)
        { sb.append(li).append(xbRDS(_member, "member")); }
        if (_memberStatus != null)
        { sb.append(li).append(xbRDS(_memberStatus, "memberStatus")); }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_memberLoginId));
        sb.append(dm).append(xfND(_memberId));
        sb.append(dm).append(xfND(_loginDatetime));
        sb.append(dm).append(xfND(_mobileLoginFlg));
        sb.append(dm).append(xfND(_loginMemberStatusCode));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_member != null)
        { sb.append(dm).append("member"); }
        if (_memberStatus != null)
        { sb.append(dm).append("memberStatus"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public MemberLogin clone() {
        return (MemberLogin)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (会員ログインID)MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @return The value of the column 'MEMBER_LOGIN_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getMemberLoginId() {
        checkSpecifiedProperty("memberLoginId");
        return _memberLoginId;
    }

    /**
     * [set] (会員ログインID)MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @param memberLoginId The value of the column 'MEMBER_LOGIN_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberLoginId(Long memberLoginId) {
        registerModifiedProperty("memberLoginId");
        _memberLoginId = memberLoginId;
    }

    /**
     * [get] (会員ID)MEMBER_ID: {UQ+, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * @return The value of the column 'MEMBER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMemberId() {
        checkSpecifiedProperty("memberId");
        return _memberId;
    }

    /**
     * [set] (会員ID)MEMBER_ID: {UQ+, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * @param memberId The value of the column 'MEMBER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberId(Integer memberId) {
        registerModifiedProperty("memberId");
        _memberId = memberId;
    }

    /**
     * [get] (ログイン日時)LOGIN_DATETIME: {+UQ, IX, NotNull, TIMESTAMP(23, 10)} <br />
     * ログインした瞬間の日時。
     * @return The value of the column 'LOGIN_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getLoginDatetime() {
        checkSpecifiedProperty("loginDatetime");
        return _loginDatetime;
    }

    /**
     * [set] (ログイン日時)LOGIN_DATETIME: {+UQ, IX, NotNull, TIMESTAMP(23, 10)} <br />
     * ログインした瞬間の日時。
     * @param loginDatetime The value of the column 'LOGIN_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setLoginDatetime(java.sql.Timestamp loginDatetime) {
        registerModifiedProperty("loginDatetime");
        _loginDatetime = loginDatetime;
    }

    /**
     * [get] (モバイルログインフラグ)MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * モバイル機器からのログインか否か。
     * @return The value of the column 'MOBILE_LOGIN_FLG'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMobileLoginFlg() {
        checkSpecifiedProperty("mobileLoginFlg");
        return _mobileLoginFlg;
    }

    /**
     * [set] (モバイルログインフラグ)MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * モバイル機器からのログインか否か。
     * @param mobileLoginFlg The value of the column 'MOBILE_LOGIN_FLG'. (basically NotNull if update: for the constraint)
     */
    protected void setMobileLoginFlg(Integer mobileLoginFlg) {
        checkClassificationCode("MOBILE_LOGIN_FLG", CDef.DefMeta.Flg, mobileLoginFlg);
        registerModifiedProperty("mobileLoginFlg");
        _mobileLoginFlg = mobileLoginFlg;
    }

    /**
     * [get] (ログイン会員ステータスコード)LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * ログイン時の会員ステータス
     * @return The value of the column 'LOGIN_MEMBER_STATUS_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getLoginMemberStatusCode() {
        checkSpecifiedProperty("loginMemberStatusCode");
        return convertEmptyToNull(_loginMemberStatusCode);
    }

    /**
     * [set] (ログイン会員ステータスコード)LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * ログイン時の会員ステータス
     * @param loginMemberStatusCode The value of the column 'LOGIN_MEMBER_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setLoginMemberStatusCode(String loginMemberStatusCode) {
        registerModifiedProperty("loginMemberStatusCode");
        _loginMemberStatusCode = loginMemberStatusCode;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param mobileLoginFlg The value of the column 'MOBILE_LOGIN_FLG'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingMobileLoginFlg(Integer mobileLoginFlg) {
        setMobileLoginFlg(mobileLoginFlg);
    }

    /**
     * For framework so basically DON'T use this method.
     * @param loginMemberStatusCode The value of the column 'LOGIN_MEMBER_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingLoginMemberStatusCode(String loginMemberStatusCode) {
        setLoginMemberStatusCode(loginMemberStatusCode);
    }
}
