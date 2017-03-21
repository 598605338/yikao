package com.linjia.web.model;

import java.util.Date;

public class Logistics {

	//id
	private Integer id;
	//订单id
	private String order_id;
	//订单状态
	private Integer order_status;
	//配送员id
	private Integer dm_id;
	//取消原因
	private String cancel_reason;
	//配送员姓名
	private String dm_name;
	//配送员电话
	private String dm_mobile;
	//更新时间
	private Long update_time;
	//接单时间时间
	private Long recieve_time;
	private Date recieve_date;
	//配送时间
	private Long send_time;
	private Date send_date;
	//完成时间
	private Long finish_time;
	private Date finish_date;
	//时间类型(达达)
	private Integer action_type;
	//取消原因id
	private Integer reason_id;
	//店铺id
	private String mall_code;
	//订单来源
	private String order_source;
	//创建时间
	private Date create_time;
	//
	private String client_id;
	private String signature;
	//达达物流添加字段
	private Integer fee;
	private Double distance;
	private Integer orderid;
	private String status;
	private String 	finishCode;
	//百度物流添加字段
	private String message;
	private Integer error_no;
	private BdLogisResult result;
	private Integer responseCode;
	private String errorMessage;
	private Integer errorCode;
	private Integer logis_type;
	
	private String outer_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public Integer getDm_id() {
		return dm_id;
	}
	public void setDm_id(Integer dm_id) {
		this.dm_id = dm_id;
	}
	public String getCancel_reason() {
		return cancel_reason;
	}
	public void setCancel_reason(String cancel_reason) {
		this.cancel_reason = cancel_reason;
	}
	public String getDm_name() {
		return dm_name;
	}
	public void setDm_name(String dm_name) {
		this.dm_name = dm_name;
	}
	public String getDm_mobile() {
		return dm_mobile;
	}
	public void setDm_mobile(String dm_mobile) {
		this.dm_mobile = dm_mobile;
	}
	public Long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	public Integer getAction_type() {
		return action_type;
	}
	public void setAction_type(Integer action_type) {
		this.action_type = action_type;
	}
	public Integer getReason_id() {
		return reason_id;
	}
	public void setReason_id(Integer reason_id) {
		this.reason_id = reason_id;
	}
	public String getMall_code() {
		return mall_code;
	}
	public void setMall_code(String mall_code) {
		this.mall_code = mall_code;
	}
	public String getOrder_source() {
		return order_source;
	}
	public void setOrder_source(String order_source) {
		this.order_source = order_source;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFinishCode() {
		return finishCode;
	}
	public void setFinishCode(String finishCode) {
		this.finishCode = finishCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getError_no() {
		return error_no;
	}
	public void setError_no(Integer error_no) {
		this.error_no = error_no;
	}
	public BdLogisResult getResult() {
		return result;
	}
	public void setResult(BdLogisResult result) {
		this.result = result;
	}
	public String getOuter_id() {
		return outer_id;
	}
	public void setOuter_id(String outer_id) {
		this.outer_id = outer_id;
	}
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public Integer getLogis_type() {
		return logis_type;
	}
	public void setLogis_type(Integer logis_type) {
		this.logis_type = logis_type;
	}
	public Long getRecieve_time() {
		return recieve_time;
	}
	public void setRecieve_time(Long recieve_time) {
		this.recieve_time = recieve_time;
	}
	public Long getSend_time() {
		return send_time;
	}
	public void setSend_time(Long send_time) {
		this.send_time = send_time;
	}
	public Long getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(Long finish_time) {
		this.finish_time = finish_time;
	}
	public Date getRecieve_date() {
		return recieve_date;
	}
	public void setRecieve_date(Date recieve_date) {
		this.recieve_date = recieve_date;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public Date getFinish_date() {
		return finish_date;
	}
	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}
	
	
}
