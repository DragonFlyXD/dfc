package com.dragonflyxd.dfcb.components.common.web.handler;

import com.dragonflyxd.dfcb.components.common.exception.BaseException;
import com.dragonflyxd.dfcb.components.common.exception.BizException;
import com.dragonflyxd.dfcb.components.common.exception.SystemErrorException;
import com.dragonflyxd.dfcb.components.common.web.response.ResultResponse;
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

        ResultResponse resp = new ResultResponse(new SystemErrorException());

        // 若为业务异常
        if (e instanceof BizException) {
            resp.setCode(((BizException) e).getCode());
            resp.setMessage(e.getMessage());
        }
        // 若为其他异常
        else if (e instanceof BaseException) {
            resp.setCode(((BaseException) e).getCode());
            resp.setMessage(e.getMessage());
        }

        return resp;
    }
}