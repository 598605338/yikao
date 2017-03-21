package com.linjia.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class ActivityProduct {

	private Integer id;
	private Integer activity_id;
	private Integer product_id;
	private String p_code;
	private String p_name;
	private BigDecimal p_price;
	private Integer p_send_type;
	private Date create_time;
	private Date update_time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public BigDecimal getP_price() {
		return p_price;
	}
	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
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
