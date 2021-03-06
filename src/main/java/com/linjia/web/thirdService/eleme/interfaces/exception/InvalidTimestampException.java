package com.linjia.web.thirdService.eleme.interfaces.exception;


public class InvalidTimestampException extends ServiceException {
    public InvalidTimestampException() {
        super("INVALID_TIMESTAMP", "请求时间戳异常");
    }
    public InvalidTimestampException(String message) {
        super("INVALID_TIMESTAMP", message);
    }
}
