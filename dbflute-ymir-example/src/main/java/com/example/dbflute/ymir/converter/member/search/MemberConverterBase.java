package com.example.dbflute.ymir.converter.member.search;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.ymir.converter.TypeConversionManager;
import org.seasar.ymir.message.Messages;

import com.example.dbflute.ymir.dbflute.exentity.Member;
import com.example.dbflute.ymir.dto.member.search.MemberDto;

/**
 * A class to convert Dto objects and entity objects.
 * <p>Developer can override methods to customize this class's behavior,
 * and add methods to gain conversion ability.
 * </p>
 */
public class MemberConverterBase {
    protected TypeConversionManager typeConversionManager;

    protected Messages messages;

    @Binding(bindingType = BindingType.MUST)
    final public void setConversionManager(
        TypeConversionManager typeConversionManager) {
        this.typeConversionManager = typeConversionManager;
    }

    @Binding(bindingType = BindingType.MUST)
    final public void setMessages(Messages messages) {
        this.messages = messages;
    }

    /**
     * Gets TypeConversionManager.
     * <p>Gets a TypeConversionManager instance to convert types of object.
     * </p>
     * 
     * @return A TypeConversionManager instance.
     */
    final protected TypeConversionManager getTypeConversionManager() {
        return typeConversionManager;
    }

    /**
     * Gets Messages.
     * <p>Gets a Messages instance to localize messages represented by keys.
     * </p>
     * 
     * @return A Messages instance.
     */
    final protected Messages getMessages() {
        return messages;
    }

    /**
     * Converts object by specified type.
     * <p>Converts object by specified type using TypeConversionManager.
     * </p>
     * 
     * @param value Source object.
     * @param type Destination type.
     * @return Conversion result.
     */
    protected <T> T convert(Object value, Class<T> type) {
        return typeConversionManager.convert(value, type);
    }

    /**
     * Converts object for entity by specified type.
     * <p>This method is used in order to set converted objects to entities.
     * You can change behavior of this method by overriding this method.
     * </p>
     * 
     * @param value source object.
     * @param type destination type.
     * @return conversion result.
     */
    protected <T> T convertForEntity(Object value, Class<T> type) {
        return typeConversionManager.convert(value, type);
    }

    /**
     * Gets String representation of object.
     * <p>Gets String representation of specified object.
     * If the object is null, null is returned.
     * </p>
     * 
     * @param obj Source object.
     * @return String representation.
     */
    final protected String valueOf(Object obj) {
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    /**
     * Returns whether object is empty or not.
     * <p>Returns whether specified object is empty or not.
     * 'Empty' means that a object is null or 0-length String.
     * </p>
     *  
     * @param obj Target object.
     * @return Whether object is empty or not.
     */
    protected boolean isEmpty(Object obj) {
        return (obj == null || obj instanceof String
            && ((String) obj).trim().length() == 0);
    }

    /**
     * Converts null if object is empty.
     * <p>Converts null if specified object is empty.
     * 'Empty' means that a object is null or 0-length String.
     * </p>
     *  
     * @param obj Target object.
     * @return Original object, or null if it is empty.
     */
    protected <T> T emptyToNull(T obj) {
        if (isEmpty(obj)) {
            return null;
        } else {
            return obj;
        }
    }

    /**
     * Copies Member entity to MemberDto instance.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberId</li>
     *   <li>memberName</li>
     *   <li>formalizedDatetime</li>
     *   <li>updateDatetime</li>
     * </ul>
     * 
     * @param entity Source object.
     * @param dto Destination object.
     * @return Dto given as the second argument of this method.
     */
    public MemberDto copyEntityToDto(Member entity, MemberDto dto) {
        reflectMemberIdToDto(entity, dto);
        reflectMemberNameToDto(entity, dto);
        reflectFormalizedDatetimeToDto(entity, dto);
        reflectUpdateDatetimeToDto(entity, dto);

        return dto;
    }

    /**
     * Copies a List of Member entity to a List of MemberDto.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberId</li>
     *   <li>memberName</li>
     *   <li>formalizedDatetime</li>
     *   <li>updateDatetime</li>
     * </ul>
     * 
     * @param entityList Source List.
     * @return Copied List of Dto.
     */
    public List<MemberDto> toDtoList(List<Member> entityList) {
        List<MemberDto> dtoList = new ArrayList<MemberDto>();
        for (Member entity : entityList) {
            dtoList.add(copyEntityToDto(entity, new MemberDto()));
        }
        return dtoList;
    }

    /**
     * Copies 'memberId' property of Member entity to MemberDto instance's 'memberId' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectMemberIdToDto(Member entity, MemberDto dto) {
        dto.setMemberId(extractMemberIdFromEntity(entity));
    }

    /**
     * Extracts 'memberId' property of Member entity in order to copy to MemberDto instance's 'memberId' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected String extractMemberIdFromEntity(Member entity) {
        return convert(entity.getMemberId(), String.class);
    }

    /**
     * Copies 'memberName' property of Member entity to MemberDto instance's 'memberName' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectMemberNameToDto(Member entity, MemberDto dto) {
        dto.setMemberName(extractMemberNameFromEntity(entity));
    }

    /**
     * Extracts 'memberName' property of Member entity in order to copy to MemberDto instance's 'memberName' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected String extractMemberNameFromEntity(Member entity) {
        return convert(entity.getMemberName(), String.class);
    }

    /**
     * Copies 'formalizedDatetime' property of Member entity to MemberDto instance's 'formalizedDatetime' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectFormalizedDatetimeToDto(Member entity, MemberDto dto) {
        dto.setFormalizedDatetime(extractFormalizedDatetimeFromEntity(entity));
    }

    /**
     * Extracts 'formalizedDatetime' property of Member entity in order to copy to MemberDto instance's 'formalizedDatetime' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected Date extractFormalizedDatetimeFromEntity(Member entity) {
        return convert(entity.getFormalizedDatetime(), Date.class);
    }

    /**
     * Copies 'updateDatetime' property of Member entity to MemberDto instance's 'updateDatetime' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectUpdateDatetimeToDto(Member entity, MemberDto dto) {
        dto.setUpdateDatetime(extractUpdateDatetimeFromEntity(entity));
    }

    /**
     * Extracts 'updateDatetime' property of Member entity in order to copy to MemberDto instance's 'updateDatetime' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected Date extractUpdateDatetimeFromEntity(Member entity) {
        return convert(entity.getUpdateDatetime(), Date.class);
    }

    /**
     * Copies MemberDto entity to Member instance.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>formalizedDatetime</li>
     *   <li>memberId</li>
     *   <li>memberName</li>
     *   <li>updateDatetime</li>
     * </ul>
     * 
     * @param dto Source object.
     * @param entity Destination object.
     * @return Entity given as the second argument of this method.
     */
    public Member copyDtoToEntity(MemberDto dto, Member entity) {
        reflectFormalizedDatetimeToEntity(dto, entity);
        reflectMemberIdToEntity(dto, entity);
        reflectMemberNameToEntity(dto, entity);
        reflectUpdateDatetimeToEntity(dto, entity);

        return entity;
    }

    /**
     * Copies a List of MemberDto entity to a List of Member.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>formalizedDatetime</li>
     *   <li>memberId</li>
     *   <li>memberName</li>
     *   <li>updateDatetime</li>
     * </ul>
     * 
     * @param dtoList Source List.
     * @return Copied List of entity.
     */
    public List<Member> toEntityList(List<MemberDto> dtoList) {
        List<Member> entityList = new ArrayList<Member>();
        for (MemberDto dto : dtoList) {
            entityList.add(copyDtoToEntity(dto, new Member()));
        }
        return entityList;
    }

    /**
     * Copies 'formalizedDatetime' property of MemberDto entity to Member instance's 'formalizedDatetime' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectFormalizedDatetimeToEntity(MemberDto dto, Member entity) {
        entity.setFormalizedDatetime(extractFormalizedDatetimeFromDto(dto));
    }

    /**
     * Extracts 'formalizedDatetime' property of MemberDto entity in order to copy to Member instance's 'formalizedDatetime' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Timestamp extractFormalizedDatetimeFromDto(MemberDto dto) {
        return convertForEntity(dto.getFormalizedDatetime(), Timestamp.class);
    }

    /**
     * Copies 'memberId' property of MemberDto entity to Member instance's 'memberId' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectMemberIdToEntity(MemberDto dto, Member entity) {
        entity.setMemberId(extractMemberIdFromDto(dto));
    }

    /**
     * Extracts 'memberId' property of MemberDto entity in order to copy to Member instance's 'memberId' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Integer extractMemberIdFromDto(MemberDto dto) {
        return convertForEntity(dto.getMemberId(), Integer.class);
    }

    /**
     * Copies 'memberName' property of MemberDto entity to Member instance's 'memberName' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectMemberNameToEntity(MemberDto dto, Member entity) {
        entity.setMemberName(extractMemberNameFromDto(dto));
    }

    /**
     * Extracts 'memberName' property of MemberDto entity in order to copy to Member instance's 'memberName' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected String extractMemberNameFromDto(MemberDto dto) {
        return convertForEntity(dto.getMemberName(), String.class);
    }

    /**
     * Copies 'updateDatetime' property of MemberDto entity to Member instance's 'updateDatetime' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectUpdateDatetimeToEntity(MemberDto dto, Member entity) {
        entity.setUpdateDatetime(extractUpdateDatetimeFromDto(dto));
    }

    /**
     * Extracts 'updateDatetime' property of MemberDto entity in order to copy to Member instance's 'updateDatetime' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Timestamp extractUpdateDatetimeFromDto(MemberDto dto) {
        return convertForEntity(dto.getUpdateDatetime(), Timestamp.class);
    }

}
