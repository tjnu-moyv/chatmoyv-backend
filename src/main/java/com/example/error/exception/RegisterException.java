package com.example.error.exception;

import com.example.error.ChatError;

/**
 * 抛出注册异常
 *
 * @author SurKaa
 */
public class RegisterException extends UserCenterException {
    private RegisterException(String message, int code, String description) {
        super(message, code, description);
    }

    /**
     * 发生注册错误
     *
     * @param description 错误原因(传入的参数问题)
     * @return error
     */
    public static RegisterException error(String description) {
        return new RegisterException(
                ChatError.REGISTER_ERROR.getMessage(),
                ChatError.REGISTER_ERROR.getCode(),
                description
        );
    }
}
