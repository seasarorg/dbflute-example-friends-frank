package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of MEMBER as TABLE.
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
[Bindable]
public class BsMemberDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _memberId:String;

    private var _memberName:String;

    private var _memberAccount:String;

    private var _memberStatusCode:String;

    private var _formalizedDatetime:Date;

    private var _birthdate:Date;

    private var _registerDatetime:Date;

    private var _registerUser:String;

    private var _updateDatetime:Date;

    private var _updateUser:String;

    private var _versionNo:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    private var _memberStatus:MemberStatusDto;

    public function get memberStatus():MemberStatusDto {
        return _memberStatus;
    }

    public function set memberStatus(memberStatus:MemberStatusDto):void {
        this._memberStatus = memberStatus;
    }

    private var _memberLoginAsLatest:MemberLoginDto;

    public function get memberLoginAsLatest():MemberLoginDto {
        return _memberLoginAsLatest;
    }

    public function set memberLoginAsLatest(memberLoginAsLatest:MemberLoginDto):void {
        this._memberLoginAsLatest = memberLoginAsLatest;
    }

    private var _memberSecurityAsOne:MemberSecurityDto;

    public function get memberSecurityAsOne():MemberSecurityDto {
        return _memberSecurityAsOne;
    }

    public function set memberSecurityAsOne(memberSecurityAsOne:MemberSecurityDto):void {
        this._memberSecurityAsOne = memberSecurityAsOne;
    }
    private var _memberServiceAsOne:MemberServiceDto;

    public function get memberServiceAsOne():MemberServiceDto {
        return _memberServiceAsOne;
    }

    public function set memberServiceAsOne(memberServiceAsOne:MemberServiceDto):void {
        this._memberServiceAsOne = memberServiceAsOne;
    }
    private var _memberWithdrawalAsOne:MemberWithdrawalDto;

    public function get memberWithdrawalAsOne():MemberWithdrawalDto {
        return _memberWithdrawalAsOne;
    }

    public function set memberWithdrawalAsOne(memberWithdrawalAsOne:MemberWithdrawalDto):void {
        this._memberWithdrawalAsOne = memberWithdrawalAsOne;
    }
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    MemberAddressDto;
    protected var _memberAddressList:Array;/* of the entity 'MemberAddressDto'. */

    public function get memberAddressList():Array {
        if (_memberAddressList == null) { _memberAddressList = new Array(); }
        return _memberAddressList;
    }

    public function set memberAddressList(memberAddressList:Array):void {
        this._memberAddressList = memberAddressList;
    }

    MemberLoginDto;
    protected var _memberLoginList:Array;/* of the entity 'MemberLoginDto'. */

    public function get memberLoginList():Array {
        if (_memberLoginList == null) { _memberLoginList = new Array(); }
        return _memberLoginList;
    }

    public function set memberLoginList(memberLoginList:Array):void {
        this._memberLoginList = memberLoginList;
    }

    PurchaseDto;
    protected var _purchaseList:Array;/* of the entity 'PurchaseDto'. */

    public function get purchaseList():Array {
        if (_purchaseList == null) { _purchaseList = new Array(); }
        return _purchaseList;
    }

    public function set purchaseList(purchaseList:Array):void {
        this._purchaseList = purchaseList;
    }


    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get memberId():String {
        return _memberId;
    }

    public function set memberId(memberId:String):void {
        this._memberId = memberId;
    }

    public function get memberName():String {
        return _memberName;
    }

    public function set memberName(memberName:String):void {
        this._memberName = memberName;
    }

    public function get memberAccount():String {
        return _memberAccount;
    }

    public function set memberAccount(memberAccount:String):void {
        this._memberAccount = memberAccount;
    }

    public function get memberStatusCode():String {
        return _memberStatusCode;
    }

    public function set memberStatusCode(memberStatusCode:String):void {
        this._memberStatusCode = memberStatusCode;
    }

    public function get formalizedDatetime():Date {
        return _formalizedDatetime;
    }

    public function set formalizedDatetime(formalizedDatetime:Date):void {
        this._formalizedDatetime = formalizedDatetime;
    }

    public function get birthdate():Date {
        return _birthdate;
    }

    public function set birthdate(birthdate:Date):void {
        this._birthdate = birthdate;
    }

    public function get registerDatetime():Date {
        return _registerDatetime;
    }

    public function set registerDatetime(registerDatetime:Date):void {
        this._registerDatetime = registerDatetime;
    }

    public function get registerUser():String {
        return _registerUser;
    }

    public function set registerUser(registerUser:String):void {
        this._registerUser = registerUser;
    }

    public function get updateDatetime():Date {
        return _updateDatetime;
    }

    public function set updateDatetime(updateDatetime:Date):void {
        this._updateDatetime = updateDatetime;
    }

    public function get updateUser():String {
        return _updateUser;
    }

    public function set updateUser(updateUser:String):void {
        this._updateUser = updateUser;
    }

    public function get versionNo():String {
        return _versionNo;
    }

    public function set versionNo(versionNo:String):void {
        this._versionNo = versionNo;
    }

}

}
