package com.cpstudio.recipe_app.core.exception;

public class NotFoundException extends GlobalException {

    private static final String DEFAULT_ERROR_CODE = "NOT_FOUND";

    public NotFoundException(final String message) {
        super(DEFAULT_ERROR_CODE, message);
    }
}
