package com.linjia.web.thirdService.eleme.interfaces.entity.order;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 篮子商品
 */
public class OGoodsItem {

    /**
     * 商品Id||27970000058
     */
    private long id;

    /**
     * 规格Id||2543
     */
    private Long skuId;

    /**
     * 商品名称||"奶茶"
     */
    private String name = "";

    /**
     * 商品分类Id||26940000135
     */
    private long categoryId = 0;

    /**
     * 商品单价||9.0
     */
    private double price = 0.0;

    /**
     * 商品数量||2
     */
    private int quantity = 0;

    /**
     * 总价||18.0
     */
    private double total = 0.0;
    
    @JsonIgnore
    private String orderId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
    
    
}
