package com.dragonflyxd.dfcb.components.common.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragonflyxd.dfcb.components.common.dao.entity.BaseEntity;
import com.dragonflyxd.dfcb.components.common.dao.id.IdGenerator;
import com.dragonflyxd.dfcb.components.common.dao.mapper.BaseMapper;
import com.dragonflyxd.dfcb.components.common.service.BaseService;
import com.dragonflyxd.dfcb.components.common.web.context.UserContext;
import com.dragonflyxd.dfcb.components.context.dto.BaseDTO;
import com.dragonflyxd.dfcb.components.context.emuns.DeleteFlagEnum;
import com.dragonflyxd.dfcb.components.context.emuns.EnableFlagEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Service - 基类实现类
 *
 * @author longfei.chen
 * @since 2020.10.28
 **/
@Slf4j
public class BaseServiceImpl<E extends BaseEntity, D extends BaseDTO, M extends BaseMapper<E>> extends ServiceImpl<M, E> implements BaseService<E, D> {
    protected Class<D> dtoClass = currentDTOClass();

    @Autowired
    private IdGenerator<Long> idGenerator;

    /**
     * 设置保存的共通字段
     *
     * @param dto DTO
     */
    @Override
    public void setSaveColumns(D dto) {
        if (null == dto.getId()) {
            dto.setId(idGenerator.generateId());
        }

        if (null == dto.getEnableFlag()) {
            dto.setEnableFlag(EnableFlagEnum.ENABLED.getCode());
        }

        if (null == dto.getDeleteFlag()) {
            dto.setDeleteFlag(DeleteFlagEnum.NOT_DELETE.getCode());
        }

        Timestamp timestamp = Timestamp.from(Instant.now());

        dto.setCreatedAt(UserContext.getUserId());
        dto.setCreatedUserName(UserContext.getUsername());
        dto.setCreatedTime(timestamp);
        dto.setUpdatedAt(UserContext.getUserId());
        dto.setUpdatedUserName(UserContext.getUsername());
        dto.setUpdatedTime(timestamp);
    }

    /**
     * 设置更新的共通字段
     *
     * @param dto DTO
     */
    @Override
    public void setUpdateColumns(D dto) {
        dto.setUpdatedAt(UserContext.getUserId());
        dto.setUpdatedUserName(UserContext.getUsername());
        dto.setUpdatedTime(Timestamp.from(Instant.now()));
    }

    /**
     * DTO转换成实体类
     *
     * @param dto DTO
     * @return 实体类
     */
    @Override
    public E dtoToEntity(D dto) {
        E entity;

        try {
            entity = (E) entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            log.error("BaseServiceImpl.dtoToEntity err：{}", ex.getMessage());

            return null;
        }

        BeanUtils.copyProperties(dto, entity);

        return entity;
    }

    /**
     * 实体类转换成DTO
     *
     * @param entity 实体类
     * @return DTO
     */
    @Override
    public D entityToDTO(E entity) {
        D dto;

        try {
            dto = dtoClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            log.error("BaseServiceImpl.entityToDTO err：{}", ex.getMessage());

            return null;
        }

        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    /**
     * 获取DTO类型
     *
     * @return DTO类型
     */
    protected Class<D> currentDTOClass() {
        return (Class<D>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
    }
}