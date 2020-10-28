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
import com.dragonflyxd.dfcb.components.common.web.dto.BaseDTO;

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
    default boolean save(DTO dto) {
        return save(DTOToEntity(dto));
    }

    default boolean saveBatch(List<DTO> dtos) {
        return saveBatch(DTOsToEntities(dtos));
    }

    default boolean saveBatch(List<DTO> dtos, int batchSize) {
        return saveBatch(DTOsToEntities(dtos), )
    }

    @Override
    default boolean saveOrUpdateBatch(Collection<Entity> entityList) {
        return false;
    }

    @Override
    boolean saveOrUpdateBatch(Collection<Entity> entityList, int batchSize);

    @Override
    default boolean removeById(Serializable id) {
        return false;
    }

    @Override
    default boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    default boolean remove(Wrapper<Entity> queryWrapper) {
        return false;
    }

    @Override
    default boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    default boolean updateById(Entity entity) {
        return false;
    }

    @Override
    default boolean update(Wrapper<Entity> updateWrapper) {
        return false;
    }

    @Override
    default boolean update(Entity entity, Wrapper<Entity> updateWrapper) {
        return false;
    }

    @Override
    default boolean updateBatchById(Collection<Entity> entityList) {
        return false;
    }

    @Override
    boolean updateBatchById(Collection<Entity> entityList, int batchSize);

    @Override
    boolean saveOrUpdate(Entity entity);

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

    Entity DTOToEntity(DTO dto);

    default List<Entity> DTOsToEntities(List<DTO> dtos) {
        return dtos.stream().map(this::DTOToEntity).collect(Collectors.toList());
    }

    DTO entityToDTO(Entity entity);

    default List<DTO> entitiesToDTOs(List<Entity> entities) {
        return entities.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}