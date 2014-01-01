package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of MEMBER_STATUS as TABLE.
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
[Bindable]
public class BsMemberStatusDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _memberStatusCode:String;

    private var _memberStatusName:String;

    private var _description:String;

    private var _displayOrder:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    MemberDto;
    protected var _memberList:Array;/* of the entity 'MemberDto'. */

    public function get memberList():Array {
        if (_memberList == null) { _memberList = new Array(); }
        return _memberList;
    }

    public function set memberList(memberList:Array):void {
        this._memberList = memberList;
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


    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get memberStatusCode():String {
        return _memberStatusCode;
    }

    public function set memberStatusCode(memberStatusCode:String):void {
        this._memberStatusCode = memberStatusCode;
    }

    public function get memberStatusName():String {
        return _memberStatusName;
    }

    public function set memberStatusName(memberStatusName:String):void {
        this._memberStatusName = memberStatusName;
    }

    public function get description():String {
        return _description;
    }

    public function set description(description:String):void {
        this._description = description;
    }

    public function get displayOrder():String {
        return _displayOrder;
    }

    public function set displayOrder(displayOrder:String):void {
        this._displayOrder = displayOrder;
    }

}

}
