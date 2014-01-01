package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of REGION as TABLE.
 * <pre>
 * [primary-key]
 *     REGION_ID
 * 
 * [column]
 *     REGION_ID, REGION_NAME
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
 *     MEMBER_ADDRESS
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberAddressList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
[Bindable]
public class BsRegionDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _regionId:String;

    private var _regionName:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
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


    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get regionId():String {
        return _regionId;
    }

    public function set regionId(regionId:String):void {
        this._regionId = regionId;
    }

    public function get regionName():String {
        return _regionName;
    }

    public function set regionName(regionName:String):void {
        this._regionName = regionName;
    }

}

}
