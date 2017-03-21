package com.linjia.web.thirdService.eleme.interfaces.enumeration.shop;

/**
 * 店铺营业状态
 */
public enum OBusyLevel {

    /**
     * 未知状态
     */
    others(-1, "other", " 未知状态"),

    /**
     * 店铺正常营业
     */
    busyLevelFree(0, "busyLevelFree", "店铺正常营业"),

    /**
     * 店铺休息中
     */
    busyLevelClosed(2, "busyLevelClosed", " 店铺休息中"),

    /**
     * 店铺网络不稳定/电话订餐
     */
    busyLevelNetworkUnstable(3, "busyLevelNetworkUnstable", " 店铺网络不稳定/电话订餐"),

    /**
     * 店铺休假中
     */
    busyLevelHoliday(4, "busyLevelHoliday", " 店铺休假中");

    private int value;
    private String name;
    private String description;

    OBusyLevel(int value, String name, String description) {
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public static OBusyLevel findValue(int type) {
        for (OBusyLevel invalidStatus : values()) {
            if (invalidStatus.getValue() == type) {
                return invalidStatus;
            }
        }
        return OBusyLevel.others;
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
