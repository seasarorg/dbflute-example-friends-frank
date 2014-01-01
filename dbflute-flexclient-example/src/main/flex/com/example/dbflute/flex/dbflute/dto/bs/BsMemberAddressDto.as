package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of MEMBER_ADDRESS as TABLE.
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
[Bindable]
public class BsMemberAddressDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _memberAddressId:String;

    private var _memberId:String;

    private var _validBeginDate:Date;

    private var _validEndDate:Date;

    private var _address:String;

    private var _regionId:String;

    private var _registerDatetime:Date;

    private var _registerUser:String;

    private var _updateDatetime:Date;

    private var _updateUser:String;

    private var _versionNo:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    private var _member:MemberDto;

    public function get member():MemberDto {
        return _member;
    }

    public function set member(member:MemberDto):void {
        this._member = member;
    }

    private var _region:RegionDto;

    public function get region():RegionDto {
        return _region;
    }

    public function set region(region:RegionDto):void {
        this._region = region;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get memberAddressId():String {
        return _memberAddressId;
    }

    public function set memberAddressId(memberAddressId:String):void {
        this._memberAddressId = memberAddressId;
    }

    public function get memberId():String {
        return _memberId;
    }

    public function set memberId(memberId:String):void {
        this._memberId = memberId;
    }

    public function get validBeginDate():Date {
        return _validBeginDate;
    }

    public function set validBeginDate(validBeginDate:Date):void {
        this._validBeginDate = validBeginDate;
    }

    public function get validEndDate():Date {
        return _validEndDate;
    }

    public function set validEndDate(validEndDate:Date):void {
        this._validEndDate = validEndDate;
    }

    public function get address():String {
        return _address;
    }

    public function set address(address:String):void {
        this._address = address;
    }

    public function get regionId():String {
        return _regionId;
    }

    public function set regionId(regionId:String):void {
        this._regionId = regionId;
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
