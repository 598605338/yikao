package com.linjia.web.thirdService.meituan.exception;

/**
 * Created by zhangzhidong on 15/10/26.
 */
public class ApiSysException extends Exception {

    private ExceptionEnum exceptionEnum;
    public ApiSysException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(
        ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ApiSysException(String msg,Throwable t){
        super(msg,t);
    }

    public ApiSysException(Throwable t){
        super(t);
    }

    public ApiSysException(String msg){
        super(msg);
    }

    @Override
    public String toString() {
        return super.toString() + " " + exceptionEnum.toString();
    }
}
