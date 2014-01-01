package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of SUMMARY_PRODUCT as VIEW.
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     PRODUCT_ID, PRODUCT_NAME, PRODUCT_HANDLE_CODE, PRODUCT_STATUS_CODE, LATEST_PURCHASE_DATETIME
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
public class BsSummaryProductDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _productId:String;

    private var _productName:String;

    private var _productHandleCode:String;

    private var _productStatusCode:String;

    private var _latestPurchaseDatetime:Date;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get productId():String {
        return _productId;
    }

    public function set productId(productId:String):void {
        this._productId = productId;
    }

    public function get productName():String {
        return _productName;
    }

    public function set productName(productName:String):void {
        this._productName = productName;
    }

    public function get productHandleCode():String {
        return _productHandleCode;
    }

    public function set productHandleCode(productHandleCode:String):void {
        this._productHandleCode = productHandleCode;
    }

    public function get productStatusCode():String {
        return _productStatusCode;
    }

    public function set productStatusCode(productStatusCode:String):void {
        this._productStatusCode = productStatusCode;
    }

    public function get latestPurchaseDatetime():Date {
        return _latestPurchaseDatetime;
    }

    public function set latestPurchaseDatetime(latestPurchaseDatetime:Date):void {
        this._latestPurchaseDatetime = latestPurchaseDatetime;
    }

}

}
