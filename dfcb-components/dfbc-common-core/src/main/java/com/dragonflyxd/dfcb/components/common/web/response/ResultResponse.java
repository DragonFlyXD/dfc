package com.dragonflyxd.dfcb.components.common.web.response;

import com.dragonflyxd.dfcb.components.common.emuns.ResponseCodeEnum;
import com.dragonflyxd.dfcb.components.common.exception.BaseException;
import lombok.Data;

/**
 * 结果 - 响应
 *
 * @author longfei.chen
 * @since 2020.10.24
 **/
@Data
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

    public ResultResponse() {
        this.success = true;
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.message = ResponseCodeEnum.SUCCESS.getMessage();
    }

    public ResultResponse(BaseException e) {
        this.success = false;
        this.code = e.getCode();
        this.message = e.getMessage();
    }

    public ResultResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultResponse(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ResultResponse(T data) {
        this.success = true;
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.message = ResponseCodeEnum.SUCCESS.getMessage();
        this.data = data;
    }
}