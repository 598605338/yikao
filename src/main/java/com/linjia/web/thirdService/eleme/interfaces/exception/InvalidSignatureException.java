package com.linjia.web.thirdService.eleme.interfaces.exception;


public class InvalidSignatureException extends ServiceException {
    public InvalidSignatureException() {
        super("INVALID_SIGNATURE", "无效的签名");
    }
    public InvalidSignatureException(String message) {
        super("INVALID_SIGNATURE", message);
    }
}
