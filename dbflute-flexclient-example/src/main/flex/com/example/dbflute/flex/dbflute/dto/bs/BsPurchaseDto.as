package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of PURCHASE as TABLE.
 * <pre>
 * [primary-key]
 *     PURCHASE_ID
 * 
 * [column]
 *     PURCHASE_ID, MEMBER_ID, PRODUCT_ID, PURCHASE_DATETIME, PURCHASE_COUNT, PURCHASE_PRICE, PAYMENT_COMPLETE_FLG, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     PURCHASE_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER, PRODUCT
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, product
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
[Bindable]
public class BsPurchaseDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _purchaseId:String;

    private var _memberId:String;

    private var _productId:String;

    private var _purchaseDatetime:Date;

    private var _purchaseCount:String;

    private var _purchasePrice:String;

    private var _paymentCompleteFlg:String;

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

    private var _product:ProductDto;

    public function get product():ProductDto {
        return _product;
    }

    public function set product(product:ProductDto):void {
        this._product = product;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get purchaseId():String {
        return _purchaseId;
    }

    public function set purchaseId(purchaseId:String):void {
        this._purchaseId = purchaseId;
    }

    public function get memberId():String {
        return _memberId;
    }

    public function set memberId(memberId:String):void {
        this._memberId = memberId;
    }

    public function get productId():String {
        return _productId;
    }

    public function set productId(productId:String):void {
        this._productId = productId;
    }

    public function get purchaseDatetime():Date {
        return _purchaseDatetime;
    }

    public function set purchaseDatetime(purchaseDatetime:Date):void {
        this._purchaseDatetime = purchaseDatetime;
    }

    public function get purchaseCount():String {
        return _purchaseCount;
    }

    public function set purchaseCount(purchaseCount:String):void {
        this._purchaseCount = purchaseCount;
    }

    public function get purchasePrice():String {
        return _purchasePrice;
    }

    public function set purchasePrice(purchasePrice:String):void {
        this._purchasePrice = purchasePrice;
    }

    public function get paymentCompleteFlg():String {
        return _paymentCompleteFlg;
    }

    public function set paymentCompleteFlg(paymentCompleteFlg:String):void {
        this._paymentCompleteFlg = paymentCompleteFlg;
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
