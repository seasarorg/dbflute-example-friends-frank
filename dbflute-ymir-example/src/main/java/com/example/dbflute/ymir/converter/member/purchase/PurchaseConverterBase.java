package com.example.dbflute.ymir.converter.member.purchase;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.ymir.converter.TypeConversionManager;
import org.seasar.ymir.message.Messages;

import com.example.dbflute.ymir.dbflute.exentity.Purchase;
import com.example.dbflute.ymir.dto.member.purchase.PurchaseDto;

/**
 * A class to convert Dto objects and entity objects.
 * <p>Developer can override methods to customize this class's behavior,
 * and add methods to gain conversion ability.
 * </p>
 */
public class PurchaseConverterBase {
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
     * Copies Purchase entity to PurchaseDto instance.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>purchaseDatetime</li>
     *   <li>purchasePrice</li>
     *   <li>purchaseCount</li>
     *   <li>purchaseId</li>
     * </ul>
     * 
     * @param entity Source object.
     * @param dto Destination object.
     * @return The first argument of this method.
     */
    public PurchaseDto copyEntityToDto(Purchase entity, PurchaseDto dto) {
        reflectPurchaseDatetimeToDto(entity, dto);
        reflectPurchasePriceToDto(entity, dto);
        reflectPurchaseCountToDto(entity, dto);
        reflectPurchaseIdToDto(entity, dto);

        return dto;
    }

    /**
     * Copies a List of Purchase entity to a List of PurchaseDto.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>purchaseDatetime</li>
     *   <li>purchasePrice</li>
     *   <li>purchaseCount</li>
     *   <li>purchaseId</li>
     * </ul>
     * 
     * @param entityList Source List.
     * @return Copied List of Dto.
     */
    public List<PurchaseDto> toDtoList(List<Purchase> entityList) {
        List<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
        for (Purchase entity : entityList) {
            dtoList.add(copyEntityToDto(entity, new PurchaseDto()));
        }
        return dtoList;
    }

    /**
     * Copies 'purchaseDatetime' property of Purchase entity to PurchaseDto instance's 'purchaseDatetime' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectPurchaseDatetimeToDto(Purchase entity, PurchaseDto dto) {
        dto.setPurchaseDatetime(extractPurchaseDatetimeFromEntity(entity));
    }

    /**
     * Extracts 'purchaseDatetime' property of Purchase entity in order to copy to PurchaseDto instance's 'purchaseDatetime' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected String extractPurchaseDatetimeFromEntity(Purchase entity) {
        return convert(entity.getPurchaseDatetime(), String.class);
    }

    /**
     * Copies 'purchasePrice' property of Purchase entity to PurchaseDto instance's 'purchasePrice' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectPurchasePriceToDto(Purchase entity, PurchaseDto dto) {
        dto.setPurchasePrice(extractPurchasePriceFromEntity(entity));
    }

    /**
     * Extracts 'purchasePrice' property of Purchase entity in order to copy to PurchaseDto instance's 'purchasePrice' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected String extractPurchasePriceFromEntity(Purchase entity) {
        return convert(entity.getPurchasePrice(), String.class);
    }

    /**
     * Copies 'purchaseCount' property of Purchase entity to PurchaseDto instance's 'purchaseCount' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectPurchaseCountToDto(Purchase entity, PurchaseDto dto) {
        dto.setPurchaseCount(extractPurchaseCountFromEntity(entity));
    }

    /**
     * Extracts 'purchaseCount' property of Purchase entity in order to copy to PurchaseDto instance's 'purchaseCount' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected String extractPurchaseCountFromEntity(Purchase entity) {
        return convert(entity.getPurchaseCount(), String.class);
    }

    /**
     * Copies 'purchaseId' property of Purchase entity to PurchaseDto instance's 'purchaseId' property.
     * 
     * @param entity Source object.
     * @param dto Destination object.
     */
    protected void reflectPurchaseIdToDto(Purchase entity, PurchaseDto dto) {
        dto.setPurchaseId(extractPurchaseIdFromEntity(entity));
    }

    /**
     * Extracts 'purchaseId' property of Purchase entity in order to copy to PurchaseDto instance's 'purchaseId' property.
     * 
     * @param entity Source object.
     * @return Extracted value.
     */
    protected String extractPurchaseIdFromEntity(Purchase entity) {
        return convert(entity.getPurchaseId(), String.class);
    }

    /**
     * Copies PurchaseDto entity to Purchase instance.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>purchaseCount</li>
     *   <li>purchaseDatetime</li>
     *   <li>purchaseId</li>
     *   <li>purchasePrice</li>
     * </ul>
     * 
     * @param dto Source object.
     * @param entity Destination object.
     * @return The first argument of this method.
     */
    public Purchase copyDtoToEntity(PurchaseDto dto, Purchase entity) {
        reflectPurchaseCountToEntity(dto, entity);
        reflectPurchaseDatetimeToEntity(dto, entity);
        reflectPurchaseIdToEntity(dto, entity);
        reflectPurchasePriceToEntity(dto, entity);

        return entity;
    }

    /**
     * Copies a List of PurchaseDto entity to a List of Purchase.
     * <p>This methods copies the following properties automatically:</p>
     * <ul>
     *   <li>purchaseCount</li>
     *   <li>purchaseDatetime</li>
     *   <li>purchaseId</li>
     *   <li>purchasePrice</li>
     * </ul>
     * 
     * @param dtoList Source List.
     * @return Copied List of entity.
     */
    public List<Purchase> toEntityList(List<PurchaseDto> dtoList) {
        List<Purchase> entityList = new ArrayList<Purchase>();
        for (PurchaseDto dto : dtoList) {
            entityList.add(copyDtoToEntity(dto, new Purchase()));
        }
        return entityList;
    }

    /**
     * Copies 'purchaseCount' property of PurchaseDto entity to Purchase instance's 'purchaseCount' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectPurchaseCountToEntity(PurchaseDto dto, Purchase entity) {
        entity.setPurchaseCount(extractPurchaseCountFromDto(dto));
    }

    /**
     * Extracts 'purchaseCount' property of PurchaseDto entity in order to copy to Purchase instance's 'purchaseCount' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Integer extractPurchaseCountFromDto(PurchaseDto dto) {
        return convertForEntity(dto.getPurchaseCount(), Integer.class);
    }

    /**
     * Copies 'purchaseDatetime' property of PurchaseDto entity to Purchase instance's 'purchaseDatetime' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectPurchaseDatetimeToEntity(PurchaseDto dto, Purchase entity) {
        entity.setPurchaseDatetime(extractPurchaseDatetimeFromDto(dto));
    }

    /**
     * Extracts 'purchaseDatetime' property of PurchaseDto entity in order to copy to Purchase instance's 'purchaseDatetime' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Timestamp extractPurchaseDatetimeFromDto(PurchaseDto dto) {
        return convertForEntity(dto.getPurchaseDatetime(), Timestamp.class);
    }

    /**
     * Copies 'purchaseId' property of PurchaseDto entity to Purchase instance's 'purchaseId' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectPurchaseIdToEntity(PurchaseDto dto, Purchase entity) {
        entity.setPurchaseId(extractPurchaseIdFromDto(dto));
    }

    /**
     * Extracts 'purchaseId' property of PurchaseDto entity in order to copy to Purchase instance's 'purchaseId' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Long extractPurchaseIdFromDto(PurchaseDto dto) {
        return convertForEntity(dto.getPurchaseId(), Long.class);
    }

    /**
     * Copies 'purchasePrice' property of PurchaseDto entity to Purchase instance's 'purchasePrice' property.
     * 
     * @param dto Source object.
     * @param entity Destination object.
     */
    protected void reflectPurchasePriceToEntity(PurchaseDto dto, Purchase entity) {
        entity.setPurchasePrice(extractPurchasePriceFromDto(dto));
    }

    /**
     * Extracts 'purchasePrice' property of PurchaseDto entity in order to copy to Purchase instance's 'purchasePrice' property.
     * 
     * @param dto Source object.
     * @return Extracted value.
     */
    protected Integer extractPurchasePriceFromDto(PurchaseDto dto) {
        return convertForEntity(dto.getPurchasePrice(), Integer.class);
    }

}
