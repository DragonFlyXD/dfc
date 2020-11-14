package com.dragonflyxd.dfcb.components.context.emuns;

import com.dragonflyxd.dfcb.components.context.util.EnumUtil;

/**
 * 删除标识 - 枚举
 *
 * @author longfei.chen
 * @since 2020.10.23
 **/
public enum DeleteFlagEnum {
    /**
     * 未删除
     */
    NOT_DELETE(0, "NOT_DELETE"),
    /**
     * 已删除
     */
    DELETED(1, "DELETED");

    private Integer code;
    private String message;

    DeleteFlagEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static DeleteFlagEnum getEnum(String code) {
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