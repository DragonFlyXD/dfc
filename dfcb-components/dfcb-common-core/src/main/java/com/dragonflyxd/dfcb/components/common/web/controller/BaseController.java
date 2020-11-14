package com.dragonflyxd.dfcb.components.common.web.controller;

import com.dragonflyxd.dfcb.components.common.dao.entity.BaseEntity;
import com.dragonflyxd.dfcb.components.common.service.BaseService;
import com.dragonflyxd.dfcb.components.context.api.BaseApi;
import com.dragonflyxd.dfcb.components.context.dto.BaseDTO;
import com.dragonflyxd.dfcb.components.context.response.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 控制器 - 基类
 *
 * @author longfei.chen
 * @since 2020.11.09
 **/
public abstract class BaseController<E extends BaseEntity, D extends BaseDTO, S extends BaseService<E, D>> implements BaseApi<D> {
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @Autowired
    private S service;

    /**
     * 查询所有
     *
     * @return DTO集合
     */
    @GetMapping
    @Override
    public ResultResponse<List<D>> getAll() {
        return ResultResponse.init().ok().build(service.findAll());
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return DTO
     */
    @GetMapping("{id}")
    @Override
    public ResultResponse<D> getById(@PathVariable Long id) {
        return ResultResponse.init().ok().build(service.findById(id));
    }

    /**
     * 保存
     *
     * @param dto DTO
     * @return DTO
     */
    @PostMapping
    @Override
    public ResultResponse<D> create(@RequestBody D dto) {
        return ResultResponse.init().ok().build(service.save(dto));
    }

    /**
     * 更新
     *
     * @param id  主键
     * @param dto DTO
     * @return DTO
     */
    @PutMapping("{id}")
    @Override
    public ResultResponse<D> update(@PathVariable Long id, @RequestBody D dto) {
        return ResultResponse.init().ok().build(service.checkAndUpdate(id, dto));
    }

    /**
     * 删除
     *
     * @param id  主键
     * @param dto DTO
     * @return DTO
     */
    @DeleteMapping("{id}")
    @Override
    public ResultResponse<D> delete(@PathVariable Long id, @RequestBody D dto) {
        return ResultResponse.init().ok().build(service.checkAndDelete(id, dto));
    }
}
