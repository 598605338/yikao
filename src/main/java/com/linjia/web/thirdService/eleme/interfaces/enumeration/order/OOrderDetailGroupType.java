package com.linjia.web.thirdService.eleme.interfaces.enumeration.order;

/**
 * 订单详情分组类型
 */
public enum OOrderDetailGroupType {

    /**
     * 正常的菜品
     */
    normal("normal", "正常的菜品"),

    /**
     * 配送费等
     */
    extra("extra", "配送费等"),

    /**
     * 折扣,如红包,满减等
     */
    discount("discount", "折扣,如红包,满减等");

    private String name;
    private String description;

    OOrderDetailGroupType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static OOrderDetailGroupType getByName(String name) {
        for (OOrderDetailGroupType oOrderDetailGroupType : OOrderDetailGroupType.values()) {
            if (oOrderDetailGroupType.getName().equals(name))
                return oOrderDetailGroupType;
        }
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }
}
