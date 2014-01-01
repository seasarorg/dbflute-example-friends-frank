package com.example.dbflute.ymir.converter.member.edit;

public class InputFormConverter extends InputFormConverterBase {
    /*
     * For example, if you want to convert empty String as null value
     * when it is set to an entity, override this method by uncommenting
     * the folling lines.
     *
     * @see InputFormConverterBase#convertForEntity(Object, Class)
     */
    //    protected <T> T convertForEntity(Object value, Class<T> type) {
    //        return emptyToNull(typeConversionManager.convert(value, type));
    //    }
}
