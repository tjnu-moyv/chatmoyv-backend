package com.example.utils;

import com.example.error.exception.UserCenterException;
import lombok.Data;

/**
 * 统一的返回体
 *
 * @author SurKaa
 */
@Data
public class Response<T> {

    private int code;
    private T data;
    private String message;
    private String description;

    private Response(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    /**
     * 错误返回体
     *
     * @param message     错误信息
     * @param description 错误详情
     * @return 返回体
     */
    public static Response<Object> fail(String message, String description) {
        return new Response<>(-1, null, message, description);
    }

    /**
     * 错误返回体
     *
     * @param message 错误信息
     * @return 返回体
     */
    public static Response<Object> fail(String message) {
        return new Response<>(-1, null, message, null);
    }

    /**
     * 错误返回体
     *
     * @param e    错误异常
     * @param data 错误信息
     * @return 返回体
     */
    public static <T> Response<T> fail(UserCenterException e, T data) {
        return new Response<>(e.getCode(), data, e.getMessage(), e.getDescription());
    }

    /**
     * 错误返回体
     *
     * @param e 错误异常
     * @return 返回体
     */
    public static Response<Object> fail(UserCenterException e) {
        return new Response<>(e.getCode(), null, e.getMessage(), e.getDescription());
    }

    /**
     * 成功返回提
     *
     * @param data 返回数据
     * @param <T>  返回数据的类型
     * @return 返回体
     */
    public static <T> Response<T> success(T data) {
        return new Response<>(0, data, null, null);
    }
}
