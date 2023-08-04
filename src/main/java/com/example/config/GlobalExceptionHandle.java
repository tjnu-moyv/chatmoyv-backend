package com.example.config;

import com.example.error.exception.UserCenterException;
import com.example.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author SurKaa
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(UserCenterException.class)
    public Response<Object> userCenterException(UserCenterException e) {
        log.error("UserCenter: ", e);
        return Response.fail(e);
    }

    @ExceptionHandler(Exception.class)
    public Response<Object> exception(Exception e) {
        log.error("Exception: ", e);
        return Response.fail("服务器内部故障, 请稍后再试");
    }

}
