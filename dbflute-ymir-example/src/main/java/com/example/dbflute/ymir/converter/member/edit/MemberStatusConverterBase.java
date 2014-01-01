package com.example.dbflute.ymir.converter.member.edit;

import java.util.ArrayList;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.ymir.converter.TypeConversionManager;
import org.seasar.ymir.message.Messages;

import com.example.dbflute.ymir.dto.member.edit.MemberStatusDto;
import com.example.dbflute.ymir.dbflute.exentity.MemberStatus;

/**
 * A class to convert Dto objects and entity objects.
 * <p>Developer can override methods to customize this class's behavior,
 * and add methods to gain conversion ability.
 * </p>
 */
public class MemberStatusConverterBase
{
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
     * Copies MemberStatus entity to MemberStatusDto instance.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberStatusCode</li>
     *   <li>memberStatusName</li>
     * </ul>
     * 
     * @param dto Destination object.
     * @param entity Source object.
     * @return The first argument of this method.
     */
    public MemberStatusDto copyTo(MemberStatusDto dto, MemberStatus entity)
    {
        copyMemberStatusCodeTo(dto, entity);
        copyMemberStatusNameTo(dto, entity);

        return dto;
    }

    /**
     * Copies an array of MemberStatus entity to an array of MemberStatusDto.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberStatusCode</li>
     *   <li>memberStatusName</li>
     * </ul>
     * 
     * @param entities Source array.
     * @return Copied array of Dto.
     */
    public MemberStatusDto[] copyTo(MemberStatus[] entities)
    {
        MemberStatusDto[] dtos = new MemberStatusDto[entities.length];
        for (int i = 0; i < entities.length; i++) {
            dtos[i] = copyTo(new MemberStatusDto(), entities[i]);
        }
        return dtos;
    }

    /**
     * Copies a List of MemberStatus entity to a List of MemberStatusDto.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberStatusCode</li>
     *   <li>memberStatusName</li>
     * </ul>
     * 
     * @param entityList Source List.
     * @return Copied List of Dto.
     */
    public List<MemberStatusDto> copyToDtoList(List<MemberStatus> entityList)
    {
        List<MemberStatusDto> dtoList = new ArrayList<MemberStatusDto>();
        for (MemberStatus entity : entityList) {
            dtoList.add(copyTo(new MemberStatusDto(), entity));
        }
        return dtoList;
    }

    /**
     * Copies 'memberStatusCode' property of MemberStatus entity to MemberStatusDto instance's 'memberStatusCode' property.
     * 
     * @param dto Destination object.
     * @param entity Source object.
     */
    protected void copyMemberStatusCodeTo(MemberStatusDto dto, MemberStatus entity)
    {
        dto.setMemberStatusCode(convert(entity.getMemberStatusCode(), String.class));
    }

    /**
     * Copies 'memberStatusName' property of MemberStatus entity to MemberStatusDto instance's 'memberStatusName' property.
     * 
     * @param dto Destination object.
     * @param entity Source object.
     */
    protected void copyMemberStatusNameTo(MemberStatusDto dto, MemberStatus entity)
    {
        dto.setMemberStatusName(convert(entity.getMemberStatusName(), String.class));
    }

    /**
     * Copies MemberStatusDto entity to MemberStatus instance.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberStatusCode</li>
     *   <li>memberStatusName</li>
     * </ul>
     * 
     * @param entity Destination object.
     * @param dto Source object.
     * @return The first argument of this method.
     */
    public MemberStatus copyTo(MemberStatus entity, MemberStatusDto dto)
    {
        copyMemberStatusCodeTo(entity, dto);
        copyMemberStatusNameTo(entity, dto);

        return entity;
    }

    /**
     * Copies an array of MemberStatusDto entity to an array of MemberStatus.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberStatusCode</li>
     *   <li>memberStatusName</li>
     * </ul>
     * 
     * @param dtos Source array.
     * @return Copied array of entity.
     */
    public MemberStatus[] copyTo(MemberStatusDto[] dtos)
    {

        MemberStatus[] entities = new MemberStatus[dtos.length];
        for (int i = 0; i < dtos.length; i++) {
            entities[i] = copyTo(new MemberStatus(), dtos[i]);
        }
        return entities;
    }

    /**
     * Copies a List of MemberStatusDto entity to a List of MemberStatus.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>memberStatusCode</li>
     *   <li>memberStatusName</li>
     * </ul>
     * 
     * @param dtoList Source List.
     * @return Copied List of entity.
     */
    public List<MemberStatus> copyToEntityList(List<MemberStatusDto> dtoList)
    {
        List<MemberStatus> entityList = new ArrayList<MemberStatus>();
        for (MemberStatusDto dto : dtoList) {
            entityList.add(copyTo(new MemberStatus(), dto));
        }
        return entityList;
    }

    /**
     * Copies 'memberStatusCode' property of MemberStatusDto entity to MemberStatus instance's 'memberStatusCode' property.
     * 
     * @param entity Destination object.
     * @param dto Source object.
     */
    protected void copyMemberStatusCodeTo(MemberStatus entity, MemberStatusDto dto)
    {
        entity.setMemberStatusCode(convertForEntity(dto.getMemberStatusCode(), String.class));
    }

    /**
     * Copies 'memberStatusName' property of MemberStatusDto entity to MemberStatus instance's 'memberStatusName' property.
     * 
     * @param entity Destination object.
     * @param dto Source object.
     */
    protected void copyMemberStatusNameTo(MemberStatus entity, MemberStatusDto dto)
    {
        entity.setMemberStatusName(convertForEntity(dto.getMemberStatusName(), String.class));
    }

}
