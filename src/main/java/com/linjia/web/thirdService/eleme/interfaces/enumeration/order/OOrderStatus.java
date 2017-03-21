package com.linjia.web.thirdService.eleme.interfaces.enumeration.order;

/**
 * 订单状态
 */
public enum OOrderStatus {

    /**
     * 未生效订单
     */
    pending("pending", "未生效订单"),

    /**
     * 未处理订单
     */
    unprocessed("unprocessed", "未处理订单"),

    /**
     * 退单处理中
     */
    refunding("refunding", "退单处理中"),

    /**
     * 已处理的有效订单
     */
    valid("valid", "已处理的有效订单"),

    /**
     * 无效订单
     */
    invalid("invalid", "无效订单"),

    /**
     * 已完成订单
     */
    settled("settled", "已完成订单");

    private String name;
    private String description;

    OOrderStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static OOrderStatus getByName(String name) {
        for (OOrderStatus oOrderStatus : OOrderStatus.values()) {
            if (oOrderStatus.getName().equals(name))
                return oOrderStatus;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
