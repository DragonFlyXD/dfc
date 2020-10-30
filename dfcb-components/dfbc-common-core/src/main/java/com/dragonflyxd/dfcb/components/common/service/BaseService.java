package com.dragonflyxd.dfcb.components.common.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dragonflyxd.dfcb.components.common.dao.entity.BaseEntity;
import com.dragonflyxd.dfcb.components.common.emuns.DeleteFlagEnum;
import com.dragonflyxd.dfcb.components.common.emuns.ResponseCodeEnum;
import com.dragonflyxd.dfcb.components.common.util.AssertUtil;
import com.dragonflyxd.dfcb.components.common.web.dto.BaseDTO;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Service - 基类
 *
 * @author longfei.chen
 * @since 2020.10.27
 **/
public interface BaseService<Entity extends BaseEntity, DTO extends BaseDTO> extends IService<Entity> {
    /**
     * 保存
     *
     * @param dto DTO
     * @return DTO
     */
    @Transactional(rollbackFor = Exception.class)
    default DTO save(DTO dto) {
        AssertUtil.notNull(dto, ResponseCodeEnum.PARAMS_INVALID.getCode());
        AssertUtil.isTrue(save(DTOToEntity(dto)), ResponseCodeEnum.SAVE_FAILED.getCode());

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
        AssertUtil.isTrue(saveBatch(DTOsToEntities(dtos), dtos.size()), ResponseCodeEnum.SAVE_BATCH_FAILED.getCode());

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
        AssertUtil.isTrue(updateById(DTOToEntity(dto)), ResponseCodeEnum.UPDATE_FAILED.getCode());

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
        AssertUtil.isTrue(updateBatchById(DTOsToEntities(dtos), dtos.size()), ResponseCodeEnum.UPDATE_BATCH_FAILED.getCode());

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
        AssertUtil.isTrue(updateById(DTOToEntity(dto)), ResponseCodeEnum.DELETE_FAILED.getCode());

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
        AssertUtil.isTrue(updateBatchById(DTOsToEntities(dtos), dtos.size()), ResponseCodeEnum.DELETE_BATCH_FAILED.getCode());

        return dtos;
    }

    @Override
    default Entity getById(Serializable id) {
        return null;
    }

    @Override
    default List<Entity> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    default List<Entity> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    default Entity getOne(Wrapper<Entity> queryWrapper) {
        return null;
    }

    @Override
    Entity getOne(Wrapper<Entity> queryWrapper, boolean throwEx);

    @Override
    Map<String, Object> getMap(Wrapper<Entity> queryWrapper);

    @Override
    <V> V getObj(Wrapper<Entity> queryWrapper, Function<? super Object, V> mapper);

    @Override
    default int count() {
        return 0;
    }

    @Override
    default int count(Wrapper<Entity> queryWrapper) {
        return 0;
    }

    @Override
    default List<Entity> list(Wrapper<Entity> queryWrapper) {
        return null;
    }

    @Override
    default List<Entity> list() {
        return null;
    }

    @Override
    default <E extends IPage<Entity>> E page(E page, Wrapper<Entity> queryWrapper) {
        return null;
    }

    @Override
    default <E extends IPage<Entity>> E page(E page) {
        return null;
    }

    @Override
    default List<Map<String, Object>> listMaps(Wrapper<Entity> queryWrapper) {
        return null;
    }

    @Override
    default List<Map<String, Object>> listMaps() {
        return null;
    }

    @Override
    default List<Object> listObjs() {
        return null;
    }

    @Override
    default <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    default List<Object> listObjs(Wrapper<Entity> queryWrapper) {
        return null;
    }

    @Override
    default <V> List<V> listObjs(Wrapper<Entity> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    default <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<Entity> queryWrapper) {
        return null;
    }

    @Override
    default <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return null;
    }

    @Override
    BaseMapper<Entity> getBaseMapper();

    @Override
    default QueryChainWrapper<Entity> query() {
        return null;
    }

    @Override
    default LambdaQueryChainWrapper<Entity> lambdaQuery() {
        return null;
    }

    @Override
    default UpdateChainWrapper<Entity> update() {
        return null;
    }

    @Override
    default LambdaUpdateChainWrapper<Entity> lambdaUpdate() {
        return null;
    }

    @Override
    default boolean saveOrUpdate(Entity entity, Wrapper<Entity> updateWrapper) {
        return false;
    }

    /**
     * DTO转换成实体类
     *
     * @param dto DTO
     * @return 实体类
     */
    Entity DTOToEntity(DTO dto);

    /**
     * DTO批量转换成实体类
     *
     * @param dtos DTO集合
     * @return 实体类集合
     */
    default List<Entity> DTOsToEntities(List<DTO> dtos) {
        return dtos.stream().map(this::DTOToEntity).collect(Collectors.toList());
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