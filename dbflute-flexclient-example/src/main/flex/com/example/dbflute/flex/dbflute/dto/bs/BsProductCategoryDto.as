package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of PRODUCT_CATEGORY as TABLE.
 * <pre>
 * [primary-key]
 *     PRODUCT_CATEGORY_CODE
 * 
 * [column]
 *     PRODUCT_CATEGORY_CODE, PRODUCT_CATEGORY_NAME, PARENT_CATEGORY_CODE
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
 *     PRODUCT_CATEGORY
 * 
 * [referrer-table]
 *     PRODUCT, PRODUCT_CATEGORY
 * 
 * [foreign-property]
 *     productCategorySelf
 * 
 * [referrer-property]
 *     productList, productCategorySelfList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
[Bindable]
public class BsProductCategoryDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _productCategoryCode:String;

    private var _productCategoryName:String;

    private var _parentCategoryCode:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    private var _productCategorySelf:ProductCategoryDto;

    public function get productCategorySelf():ProductCategoryDto {
        return _productCategorySelf;
    }

    public function set productCategorySelf(productCategorySelf:ProductCategoryDto):void {
        this._productCategorySelf = productCategorySelf;
    }

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

    ProductCategoryDto;
    protected var _productCategorySelfList:Array;/* of the entity 'ProductCategoryDto'. */

    public function get productCategorySelfList():Array {
        if (_productCategorySelfList == null) { _productCategorySelfList = new Array(); }
        return _productCategorySelfList;
    }

    public function set productCategorySelfList(productCategorySelfList:Array):void {
        this._productCategorySelfList = productCategorySelfList;
    }


    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get productCategoryCode():String {
        return _productCategoryCode;
    }

    public function set productCategoryCode(productCategoryCode:String):void {
        this._productCategoryCode = productCategoryCode;
    }

    public function get productCategoryName():String {
        return _productCategoryName;
    }

    public function set productCategoryName(productCategoryName:String):void {
        this._productCategoryName = productCategoryName;
    }

    public function get parentCategoryCode():String {
        return _parentCategoryCode;
    }

    public function set parentCategoryCode(parentCategoryCode:String):void {
        this._parentCategoryCode = parentCategoryCode;
    }

}

}
