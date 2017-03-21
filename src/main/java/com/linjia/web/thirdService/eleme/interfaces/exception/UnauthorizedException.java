package com.linjia.web.thirdService.eleme.interfaces.exception;


public class UnauthorizedException extends ServiceException {
    public UnauthorizedException() {
        super("UNAUTHORIZED", "token认证失败,请重新申请token");
    }
    public UnauthorizedException(String message) {
        super("UNAUTHORIZED", message);
    }
}
