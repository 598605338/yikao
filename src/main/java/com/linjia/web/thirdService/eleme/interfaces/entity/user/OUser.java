package com.linjia.web.thirdService.eleme.interfaces.entity.user;

import java.util.List;

public class OUser {
    private long userId;
    private String userName;
    private List<OAuthorizedShop> authorizedShops;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<OAuthorizedShop> getAuthorizedShops() {
        return authorizedShops;
    }

    public void setAuthorizedShops(List<OAuthorizedShop> authorizedShops) {
        this.authorizedShops = authorizedShops;
    }
}
