package com.linjia.web.thirdService.meituan.vo;

/**
 * Created by yangzhiqi on 15/10/15.
 * 每个接口都需要传入的参数
 */
public class SystemParam {

    private String appId;
    private String appSecret;

    public SystemParam(String appId, String appSecret){
        this.setAppId(appId);
        this.setAppSecret(appSecret);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
