package com.dragonflyxd.dfcb.components.common.emuns;

import com.dragonflyxd.dfcb.components.common.util.EnumUtil;

/**
 * 响应编码 - 枚举
 *
 * @author longfei.chen
 * @since 2020.10.24
 **/
public enum ResponseCodeEnum {
    /**
     * 成功
     */
    SUCCESS("IMSG000001", "SUCCESS"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR("EMSG000001", "SYSTEM_ERROR"),
    /**
     * 排他
     */
    EXCLUSIVE("EMSG000002", "EXCLUSIVE");

    private String code;
    private String message;

    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseCodeEnum getEnum(String code) {
        return EnumUtil.getByCode(values(), code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}