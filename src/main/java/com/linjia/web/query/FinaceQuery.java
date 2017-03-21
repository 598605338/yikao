package com.linjia.web.query;

import com.linjia.base.query.Query;

public class FinaceQuery extends Query{

	//开始时间
	private String beginDate;
	
	//结束时间
	private String endDate;
	
	//状态
	private Integer status;
	
	//多个状态(多个状态以，隔开)
	private String statusList;

	//门店code
	private String mall_code;
	
	//门店名称
	private String mall_name;
	
	//开始价位
	private Integer beginPrice;
	
	//结束价位
	private Integer endPrice;
	
	//商品条码
	private String p_code;
	
	//商品名称
	private String p_name;
	
	//商品大类代码
	private Integer large_catagory_id;
	
	//商品大类名称
	private String large_catagory_name;
	
	//商品中类代码
	private Integer middle_catagory_id;
	
	//商品中类名称
	private String middle_catagory_name;
	
	//订单号
	private Long order_id;
	
	//门店接单时长开始时间
	private Integer beigin_recive_time;
	
	//门店接单时长结束时间
	private Integer end_recive_time;
	
	//门店配送时长开始时间
	private Integer beigin_send_time;
		
	//门店配送时长结束时间
	private Integer end_send_time;
	
	//达达接单时长开始时间
	private Integer beigin_dadaRecive_time;
		
	//达达接单时长结束时间
	private Integer end_dadaRecive_time;
		
	//达达配送时长开始时间
	private Integer beigin_dadaSend_time;
			
	//达达配送时长结束时间
	private Integer end_dadaSend_time;
	
	//支付到完成时间
	private Integer payToFinishTime;
	
	//支付取消时间差
	private Integer payToCancelTime;
	
	//下单时间
	private String orderCreateTime;

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusList() {
		return statusList;
	}

	public void setStatusList(String statusList) {
		this.statusList = statusList;
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

	public Integer getBeginPrice() {
		return beginPrice;
	}

	public void setBeginPrice(Integer beginPrice) {
		this.beginPrice = beginPrice;
	}

	public Integer getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Integer endPrice) {
		this.endPrice = endPrice;
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

	public Integer getLarge_catagory_id() {
		return large_catagory_id;
	}

	public void setLarge_catagory_id(Integer large_catagory_id) {
		this.large_catagory_id = large_catagory_id;
	}

	public Integer getMiddle_catagory_id() {
		return middle_catagory_id;
	}

	public void setMiddle_catagory_id(Integer middle_catagory_id) {
		this.middle_catagory_id = middle_catagory_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Integer getBeigin_recive_time() {
		return beigin_recive_time;
	}

	public void setBeigin_recive_time(Integer beigin_recive_time) {
		this.beigin_recive_time = beigin_recive_time;
	}

	public Integer getEnd_recive_time() {
		return end_recive_time;
	}

	public void setEnd_recive_time(Integer end_recive_time) {
		this.end_recive_time = end_recive_time;
	}

	public Integer getBeigin_send_time() {
		return beigin_send_time;
	}

	public void setBeigin_send_time(Integer beigin_send_time) {
		this.beigin_send_time = beigin_send_time;
	}

	public Integer getEnd_send_time() {
		return end_send_time;
	}

	public void setEnd_send_time(Integer end_send_time) {
		this.end_send_time = end_send_time;
	}

	public Integer getBeigin_dadaRecive_time() {
		return beigin_dadaRecive_time;
	}

	public void setBeigin_dadaRecive_time(Integer beigin_dadaRecive_time) {
		this.beigin_dadaRecive_time = beigin_dadaRecive_time;
	}

	public Integer getEnd_dadaRecive_time() {
		return end_dadaRecive_time;
	}

	public void setEnd_dadaRecive_time(Integer end_dadaRecive_time) {
		this.end_dadaRecive_time = end_dadaRecive_time;
	}

	public Integer getBeigin_dadaSend_time() {
		return beigin_dadaSend_time;
	}

	public void setBeigin_dadaSend_time(Integer beigin_dadaSend_time) {
		this.beigin_dadaSend_time = beigin_dadaSend_time;
	}

	public Integer getEnd_dadaSend_time() {
		return end_dadaSend_time;
	}

	public void setEnd_dadaSend_time(Integer end_dadaSend_time) {
		this.end_dadaSend_time = end_dadaSend_time;
	}

	public Integer getPayToFinishTime() {
		return payToFinishTime;
	}

	public void setPayToFinishTime(Integer payToFinishTime) {
		this.payToFinishTime = payToFinishTime;
	}

	public Integer getPayToCancelTime() {
		return payToCancelTime;
	}

	public void setPayToCancelTime(Integer payToCancelTime) {
		this.payToCancelTime = payToCancelTime;
	}

	public String getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(String orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public String getLarge_catagory_name() {
		return large_catagory_name;
	}

	public void setLarge_catagory_name(String large_catagory_name) {
		this.large_catagory_name = large_catagory_name;
	}

	public String getMiddle_catagory_name() {
		return middle_catagory_name;
	}

	public void setMiddle_catagory_name(String middle_catagory_name) {
		this.middle_catagory_name = middle_catagory_name;
	}
	
	
	
}
