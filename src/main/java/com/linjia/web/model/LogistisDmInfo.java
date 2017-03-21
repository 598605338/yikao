package com.linjia.web.model;

import java.util.Date;

public class LogistisDmInfo {

	//订单号
	private String order_id;
	
	//物流状态名称
	private String statusName;
	
	//取餐时间
	private String pickup_time;
	private Date pickup_date;
	//到店时间
	private String atshop_time;
	private Date atshop_date;
	//送餐时间
	private String delivery_time;
	private Date delivery_date;
	//完成时间
	private String finished_time;
	private Date finished_date;
	//接单时间
	private String recive_time;
	private Date recive_date;
	//送达时间
	private String send_time;
	private Date send_date;
	private String cancel_time;
	private Date cancel_date;
	//物流名称
	private String logisticsName;
	
	//配送人员名称
	private String dmName;
	
	//配送人员电话
	private String dmPhone;
	
	private Integer status;
	
	private String statusStr;
	
	private String logisMainStatus;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getRecive_time() {
		return recive_time;
	}

	public void setRecive_time(String recive_time) {
		this.recive_time = recive_time;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public String getLogisticsName() {
		return logisticsName;
	}

	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}

	public String getDmName() {
		return dmName;
	}

	public void setDmName(String dmName) {
		this.dmName = dmName;
	}

	public String getDmPhone() {
		return dmPhone;
	}

	public void setDmPhone(String dmPhone) {
		this.dmPhone = dmPhone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPickup_time() {
		return pickup_time;
	}

	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
	}

	public String getAtshop_time() {
		return atshop_time;
	}

	public void setAtshop_time(String atshop_time) {
		this.atshop_time = atshop_time;
	}

	public String getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}

	public String getFinished_time() {
		return finished_time;
	}

	public void setFinished_time(String finished_time) {
		this.finished_time = finished_time;
	}

	public String getCancel_time() {
		return cancel_time;
	}

	public void setCancel_time(String cancel_time) {
		this.cancel_time = cancel_time;
	}

	public Date getPickup_date() {
		return pickup_date;
	}

	public void setPickup_date(Date pickup_date) {
		this.pickup_date = pickup_date;
	}

	public Date getAtshop_date() {
		return atshop_date;
	}

	public void setAtshop_date(Date atshop_date) {
		this.atshop_date = atshop_date;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public Date getFinished_date() {
		return finished_date;
	}

	public void setFinished_date(Date finished_date) {
		this.finished_date = finished_date;
	}

	public Date getRecive_date() {
		return recive_date;
	}

	public void setRecive_date(Date recive_date) {
		this.recive_date = recive_date;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	public Date getCancel_date() {
		return cancel_date;
	}

	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getLogisMainStatus() {
		return logisMainStatus;
	}

	public void setLogisMainStatus(String logisMainStatus) {
		this.logisMainStatus = logisMainStatus;
	}
	
	
}
