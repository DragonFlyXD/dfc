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
    SUCCESS("IMS100100", "SUCCESS"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR("EMS500100", "SYSTEM_ERROR"),
    /**
     * 排他异常
     */
    EXCLUSIVE_ERROR("EMS500101", "EXCLUSIVE_ERROR"),
    /**
     * 保存失败
     */
    SAVE_FAILED("EMS500200", "SAVE_FAILED"),
    /**
     * 批量保存失败
     */
    SAVE_BATCH_FAILED("EMS500201", "SAVE_BATCH_FAILED"),
    /**
     * 更新失败
     */
    UPDATE_FAILED("EMS500300", "UPDATE_FAILED"),
    /**
     * 批量更新失败
     */
    UPDATE_BATCH_FAILED("EMS500301", "UPDATE_BATCH_FAILED"),
    /**
     * 删除失败
     */
    DELETE_FAILED("EMS500400", "DELETE_FAILED"),
    /**
     * 批量删除失败
     */
    DELETE_BATCH_FAILED("EMS500401", "DELETE_BATCH_FAILED"),
    /**
     * 参数不合法
     */
    PARAMS_INVALID("EMS500501", "PARAMS_INVALID");


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