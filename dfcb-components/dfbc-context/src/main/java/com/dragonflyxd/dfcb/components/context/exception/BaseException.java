package com.dragonflyxd.dfcb.components.context.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 异常 - 基类
 *
 * @author longfei.chen
 * @since 2020.10.26
 **/
@Data
@NoArgsConstructor
public class BaseException extends RuntimeException {
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;

    public BaseException(String code) {
        this.code = code;
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }
}