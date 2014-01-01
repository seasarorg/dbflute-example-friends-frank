package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of PRODUCT as TABLE.
 * <pre>
 * [primary-key]
 *     PRODUCT_ID
 * 
 * [column]
 *     PRODUCT_ID, PRODUCT_NAME, PRODUCT_HANDLE_CODE, PRODUCT_CATEGORY_CODE, PRODUCT_STATUS_CODE, REGULAR_PRICE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     PRODUCT_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     PRODUCT_CATEGORY, PRODUCT_STATUS
 * 
 * [referrer-table]
 *     PURCHASE
 * 
 * [foreign-property]
 *     productCategory, productStatus
 * 
 * [referrer-property]
 *     purchaseList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
[Bindable]
public class BsProductDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _productId:String;

    private var _productName:String;

    private var _productHandleCode:String;

    private var _productCategoryCode:String;

    private var _productStatusCode:String;

    private var _regularPrice:String;

    private var _registerDatetime:Date;

    private var _registerUser:String;

    private var _updateDatetime:Date;

    private var _updateUser:String;

    private var _versionNo:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    private var _productCategory:ProductCategoryDto;

    public function get productCategory():ProductCategoryDto {
        return _productCategory;
    }

    public function set productCategory(productCategory:ProductCategoryDto):void {
        this._productCategory = productCategory;
    }

    private var _productStatus:ProductStatusDto;

    public function get productStatus():ProductStatusDto {
        return _productStatus;
    }

    public function set productStatus(productStatus:ProductStatusDto):void {
        this._productStatus = productStatus;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
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

    public function get productCategoryCode():String {
        return _productCategoryCode;
    }

    public function set productCategoryCode(productCategoryCode:String):void {
        this._productCategoryCode = productCategoryCode;
    }

    public function get productStatusCode():String {
        return _productStatusCode;
    }

    public function set productStatusCode(productStatusCode:String):void {
        this._productStatusCode = productStatusCode;
    }

    public function get regularPrice():String {
        return _regularPrice;
    }

    public function set regularPrice(regularPrice:String):void {
        this._regularPrice = regularPrice;
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
