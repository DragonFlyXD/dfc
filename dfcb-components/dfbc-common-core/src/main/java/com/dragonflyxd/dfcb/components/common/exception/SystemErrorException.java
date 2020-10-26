package com.dragonflyxd.dfcb.components.common.exception;

import com.dragonflyxd.dfcb.components.common.emuns.ResponseCodeEnum;
import lombok.Data;

/**
 * 系统错误 - 异常
 *
 * @author longfei.chen
 * @since 2020.10.26
 **/
@Data
public class SystemErrorException extends BaseException {
    public SystemErrorException() {
        super(ResponseCodeEnum.SYSTEM_ERROR.getCode(), ResponseCodeEnum.SYSTEM_ERROR.getMessage());
    }
}