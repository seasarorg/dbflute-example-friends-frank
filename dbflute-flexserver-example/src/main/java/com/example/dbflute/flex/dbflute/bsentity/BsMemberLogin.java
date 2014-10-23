package com.example.dbflute.flex.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.AbstractEntity;
import com.example.dbflute.flex.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.flex.dbflute.allcommon.CDef;
import com.example.dbflute.flex.dbflute.exentity.*;

/**
 * The entity of MEMBER_LOGIN as TABLE. <br />
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
public abstract class BsMemberLogin extends AbstractEntity {

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

    /** MEMBER_ID: {UQ+, IX, NotNull, INTEGER(10), FK to MEMBER} */
    protected Integer _memberId;

    /** LOGIN_DATETIME: {+UQ, IX, NotNull, TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp _loginDatetime;

    /** MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} */
    protected Integer _mobileLoginFlg;

    /** LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS} */
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
     * @param memberId : UQ+, IX, NotNull, INTEGER(10), FK to MEMBER. (NotNull)
     * @param loginDatetime : +UQ, IX, NotNull, TIMESTAMP(23, 10). (NotNull)
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
     * MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * フラグを示す
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Flg getMobileLoginFlgAsFlg() {
        return CDef.Flg.codeOf(getMobileLoginFlg());
    }

    /**
     * Set the value of mobileLoginFlg as the classification of Flg. <br />
     * MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * フラグを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setMobileLoginFlgAsFlg(CDef.Flg cdef) {
        setMobileLoginFlg(cdef != null ? toNumber(cdef.code(), Integer.class) : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of mobileLoginFlg as True (1). <br />
     * True: 有効を示す
     */
    public void setMobileLoginFlg_True() {
        setMobileLoginFlgAsFlg(CDef.Flg.True);
    }

    /**
     * Set the value of mobileLoginFlg as False (0). <br />
     * False: 無効を示す
     */
    public void setMobileLoginFlg_False() {
        setMobileLoginFlgAsFlg(CDef.Flg.False);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of mobileLoginFlg True? <br />
     * True: 有効を示す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMobileLoginFlgTrue() {
        CDef.Flg cdef = getMobileLoginFlgAsFlg();
        return cdef != null ? cdef.equals(CDef.Flg.True) : false;
    }

    /**
     * Is the value of mobileLoginFlg False? <br />
     * False: 無効を示す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMobileLoginFlgFalse() {
        CDef.Flg cdef = getMobileLoginFlgAsFlg();
        return cdef != null ? cdef.equals(CDef.Flg.False) : false;
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

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** MEMBER by my MEMBER_ID, named 'member'. */
    protected Member _member;

    /**
     * [get] MEMBER by my MEMBER_ID, named 'member'.
     * @return The entity of foreign property 'member'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public Member getMember() {
        return _member;
    }

    /**
     * [set] MEMBER by my MEMBER_ID, named 'member'.
     * @param member The entity of foreign property 'member'. (NullAllowed)
     */
    public void setMember(Member member) {
        _member = member;
    }

    /** MEMBER_STATUS by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'. */
    protected MemberStatus _memberStatus;

    /**
     * [get] MEMBER_STATUS by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'.
     * @return The entity of foreign property 'memberStatus'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public MemberStatus getMemberStatus() {
        return _memberStatus;
    }

    /**
     * [set] MEMBER_STATUS by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'.
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
        if (_member != null) { sb.append(dm).append("member"); }
        if (_memberStatus != null) { sb.append(dm).append("memberStatus"); }
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
     * [get] MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * 会員ログインID:
     * @return The value of the column 'MEMBER_LOGIN_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getMemberLoginId() {
        checkSpecifiedProperty("memberLoginId");
        return _memberLoginId;
    }

    /**
     * [set] MEMBER_LOGIN_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * 会員ログインID:
     * @param memberLoginId The value of the column 'MEMBER_LOGIN_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberLoginId(Long memberLoginId) {
        __modifiedProperties.addPropertyName("memberLoginId");
        _memberLoginId = memberLoginId;
    }

    /**
     * [get] MEMBER_ID: {UQ+, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * 会員ID:
     * @return The value of the column 'MEMBER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMemberId() {
        checkSpecifiedProperty("memberId");
        return _memberId;
    }

    /**
     * [set] MEMBER_ID: {UQ+, IX, NotNull, INTEGER(10), FK to MEMBER} <br />
     * 会員ID:
     * @param memberId The value of the column 'MEMBER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberId(Integer memberId) {
        __modifiedProperties.addPropertyName("memberId");
        _memberId = memberId;
    }

    /**
     * [get] LOGIN_DATETIME: {+UQ, IX, NotNull, TIMESTAMP(23, 10)} <br />
     * ログイン日時: ログインした瞬間の日時。
     * @return The value of the column 'LOGIN_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getLoginDatetime() {
        checkSpecifiedProperty("loginDatetime");
        return _loginDatetime;
    }

    /**
     * [set] LOGIN_DATETIME: {+UQ, IX, NotNull, TIMESTAMP(23, 10)} <br />
     * ログイン日時: ログインした瞬間の日時。
     * @param loginDatetime The value of the column 'LOGIN_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setLoginDatetime(java.sql.Timestamp loginDatetime) {
        __modifiedProperties.addPropertyName("loginDatetime");
        _loginDatetime = loginDatetime;
    }

    /**
     * [get] MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * モバイルログインフラグ: モバイル機器からのログインか否か。
     * @return The value of the column 'MOBILE_LOGIN_FLG'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMobileLoginFlg() {
        checkSpecifiedProperty("mobileLoginFlg");
        return _mobileLoginFlg;
    }

    /**
     * [set] MOBILE_LOGIN_FLG: {NotNull, INTEGER(10), classification=Flg} <br />
     * モバイルログインフラグ: モバイル機器からのログインか否か。
     * @param mobileLoginFlg The value of the column 'MOBILE_LOGIN_FLG'. (basically NotNull if update: for the constraint)
     */
    public void setMobileLoginFlg(Integer mobileLoginFlg) {
        __modifiedProperties.addPropertyName("mobileLoginFlg");
        _mobileLoginFlg = mobileLoginFlg;
    }

    /**
     * [get] LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS} <br />
     * ログイン会員ステータスコード: ログイン時の会員ステータス
     * @return The value of the column 'LOGIN_MEMBER_STATUS_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getLoginMemberStatusCode() {
        checkSpecifiedProperty("loginMemberStatusCode");
        return _loginMemberStatusCode;
    }

    /**
     * [set] LOGIN_MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS} <br />
     * ログイン会員ステータスコード: ログイン時の会員ステータス
     * @param loginMemberStatusCode The value of the column 'LOGIN_MEMBER_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    public void setLoginMemberStatusCode(String loginMemberStatusCode) {
        __modifiedProperties.addPropertyName("loginMemberStatusCode");
        _loginMemberStatusCode = loginMemberStatusCode;
    }
}
