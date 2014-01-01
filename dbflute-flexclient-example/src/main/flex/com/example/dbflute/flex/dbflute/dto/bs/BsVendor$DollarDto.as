package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of VENDOR_$_DOLLAR as TABLE.
 * <pre>
 * [primary-key]
 *     VENDOR_$_DOLLAR_ID
 * 
 * [column]
 *     VENDOR_$_DOLLAR_ID, VENDOR_$_DOLLAR_NAME
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
 *     
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
[Bindable]
public class BsVendor$DollarDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _vendor$DollarId:String;

    private var _vendor$DollarName:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get vendor$DollarId():String {
        return _vendor$DollarId;
    }

    public function set vendor$DollarId(vendor$DollarId:String):void {
        this._vendor$DollarId = vendor$DollarId;
    }

    public function get vendor$DollarName():String {
        return _vendor$DollarName;
    }

    public function set vendor$DollarName(vendor$DollarName:String):void {
        this._vendor$DollarName = vendor$DollarName;
    }

}

}
