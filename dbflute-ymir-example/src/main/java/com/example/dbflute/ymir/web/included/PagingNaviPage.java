package com.example.dbflute.ymir.web.included;

import java.util.ArrayList;
import java.util.List;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.cbean.PagingResultBean;

import com.example.dbflute.ymir.dto.pagingnavi.PagingNaviDto;
import com.example.dbflute.ymir.dto.pagingnavi.PagingNumberDto;

/**
 * @author jflute
 */
public class PagingNaviPage extends com.example.dbflute.ymir.web.PageBase {
    
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected PagingNaviDto pagingNavi;

    protected PagingResultBean<? extends Entity> pagingResult;

    protected Integer current;

    // ===================================================================================
    //                                                                          Pre-render
    //                                                                          ==========
    public void _prerender() {
        setupPagingNavi();
    }

    // ===================================================================================
    //                                                                              Set up
    //                                                                              ======
    protected void setupPagingNavi() {
        if (pagingResult == null) {
            return;
        }
        PagingNaviDto pagingNaviDto = new PagingNaviDto();
        pagingNaviDto.setCurrentPageNumber(pagingResult.getCurrentPageNumber());
        pagingNaviDto.setAllRecordCount(pagingResult.getAllRecordCount());
        pagingNaviDto.setAllPageCount(pagingResult.getAllPageCount());
        if (pagingResult.isExistPrePage()) {
            pagingNaviDto.setExistPrePage(true);
            pagingNaviDto.setPrePageNumber(pagingResult.getCurrentPageNumber() - 1);
        }
        if (pagingResult.isExistNextPage()) {
            pagingNaviDto.setExistNextPage(true);
            pagingNaviDto.setNextPageNumber(pagingResult.getCurrentPageNumber() + 1);
        }
        List<PagingNumberDto> pagingNumberList = new ArrayList<PagingNumberDto>();
        pagingResult.setPageRangeSize(3); // It prefers to get the one from configuration actually.
        for (Integer pageNumber : pagingResult.pageRange().createPageNumberList()) {
            PagingNumberDto pageNumberDto = new PagingNumberDto();
            pageNumberDto.setCurrent(pageNumber.intValue() == pagingResult.getCurrentPageNumber());
            pageNumberDto.setValue(pageNumber);
            pagingNumberList.add(pageNumberDto);
        }
        pagingNaviDto.setPagingNumberItems(pagingNumberList);
        pagingNavi = pagingNaviDto;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public PagingNaviDto getPagingNavi() {
        return pagingNavi;
    }

    public void setPagingNavi(PagingNaviDto pagingNavi) {
        this.pagingNavi = pagingNavi;
    }

    public PagingResultBean<? extends Entity> getPagingResult() {
        return pagingResult;
    }

    public void setPagingResult(PagingResultBean<? extends Entity> pagingResult) {
        this.pagingResult = pagingResult;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}
