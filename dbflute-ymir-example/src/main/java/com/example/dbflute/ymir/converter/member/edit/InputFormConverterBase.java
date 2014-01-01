package com.example.dbflute.ymir.converter.member.edit;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.ymir.converter.TypeConversionManager;
import org.seasar.ymir.message.Messages;

import com.example.dbflute.ymir.dbflute.exentity.Member;
import com.example.dbflute.ymir.dto.member.edit.InputFormDto;

/**
 * A class to convert Dto objects and entity objects.
 * <p>Developer can override methods to customize this class's behavior,
 * and add methods to gain conversion ability.
 * </p>
 */
public class InputFormConverterBase {
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
     * Copies Member entity to InputFormDto instance.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberId</li>
     *   <li>memberName</li>
     *   <li>memberAccount</li>
     *   <li>memberStatusCode</li>
     *   <li>birthdate</li>
     *   <li>formalizedDatetime</li>
     *   <li>latestLoginDatetime</li>
     *   <li>updateDatetime</li>
     *   <li>versionNo</li>
     * </ul>
     * 
     * @param entity Source object.
     * @param dto Destination object.
     * @return The first argument of this method.
     */
    public InputFormDto copyEntityToDto(Member entity, InputFormDto dto) {
        reflectMemberIdToDto(entity, dto);
        reflectMemberNameToDto(entity, dto);
        reflectMemberAccountToDto(entity, dto);
        reflectMemberStatusCodeToDto(entity, dto);
        reflectBirthdateToDto(entity, dto);
        reflectFormalizedDatetimeToDto(entity, dto);
        reflectLatestLoginDatetimeToDto(entity, dto);
        reflectUpdateDatetimeToDto(entity, dto);
        reflectVersionNoToDto(entity, dto);

        return dto;
    }

    /**
     * Copies a List of Member entity to a List of InputFormDto.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberId</li>
     *   <li>memberName</li>
     *   <li>memberAccount</li>
     *   <li>memberStatusCode</li>
     *   <li>birthdate</li>
     *   <li>formalizedDatetime</li>
     *   <li>latestLoginDatetime</li>
     *   <li>updateDatetime</li>
     *   <li>versionNo</li>
     * </ul>
     * 
     * @param entityList Source List.
     * @return Copied List of Dto.
     */
    public List<InputFormDto> toDtoList(List<Member> entityList) {
        List<InputFormDto> dtoList = new ArrayList<InputFormDto>();
        for (Member entity : entityList) {
            dtoList.add(copyEntityToDto(entity, new InputFormDto()));
        }
        return dtoList;
    }

    /**
     * Copies 'memberId' property of Member entity to InputFormDto instance's 'memberId' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectMemberIdToDto(Member entity, InputFormDto dto) {
        dto.setMemberId(extractMemberIdFromEntity(entity));
    }

    /**
     * Extracts 'memberId' property of Member entity in order to copy to InputFormDto instance's 'memberId' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected Integer extractMemberIdFromEntity(Member entity) {
        return convert(entity.getMemberId(), Integer.class);
    }

    /**
     * Copies 'memberName' property of Member entity to InputFormDto instance's 'memberName' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectMemberNameToDto(Member entity, InputFormDto dto) {
        dto.setMemberName(extractMemberNameFromEntity(entity));
    }

    /**
     * Extracts 'memberName' property of Member entity in order to copy to InputFormDto instance's 'memberName' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected String extractMemberNameFromEntity(Member entity) {
        return convert(entity.getMemberName(), String.class);
    }

    /**
     * Copies 'memberAccount' property of Member entity to InputFormDto instance's 'memberAccount' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectMemberAccountToDto(Member entity, InputFormDto dto) {
        dto.setMemberAccount(extractMemberAccountFromEntity(entity));
    }

    /**
     * Extracts 'memberAccount' property of Member entity in order to copy to InputFormDto instance's 'memberAccount' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected String extractMemberAccountFromEntity(Member entity) {
        return convert(entity.getMemberAccount(), String.class);
    }

    /**
     * Copies 'memberStatusCode' property of Member entity to InputFormDto instance's 'memberStatusCodeSelect' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectMemberStatusCodeToDto(Member entity, InputFormDto dto) {
        dto.getMemberStatusCodeSelect().setSelectedValue(extractMemberStatusCodeFromEntity(entity));
    }

    /**
     * Extracts 'memberStatusCode' property of Member entity in order to copy to InputFormDto instance's 'memberStatusCodeSelect' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected String extractMemberStatusCodeFromEntity(Member entity) {
        return convert(entity.getMemberStatusCode(), String.class);
    }

    /**
     * Copies 'birthdate' property of Member entity to InputFormDto instance's 'birthdate' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectBirthdateToDto(Member entity, InputFormDto dto) {
        dto.setBirthdate(extractBirthdateFromEntity(entity));
    }

    /**
     * Extracts 'birthdate' property of Member entity in order to copy to InputFormDto instance's 'birthdate' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected Date extractBirthdateFromEntity(Member entity) {
        return convert(entity.getBirthdate(), Date.class);
    }

    /**
     * Copies 'formalizedDatetime' property of Member entity to InputFormDto instance's 'formalizedDatetime' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectFormalizedDatetimeToDto(Member entity, InputFormDto dto) {
        dto.setFormalizedDatetime(extractFormalizedDatetimeFromEntity(entity));
    }

    /**
     * Extracts 'formalizedDatetime' property of Member entity in order to copy to InputFormDto instance's 'formalizedDatetime' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected Date extractFormalizedDatetimeFromEntity(Member entity) {
        return convert(entity.getFormalizedDatetime(), Date.class);
    }

    /**
     * Copies 'latestLoginDatetime' property of Member entity to InputFormDto instance's 'latestLoginDatetime' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectLatestLoginDatetimeToDto(Member entity, InputFormDto dto) {
        dto.setLatestLoginDatetime(extractLatestLoginDatetimeFromEntity(entity));
    }

    /**
     * Extracts 'latestLoginDatetime' property of Member entity in order to copy to InputFormDto instance's 'latestLoginDatetime' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected Date extractLatestLoginDatetimeFromEntity(Member entity) {
        return convert(entity.getLatestLoginDatetime(), Date.class);
    }

    /**
     * Copies 'updateDatetime' property of Member entity to InputFormDto instance's 'updateDatetime' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectUpdateDatetimeToDto(Member entity, InputFormDto dto) {
        dto.setUpdateDatetime(extractUpdateDatetimeFromEntity(entity));
    }

    /**
     * Extracts 'updateDatetime' property of Member entity in order to copy to InputFormDto instance's 'updateDatetime' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected Date extractUpdateDatetimeFromEntity(Member entity) {
        return convert(entity.getUpdateDatetime(), Date.class);
    }

    /**
     * Copies 'versionNo' property of Member entity to InputFormDto instance's 'versionNo' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectVersionNoToDto(Member entity, InputFormDto dto) {
        dto.setVersionNo(extractVersionNoFromEntity(entity));
    }

    /**
     * Extracts 'versionNo' property of Member entity in order to copy to InputFormDto instance's 'versionNo' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected Integer extractVersionNoFromEntity(Member entity) {
        return convert(entity.getVersionNo(), Integer.class);
    }

    /**
     * Copies InputFormDto entity to Member instance.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>birthdate</li>
     *   <li>formalizedDatetime</li>
     *   <li>latestLoginDatetime</li>
     *   <li>memberAccount</li>
     *   <li>memberId</li>
     *   <li>memberName</li>
     *   <li>memberStatusCode</li>
     *   <li>updateDatetime</li>
     *   <li>versionNo</li>
     * </ul>
     * 
     * @param dto Source object.
     * @param entity Destination object.
     * @return The first argument of this method.
     */
    public Member copyDtoToEntity(InputFormDto dto, Member entity) {
        reflectBirthdateToEntity(dto, entity);
        reflectFormalizedDatetimeToEntity(dto, entity);
        reflectLatestLoginDatetimeToEntity(dto, entity);
        reflectMemberAccountToEntity(dto, entity);
        reflectMemberIdToEntity(dto, entity);
        reflectMemberNameToEntity(dto, entity);
        reflectMemberStatusCodeToEntity(dto, entity);
        reflectUpdateDatetimeToEntity(dto, entity);
        reflectVersionNoToEntity(dto, entity);

        return entity;
    }

    /**
     * Copies a List of InputFormDto entity to a List of Member.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>birthdate</li>
     *   <li>formalizedDatetime</li>
     *   <li>latestLoginDatetime</li>
     *   <li>memberAccount</li>
     *   <li>memberId</li>
     *   <li>memberName</li>
     *   <li>memberStatusCode</li>
     *   <li>updateDatetime</li>
     *   <li>versionNo</li>
     * </ul>
     * 
     * @param dtoList Source List.
     * @return Copied List of entity.
     */
    public List<Member> toEntityList(List<InputFormDto> dtoList) {
        List<Member> entityList = new ArrayList<Member>();
        for (InputFormDto dto : dtoList) {
            entityList.add(copyDtoToEntity(dto, new Member()));
        }
        return entityList;
    }

    /**
     * Copies 'birthdate' property of InputFormDto entity to Member instance's 'birthdate' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectBirthdateToEntity(InputFormDto dto, Member entity) {
        entity.setBirthdate(extractBirthdateFromDto(dto));
    }

    /**
     * Extracts 'birthdate' property of InputFormDto entity in order to copy to Member instance's 'birthdate' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Date extractBirthdateFromDto(InputFormDto dto) {
        return convertForEntity(dto.getBirthdate(), Date.class);
    }

    /**
     * Copies 'formalizedDatetime' property of InputFormDto entity to Member instance's 'formalizedDatetime' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectFormalizedDatetimeToEntity(InputFormDto dto, Member entity) {
        entity.setFormalizedDatetime(extractFormalizedDatetimeFromDto(dto));
    }

    /**
     * Extracts 'formalizedDatetime' property of InputFormDto entity in order to copy to Member instance's 'formalizedDatetime' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Timestamp extractFormalizedDatetimeFromDto(InputFormDto dto) {
        return convertForEntity(dto.getFormalizedDatetime(), Timestamp.class);
    }

    /**
     * Copies 'latestLoginDatetime' property of InputFormDto entity to Member instance's 'latestLoginDatetime' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectLatestLoginDatetimeToEntity(InputFormDto dto, Member entity) {
        entity.setLatestLoginDatetime(extractLatestLoginDatetimeFromDto(dto));
    }

    /**
     * Extracts 'latestLoginDatetime' property of InputFormDto entity in order to copy to Member instance's 'latestLoginDatetime' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Timestamp extractLatestLoginDatetimeFromDto(InputFormDto dto) {
        return convertForEntity(dto.getLatestLoginDatetime(), Timestamp.class);
    }

    /**
     * Copies 'memberAccount' property of InputFormDto entity to Member instance's 'memberAccount' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectMemberAccountToEntity(InputFormDto dto, Member entity) {
        entity.setMemberAccount(extractMemberAccountFromDto(dto));
    }

    /**
     * Extracts 'memberAccount' property of InputFormDto entity in order to copy to Member instance's 'memberAccount' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected String extractMemberAccountFromDto(InputFormDto dto) {
        return convertForEntity(dto.getMemberAccount(), String.class);
    }

    /**
     * Copies 'memberId' property of InputFormDto entity to Member instance's 'memberId' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectMemberIdToEntity(InputFormDto dto, Member entity) {
        entity.setMemberId(extractMemberIdFromDto(dto));
    }

    /**
     * Extracts 'memberId' property of InputFormDto entity in order to copy to Member instance's 'memberId' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Integer extractMemberIdFromDto(InputFormDto dto) {
        return convertForEntity(dto.getMemberId(), Integer.class);
    }

    /**
     * Copies 'memberName' property of InputFormDto entity to Member instance's 'memberName' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectMemberNameToEntity(InputFormDto dto, Member entity) {
        entity.setMemberName(extractMemberNameFromDto(dto));
    }

    /**
     * Extracts 'memberName' property of InputFormDto entity in order to copy to Member instance's 'memberName' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected String extractMemberNameFromDto(InputFormDto dto) {
        return convertForEntity(dto.getMemberName(), String.class);
    }

    /**
     * Copies 'memberStatusCodeSelect' property of InputFormDto entity to Member instance's 'memberStatusCode' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectMemberStatusCodeToEntity(InputFormDto dto, Member entity) {
        entity.setMemberStatusCode(extractMemberStatusCodeFromDto(dto));
    }

    /**
     * Extracts 'memberStatusCodeSelect' property of InputFormDto entity in order to copy to Member instance's 'memberStatusCode' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected String extractMemberStatusCodeFromDto(InputFormDto dto) {
        return convertForEntity(dto.getMemberStatusCodeSelect().getSelectedValue(), String.class);
    }

    /**
     * Copies 'updateDatetime' property of InputFormDto entity to Member instance's 'updateDatetime' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectUpdateDatetimeToEntity(InputFormDto dto, Member entity) {
        entity.setUpdateDatetime(extractUpdateDatetimeFromDto(dto));
    }

    /**
     * Extracts 'updateDatetime' property of InputFormDto entity in order to copy to Member instance's 'updateDatetime' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Timestamp extractUpdateDatetimeFromDto(InputFormDto dto) {
        return convertForEntity(dto.getUpdateDatetime(), Timestamp.class);
    }

    /**
     * Copies 'versionNo' property of InputFormDto entity to Member instance's 'versionNo' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectVersionNoToEntity(InputFormDto dto, Member entity) {
        entity.setVersionNo(extractVersionNoFromDto(dto));
    }

    /**
     * Extracts 'versionNo' property of InputFormDto entity in order to copy to Member instance's 'versionNo' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Long extractVersionNoFromDto(InputFormDto dto) {
        return convertForEntity(dto.getVersionNo(), Long.class);
    }

}
