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
public interface BaseService<E extends BaseEntity, D extends BaseDTO> extends IService<E> {
    /**
     * 查询所有
     *
     * @return DTO集合
     */
    default List<D> findAll() {
        return entitiesToDTOs(list());
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return DTO
     */
    default D findById(Long id) {
        AssertUtil.notNull(id, ResponseCodeEnum.PARAMS_INVALID.getCode());

        return entityToDTO(getById(id));
    }

    /**
     * 根据主键集合查询
     *
     * @param ids 主键集合
     * @return DTO集合
     */
    default List<D> findByIds(List<Long> ids) {
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
    default D save(D dto) {
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
    default List<D> saveBatch(List<D> dtos) {
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
    default D update(D dto) {
        AssertUtil.notNull(dto, ResponseCodeEnum.PARAMS_INVALID.getCode());
        AssertUtil.isTrue(updateById(dtoToEntity(dto)), ResponseCodeEnum.UPDATE_FAILED.getCode());

        return dto;
    }

    /**
     * 检查并更新
     *
     * @param id  主键
     * @param dto DTO
     * @return DTO
     */
    @Transactional(rollbackFor = Exception.class)
    default D checkAndUpdate(Long id, D dto) {
        AssertUtil.notNull(id, ResponseCodeEnum.PARAMS_INVALID.getCode());
        AssertUtil.notNull(dto, ResponseCodeEnum.PARAMS_INVALID.getCode());

        AssertUtil.notNull(getById(id), ResponseCodeEnum.QUERY_FAILED.getCode());
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
    default List<D> updateBatch(List<D> dtos) {
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
    default D remove(D dto) {
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
    default List<D> removeBatch(List<D> dtos) {
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
    E dtoToEntity(D dto);

    /**
     * DTO批量转换成实体类
     *
     * @param dtos DTO集合
     * @return 实体类集合
     */
    default List<E> dtosToEntities(List<D> dtos) {
        return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    /**
     * 实体类转换成DTO
     *
     * @param entity 实体类
     * @return DTO
     */
    D entityToDTO(E entity);

    /**
     * 实体类批量转换成DTO
     *
     * @param entities 实体类集合
     * @return DTO集合
     */
    default List<D> entitiesToDTOs(List<E> entities) {
        return entities.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}