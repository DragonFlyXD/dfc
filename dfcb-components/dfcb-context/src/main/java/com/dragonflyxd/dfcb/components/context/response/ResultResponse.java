package com.dragonflyxd.dfcb.components.context.response;

import com.dragonflyxd.dfcb.components.context.emuns.ResponseCodeEnum;
import lombok.AllArgsConstructor;

/**
 * 结果 - 响应
 *
 * @author longfei.chen
 * @since 2020.10.24
 **/
@AllArgsConstructor
public class ResultResponse<T> {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 响应内容
     */
    private T data;

    public static Builder init() {
        return new Builder();
    }

    public static class Builder {
        protected static boolean success;
        protected static String code;
        protected static String message;

        public Builder ok() {
            success = true;
            code = ResponseCodeEnum.SUCCESS.getCode();
            message = ResponseCodeEnum.SUCCESS.getMessage();

            return this;
        }

        public Builder error(String code, String message) {
            success = false;
            Builder.code = code;
            Builder.message = message;

            return this;
        }

        public <T> ResultResponse<T> build() {
            return new ResultResponse<>(success, code, message, null);
        }

        public <T> ResultResponse<T> build(T data) {
            return new ResultResponse<>(success, code, message, data);
        }
    }
}