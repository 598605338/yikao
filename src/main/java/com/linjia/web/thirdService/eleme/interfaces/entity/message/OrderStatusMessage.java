package com.linjia.web.thirdService.eleme.interfaces.entity.message;

public class OrderStatusMessage {

	//订单号
	private String orderId;
	
	//店铺id
	private Long shopId;
	
	//运单主状态，参阅运单主状态枚举定义
	private String state;
	
	//运单子状态，参阅运单子状态枚举定义
	private String subState;
	
	//配送员姓名
	private String name;
	
	//配送员联系方式
	private String phone;
	
	//状态变更的时间戳，单位毫秒
	private Long updateAt;
	
	//备注
	private String	remark;
	
	//催单id
	private Long remindId;
	
	//发起催单的用户id
	private Long userId;
	
	//退单状态
	private String refundStatus;
	
	//用户发起催单的时间戳，单位秒;消息发送时间戳，单位秒
	private Long updateTime;
	
	//退单操作原因描述
	private String reason;
	
	//1,下单用户;2,饿了么系统;3,饿了么商户;4,饿了么客服;5,饿了么开发平台系统;6,饿了么短信系统;7,饿了么无线打印机系统;8,饿了么风控系统
	private Integer role;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSubState() {
		return subState;
	}

	public void setSubState(String subState) {
		this.subState = subState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getRemindId() {
		return remindId;
	}

	public void setRemindId(Long remindId) {
		this.remindId = remindId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	
}
