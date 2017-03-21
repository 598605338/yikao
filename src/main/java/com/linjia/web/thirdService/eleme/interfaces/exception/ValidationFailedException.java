package com.linjia.web.thirdService.eleme.interfaces.exception;


public class ValidationFailedException extends ServiceException {
    public ValidationFailedException() {
        super("VALIDATION_FAILED", "参数错误");
    }

    public ValidationFailedException(String message) {
        super("VALIDATION_FAILED", message);
    }
}
