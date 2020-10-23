package com.dragonflyxd.dfcb.components.common.emuns;

import com.dragonflyxd.dfcb.components.common.util.EnumUtil;

/**
 * 启用标识 - 枚举
 *
 * @author longfei.chen
 * @since 2020.10.23
 **/
public enum EnableFlagEnum {
    /**
     * 未启用
     */
    NOT_ENABLE(0, "NOT_ENABLE"),
    /**
     * 已启用
     */
    ENABLED(1, "ENABLED"),
    /**
     * 停用
     */
    DISABLED(2, "DISABLED");

    private Integer code;
    private String message;

    EnableFlagEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static EnableFlagEnum getEnum(String code) {
        return EnumUtil.getByCode(values(), code);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}