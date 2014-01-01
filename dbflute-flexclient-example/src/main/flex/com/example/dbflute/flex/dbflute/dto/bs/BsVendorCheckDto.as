package com.example.dbflute.flex.dbflute.dto.bs {

import com.example.dbflute.flex.dbflute.dto.*;

/**
 * The flex DTO of VENDOR_CHECK as TABLE.
 * <pre>
 * [primary-key]
 *     VENDOR_CHECK_ID
 * 
 * [column]
 *     VENDOR_CHECK_ID, TYPE_OF_CHAR, TYPE_OF_VARCHAR, TYPE_OF_CLOB, TYPE_OF_TEXT, TYPE_OF_NUMERIC_INTEGER, TYPE_OF_NUMERIC_BIGINT, TYPE_OF_NUMERIC_DECIMAL, TYPE_OF_NUMERIC_INTEGER_MIN, TYPE_OF_NUMERIC_INTEGER_MAX, TYPE_OF_NUMERIC_BIGINT_MIN, TYPE_OF_NUMERIC_BIGINT_MAX, TYPE_OF_NUMERIC_SUPERINT_MIN, TYPE_OF_NUMERIC_SUPERINT_MAX, TYPE_OF_NUMERIC_MAXDECIMAL, TYPE_OF_INTEGER, TYPE_OF_BIGINT, TYPE_OF_DATE, TYPE_OF_TIMESTAMP, TYPE_OF_TIME, TYPE_OF_BOOLEAN, TYPE_OF_BINARY, TYPE_OF_BLOB, TYPE_OF_UUID, TYPE_OF_ARRAY, TYPE_OF_OTHER, U_Y_TEXT
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
public class BsVendorCheckDto {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private var _vendorCheckId:Number;

    private var _typeOfChar:String;

    private var _typeOfVarchar:String;

    private var _typeOfClob:String;

    private var _typeOfText:String;

    private var _typeOfNumericInteger:Number;

    private var _typeOfNumericBigint:Number;

    private var _typeOfNumericDecimal:Number;

    private var _typeOfNumericIntegerMin:Number;

    private var _typeOfNumericIntegerMax:Number;

    private var _typeOfNumericBigintMin:Number;

    private var _typeOfNumericBigintMax:Number;

    private var _typeOfNumericSuperintMin:Number;

    private var _typeOfNumericSuperintMax:Number;

    private var _typeOfNumericMaxdecimal:Number;

    private var _typeOfInteger:String;

    private var _typeOfBigint:String;

    private var _typeOfDate:Date;

    private var _typeOfTimestamp:Date;

    private var _typeOfTime:Date;

    private var _typeOfBoolean:Boolean;

    private var _typeOfBinary:Object;

    private var _typeOfBlob:Object;

    private var _typeOfUuid:Object;

    private var _typeOfArray:String;

    private var _typeOfOther:String;

    private var _uYText:String;


    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public function get vendorCheckId():Number {
        return _vendorCheckId;
    }

    public function set vendorCheckId(vendorCheckId:Number):void {
        this._vendorCheckId = vendorCheckId;
    }

    public function get typeOfChar():String {
        return _typeOfChar;
    }

    public function set typeOfChar(typeOfChar:String):void {
        this._typeOfChar = typeOfChar;
    }

    public function get typeOfVarchar():String {
        return _typeOfVarchar;
    }

    public function set typeOfVarchar(typeOfVarchar:String):void {
        this._typeOfVarchar = typeOfVarchar;
    }

    public function get typeOfClob():String {
        return _typeOfClob;
    }

    public function set typeOfClob(typeOfClob:String):void {
        this._typeOfClob = typeOfClob;
    }

    public function get typeOfText():String {
        return _typeOfText;
    }

    public function set typeOfText(typeOfText:String):void {
        this._typeOfText = typeOfText;
    }

    public function get typeOfNumericInteger():Number {
        return _typeOfNumericInteger;
    }

    public function set typeOfNumericInteger(typeOfNumericInteger:Number):void {
        this._typeOfNumericInteger = typeOfNumericInteger;
    }

    public function get typeOfNumericBigint():Number {
        return _typeOfNumericBigint;
    }

    public function set typeOfNumericBigint(typeOfNumericBigint:Number):void {
        this._typeOfNumericBigint = typeOfNumericBigint;
    }

    public function get typeOfNumericDecimal():Number {
        return _typeOfNumericDecimal;
    }

    public function set typeOfNumericDecimal(typeOfNumericDecimal:Number):void {
        this._typeOfNumericDecimal = typeOfNumericDecimal;
    }

    public function get typeOfNumericIntegerMin():Number {
        return _typeOfNumericIntegerMin;
    }

    public function set typeOfNumericIntegerMin(typeOfNumericIntegerMin:Number):void {
        this._typeOfNumericIntegerMin = typeOfNumericIntegerMin;
    }

    public function get typeOfNumericIntegerMax():Number {
        return _typeOfNumericIntegerMax;
    }

    public function set typeOfNumericIntegerMax(typeOfNumericIntegerMax:Number):void {
        this._typeOfNumericIntegerMax = typeOfNumericIntegerMax;
    }

    public function get typeOfNumericBigintMin():Number {
        return _typeOfNumericBigintMin;
    }

    public function set typeOfNumericBigintMin(typeOfNumericBigintMin:Number):void {
        this._typeOfNumericBigintMin = typeOfNumericBigintMin;
    }

    public function get typeOfNumericBigintMax():Number {
        return _typeOfNumericBigintMax;
    }

    public function set typeOfNumericBigintMax(typeOfNumericBigintMax:Number):void {
        this._typeOfNumericBigintMax = typeOfNumericBigintMax;
    }

    public function get typeOfNumericSuperintMin():Number {
        return _typeOfNumericSuperintMin;
    }

    public function set typeOfNumericSuperintMin(typeOfNumericSuperintMin:Number):void {
        this._typeOfNumericSuperintMin = typeOfNumericSuperintMin;
    }

    public function get typeOfNumericSuperintMax():Number {
        return _typeOfNumericSuperintMax;
    }

    public function set typeOfNumericSuperintMax(typeOfNumericSuperintMax:Number):void {
        this._typeOfNumericSuperintMax = typeOfNumericSuperintMax;
    }

    public function get typeOfNumericMaxdecimal():Number {
        return _typeOfNumericMaxdecimal;
    }

    public function set typeOfNumericMaxdecimal(typeOfNumericMaxdecimal:Number):void {
        this._typeOfNumericMaxdecimal = typeOfNumericMaxdecimal;
    }

    public function get typeOfInteger():String {
        return _typeOfInteger;
    }

    public function set typeOfInteger(typeOfInteger:String):void {
        this._typeOfInteger = typeOfInteger;
    }

    public function get typeOfBigint():String {
        return _typeOfBigint;
    }

    public function set typeOfBigint(typeOfBigint:String):void {
        this._typeOfBigint = typeOfBigint;
    }

    public function get typeOfDate():Date {
        return _typeOfDate;
    }

    public function set typeOfDate(typeOfDate:Date):void {
        this._typeOfDate = typeOfDate;
    }

    public function get typeOfTimestamp():Date {
        return _typeOfTimestamp;
    }

    public function set typeOfTimestamp(typeOfTimestamp:Date):void {
        this._typeOfTimestamp = typeOfTimestamp;
    }

    public function get typeOfTime():Date {
        return _typeOfTime;
    }

    public function set typeOfTime(typeOfTime:Date):void {
        this._typeOfTime = typeOfTime;
    }

    public function get typeOfBoolean():Boolean {
        return _typeOfBoolean;
    }

    public function set typeOfBoolean(typeOfBoolean:Boolean):void {
        this._typeOfBoolean = typeOfBoolean;
    }

    public function get typeOfBinary():Object {
        return _typeOfBinary;
    }

    public function set typeOfBinary(typeOfBinary:Object):void {
        this._typeOfBinary = typeOfBinary;
    }

    public function get typeOfBlob():Object {
        return _typeOfBlob;
    }

    public function set typeOfBlob(typeOfBlob:Object):void {
        this._typeOfBlob = typeOfBlob;
    }

    public function get typeOfUuid():Object {
        return _typeOfUuid;
    }

    public function set typeOfUuid(typeOfUuid:Object):void {
        this._typeOfUuid = typeOfUuid;
    }

    public function get typeOfArray():String {
        return _typeOfArray;
    }

    public function set typeOfArray(typeOfArray:String):void {
        this._typeOfArray = typeOfArray;
    }

    public function get typeOfOther():String {
        return _typeOfOther;
    }

    public function set typeOfOther(typeOfOther:String):void {
        this._typeOfOther = typeOfOther;
    }

    public function get uYText():String {
        return _uYText;
    }

    public function set uYText(uYText:String):void {
        this._uYText = uYText;
    }

}

}
