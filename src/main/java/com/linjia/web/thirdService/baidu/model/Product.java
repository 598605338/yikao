package com.linjia.web.thirdService.baidu.model;

public class Product {

	private String product_id;
	
	private String product_name;
	
	private Integer product_amount;
	
	private Integer product_price;
	
	private Integer product_fee;
	
	private Integer  package_price;
	
	private Integer package_amount;
	
	private Integer package_fee;
	
	private Integer total_fee;
	
	private String upc;
	
	private Long orderId;
	
	private String bdProduct_id;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getProduct_amount() {
		return product_amount;
	}

	public void setProduct_amount(Integer product_amount) {
		this.product_amount = product_amount;
	}

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}

	public Integer getProduct_fee() {
		return product_fee;
	}

	public void setProduct_fee(Integer product_fee) {
		this.product_fee = product_fee;
	}

	public Integer getPackage_price() {
		return package_price;
	}

	public void setPackage_price(Integer package_price) {
		this.package_price = package_price;
	}

	public Integer getPackage_amount() {
		return package_amount;
	}

	public void setPackage_amount(Integer package_amount) {
		this.package_amount = package_amount;
	}

	public Integer getPackage_fee() {
		return package_fee;
	}

	public void setPackage_fee(Integer package_fee) {
		this.package_fee = package_fee;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getBdProduct_id() {
		return bdProduct_id;
	}

	public void setBdProduct_id(String bdProduct_id) {
		this.bdProduct_id = bdProduct_id;
	}
	
}
