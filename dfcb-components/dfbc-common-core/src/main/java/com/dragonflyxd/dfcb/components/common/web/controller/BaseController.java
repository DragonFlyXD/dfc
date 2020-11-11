package com.dragonflyxd.dfcb.components.common.web.controller;

import com.dragonflyxd.dfcb.components.common.dao.entity.BaseEntity;
import com.dragonflyxd.dfcb.components.common.service.BaseService;
import com.dragonflyxd.dfcb.components.common.web.dto.BaseDTO;
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
public abstract class BaseController<E extends BaseEntity, D extends BaseDTO, S extends BaseService<E, D>> {
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
    public List<D> getAll() {
        return service.findAll();
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return DTO
     */
    @GetMapping("{id}")
    public D getById(@PathVariable Long id) {
        return service.findById(id);
    }

    /**
     * 保存
     *
     * @param dto DTO
     * @return DTO
     */
    @PostMapping
    public D create(@RequestBody D dto) {
        return service.save(dto);
    }

    /**
     * 更新
     *
     * @param id  主键
     * @param dto DTO
     * @return DTO
     */
    @PutMapping("{id}")
    public D update(@PathVariable Long id, @RequestBody D dto) {
        return service.checkAndUpdate(id, dto);
    }

    @DeleteMapping("{id}")
    public D delete(@PathVariable Long id){
        return service.remove(id);
    }
}
