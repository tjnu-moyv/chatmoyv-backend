package com.example.error.exception;


import com.example.error.ChatError;

/**
 * 登录时发生的异常
 *
 * @author SurKaa
 */
public class LoginException extends UserCenterException {
    private LoginException(String message, int code, String description) {
        super(message, code, description);
    }

    /**
     * 发生登录错误
     *
     * @param description 错误原因(传入的参数问题)
     * @return error
     */
    public static LoginException error(String description) {
        return new LoginException(
                ChatError.LOGIN_ERROR.getMessage(),
                ChatError.LOGIN_ERROR.getCode(),
                description
        );
    }
}
