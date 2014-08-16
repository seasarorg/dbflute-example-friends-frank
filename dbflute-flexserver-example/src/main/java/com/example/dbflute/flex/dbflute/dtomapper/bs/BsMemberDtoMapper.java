package com.example.dbflute.flex.dbflute.dtomapper.bs;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.bhv.DtoMapper;
import org.seasar.dbflute.bhv.InstanceKeyDto;
import org.seasar.dbflute.bhv.InstanceKeyEntity;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.helper.beans.DfBeanDesc;
import org.seasar.dbflute.helper.beans.DfPropertyDesc;
import org.seasar.dbflute.helper.beans.factory.DfBeanDescFactory;
import org.seasar.dbflute.jdbc.Classification;
import com.example.dbflute.flex.dbflute.allcommon.CDef;
import com.example.dbflute.flex.dbflute.exentity.*;
import com.example.dbflute.flex.simpleflute.dto.*;
import com.example.dbflute.flex.dbflute.dtomapper.*;

/**
 * The DTO mapper of MEMBER as TABLE. <br />
 * 会員: 会員登録時にデータが登録される。基本的に物理削除はなく、退会したらステータスが退会会員になる。ライフサイクルやカテゴリの違う会員それぞれの詳細情報は、別途 one-to-one のテーブルに。
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, MEMBER_ACCOUNT, MEMBER_STATUS_CODE, FORMALIZED_DATETIME, BIRTHDATE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER_STATUS, MEMBER_LOGIN(AsLatest), MEMBER_SECURITY(AsOne), MEMBER_SERVICE(AsOne), MEMBER_WITHDRAWAL(AsOne)
 * 
 * [referrer-table]
 *     MEMBER_ADDRESS, MEMBER_LOGIN, PURCHASE, MEMBER_SECURITY, MEMBER_SERVICE, MEMBER_WITHDRAWAL
 * 
 * [foreign-property]
 *     memberStatus, memberLoginAsLatest, memberSecurityAsOne, memberServiceAsOne, memberWithdrawalAsOne
 * 
 * [referrer-property]
 *     memberAddressList, memberLoginList, purchaseList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberDtoMapper implements DtoMapper<Member, MemberDto>, Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final Map<Entity, Object> _relationDtoMap;
    protected final Map<Object, Entity> _relationEntityMap;
    protected boolean _exceptCommonColumn;
    protected boolean _reverseReference; // default: one-way reference
    protected boolean _instanceCache = true; // default: cached
    protected boolean _suppressMemberStatus;
    protected boolean _suppressMemberLoginAsLatest;
    protected boolean _suppressMemberAddressList;
    protected boolean _suppressMemberLoginList;
    protected boolean _suppressMemberSecurityAsOne;
    protected boolean _suppressMemberServiceAsOne;
    protected boolean _suppressMemberWithdrawalAsOne;
    protected boolean _suppressPurchaseList;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsMemberDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
        _relationDtoMap = relationDtoMap;
        _relationEntityMap = relationEntityMap;
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    // -----------------------------------------------------
    //                                                to DTO
    //                                                ------
    /**
     * {@inheritDoc}
     */
    public MemberDto mappingToDto(Member entity) {
        if (entity == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Entity localKey = createInstanceKeyEntity(entity);
        Object cachedLocalDto = instanceCache ? _relationDtoMap.get(localKey) : null;
        if (cachedLocalDto != null) {
            return (MemberDto)cachedLocalDto;
        }
        boolean exceptCommonColumn = isExceptCommonColumn();
        MemberDto dto = new MemberDto();
        dto.setMemberId(entity.getMemberId());
        dto.setMemberName(entity.getMemberName());
        dto.setMemberAccount(entity.getMemberAccount());
        dto.setMemberStatusCode(entity.getMemberStatusCode());
        dto.setFormalizedDatetime(entity.getFormalizedDatetime());
        dto.setBirthdate(entity.getBirthdate());
        if (!exceptCommonColumn) {
            dto.setRegisterDatetime(entity.getRegisterDatetime());
        }
        if (!exceptCommonColumn) {
            dto.setRegisterUser(entity.getRegisterUser());
        }
        if (!exceptCommonColumn) {
            dto.setUpdateDatetime(entity.getUpdateDatetime());
        }
        if (!exceptCommonColumn) {
            dto.setUpdateUser(entity.getUpdateUser());
        }
        dto.setVersionNo(entity.getVersionNo());
        reflectDerivedProperty(entity, dto, true);
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only a DTO that has a primary key value
            _relationDtoMap.put(localKey, dto);
        }
        boolean reverseReference = isReverseReference();
        if (!_suppressMemberStatus && entity.getMemberStatus() != null) {
            MemberStatus relationEntity = entity.getMemberStatus();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberStatusDto relationDto = (MemberStatusDto)cachedDto;
                dto.setMemberStatus(relationDto);
                if (reverseReference) {
                    relationDto.getMemberList().add(dto);
                }
            } else {
                MemberStatusDtoMapper mapper = new MemberStatusDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberList();
                MemberStatusDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMemberStatus(relationDto);
                if (reverseReference) {
                    relationDto.getMemberList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMemberStatus());
                }
            }
        };
        if (!_suppressMemberLoginAsLatest && entity.getMemberLoginAsLatest() != null) {
            MemberLogin relationEntity = entity.getMemberLoginAsLatest();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberLoginDto relationDto = (MemberLoginDto)cachedDto;
                dto.setMemberLoginAsLatest(relationDto);
                if (reverseReference) {
                }
            } else {
                MemberLoginDtoMapper mapper = new MemberLoginDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                MemberLoginDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMemberLoginAsLatest(relationDto);
                if (reverseReference) {
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMemberLoginAsLatest());
                }
            }
        };
        if (!_suppressMemberAddressList && !entity.getMemberAddressList().isEmpty()) {
            MemberAddressDtoMapper mapper = new MemberAddressDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setExceptCommonColumn(exceptCommonColumn);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressMember();
            List<MemberAddressDto> relationDtoList = mapper.mappingToDtoList(entity.getMemberAddressList());
            dto.setMemberAddressList(relationDtoList);
            if (reverseReference) {
                for (MemberAddressDto relationDto : relationDtoList) {
                    relationDto.setMember(dto);
                }
            }
        };
        if (!_suppressMemberLoginList && !entity.getMemberLoginList().isEmpty()) {
            MemberLoginDtoMapper mapper = new MemberLoginDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setExceptCommonColumn(exceptCommonColumn);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressMember();
            List<MemberLoginDto> relationDtoList = mapper.mappingToDtoList(entity.getMemberLoginList());
            dto.setMemberLoginList(relationDtoList);
            if (reverseReference) {
                for (MemberLoginDto relationDto : relationDtoList) {
                    relationDto.setMember(dto);
                }
            }
        };
        if (!_suppressMemberSecurityAsOne && entity.getMemberSecurityAsOne() != null) {
            MemberSecurity relationEntity = entity.getMemberSecurityAsOne();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberSecurityDto relationDto = (MemberSecurityDto)cachedDto;
                dto.setMemberSecurityAsOne(relationDto);
                if (reverseReference) {
                    relationDto.setMember(dto);
                }
            } else {
                MemberSecurityDtoMapper mapper = new MemberSecurityDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMember();
                MemberSecurityDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMemberSecurityAsOne(relationDto);
                if (reverseReference) {
                    relationDto.setMember(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMemberSecurityAsOne());
                }
            }
        };
        if (!_suppressMemberServiceAsOne && entity.getMemberServiceAsOne() != null) {
            MemberService relationEntity = entity.getMemberServiceAsOne();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberServiceDto relationDto = (MemberServiceDto)cachedDto;
                dto.setMemberServiceAsOne(relationDto);
                if (reverseReference) {
                    relationDto.setMember(dto);
                }
            } else {
                MemberServiceDtoMapper mapper = new MemberServiceDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMember();
                MemberServiceDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMemberServiceAsOne(relationDto);
                if (reverseReference) {
                    relationDto.setMember(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMemberServiceAsOne());
                }
            }
        };
        if (!_suppressMemberWithdrawalAsOne && entity.getMemberWithdrawalAsOne() != null) {
            MemberWithdrawal relationEntity = entity.getMemberWithdrawalAsOne();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberWithdrawalDto relationDto = (MemberWithdrawalDto)cachedDto;
                dto.setMemberWithdrawalAsOne(relationDto);
                if (reverseReference) {
                    relationDto.setMember(dto);
                }
            } else {
                MemberWithdrawalDtoMapper mapper = new MemberWithdrawalDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMember();
                MemberWithdrawalDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMemberWithdrawalAsOne(relationDto);
                if (reverseReference) {
                    relationDto.setMember(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMemberWithdrawalAsOne());
                }
            }
        };
        if (!_suppressPurchaseList && !entity.getPurchaseList().isEmpty()) {
            PurchaseDtoMapper mapper = new PurchaseDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setExceptCommonColumn(exceptCommonColumn);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressMember();
            List<PurchaseDto> relationDtoList = mapper.mappingToDtoList(entity.getPurchaseList());
            dto.setPurchaseList(relationDtoList);
            if (reverseReference) {
                for (PurchaseDto relationDto : relationDtoList) {
                    relationDto.setMember(dto);
                }
            }
        };
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<MemberDto> mappingToDtoList(List<Member> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<MemberDto> dtoList = new ArrayList<MemberDto>();
        for (Member entity : entityList) {
            MemberDto dto = mappingToDto(entity);
            if (dto != null) {
                dtoList.add(dto);
            } else {
                if (isAcceptNullElementOnList()) {
                    dtoList.add(null);
                }
            }
        }
        return dtoList;
    }

    // -----------------------------------------------------
    //                                             to Entity
    //                                             ---------
    /**
     * {@inheritDoc}
     */
    public Member mappingToEntity(MemberDto dto) {
        if (dto == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Object localKey = createInstanceKeyDto(dto, dto.instanceHash());
        Entity cachedLocalEntity = instanceCache ? _relationEntityMap.get(localKey) : null;
        if (cachedLocalEntity != null) {
            return (Member)cachedLocalEntity;
        }
        boolean exceptCommonColumn = isExceptCommonColumn();
        Member entity = new Member();
        if (needsMapping(dto, dto.getMemberId(), "memberId")) {
            entity.setMemberId(dto.getMemberId());
        }
        if (needsMapping(dto, dto.getMemberName(), "memberName")) {
            entity.setMemberName(dto.getMemberName());
        }
        if (needsMapping(dto, dto.getMemberAccount(), "memberAccount")) {
            entity.setMemberAccount(dto.getMemberAccount());
        }
        if (needsMapping(dto, dto.getMemberStatusCode(), "memberStatusCode")) {
            entity.setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.codeOf(dto.getMemberStatusCode()));
        }
        if (needsMapping(dto, dto.getFormalizedDatetime(), "formalizedDatetime")) {
            entity.setFormalizedDatetime(dto.getFormalizedDatetime());
        }
        if (needsMapping(dto, dto.getBirthdate(), "birthdate")) {
            entity.setBirthdate(dto.getBirthdate());
        }
        if (needsMapping(dto, dto.getRegisterDatetime(), "registerDatetime") && !exceptCommonColumn) {
            entity.setRegisterDatetime(dto.getRegisterDatetime());
        }
        if (needsMapping(dto, dto.getRegisterUser(), "registerUser") && !exceptCommonColumn) {
            entity.setRegisterUser(dto.getRegisterUser());
        }
        if (needsMapping(dto, dto.getUpdateDatetime(), "updateDatetime") && !exceptCommonColumn) {
            entity.setUpdateDatetime(dto.getUpdateDatetime());
        }
        if (needsMapping(dto, dto.getUpdateUser(), "updateUser") && !exceptCommonColumn) {
            entity.setUpdateUser(dto.getUpdateUser());
        }
        if (needsMapping(dto, dto.getVersionNo(), "versionNo")) {
            entity.setVersionNo(dto.getVersionNo());
        }
        reflectDerivedProperty(entity, dto, false);
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only an entity that has a primary key value
            _relationEntityMap.put(localKey, entity);
        }
        boolean reverseReference = isReverseReference();
        if (!_suppressMemberStatus && dto.getMemberStatus() != null) {
            MemberStatusDto relationDto = dto.getMemberStatus();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                MemberStatus relationEntity = (MemberStatus)cachedEntity;
                entity.setMemberStatus(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberList().add(entity);
                }
            } else {
                MemberStatusDtoMapper mapper = new MemberStatusDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberList();
                MemberStatus relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMemberStatus(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberList().add(entity);
                }
                if (instanceCache && entity.getMemberStatus().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMemberStatus());
                }
            }
        };
        if (!_suppressMemberLoginAsLatest && dto.getMemberLoginAsLatest() != null) {
            MemberLoginDto relationDto = dto.getMemberLoginAsLatest();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                MemberLogin relationEntity = (MemberLogin)cachedEntity;
                entity.setMemberLoginAsLatest(relationEntity);
                if (reverseReference) {
                }
            } else {
                MemberLoginDtoMapper mapper = new MemberLoginDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                MemberLogin relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMemberLoginAsLatest(relationEntity);
                if (reverseReference) {
                }
                if (instanceCache && entity.getMemberLoginAsLatest().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMemberLoginAsLatest());
                }
            }
        };
        if (!_suppressMemberAddressList && !dto.getMemberAddressList().isEmpty()) {
            MemberAddressDtoMapper mapper = new MemberAddressDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setExceptCommonColumn(exceptCommonColumn);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressMember();
            List<MemberAddress> relationEntityList = mapper.mappingToEntityList(dto.getMemberAddressList());
            entity.setMemberAddressList(relationEntityList);
            if (reverseReference) {
                for (MemberAddress relationEntity : relationEntityList) {
                    relationEntity.setMember(entity);
                }
            }
        };
        if (!_suppressMemberLoginList && !dto.getMemberLoginList().isEmpty()) {
            MemberLoginDtoMapper mapper = new MemberLoginDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setExceptCommonColumn(exceptCommonColumn);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressMember();
            List<MemberLogin> relationEntityList = mapper.mappingToEntityList(dto.getMemberLoginList());
            entity.setMemberLoginList(relationEntityList);
            if (reverseReference) {
                for (MemberLogin relationEntity : relationEntityList) {
                    relationEntity.setMember(entity);
                }
            }
        };
        if (!_suppressMemberSecurityAsOne && dto.getMemberSecurityAsOne() != null) {
            MemberSecurityDto relationDto = dto.getMemberSecurityAsOne();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                MemberSecurity relationEntity = (MemberSecurity)cachedEntity;
                entity.setMemberSecurityAsOne(relationEntity);
                if (reverseReference) {
                    relationEntity.setMember(entity);
                }
            } else {
                MemberSecurityDtoMapper mapper = new MemberSecurityDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMember();
                MemberSecurity relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMemberSecurityAsOne(relationEntity);
                if (reverseReference) {
                    relationEntity.setMember(entity);
                }
                if (instanceCache && entity.getMemberSecurityAsOne().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMemberSecurityAsOne());
                }
            }
        };
        if (!_suppressMemberServiceAsOne && dto.getMemberServiceAsOne() != null) {
            MemberServiceDto relationDto = dto.getMemberServiceAsOne();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                MemberService relationEntity = (MemberService)cachedEntity;
                entity.setMemberServiceAsOne(relationEntity);
                if (reverseReference) {
                    relationEntity.setMember(entity);
                }
            } else {
                MemberServiceDtoMapper mapper = new MemberServiceDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMember();
                MemberService relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMemberServiceAsOne(relationEntity);
                if (reverseReference) {
                    relationEntity.setMember(entity);
                }
                if (instanceCache && entity.getMemberServiceAsOne().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMemberServiceAsOne());
                }
            }
        };
        if (!_suppressMemberWithdrawalAsOne && dto.getMemberWithdrawalAsOne() != null) {
            MemberWithdrawalDto relationDto = dto.getMemberWithdrawalAsOne();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                MemberWithdrawal relationEntity = (MemberWithdrawal)cachedEntity;
                entity.setMemberWithdrawalAsOne(relationEntity);
                if (reverseReference) {
                    relationEntity.setMember(entity);
                }
            } else {
                MemberWithdrawalDtoMapper mapper = new MemberWithdrawalDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setExceptCommonColumn(exceptCommonColumn);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMember();
                MemberWithdrawal relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMemberWithdrawalAsOne(relationEntity);
                if (reverseReference) {
                    relationEntity.setMember(entity);
                }
                if (instanceCache && entity.getMemberWithdrawalAsOne().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMemberWithdrawalAsOne());
                }
            }
        };
        if (!_suppressPurchaseList && !dto.getPurchaseList().isEmpty()) {
            PurchaseDtoMapper mapper = new PurchaseDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setExceptCommonColumn(exceptCommonColumn);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressMember();
            List<Purchase> relationEntityList = mapper.mappingToEntityList(dto.getPurchaseList());
            entity.setPurchaseList(relationEntityList);
            if (reverseReference) {
                for (Purchase relationEntity : relationEntityList) {
                    relationEntity.setMember(entity);
                }
            }
        };
        return entity;
    }

    /**
     * Does the property need to be mapped to an entity? <br />
     * If modified info of DTO has at least one property, only modified properties are mapped.
     * And if no property is modified, all properties are mapped (but the other option exists).
     * @param dto The instance of DTO. (NotNull)
     * @param value The value of DTO's property. (NotNull)
     * @param propName The property name of DTO. (NotNull)
     * @return The determination, true or false.
     */
    protected boolean needsMapping(MemberDto dto, Object value, String propName) {
        Set<String> modifiedProperties = dto.modifiedProperties();
        if (modifiedProperties.isEmpty()) {
            return isMappingToEntityContainsNull() || value != null;
        }
        return modifiedProperties.contains(propName);
    }

    /**
     * Does the mapping to an entity contain null values? (when no property is modified) <br />
     * Default is true that means a setter is called if the value is null.
     * But this method is valid only when no property is modified. 
     * @return The determination, true or false.
     */
    protected boolean isMappingToEntityContainsNull() { // for extension
        return true; // as default
    }

    /**
     * {@inheritDoc}
     */
    public List<Member> mappingToEntityList(List<MemberDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<Member> entityList = new ArrayList<Member>();
        for (MemberDto dto : dtoList) {
            Member entity = mappingToEntity(dto);
            if (entity != null) {
                entityList.add(entity);
            } else {
                if (isAcceptNullElementOnList()) {
                    entityList.add(null);
                }
            }
        }
        return entityList;
    }

    protected boolean isAcceptNullElementOnList() {
        return true; // as default
    }

    // -----------------------------------------------------
    //                                          Instance Key
    //                                          ------------
    protected Object createInstanceKeyDto(final Object dto, final int instanceHash) {
        return new InstanceKeyDto(dto, instanceHash);
    }

    protected InstanceKeyEntity createInstanceKeyEntity(Entity entity) {
        return new InstanceKeyEntity(entity);
    }

    public void disableInstanceCache() { // internal option
        _instanceCache = false;
    }

    // -----------------------------------------------------
    //                                      Derived Property
    //                                      ----------------
    protected void reflectDerivedProperty(Entity entity, Object dto, boolean toDto) {
        DfBeanDesc entityDesc = DfBeanDescFactory.getBeanDesc(entity.getClass());
        DfBeanDesc dtoDesc = DfBeanDescFactory.getBeanDesc(dto.getClass());
        DBMeta dbmeta = entity.getDBMeta();
        for (String propertyName : entityDesc.getProppertyNameList()) {
            if (isOutOfDerivedPropertyName(entity, dto, toDto, dbmeta, entityDesc, dtoDesc, propertyName)) {
                continue;
            }
            DfPropertyDesc entityProp = entityDesc.getPropertyDesc(propertyName);
            Class<?> propertyType = entityProp.getPropertyType();
            if (isOutOfDerivedPropertyType(entity, dto, toDto, propertyName, propertyType)) {
                continue;
            }
            if (entityProp.isReadable() && entityProp.isWritable()) {
                DfPropertyDesc dtoProp = dtoDesc.getPropertyDesc(propertyName);
                if (dtoProp.isReadable() && dtoProp.isWritable()) {
                    if (toDto) {
                        dtoProp.setValue(dto, entityProp.getValue(entity));
                    } else {
                        entityProp.setValue(entity, dtoProp.getValue(dto));
                    }
                }
            }
        }
    }

    protected boolean isOutOfDerivedPropertyName(Entity entity, Object dto, boolean toDto
                                               , DBMeta dbmeta, DfBeanDesc entityDesc, DfBeanDesc dtoDesc
                                               , String propertyName) {
        return dbmeta.hasColumn(propertyName)
                    || dbmeta.hasForeign(propertyName) || dbmeta.hasReferrer(propertyName)
                    || !dtoDesc.hasPropertyDesc(propertyName);
    }

    protected boolean isOutOfDerivedPropertyType(Entity entity, Object dto, boolean toDto
                                               , String propertyName, Class<?> propertyType) {
        return List.class.isAssignableFrom(propertyType)
                || Entity.class.isAssignableFrom(propertyType)
                || Classification.class.isAssignableFrom(propertyType);
    }

    // ===================================================================================
    //                                                                   Suppress Relation
    //                                                                   =================
    // (basically) to suppress infinity loop
    public void suppressMemberStatus() {
        _suppressMemberStatus = true;
    }
    public void suppressMemberLoginAsLatest() {
        _suppressMemberLoginAsLatest = true;
    }
    public void suppressMemberAddressList() {
        _suppressMemberAddressList = true;
    }
    public void suppressMemberLoginList() {
        _suppressMemberLoginList = true;
    }
    public void suppressMemberSecurityAsOne() {
        _suppressMemberSecurityAsOne = true;
    }
    public void suppressMemberServiceAsOne() {
        _suppressMemberServiceAsOne = true;
    }
    public void suppressMemberWithdrawalAsOne() {
        _suppressMemberWithdrawalAsOne = true;
    }
    public void suppressPurchaseList() {
        _suppressPurchaseList = true;
    }
    protected void doSuppressAll() { // internal
        suppressMemberStatus();
        suppressMemberLoginAsLatest();
        suppressMemberAddressList();
        suppressMemberLoginList();
        suppressMemberSecurityAsOne();
        suppressMemberServiceAsOne();
        suppressMemberWithdrawalAsOne();
        suppressPurchaseList();
    }
    protected void doSuppressClear() { // internal
        _suppressMemberStatus = false;
        _suppressMemberLoginAsLatest = false;
        _suppressMemberAddressList = false;
        _suppressMemberLoginList = false;
        _suppressMemberSecurityAsOne = false;
        _suppressMemberServiceAsOne = false;
        _suppressMemberWithdrawalAsOne = false;
        _suppressPurchaseList = false;
    }

    // ===================================================================================
    //                                                                      Mapping Option
    //                                                                      ==============
    /**
     * {@inheritDoc}
     */
    public void setBaseOnlyMapping(boolean baseOnlyMapping) {
        if (baseOnlyMapping) {
            doSuppressAll();
        } else {
            doSuppressClear();
        }
    }

    protected boolean isExceptCommonColumn() {
        return _exceptCommonColumn;
    }

    /**
     * {@inheritDoc}
     */
    public void setExceptCommonColumn(boolean exceptCommonColumn) {
        _exceptCommonColumn = exceptCommonColumn;
    }

    protected boolean isReverseReference() {
        return _reverseReference;
    }

    /**
     * {@inheritDoc}
     */
    public void setReverseReference(boolean reverseReference) {
        _reverseReference = reverseReference;
    }

    // -----------------------------------------------------
    //                                           Easy-to-Use
    //                                           -----------
    /**
     * Enable base-only mapping that means the mapping ignores all references.
     * @return this. (NotNull)
     */
    public MemberDtoMapper baseOnlyMapping() {
        setBaseOnlyMapping(true);
        return (MemberDtoMapper)this;
    }

    /**
     * Enable except common column that means the mapping excepts common column.
     * @return this. (NotNull)
     */
    public MemberDtoMapper exceptCommonColumn() {
        setExceptCommonColumn(true);
        return (MemberDtoMapper)this;
    }

    /**
     * Enable reverse reference that means the mapping contains reverse references.
     * @return this. (NotNull)
     */
    public MemberDtoMapper reverseReference() {
        setReverseReference(true);
        return (MemberDtoMapper)this;
    }
}
