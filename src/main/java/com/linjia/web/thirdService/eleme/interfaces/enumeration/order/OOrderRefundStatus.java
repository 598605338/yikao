package com.linjia.web.thirdService.eleme.interfaces.enumeration.order;

/**
 * 退单状态
 */
public enum OOrderRefundStatus {

    /**
     * 未申请退单
     */
    noRefund("noRefund", "未申请退单"),

    /**
     * 用户申请退单
     */
    applied("applied", "用户申请退单"),

    /**
     * 店铺拒绝退单
     */
    rejected("rejected", "餐厅拒绝退单"),

    /**
     * 客服仲裁中
     */
    arbitrating("arbitrating", "客服仲裁中"),

    /**
     * 退单失败
     */
    failed("failed", "退单失败"),

    /**
     * 退单成功
     */
    successful("successful", "退单成功");

    private String name;
    private String description;

    OOrderRefundStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static OOrderRefundStatus getByName(String name) {
        for (OOrderRefundStatus oOrderRefundStatus : OOrderRefundStatus.values()) {
            if (oOrderRefundStatus.getName().equals(name))
                return oOrderRefundStatus;
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
