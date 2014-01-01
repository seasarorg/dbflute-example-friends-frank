package com.example.dbflute.ymir.converter.member.search;

import com.example.dbflute.ymir.dbflute.exentity.Member;
import com.example.dbflute.ymir.dto.member.search.MemberDto;

public class MemberConverter extends MemberConverterBase {
    /*
     * For example, if you want to convert empty String as null value
     * when it is set to an entity, override this method by uncommenting
     * the following lines.
     *
     * @see MemberConverterBase#convertForEntity(Object, Class)
     */
    //    protected <T> T convertForEntity(Object value, Class<T> type) {
    //        return emptyToNull(typeConversionManager.convert(value, type));
    //    }
    @Override
    public MemberDto copyEntityToDto(Member entity, MemberDto dto) {
        // String Type
        dto.setMemberStatusName(entity.getMemberStatus().getMemberStatusName());

        // Boolean Type
        dto.setEditable(!entity.isMemberStatusCodeWithdrawal());
        dto.setPurchaseLinkVisible(entity.getCountOfPurchase() > 0);

        // Don't forget to call super's method!
        return super.copyEntityToDto(entity, dto);
    }
}
