package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of MEMBER_LOGIN as TABLE.
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
 * [foreign-table]
 *     MEMBER, MEMBER_STATUS
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, memberStatus
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
[Bindable]
public class BsMemberLoginDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _memberLoginId:String;

    private var _memberId:String;

    private var _loginDatetime:Date;

    private var _mobileLoginFlg:String;

    private var _loginMemberStatusCode:String;


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

    private var _memberStatus:MemberStatusDto;

    public function get memberStatus():MemberStatusDto {
        return _memberStatus;
    }

    public function set memberStatus(memberStatus:MemberStatusDto):void {
        this._memberStatus = memberStatus;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get memberLoginId():String {
        return _memberLoginId;
    }

    public function set memberLoginId(memberLoginId:String):void {
        this._memberLoginId = memberLoginId;
    }

    public function get memberId():String {
        return _memberId;
    }

    public function set memberId(memberId:String):void {
        this._memberId = memberId;
    }

    public function get loginDatetime():Date {
        return _loginDatetime;
    }

    public function set loginDatetime(loginDatetime:Date):void {
        this._loginDatetime = loginDatetime;
    }

    public function get mobileLoginFlg():String {
        return _mobileLoginFlg;
    }

    public function set mobileLoginFlg(mobileLoginFlg:String):void {
        this._mobileLoginFlg = mobileLoginFlg;
    }

    public function get loginMemberStatusCode():String {
        return _loginMemberStatusCode;
    }

    public function set loginMemberStatusCode(loginMemberStatusCode:String):void {
        this._loginMemberStatusCode = loginMemberStatusCode;
    }

}

}
