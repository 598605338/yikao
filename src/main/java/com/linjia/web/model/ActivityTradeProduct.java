package com.linjia.web.model;

import java.util.Date;

public class ActivityTradeProduct {

	private Integer id;
	private Integer product_id;
	private String p_name;
	private String p_code;
	private Float p_price;
	private Float p_trade_price;
	private Integer quantity;
	private Integer activity_id;
	private Date create_time;
	private Date update_time;
	private Integer p_send_type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public Float getP_price() {
		return p_price;
	}
	public void setP_price(Float p_price) {
		this.p_price = p_price;
	}
	public Float getP_trade_price() {
		return p_trade_price;
	}
	public void setP_trade_price(Float p_trade_price) {
		this.p_trade_price = p_trade_price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Integer getP_send_type() {
		return p_send_type;
	}
	public void setP_send_type(Integer p_send_type) {
		this.p_send_type = p_send_type;
	}
	
}
