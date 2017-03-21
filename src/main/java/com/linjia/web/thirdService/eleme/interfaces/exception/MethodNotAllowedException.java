package com.linjia.web.thirdService.eleme.interfaces.exception;




public class MethodNotAllowedException extends ServiceException {
    public MethodNotAllowedException() {
        super("METHOD_NOT_ALLOWED", "禁止访问");
    }
    public MethodNotAllowedException(String message) {
        super("METHOD_NOT_ALLOWED", message);
    }
}
