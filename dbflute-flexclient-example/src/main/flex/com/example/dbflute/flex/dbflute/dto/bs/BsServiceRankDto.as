package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of SERVICE_RANK as TABLE.
 * <pre>
 * [primary-key]
 *     SERVICE_RANK_CODE
 * 
 * [column]
 *     SERVICE_RANK_CODE, SERVICE_RANK_NAME, SERVICE_POINT_INCIDENCE, NEW_ACCEPTABLE_FLG, DESCRIPTION, DISPLAY_ORDER
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
 *     MEMBER_SERVICE
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberServiceList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
[Bindable]
public class BsServiceRankDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _serviceRankCode:String;

    private var _serviceRankName:String;

    private var _servicePointIncidence:Number;

    private var _newAcceptableFlg:String;

    private var _description:String;

    private var _displayOrder:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    MemberServiceDto;
    protected var _memberServiceList:Array;/* of the entity 'MemberServiceDto'. */

    public function get memberServiceList():Array {
        if (_memberServiceList == null) { _memberServiceList = new Array(); }
        return _memberServiceList;
    }

    public function set memberServiceList(memberServiceList:Array):void {
        this._memberServiceList = memberServiceList;
    }


    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get serviceRankCode():String {
        return _serviceRankCode;
    }

    public function set serviceRankCode(serviceRankCode:String):void {
        this._serviceRankCode = serviceRankCode;
    }

    public function get serviceRankName():String {
        return _serviceRankName;
    }

    public function set serviceRankName(serviceRankName:String):void {
        this._serviceRankName = serviceRankName;
    }

    public function get servicePointIncidence():Number {
        return _servicePointIncidence;
    }

    public function set servicePointIncidence(servicePointIncidence:Number):void {
        this._servicePointIncidence = servicePointIncidence;
    }

    public function get newAcceptableFlg():String {
        return _newAcceptableFlg;
    }

    public function set newAcceptableFlg(newAcceptableFlg:String):void {
        this._newAcceptableFlg = newAcceptableFlg;
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
