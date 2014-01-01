package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of WITHDRAWAL_REASON as TABLE.
 * <pre>
 * [primary-key]
 *     WITHDRAWAL_REASON_CODE
 * 
 * [column]
 *     WITHDRAWAL_REASON_CODE, WITHDRAWAL_REASON_TEXT, DISPLAY_ORDER
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
 *     MEMBER_WITHDRAWAL
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberWithdrawalList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
[Bindable]
public class BsWithdrawalReasonDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _withdrawalReasonCode:String;

    private var _withdrawalReasonText:String;

    private var _displayOrder:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    MemberWithdrawalDto;
    protected var _memberWithdrawalList:Array;/* of the entity 'MemberWithdrawalDto'. */

    public function get memberWithdrawalList():Array {
        if (_memberWithdrawalList == null) { _memberWithdrawalList = new Array(); }
        return _memberWithdrawalList;
    }

    public function set memberWithdrawalList(memberWithdrawalList:Array):void {
        this._memberWithdrawalList = memberWithdrawalList;
    }


    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get withdrawalReasonCode():String {
        return _withdrawalReasonCode;
    }

    public function set withdrawalReasonCode(withdrawalReasonCode:String):void {
        this._withdrawalReasonCode = withdrawalReasonCode;
    }

    public function get withdrawalReasonText():String {
        return _withdrawalReasonText;
    }

    public function set withdrawalReasonText(withdrawalReasonText:String):void {
        this._withdrawalReasonText = withdrawalReasonText;
    }

    public function get displayOrder():String {
        return _displayOrder;
    }

    public function set displayOrder(displayOrder:String):void {
        this._displayOrder = displayOrder;
    }

}

}
