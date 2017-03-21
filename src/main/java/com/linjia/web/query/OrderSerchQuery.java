package com.linjia.web.query;

import com.linjia.base.query.Query;

public class OrderSerchQuery extends Query{

	//收货人
	private String receive_name;
	
	//订单号
	private Long order_id;
	
	//手机号
	private String receive_phone;
	
	//门店号
	private String mall_code;
	
	//门店名称
	private String mall_name;
	
	//订单类型(1,普通订单;2，预约订单;3，团购订单;4,积分订单)
	private Integer orderType;
	
	//邻家支付状态
	private Integer ljPpay_status;
	
	//美团支付状态
	private Integer mtPay_status;
	
	//百度支付状态
	private Integer bdPay_status;
	
	//邻家订单状态
	private Integer ljOrder_status;
		
	//美团订单状态
	private Integer mtOrder_status;
		
	//百度订单状态
	private Integer bdOrder_status;
	
	//配送方式(0,送货上门；1，上门自提)
	private Integer sent_type;
	
	//退款状态(0,未退款；1，已退款)
	private Integer refund_status;
	
	//下单开始时间、
	private String order_begin;
	
	//下单结束时间
	private String order_end;
	
	//组团状态(1,组团中；2，组团失败；3，已成团)
	private Integer group_status;
	
	//退款单号
	private Long refund_orderId;
	
	//退款方式(1,人工；2，自动)
	private Integer refund_type;

	public String getReceive_name() {
		return receive_name;
	}

	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getReceive_phone() {
		return receive_phone;
	}

	public void setReceive_phone(String receive_phone) {
		this.receive_phone = receive_phone;
	}

	public String getMall_code() {
		return mall_code;
	}

	public void setMall_code(String mall_code) {
		this.mall_code = mall_code;
	}

	public String getMall_name() {
		return mall_name;
	}

	public void setMall_name(String mall_name) {
		this.mall_name = mall_name;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getLjPpay_status() {
		return ljPpay_status;
	}

	public void setLjPpay_status(Integer ljPpay_status) {
		this.ljPpay_status = ljPpay_status;
	}

	public Integer getMtPay_status() {
		return mtPay_status;
	}

	public void setMtPay_status(Integer mtPay_status) {
		this.mtPay_status = mtPay_status;
	}

	public Integer getBdPay_status() {
		return bdPay_status;
	}

	public void setBdPay_status(Integer bdPay_status) {
		this.bdPay_status = bdPay_status;
	}

	public Integer getLjOrder_status() {
		return ljOrder_status;
	}

	public void setLjOrder_status(Integer ljOrder_status) {
		this.ljOrder_status = ljOrder_status;
	}

	public Integer getMtOrder_status() {
		return mtOrder_status;
	}

	public void setMtOrder_status(Integer mtOrder_status) {
		this.mtOrder_status = mtOrder_status;
	}

	public Integer getBdOrder_status() {
		return bdOrder_status;
	}

	public void setBdOrder_status(Integer bdOrder_status) {
		this.bdOrder_status = bdOrder_status;
	}

	public Integer getSent_type() {
		return sent_type;
	}

	public void setSent_type(Integer sent_type) {
		this.sent_type = sent_type;
	}

	public Integer getRefund_status() {
		return refund_status;
	}

	public void setRefund_status(Integer refund_status) {
		this.refund_status = refund_status;
	}

	public String getOrder_begin() {
		return order_begin;
	}

	public void setOrder_begin(String order_begin) {
		this.order_begin = order_begin;
	}

	public String getOrder_end() {
		return order_end;
	}

	public void setOrder_end(String order_end) {
		this.order_end = order_end;
	}

	public Integer getGroup_status() {
		return group_status;
	}

	public void setGroup_status(Integer group_status) {
		this.group_status = group_status;
	}

	public Long getRefund_orderId() {
		return refund_orderId;
	}

	public void setRefund_orderId(Long refund_orderId) {
		this.refund_orderId = refund_orderId;
	}

	public Integer getRefund_type() {
		return refund_type;
	}

	public void setRefund_type(Integer refund_type) {
		this.refund_type = refund_type;
	}
	
}
