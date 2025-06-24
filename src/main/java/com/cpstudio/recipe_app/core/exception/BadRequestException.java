package com.cpstudio.recipe_app.core.exception;

public class BadRequestException extends GlobalException {

    final static String DEFAULT_ERROR_CODE = "generic_bad_request";

    public BadRequestException(final String message) {
        super(DEFAULT_ERROR_CODE, message);
    }

    public BadRequestException(final String errorCode, final String message) {
        super(errorCode, message);
    }
}
