package com.dragonflyxd.dfcb.components.common.web.controller;

import com.dragonflyxd.dfcb.components.common.dao.entity.BaseEntity;
import com.dragonflyxd.dfcb.components.common.service.BaseService;
import com.dragonflyxd.dfcb.components.common.web.dto.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("{id}")
    public D show(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public D store(@RequestBody D dto) {
        return service.save(dto);
    }

    @PutMapping("{id}")
    public D update(@RequestBody D dto) {
        return service.update(dto);
    }
}
