package com.example.dbflute.flex.simpleflute.dto.bs;

import java.io.Serializable;
import java.util.*;

import com.example.dbflute.flex.simpleflute.dto.*;

/**
 * The simple DTO of PRODUCT_CATEGORY as TABLE. <br />
 * 商品カテゴリ: 商品のカテゴリを表現するマスタ。<br />
 * 自己参照の階層になっている。
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
public abstract class BsProductCategoryDto implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** PRODUCT_CATEGORY_CODE: {PK, NotNull, CHAR(3)} */
    protected String _productCategoryCode;

    /** PRODUCT_CATEGORY_NAME: {NotNull, VARCHAR(50)} */
    protected String _productCategoryName;

    /** PARENT_CATEGORY_CODE: {IX, CHAR(3), FK to PRODUCT_CATEGORY} */
    protected String _parentCategoryCode;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this DTO. */
    protected final Set<String> __modifiedProperties = new LinkedHashSet<String>();

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsProductCategoryDto() {
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    protected ProductCategoryDto _productCategorySelf;

    public ProductCategoryDto getProductCategorySelf() {
        return _productCategorySelf;
    }

    public void setProductCategorySelf(ProductCategoryDto productCategorySelf) {
        this._productCategorySelf = productCategorySelf;
    }

    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    protected List<ProductDto> _productList;

    public List<ProductDto> getProductList() {
        if (_productList == null) { _productList = new ArrayList<ProductDto>(); }
        return _productList;
    }

    public void setProductList(List<ProductDto> productList) {
        this._productList = productList;
    }

    protected List<ProductCategoryDto> _productCategorySelfList;

    public List<ProductCategoryDto> getProductCategorySelfList() {
        if (_productCategorySelfList == null) { _productCategorySelfList = new ArrayList<ProductCategoryDto>(); }
        return _productCategorySelfList;
    }

    public void setProductCategorySelfList(List<ProductCategoryDto> productCategorySelfList) {
        this._productCategorySelfList = productCategorySelfList;
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    public Set<String> modifiedProperties() {
        return __modifiedProperties;
    }

    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsProductCategoryDto)) { return false; }
        final BsProductCategoryDto otherEntity = (BsProductCategoryDto)other;
        if (!helpComparingValue(getProductCategoryCode(), otherEntity.getProductCategoryCode())) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    public int hashCode() {
        int result = 17;
        result = xCH(result, "PRODUCT_CATEGORY");
        result = xCH(result, getProductCategoryCode());
        return result;
    }
    protected int xCH(int result, Object value) { // calculateHashcode()
        if (value == null) {
            return result;
        }
        return (31 * result) + (value instanceof byte[] ? ((byte[]) value).length : value.hashCode());
    }

    public int instanceHash() {
        return super.hashCode();
    }

    public String toString() {
        String c = ", ";
        StringBuilder sb = new StringBuilder();
        sb.append(c).append(getProductCategoryCode());
        sb.append(c).append(getProductCategoryName());
        sb.append(c).append(getParentCategoryCode());
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] PRODUCT_CATEGORY_CODE: {PK, NotNull, CHAR(3)} <br />
     * 商品カテゴリコード:
     * @return The value of the column 'PRODUCT_CATEGORY_CODE'. (NullAllowed)
     */
    public String getProductCategoryCode() {
        return _productCategoryCode;
    }

    /**
     * [set] PRODUCT_CATEGORY_CODE: {PK, NotNull, CHAR(3)} <br />
     * 商品カテゴリコード:
     * @param productCategoryCode The value of the column 'PRODUCT_CATEGORY_CODE'. (NullAllowed)
     */
    public void setProductCategoryCode(String productCategoryCode) {
        __modifiedProperties.add("productCategoryCode");
        this._productCategoryCode = productCategoryCode;
    }

    /**
     * [get] PRODUCT_CATEGORY_NAME: {NotNull, VARCHAR(50)} <br />
     * 商品カテゴリ名称:
     * @return The value of the column 'PRODUCT_CATEGORY_NAME'. (NullAllowed)
     */
    public String getProductCategoryName() {
        return _productCategoryName;
    }

    /**
     * [set] PRODUCT_CATEGORY_NAME: {NotNull, VARCHAR(50)} <br />
     * 商品カテゴリ名称:
     * @param productCategoryName The value of the column 'PRODUCT_CATEGORY_NAME'. (NullAllowed)
     */
    public void setProductCategoryName(String productCategoryName) {
        __modifiedProperties.add("productCategoryName");
        this._productCategoryName = productCategoryName;
    }

    /**
     * [get] PARENT_CATEGORY_CODE: {IX, CHAR(3), FK to PRODUCT_CATEGORY} <br />
     * 親カテゴリコード: 最上位の場合はデータなし。
     * @return The value of the column 'PARENT_CATEGORY_CODE'. (NullAllowed)
     */
    public String getParentCategoryCode() {
        return _parentCategoryCode;
    }

    /**
     * [set] PARENT_CATEGORY_CODE: {IX, CHAR(3), FK to PRODUCT_CATEGORY} <br />
     * 親カテゴリコード: 最上位の場合はデータなし。
     * @param parentCategoryCode The value of the column 'PARENT_CATEGORY_CODE'. (NullAllowed)
     */
    public void setParentCategoryCode(String parentCategoryCode) {
        __modifiedProperties.add("parentCategoryCode");
        this._parentCategoryCode = parentCategoryCode;
    }

}
