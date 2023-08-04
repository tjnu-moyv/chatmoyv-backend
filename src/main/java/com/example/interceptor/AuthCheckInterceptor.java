package com.example.interceptor;

import com.example.error.exception.TokenException;
import com.example.utils.TokenPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 鉴权拦截器
 *
 * @author SurKaa
 */
@Slf4j
public class AuthCheckInterceptor implements HandlerInterceptor {

    public static final String[] NO_TOKEN_URL = {
            "/users/login",
            "/users/register"
    };

    /**
     * 检查是否含有token
     *
     * @param request  请求
     * @param response 返回
     * @param handler  handler
     * @return 是否允许通过
     */
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {

        log.debug(
                "New Request: uri={}, method={}, user-agent={}",
                request.getRequestURI(),
                request.getMethod(),
                request.getHeader("User-Agent")
        );

        // 跳过免登录的
        for (String s : NO_TOKEN_URL) {
            if (request.getRequestURI().endsWith(s)) {
                log.debug("NO_TOKEN_URL 跳过");
                return true;
            }
        }

        if (!TokenPool.checkToken(request)) {
            throw TokenException.error("未登录请求");
        }
        return true;
    }
}
