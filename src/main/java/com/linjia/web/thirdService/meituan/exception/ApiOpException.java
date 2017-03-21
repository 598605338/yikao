package com.linjia.web.thirdService.meituan.exception;

/**
 * Created by zhangzhidong on 15/10/26.
 */
public class ApiOpException extends Exception {

    private int code;
    private String msg;

    public ApiOpException(Throwable cause){
        super(cause);
    }

    public ApiOpException(String msg){
        this.msg = msg;
    }

    public ApiOpException(String msg,Throwable cause){
        super(msg,cause);
    }

    public ApiOpException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ApiOpException{" +
               "code=" + code +
               ", msg='" + msg + '\'' +
               '}';
    }
}
