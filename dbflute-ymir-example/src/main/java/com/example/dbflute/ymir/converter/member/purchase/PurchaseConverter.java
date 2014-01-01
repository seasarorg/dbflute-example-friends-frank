package com.example.dbflute.ymir.converter.member.purchase;

import com.example.dbflute.ymir.dbflute.exentity.Purchase;
import com.example.dbflute.ymir.dto.member.purchase.PurchaseDto;

public class PurchaseConverter extends PurchaseConverterBase {
    /*
     * For example, if you want to convert empty String as null value
     * when it is set to an entity, override this method by uncommenting
     * the folling lines.
     *
     * @see PurchaseConverterBase#convertForEntity(Object, Class)
     */
    //    protected <T> T convertForEntity(Object value, Class<T> type) {
    //        return emptyToNull(typeConversionManager.convert(value, type));
    //    }
    @Override
    public PurchaseDto copyEntityToDto(Purchase entity, PurchaseDto dto) {
        dto.setProductName(entity.getProduct().getProductName());
        dto.setIsPaymentComplete(entity.isPaymentCompleteFlgTrue());
        return super.copyEntityToDto(entity, dto);
    }
}
