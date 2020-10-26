package com.dragonflyxd.dfcb.components.common.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务 - 异常
 *
 * @author longfei.chen
 * @since 2020.10.23
 **/
@Data
@NoArgsConstructor
public class BizException extends BaseException {
    private Object[] args;

    public BizException(String code) {
        super(code);
    }

    public BizException(String code, Object[] args) {
        super(code);
        this.args = args;
    }

    public BizException(String code, String message) {
        super(code, message);
    }

    public BizException(String code, String message, Object[] args) {
        super(code, message);
        this.args = args;
    }
}