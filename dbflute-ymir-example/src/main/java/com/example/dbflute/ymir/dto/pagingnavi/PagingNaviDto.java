package com.example.dbflute.ymir.dto.pagingnavi;

import java.io.Serializable;
import java.util.List;

/**
 * @author jflute
 */
public class PagingNaviDto implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Integer currentPageNumber;

    protected Integer allPageCount;

    protected Integer allRecordCount;

    protected boolean existPrePage;

    protected Integer prePageNumber;

    protected java.util.List<PagingNumberDto> pagingNumberItems;

    protected boolean existNextPage;

    protected Integer nextPageNumber;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public PagingNaviDto() {
    }

    public PagingNaviDto(Integer allPageCount, Integer allRecordCount, Integer currentPageNumber,
            boolean existNextPage, boolean existPrePage, Integer nextPageNumber,
            java.util.List<PagingNumberDto> pageNumberItems, Integer prePageNumber) {
        this.allPageCount = allPageCount;
        this.allRecordCount = allRecordCount;
        this.currentPageNumber = currentPageNumber;
        this.existNextPage = existNextPage;
        this.existPrePage = existPrePage;
        this.nextPageNumber = nextPageNumber;
        this.pagingNumberItems = pageNumberItems;
        this.prePageNumber = prePageNumber;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append('(');
        append(sb.append("currentPageNumber="), currentPageNumber).append(", ");
        append(sb.append("allPageCount="), allPageCount).append(", ");
        append(sb.append("allRecordCount="), allRecordCount).append(", ");
        append(sb.append("existPrePage="), existPrePage).append(", ");
        append(sb.append("prePageNumber="), prePageNumber).append(", ");
        append(sb.append("pageNumberItems="), pagingNumberItems).append(", ");
        append(sb.append("existNextPage="), existNextPage).append(", ");
        append(sb.append("nextPageNumber="), nextPageNumber);
        sb.append(')');
        return toString(sb);
    }

    protected StringBuilder append(StringBuilder sb, Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            sb.append('{');
            int len = java.lang.reflect.Array.getLength(obj);
            String delim = "";
            for (int i = 0; i < len; i++) {
                sb.append(delim);
                delim = ", ";
                append(sb, java.lang.reflect.Array.get(obj, i));
            }
            sb.append('}');
        } else {
            sb.append(obj);
        }
        return sb;
    }

    protected String toString(StringBuilder sb) {
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Integer getCurrentPageNumber() {
        return this.currentPageNumber;
    }

    public void setCurrentPageNumber(Integer currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public Integer getAllPageCount() {
        return this.allPageCount;
    }

    public void setAllPageCount(Integer allPageCount) {
        this.allPageCount = allPageCount;
    }

    public Integer getAllRecordCount() {
        return this.allRecordCount;
    }

    public void setAllRecordCount(Integer allRecordCount) {
        this.allRecordCount = allRecordCount;
    }

    public boolean isExistPrePage() {
        return this.existPrePage;
    }

    public void setExistPrePage(boolean existPrePage) {
        this.existPrePage = existPrePage;
    }

    public Integer getPrePageNumber() {
        return this.prePageNumber;
    }

    public void setPrePageNumber(Integer prePageNumber) {
        this.prePageNumber = prePageNumber;
    }

    public List<PagingNumberDto> getPagingNumberItems() {
        return this.pagingNumberItems;
    }

    public void setPagingNumberItems(List<PagingNumberDto> pagingNumberItems) {
        this.pagingNumberItems = pagingNumberItems;
    }

    public boolean isExistNextPage() {
        return this.existNextPage;
    }

    public void setExistNextPage(boolean existNextPage) {
        this.existNextPage = existNextPage;
    }

    public Integer getNextPageNumber() {
        return this.nextPageNumber;
    }

    public void setNextPageNumber(Integer nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }
}
