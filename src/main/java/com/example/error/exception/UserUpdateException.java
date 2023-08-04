package com.example.error.exception;

import com.example.error.ChatError;

/**
 * 发生更新错误
 *
 * @author SurKaa
 */
public class UserUpdateException extends UserCenterException {
    private UserUpdateException(String message, int code, String description) {
        super(message, code, description);
    }

    /**
     * 发生更新错误
     *
     * @param description 错误原因(传入的参数问题)
     * @return error
     */
    public static UserUpdateException error(String description) {
        return new UserUpdateException(
                ChatError.UPDATE_ERROR.getMessage(),
                ChatError.UPDATE_ERROR.getCode(),
                description
        );
    }
}
