package com.dragonflyxd.dfcb.components.common.exception;

import com.dragonflyxd.dfcb.components.common.emuns.ResponseCodeEnum;
import lombok.Data;

/**
 * 排他 - 异常
 *
 * @author longfei.chen
 * @since 2020.10.26
 **/
@Data
public class ExclusiveException extends BaseException {
    public ExclusiveException() {
        super(ResponseCodeEnum.EXCLUSIVE_ERROR.getCode(), ResponseCodeEnum.EXCLUSIVE_ERROR.getMessage());
    }
}