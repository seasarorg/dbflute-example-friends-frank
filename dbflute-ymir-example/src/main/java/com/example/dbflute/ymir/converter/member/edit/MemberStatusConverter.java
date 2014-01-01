package com.example.dbflute.ymir.converter.member.edit;

public class MemberStatusConverter extends MemberStatusConverterBase
{
    /*
     * For example, if you want to convert empty String as null value
     * when it is set to an entity, override this method by uncommenting
     * the folling lines.
     *
     * @see MemberStatusConverterBase#convertForEntity(Object, Class)
     */      
//    protected <T> T convertForEntity(Object value, Class<T> type) {
//        return emptyToNull(typeConversionManager.convert(value, type));
//    }
}
