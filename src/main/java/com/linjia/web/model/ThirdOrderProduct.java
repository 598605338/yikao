package com.linjia.web.model;

import java.math.BigDecimal;

public class ThirdOrderProduct {

	//id
	private Integer id;
	//订单id
	private Long orderId;
	//商品code
	private String pCode;
	//商品名称
	private String pName;
	//商品数量
	private Integer quantity;
	//商品项价格
	private BigDecimal itemPrice;
	//商品图片地址
	private String imagePath;
	//
	private String unit;
	//
	private Integer box_num;
	//
	private Integer box_price;
	//
	private Float food_discount;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getBox_price() {
		return box_price;
	}
	public void setBox_price(Integer box_price) {
		this.box_price = box_price;
	}
	public Float getFood_discount() {
		return food_discount;
	}
	public void setFood_discount(Float food_discount) {
		this.food_discount = food_discount;
	}
	public Integer getBox_num() {
		return box_num;
	}
	public void setBox_num(Integer box_num) {
		this.box_num = box_num;
	}
	
}
