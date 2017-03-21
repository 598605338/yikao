package com.linjia.web.thirdService.baidu.model;

import java.util.Date;

public class Order {
	
	private long id;
	
    //订单id
	private String order_id;
	//是否立即送餐，1 是 2 否
	private Integer send_immediately;
	//期望送达时间
	private String send_time;
	//配送费，单位：分
	private Integer send_fee;
	//餐盒费，单位：分
	private Integer package_fee;
	//优惠总金额，单位：分
	private Integer discount_fee;
	//订单总价，单位：分
	private Integer total_fee;
	//商户实收总价，单位：分
	private Integer shop_fee;
	//用户实付总价，单位：分
	private Integer user_fee;
	//支付类型，1 下线 2 在线
	private String pay_type;
	//支付状态
	private Integer pay_status;
	//是否需要发票 1:是 2:否
	private Integer need_invoice;
	//发票抬头
	private String invoice_title;
	//订单备注
	private String remark;
	//物流 1 百度 2 自配送
	private Integer delivery_party;
	//订单创建时间
	private Integer create_time;
	//接单时间
	private Date recive_time;
	
	//自加参数*************************************
	
	//订单取消时间
	private Integer cancel_time;
	//订单状态
	private Integer status;
	//取消类型
	private Integer type;
	//取消原因
	private String reason;
	
	private String send_price;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Integer getSend_immediately() {
		return send_immediately;
	}
	public void setSend_immediately(Integer send_immediately) {
		this.send_immediately = send_immediately;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public Integer getPackage_fee() {
		return package_fee;
	}
	public void setPackage_fee(Integer package_fee) {
		this.package_fee = package_fee;
	}
	public Integer getDiscount_fee() {
		return discount_fee;
	}
	public void setDiscount_fee(Integer discount_fee) {
		this.discount_fee = discount_fee;
	}
	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
	public Integer getShop_fee() {
		return shop_fee;
	}
	public void setShop_fee(Integer shop_fee) {
		this.shop_fee = shop_fee;
	}
	public Integer getUser_fee() {
		return user_fee;
	}
	public void setUser_fee(Integer user_fee) {
		this.user_fee = user_fee;
	}
	public Integer getPay_status() {
		return pay_status;
	}
	public void setPay_status(Integer pay_status) {
		this.pay_status = pay_status;
	}
	public Integer getNeed_invoice() {
		return need_invoice;
	}
	public void setNeed_invoice(Integer need_invoice) {
		this.need_invoice = need_invoice;
	}
	public String getInvoice_title() {
		return invoice_title;
	}
	public void setInvoice_title(String invoice_title) {
		this.invoice_title = invoice_title;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Integer getDelivery_party() {
		return delivery_party;
	}
	public void setDelivery_party(Integer delivery_party) {
		this.delivery_party = delivery_party;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public Integer getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Integer create_time) {
		this.create_time = create_time;
	}
	public Integer getCancel_time() {
		return cancel_time;
	}
	public void setCancel_time(Integer cancel_time) {
		this.cancel_time = cancel_time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getSend_fee() {
		return send_fee;
	}
	public void setSend_fee(Integer send_fee) {
		this.send_fee = send_fee;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getRecive_time() {
		return recive_time;
	}
	public void setRecive_time(Date recive_time) {
		this.recive_time = recive_time;
	}
	public String getSend_price() {
		return send_price;
	}
	public void setSend_price(String send_price) {
		this.send_price = send_price;
	}
	
}
