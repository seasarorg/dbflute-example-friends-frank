package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of PRODUCT_STATUS as TABLE.
 * <pre>
 * [primary-key]
 *     PRODUCT_STATUS_CODE
 * 
 * [column]
 *     PRODUCT_STATUS_CODE, PRODUCT_STATUS_NAME, DISPLAY_ORDER
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
 *     PRODUCT
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     productList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
[Bindable]
public class BsProductStatusDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _productStatusCode:String;

    private var _productStatusName:String;

    private var _displayOrder:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    ProductDto;
    protected var _productList:Array;/* of the entity 'ProductDto'. */

    public function get productList():Array {
        if (_productList == null) { _productList = new Array(); }
        return _productList;
    }

    public function set productList(productList:Array):void {
        this._productList = productList;
    }


    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get productStatusCode():String {
        return _productStatusCode;
    }

    public function set productStatusCode(productStatusCode:String):void {
        this._productStatusCode = productStatusCode;
    }

    public function get productStatusName():String {
        return _productStatusName;
    }

    public function set productStatusName(productStatusName:String):void {
        this._productStatusName = productStatusName;
    }

    public function get displayOrder():String {
        return _displayOrder;
    }

    public function set displayOrder(displayOrder:String):void {
        this._displayOrder = displayOrder;
    }

}

}
