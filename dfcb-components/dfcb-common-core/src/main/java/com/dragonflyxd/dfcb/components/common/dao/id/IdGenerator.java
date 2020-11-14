package com.dragonflyxd.dfcb.components.common.dao.id;

/**
 * ID - 生成器
 *
 * @author longfei.chen
 * @since 2020.10.29
 **/
public interface IdGenerator<T> {
    /**
     * 生成ID
     *
     * @return ID
     */
    T generateId();
}
