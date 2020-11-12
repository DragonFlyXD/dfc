package com.dragonflyxd.dfcb.components.common.web.handler;

import com.dragonflyxd.dfcb.components.context.emuns.ResponseCodeEnum;
import com.dragonflyxd.dfcb.components.context.exception.BaseException;
import com.dragonflyxd.dfcb.components.context.exception.BizException;
import com.dragonflyxd.dfcb.components.context.response.ResultResponse;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局控制器异常捕捉 - 处理器
 *
 * @author longfei.chen
 * @since 2020.10.23
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultResponse handle(Exception e) {
        log.error("global exception stack trace：{}", Throwables.getStackTraceAsString(e));

        // 若为业务异常
        if (e instanceof BizException) {
            return ResultResponse.init().error(((BizException) e).getCode(), e.getMessage()).build();
        }

        // 若为其他异常
        if (e instanceof BaseException) {
            return ResultResponse.init().error(((BaseException) e).getCode(), e.getMessage()).build();
        }

        return ResultResponse.init().error(ResponseCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage()).build();
    }
}