package com.linjia.web.thirdService.eleme.interfaces.enumeration.item;

/**
 * 更新商品属性
 */
public enum OItemUpdateProperty {

    /**
     * String 商品名称|必选|"白切鸡"
     */
    name("商品名称"),

    /**
     * String 商品描述|可选|"香脆可口，外焦里嫩"
     */
    description("商品描述"),

    /**
     * String 图片imageHash|可选|"3077080f760e7bf0fc985e23dd3e36e2"
     */
    imageHash("图片imageHash"),

    /**
     * String 标签属性集合|可选|"{"isFeatured":0,"isGum":0,"isNew":1,"isSpicy":1}"
     */
    labels("标签属性集合"),

    /**
     * String 规格|必选|"[{"maxStock":100,"name":"大份","onShelf":1,"packingFee":1.0,"price":19.9,"stock":0},{"maxStock":100,"name":"中分","onShelf":1,"packingFee":1.0,"price":19.9,"stock":0}]"
     */
    specs("规格");


    private String value;

    private OItemUpdateProperty(String value) {
        this.value = value;
    }
}
