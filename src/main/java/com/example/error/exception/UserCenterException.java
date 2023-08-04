package com.example.error.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 统一的错误类型
 * <p>
 * 所有错误
 *
 * @author SurKaa
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserCenterException extends RuntimeException {

    private final int code;

    private final String description;

    public UserCenterException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }
}
