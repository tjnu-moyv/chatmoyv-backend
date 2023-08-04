package com.example.error.exception;

import com.example.error.ChatError;

/**
 * 关于鉴权的异常
 *
 * @author SurKaa
 */
public class TokenException extends UserCenterException {
    private TokenException(String message, int code, String description) {
        super(message, code, description);
    }

    /**
     * 发生鉴权错误
     *
     * @param description 错误原因(传入的参数问题)
     * @return error
     */
    public static TokenException error(String description) {
        return new TokenException(
                ChatError.TOKEN_ERROR.getMessage(),
                ChatError.TOKEN_ERROR.getCode(),
                description
        );
    }
}
