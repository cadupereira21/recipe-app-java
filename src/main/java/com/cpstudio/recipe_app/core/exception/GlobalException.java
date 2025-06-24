package com.cpstudio.recipe_app.core.exception;

import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

    public transient String errorCode;

    public GlobalException(final String errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
