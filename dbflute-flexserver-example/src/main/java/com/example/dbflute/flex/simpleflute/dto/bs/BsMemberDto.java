package com.example.dbflute.flex.simpleflute.dto.bs;

import java.io.Serializable;
import java.util.*;

import com.example.dbflute.flex.simpleflute.dto.*;

/**
 * The simple DTO of MEMBER as TABLE. <br />
 * 会員: 会員登録時にデータが登録される。基本的に物理削除はなく、退会したらステータスが退会会員になる。ライフサイクルやカテゴリの違う会員それぞれの詳細情報は、別途 one-to-one のテーブルに。
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, MEMBER_ACCOUNT, MEMBER_STATUS_CODE, FORMALIZED_DATETIME, BIRTHDATE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER_STATUS, MEMBER_LOGIN(AsLatest), MEMBER_SECURITY(AsOne), MEMBER_SERVICE(AsOne), MEMBER_WITHDRAWAL(AsOne)
 * 
 * [referrer-table]
 *     MEMBER_ADDRESS, MEMBER_LOGIN, PURCHASE, MEMBER_SECURITY, MEMBER_SERVICE, MEMBER_WITHDRAWAL
 * 
 * [foreign-property]
 *     memberStatus, memberLoginAsLatest, memberSecurityAsOne, memberServiceAsOne, memberWithdrawalAsOne
 * 
 * [referrer-property]
 *     memberAddressList, memberLoginList, purchaseList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberDto implements Serializable {

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
    /** MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_LOGIN} */
    protected Integer _memberId;

    /** MEMBER_NAME: {IX, NotNull, VARCHAR(200)} */
    protected String _memberName;

    /** MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} */
    protected String _memberAccount;

    /** MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} */
    protected String _memberStatusCode;

    /** FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp _formalizedDatetime;

    /** BIRTHDATE: {DATE(8)} */
    protected java.util.Date _birthdate;

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
    public BsMemberDto() {
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    protected MemberStatusDto _memberStatus;

    public MemberStatusDto getMemberStatus() {
        return _memberStatus;
    }

    public void setMemberStatus(MemberStatusDto memberStatus) {
        this._memberStatus = memberStatus;
    }

    protected MemberLoginDto _memberLoginAsLatest;

    public MemberLoginDto getMemberLoginAsLatest() {
        return _memberLoginAsLatest;
    }

    public void setMemberLoginAsLatest(MemberLoginDto memberLoginAsLatest) {
        this._memberLoginAsLatest = memberLoginAsLatest;
    }

    protected MemberSecurityDto _memberSecurityAsOne;

    public MemberSecurityDto getMemberSecurityAsOne() {
        return _memberSecurityAsOne;
    }

    public void setMemberSecurityAsOne(MemberSecurityDto memberSecurityAsOne) {
        this._memberSecurityAsOne = memberSecurityAsOne;
    }

    protected MemberServiceDto _memberServiceAsOne;

    public MemberServiceDto getMemberServiceAsOne() {
        return _memberServiceAsOne;
    }

    public void setMemberServiceAsOne(MemberServiceDto memberServiceAsOne) {
        this._memberServiceAsOne = memberServiceAsOne;
    }

    protected MemberWithdrawalDto _memberWithdrawalAsOne;

    public MemberWithdrawalDto getMemberWithdrawalAsOne() {
        return _memberWithdrawalAsOne;
    }

    public void setMemberWithdrawalAsOne(MemberWithdrawalDto memberWithdrawalAsOne) {
        this._memberWithdrawalAsOne = memberWithdrawalAsOne;
    }

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

    protected List<MemberLoginDto> _memberLoginList;

    public List<MemberLoginDto> getMemberLoginList() {
        if (_memberLoginList == null) { _memberLoginList = new ArrayList<MemberLoginDto>(); }
        return _memberLoginList;
    }

    public void setMemberLoginList(List<MemberLoginDto> memberLoginList) {
        this._memberLoginList = memberLoginList;
    }

    protected List<PurchaseDto> _purchaseList;

    public List<PurchaseDto> getPurchaseList() {
        if (_purchaseList == null) { _purchaseList = new ArrayList<PurchaseDto>(); }
        return _purchaseList;
    }

    public void setPurchaseList(List<PurchaseDto> purchaseList) {
        this._purchaseList = purchaseList;
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
        if (other == null || !(other instanceof BsMemberDto)) { return false; }
        final BsMemberDto otherEntity = (BsMemberDto)other;
        if (!helpComparingValue(getMemberId(), otherEntity.getMemberId())) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    public int hashCode() {
        int result = 17;
        result = xCH(result, "MEMBER");
        result = xCH(result, getMemberId());
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
        sb.append(c).append(getMemberId());
        sb.append(c).append(getMemberName());
        sb.append(c).append(getMemberAccount());
        sb.append(c).append(getMemberStatusCode());
        sb.append(c).append(getFormalizedDatetime());
        sb.append(c).append(xfUD(getBirthdate()));
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
     * [get] MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_LOGIN} <br />
     * 会員ID: 会員を識別するID。連番として自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMS次第。
     * @return The value of the column 'MEMBER_ID'. (NullAllowed)
     */
    public Integer getMemberId() {
        return _memberId;
    }

    /**
     * [set] MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_LOGIN} <br />
     * 会員ID: 会員を識別するID。連番として自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMS次第。
     * @param memberId The value of the column 'MEMBER_ID'. (NullAllowed)
     */
    public void setMemberId(Integer memberId) {
        __modifiedProperties.add("memberId");
        this._memberId = memberId;
    }

    /**
     * [get] MEMBER_NAME: {IX, NotNull, VARCHAR(200)} <br />
     * 会員名称: 会員のフルネームの名称。<br />
     * 苗字と名前を分けて管理することも多いが、ここでは Example なので単純にひとまとめ。
     * @return The value of the column 'MEMBER_NAME'. (NullAllowed)
     */
    public String getMemberName() {
        return _memberName;
    }

    /**
     * [set] MEMBER_NAME: {IX, NotNull, VARCHAR(200)} <br />
     * 会員名称: 会員のフルネームの名称。<br />
     * 苗字と名前を分けて管理することも多いが、ここでは Example なので単純にひとまとめ。
     * @param memberName The value of the column 'MEMBER_NAME'. (NullAllowed)
     */
    public void setMemberName(String memberName) {
        __modifiedProperties.add("memberName");
        this._memberName = memberName;
    }

    /**
     * [get] MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} <br />
     * 会員アカウント: 会員がログイン時に利用するアカウントNO。<br />
     * 昨今、メールアドレスをログインIDとすることが多いので、あまり見かけなくないかも。
     * @return The value of the column 'MEMBER_ACCOUNT'. (NullAllowed)
     */
    public String getMemberAccount() {
        return _memberAccount;
    }

    /**
     * [set] MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} <br />
     * 会員アカウント: 会員がログイン時に利用するアカウントNO。<br />
     * 昨今、メールアドレスをログインIDとすることが多いので、あまり見かけなくないかも。
     * @param memberAccount The value of the column 'MEMBER_ACCOUNT'. (NullAllowed)
     */
    public void setMemberAccount(String memberAccount) {
        __modifiedProperties.add("memberAccount");
        this._memberAccount = memberAccount;
    }

    /**
     * [get] MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * 会員ステータスコード: 会員ステータスを参照するコード。<br />
     * ステータスが変わるたびに、このカラムが更新される。
     * @return The value of the column 'MEMBER_STATUS_CODE'. (NullAllowed)
     */
    public String getMemberStatusCode() {
        return _memberStatusCode;
    }

    /**
     * [set] MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * 会員ステータスコード: 会員ステータスを参照するコード。<br />
     * ステータスが変わるたびに、このカラムが更新される。
     * @param memberStatusCode The value of the column 'MEMBER_STATUS_CODE'. (NullAllowed)
     */
    public void setMemberStatusCode(String memberStatusCode) {
        __modifiedProperties.add("memberStatusCode");
        this._memberStatusCode = memberStatusCode;
    }

    /**
     * [get] FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)} <br />
     * 正式会員日時: 会員が正式に確定した日時。<br />
     * 一度確定したら更新されない。
     * @return The value of the column 'FORMALIZED_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getFormalizedDatetime() {
        return _formalizedDatetime;
    }

    /**
     * [set] FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)} <br />
     * 正式会員日時: 会員が正式に確定した日時。<br />
     * 一度確定したら更新されない。
     * @param formalizedDatetime The value of the column 'FORMALIZED_DATETIME'. (NullAllowed)
     */
    public void setFormalizedDatetime(java.sql.Timestamp formalizedDatetime) {
        __modifiedProperties.add("formalizedDatetime");
        this._formalizedDatetime = formalizedDatetime;
    }

    /**
     * [get] BIRTHDATE: {DATE(8)} <br />
     * 生年月日: 必須項目ではないので、このデータがない会員もいる。
     * @return The value of the column 'BIRTHDATE'. (NullAllowed)
     */
    public java.util.Date getBirthdate() {
        return _birthdate;
    }

    /**
     * [set] BIRTHDATE: {DATE(8)} <br />
     * 生年月日: 必須項目ではないので、このデータがない会員もいる。
     * @param birthdate The value of the column 'BIRTHDATE'. (NullAllowed)
     */
    public void setBirthdate(java.util.Date birthdate) {
        __modifiedProperties.add("birthdate");
        this._birthdate = birthdate;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * 登録日時: レコードが登録された日時。<br />
     * 会員が登録された日時とほぼ等しいが、そういった業務的な役割を兼務させるのはあまり推奨されない。<br />
     * どのテーブルでも同じなので、共通カラムの説明はこのテーブルでしか書かない。
     * @return The value of the column 'REGISTER_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getRegisterDatetime() {
        return _registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * 登録日時: レコードが登録された日時。<br />
     * 会員が登録された日時とほぼ等しいが、そういった業務的な役割を兼務させるのはあまり推奨されない。<br />
     * どのテーブルでも同じなので、共通カラムの説明はこのテーブルでしか書かない。
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (NullAllowed)
     */
    public void setRegisterDatetime(java.sql.Timestamp registerDatetime) {
        __modifiedProperties.add("registerDatetime");
        this._registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * 登録ユーザ: レコードを登録したユーザ。<br />
     * 会員テーブルであれば当然、会員自身であるはずだが、他のテーブルの場合では管理画面から運用者による登録など考えられるので、しっかり保持しておく。
     * @return The value of the column 'REGISTER_USER'. (NullAllowed)
     */
    public String getRegisterUser() {
        return _registerUser;
    }

    /**
     * [set] REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * 登録ユーザ: レコードを登録したユーザ。<br />
     * 会員テーブルであれば当然、会員自身であるはずだが、他のテーブルの場合では管理画面から運用者による登録など考えられるので、しっかり保持しておく。
     * @param registerUser The value of the column 'REGISTER_USER'. (NullAllowed)
     */
    public void setRegisterUser(String registerUser) {
        __modifiedProperties.add("registerUser");
        this._registerUser = registerUser;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * 更新日時: レコードが（最後に）更新された日時。<br />
     * 業務的な利用はあまり推奨されないと別項目で説明したが、このカラムはソートの要素としてよく利用される。
     * @return The value of the column 'UPDATE_DATETIME'. (NullAllowed)
     */
    public java.sql.Timestamp getUpdateDatetime() {
        return _updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * 更新日時: レコードが（最後に）更新された日時。<br />
     * 業務的な利用はあまり推奨されないと別項目で説明したが、このカラムはソートの要素としてよく利用される。
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (NullAllowed)
     */
    public void setUpdateDatetime(java.sql.Timestamp updateDatetime) {
        __modifiedProperties.add("updateDatetime");
        this._updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * 更新ユーザ: レコードを更新したユーザ。<br />
     * システムは誰が何をしたのかちゃんと覚えている。
     * @return The value of the column 'UPDATE_USER'. (NullAllowed)
     */
    public String getUpdateUser() {
        return _updateUser;
    }

    /**
     * [set] UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * 更新ユーザ: レコードを更新したユーザ。<br />
     * システムは誰が何をしたのかちゃんと覚えている。
     * @param updateUser The value of the column 'UPDATE_USER'. (NullAllowed)
     */
    public void setUpdateUser(String updateUser) {
        __modifiedProperties.add("updateUser");
        this._updateUser = updateUser;
    }

    /**
     * [get] VERSION_NO: {NotNull, BIGINT(19)} <br />
     * バージョンNO: レコードのバージョンを示すNO。<br />
     * 更新回数と等しく、主に排他制御のために利用される。
     * @return The value of the column 'VERSION_NO'. (NullAllowed)
     */
    public Long getVersionNo() {
        return _versionNo;
    }

    /**
     * [set] VERSION_NO: {NotNull, BIGINT(19)} <br />
     * バージョンNO: レコードのバージョンを示すNO。<br />
     * 更新回数と等しく、主に排他制御のために利用される。
     * @param versionNo The value of the column 'VERSION_NO'. (NullAllowed)
     */
    public void setVersionNo(Long versionNo) {
        __modifiedProperties.add("versionNo");
        this._versionNo = versionNo;
    }

}
