package com.dragonflyxd.dfcb.components.common.web.controller;

import com.dragonflyxd.dfcb.components.common.dao.entity.BaseEntity;
import com.dragonflyxd.dfcb.components.common.service.BaseService;
import com.dragonflyxd.dfcb.components.common.web.dto.BaseDTO;

/**
 * 控制器 - 基类
 *
 * @author longfei.chen
 * @since 2020.11.09
 **/
public abstract class BaseController<E extends BaseEntity, D extends BaseDTO, S extends BaseService<E, D>> {
}
