package com.cpstudio.recipe_app.core.exception;

public class ForeignKeyConstraintException extends BadRequestException {

    private static final String DEFAULT_ERROR_CODE = "FOREIGN_KEY_CONSTRAINT_VIOLATION";

    public ForeignKeyConstraintException(final String message) {
        super(DEFAULT_ERROR_CODE, message);
    }

}
