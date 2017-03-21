package com.linjia.web.thirdService.eleme.interfaces.enumeration.order;

/**
 * 订单无效类型
 */
public enum OInvalidateType {

    /**
     * 其他原因
     */
    others(0, "others", "其他原因"),

    /**
     * 用户信息不符
     */
    fakeOrder(1, "fakeOrder", "用户信息不符"),

    /**
     * 联系不上用户
     */
    contactUserFailed(4, "contactUserFailed", "联系不上用户"),

    /**
     * 商品已经售完
     */
    foodSoldOut(5, "foodSoldOut", "商品已经售完"),

    /**
     * 商家已经打烊
     */
    restaurantClosed(6, "restaurantClosed", "商家已经打烊"),

    /**
     * 超出配送范围
     */
    distanceTooFar(7, "distanceTooFar", "超出配送范围"),

    /**
     * 商家现在太忙
     */
    restaurantTooBusy(8, "restaurantTooBusy", "商家现在太忙"),

    /**
     * 用户申请取消
     */
    forceRejectOrder(9, "forceRejectOrder", "用户申请取消"),

    /**
     * 配送出现问题
     */
    deliveryFault(11, "deliveryFault", "配送出现问题"),

    /**
     * 不满足起送要求
     */
    notSatisfiedDeliveryRequirement(17, "notSatisfiedDeliveryRequirement", "不满足起送要求");

    private int value;
    private String name;
    private String description;

    private OInvalidateType(int value, String name, String description) {
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public static OInvalidateType findValue(int type) {
        for (OInvalidateType invalidStatus : values()) {
            if (invalidStatus.getValue() == type) {
                return invalidStatus;
            }
        }
        return OInvalidateType.others;
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
