package com.dragonflyxd.dfcb.components.context.api;

import com.dragonflyxd.dfcb.components.context.dto.BaseDTO;
import com.dragonflyxd.dfcb.components.context.response.ResultResponse;

import java.util.List;

/**
 * Api - 基类
 *
 * @author longfei.chen
 * @since 2020.11.12
 **/
public interface BaseApi<D extends BaseDTO> {
    /**
     * 查询所有
     *
     * @return DTO集合
     */
    ResultResponse<List<D>> getAll();

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return DTO
     */
    ResultResponse<D> getById(Long id);

    /**
     * 保存
     *
     * @param dto DTO
     * @return DTO
     */
    ResultResponse<D> create(D dto);

    /**
     * 更新
     *
     * @param id  主键
     * @param dto DTO
     * @return DTO
     */
    ResultResponse<D> update(Long id, D dto);

    /**
     * 删除
     *
     * @param id  主键
     * @param dto DTO
     * @return DTO
     */
    ResultResponse<D> delete(Long id, D dto);
}