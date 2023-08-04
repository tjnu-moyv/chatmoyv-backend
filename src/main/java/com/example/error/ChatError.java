package com.example.error;

/**
 * 错误类型的定义
 *
 * @author SurKaa
 */
public enum ChatError {

    SYSTEM_ERROR(-1, "服务器故障, 请联系开发者修复"),
    REGISTER_ERROR(100, "注册失败"),
    LOGIN_ERROR(200, "登录失败"),
    TOKEN_ERROR(300, "登陆过期, 请重新登录"),
    UPDATE_ERROR(400, "更新失败");

    private final int code;
    private final String message;

    ChatError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
