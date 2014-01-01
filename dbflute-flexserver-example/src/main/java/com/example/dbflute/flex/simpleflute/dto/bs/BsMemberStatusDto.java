package com.example.dbflute.flex.simpleflute.dto.bs;

import java.io.Serializable;
import java.util.*;

import com.example.dbflute.flex.simpleflute.dto.*;

/**
 * The simple DTO of MEMBER_STATUS as TABLE. <br />
 * 会員ステータス: 会員のステータスを示す固定的なマスタテーブル。<br />
 * 業務で増えることはなく、増減するときは実装もともなうレベルの業務変更と考えられる。<br />
 * <br />
 * こういった固定的なマスタテーブルには、更新日時などの共通カラムは定義していないが、業務上そういった情報を管理する必要性が低いという理由に加え、ExampleDBとして共通カラムでER図が埋め尽くされてしまい見づらくなるという<br />
 * ところで割り切っている。実業務では統一的に定義することもある。
 * <pre>
 * [primary-key]
 *     MEMBER_STATUS_CODE
 * 
 * [column]
 *     MEMBER_STATUS_CODE, MEMBER_STATUS_NAME, DESCRIPTION, DISPLAY_ORDER
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
 *     MEMBER, MEMBER_LOGIN
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberList, memberLoginList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberStatusDto implements Serializable {

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
    /** MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus} */
    protected String _memberStatusCode;

    /** MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)} */
    protected String _memberStatusName;

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
    public BsMemberStatusDto() {
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    protected List<MemberDto> _memberList;

    public List<MemberDto> getMemberList() {
        if (_memberList == null) { _memberList = new ArrayList<MemberDto>(); }
        return _memberList;
    }

    public void setMemberList(List<MemberDto> memberList) {
        this._memberList = memberList;
    }

    protected List<MemberLoginDto> _memberLoginList;

    public List<MemberLoginDto> getMemberLoginList() {
        if (_memberLoginList == null) { _memberLoginList = new ArrayList<MemberLoginDto>(); }
        return _memberLoginList;
    }

    public void setMemberLoginList(List<MemberLoginDto> memberLoginList) {
        this._memberLoginList = memberLoginList;
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
        if (other == null || !(other instanceof BsMemberStatusDto)) { return false; }
        final BsMemberStatusDto otherEntity = (BsMemberStatusDto)other;
        if (!helpComparingValue(getMemberStatusCode(), otherEntity.getMemberStatusCode())) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    public int hashCode() {
        int result = 17;
        result = xCH(result, "MEMBER_STATUS");
        result = xCH(result, getMemberStatusCode());
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
        sb.append(c).append(getMemberStatusCode());
        sb.append(c).append(getMemberStatusName());
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
     * [get] MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus} <br />
     * 会員ステータスコード: 会員ステータスを識別するコード。<br />
     * 固定的なデータなので、連番とか番号にはせず、<br />
     * データを直接見たときも人が直感的にわかるように、<br />
     * このような３桁のコード形式にしている。
     * @return The value of the column 'MEMBER_STATUS_CODE'. (NullAllowed)
     */
    public String getMemberStatusCode() {
        return _memberStatusCode;
    }

    /**
     * [set] MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus} <br />
     * 会員ステータスコード: 会員ステータスを識別するコード。<br />
     * 固定的なデータなので、連番とか番号にはせず、<br />
     * データを直接見たときも人が直感的にわかるように、<br />
     * このような３桁のコード形式にしている。
     * @param memberStatusCode The value of the column 'MEMBER_STATUS_CODE'. (NullAllowed)
     */
    public void setMemberStatusCode(String memberStatusCode) {
        __modifiedProperties.add("memberStatusCode");
        this._memberStatusCode = memberStatusCode;
    }

    /**
     * [get] MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)} <br />
     * 会員ステータス名称:
     * @return The value of the column 'MEMBER_STATUS_NAME'. (NullAllowed)
     */
    public String getMemberStatusName() {
        return _memberStatusName;
    }

    /**
     * [set] MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)} <br />
     * 会員ステータス名称:
     * @param memberStatusName The value of the column 'MEMBER_STATUS_NAME'. (NullAllowed)
     */
    public void setMemberStatusName(String memberStatusName) {
        __modifiedProperties.add("memberStatusName");
        this._memberStatusName = memberStatusName;
    }

    /**
     * [get] DESCRIPTION: {NotNull, VARCHAR(200)} <br />
     * 説明: 会員ステータスそれぞれの説明。<br />
     * 気の利いた説明があるとディベロッパーがとても助かる。
     * @return The value of the column 'DESCRIPTION'. (NullAllowed)
     */
    public String getDescription() {
        return _description;
    }

    /**
     * [set] DESCRIPTION: {NotNull, VARCHAR(200)} <br />
     * 説明: 会員ステータスそれぞれの説明。<br />
     * 気の利いた説明があるとディベロッパーがとても助かる。
     * @param description The value of the column 'DESCRIPTION'. (NullAllowed)
     */
    public void setDescription(String description) {
        __modifiedProperties.add("description");
        this._description = description;
    }

    /**
     * [get] DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * 表示順: UI上のステータスの表示順を示すNO。<br />
     * 並べるときは、このカラムに対して昇順のソート条件にする。
     * @return The value of the column 'DISPLAY_ORDER'. (NullAllowed)
     */
    public Integer getDisplayOrder() {
        return _displayOrder;
    }

    /**
     * [set] DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * 表示順: UI上のステータスの表示順を示すNO。<br />
     * 並べるときは、このカラムに対して昇順のソート条件にする。
     * @param displayOrder The value of the column 'DISPLAY_ORDER'. (NullAllowed)
     */
    public void setDisplayOrder(Integer displayOrder) {
        __modifiedProperties.add("displayOrder");
        this._displayOrder = displayOrder;
    }

}
