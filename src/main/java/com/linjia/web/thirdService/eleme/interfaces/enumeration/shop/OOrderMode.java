package com.linjia.web.thirdService.eleme.interfaces.enumeration.shop;

/**
 * 订单模式
 */
public enum OOrderMode {

    /**
     * 未知状态
     */
    unknown(-1, "unknown", " 未知状态"),

    /**
     * 使用开放平台接单
     */
    openApi(1, "busyLevelFree", "使用开放平台接单"),

    /**
     * 使用饿了么商家版后台接单
     */
    webSystem(2, "busyLevelClosed", " 使用饿了么商家版后台接单"),

    /**
     * 使用饿了么商家版的android客户端接单
     */
    android(3, "busyLevelNetworkUnstable", "使用饿了么商家版的android客户端接单"),

    /**
     * 使用饿了么商家版的ios客户端接单
     */
    ios(4, "busyLevelHoliday", "使用饿了么商家版的ios客户端接单");

    private int value;
    private String name;
    private String description;

    OOrderMode(int value, String name, String description) {
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public static OOrderMode findValue(int type) {
        for (OOrderMode invalidStatus : values()) {
            if (invalidStatus.getValue() == type) {
                return invalidStatus;
            }
        }
        return OOrderMode.unknown;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
