package com.linjia.web.thirdService.meituan.constants;

/**
 * Created by yangzhiqi on 15/10/19.
 * 请求方法类型
 */
public enum RequestMethodTypeEnum {

    POST("POST","POST"),
    GET("GET","GET");

    private String code;
    private String desc;

    RequestMethodTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
