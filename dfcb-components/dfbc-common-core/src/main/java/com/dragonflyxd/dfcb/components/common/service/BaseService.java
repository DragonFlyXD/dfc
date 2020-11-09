package com.dragonflyxd.dfcb.components.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dragonflyxd.dfcb.components.common.dao.entity.BaseEntity;
import com.dragonflyxd.dfcb.components.common.emuns.DeleteFlagEnum;
import com.dragonflyxd.dfcb.components.common.emuns.ResponseCodeEnum;
import com.dragonflyxd.dfcb.components.common.util.AssertUtil;
import com.dragonflyxd.dfcb.components.common.web.dto.BaseDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service - 基类
 *
 * @author longfei.chen
 * @since 2020.10.27
 **/
public interface BaseService<Entity extends BaseEntity, DTO extends BaseDTO> extends IService<Entity> {
    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return DTO
     */
    default DTO findById(Long id) {
        AssertUtil.notNull(id, ResponseCodeEnum.PARAMS_INVALID.getCode());

        return entityToDTO(getById(id));
    }

    /**
     * 根据主键集合查询
     *
     * @param ids 主键集合
     * @return DTO集合
     */
    default List<DTO> findByIds(List<Long> ids) {
        AssertUtil.notEmpty(ids, ResponseCodeEnum.PARAMS_INVALID.getCode());

        return entitiesToDTOs(listByIds(ids));
    }

    /**
     * 保存
     *
     * @param dto DTO
     * @return DTO
     */
    @Transactional(rollbackFor = Exception.class)
    default DTO save(DTO dto) {
        AssertUtil.notNull(dto, ResponseCodeEnum.PARAMS_INVALID.getCode());
        AssertUtil.isTrue(save(dtoToEntity(dto)), ResponseCodeEnum.SAVE_FAILED.getCode());

        return dto;
    }

    /**
     * 批量保存
     *
     * @param dtos DTO集合
     * @return DTO集合
     */
    @Transactional(rollbackFor = Exception.class)
    default List<DTO> saveBatch(List<DTO> dtos) {
        AssertUtil.notEmpty(dtos, ResponseCodeEnum.PARAMS_INVALID.getCode());
        AssertUtil.isTrue(saveBatch(dtosToEntities(dtos), dtos.size()), ResponseCodeEnum.SAVE_BATCH_FAILED.getCode());

        return dtos;
    }

    /**
     * 更新
     *
     * @param dto DTO
     * @return DTO
     */
    @Transactional(rollbackFor = Exception.class)
    default DTO update(DTO dto) {
        AssertUtil.notNull(dto, ResponseCodeEnum.PARAMS_INVALID.getCode());
        AssertUtil.isTrue(updateById(dtoToEntity(dto)), ResponseCodeEnum.UPDATE_FAILED.getCode());

        return dto;
    }

    /**
     * 批量更新
     *
     * @param dtos DTO集合
     * @return DTO集合
     */
    @Transactional(rollbackFor = Exception.class)
    default List<DTO> updateBatch(List<DTO> dtos) {
        AssertUtil.notEmpty(dtos, ResponseCodeEnum.PARAMS_INVALID.getCode());
        AssertUtil.isTrue(updateBatchById(dtosToEntities(dtos), dtos.size()), ResponseCodeEnum.UPDATE_BATCH_FAILED.getCode());

        return dtos;
    }

    /**
     * 删除
     *
     * @param dto DTO
     * @return DTO
     */
    @Transactional(rollbackFor = Exception.class)
    default DTO remove(DTO dto) {
        AssertUtil.notNull(dto, ResponseCodeEnum.PARAMS_INVALID.getCode());

        dto.setDeleteFlag(DeleteFlagEnum.DELETED.getCode());
        AssertUtil.isTrue(updateById(dtoToEntity(dto)), ResponseCodeEnum.DELETE_FAILED.getCode());

        return dto;
    }

    /**
     * 批量删除
     *
     * @param dtos DTO集合
     * @return DTO集合
     */
    @Transactional(rollbackFor = Exception.class)
    default List<DTO> removeBatch(List<DTO> dtos) {
        AssertUtil.notEmpty(dtos, ResponseCodeEnum.PARAMS_INVALID.getCode());

        dtos.forEach(v -> v.setDeleteFlag(DeleteFlagEnum.DELETED.getCode()));
        AssertUtil.isTrue(updateBatchById(dtosToEntities(dtos), dtos.size()), ResponseCodeEnum.DELETE_BATCH_FAILED.getCode());

        return dtos;
    }

    /**
     * DTO转换成实体类
     *
     * @param dto DTO
     * @return 实体类
     */
    Entity dtoToEntity(DTO dto);

    /**
     * DTO批量转换成实体类
     *
     * @param dtos DTO集合
     * @return 实体类集合
     */
    default List<Entity> dtosToEntities(List<DTO> dtos) {
        return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    /**
     * 实体类转换成DTO
     *
     * @param entity 实体类
     * @return DTO
     */
    DTO entityToDTO(Entity entity);

    /**
     * 实体类批量转换成DTO
     *
     * @param entities 实体类集合
     * @return DTO集合
     */
    default List<DTO> entitiesToDTOs(List<Entity> entities) {
        return entities.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}