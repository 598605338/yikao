package com.linjia.web.model;

import java.util.Date;


/** 
 * 运单状态消息
 * @author  lixinling: 
 * @date 2017年2月24日 下午4:49:45 
 * @version 1.0 
*/
public class JddjDeliveryStatus {

	/** 编号* */
	private Long id;
	/** 订单编号* */
	private String orderId;
	/** 操作时间，日期格式为"yyyy-MM-dd HH:mm:ss"* */
	private String deliveryStatusTime;
	/** 操作人账号* */
	private String deliveryManNo;
	/** 操作人名称* */
	private String deliveryManName;
	/** 操作人电话* */
	private String deliveryManPhone;
	/** 承运商编号* */
	private String deliveryCarrierNo;
	/** 承运商名称* */
	private String deliveryCarrierName;
	/** 配送状态(10 等待抢单;20 已抢单;25 取货失败;27 取货失败待审核;30 已收单;35 投递失败;40 已完成;50 取消;80撤销抢单)* */
	private String deliveryStatus;
	/** 取消原因* */
	private String remark;
	/** 失败类型(1 厂家直送拒收;2 厂家直送需退发货;3 厂家直送已退发货;10 等待商家确认收货;11 商家确认收货;GTF_1 门店商品缺货;GTF_5 门店未营业;
				GTF_6 等待时间长;GTF_7 恶意订单;DTF_1 配送距离超过5公里;DTF_2 联系收货人失败超过3次;DTF_3 客户要求改期配送;DTF_4 客户无理由拒收;
				DTF_5 质量问题;DTF_6 少件/发错货;DTF_7 订单超时客户拒收;DTF_8 其他;DTF_9 恶意刷单;DTF_10 客户更改配送地址)* */
	private String failType;
	/** 创建人* */
	private String createPin;
	/** 操作时间* */
	private String opTime;
	/** 接单时间* */
	private Date fetchTime;
	/** 配送时间* */
	private Date sendTime;
	/** 完成时间* */
	private Date finishedTime;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDeliveryStatusTime() {
		return deliveryStatusTime;
	}
	public void setDeliveryStatusTime(String deliveryStatusTime) {
		this.deliveryStatusTime = deliveryStatusTime;
	}
	public String getDeliveryManNo() {
		return deliveryManNo;
	}
	public void setDeliveryManNo(String deliveryManNo) {
		this.deliveryManNo = deliveryManNo;
	}
	public String getDeliveryManName() {
		return deliveryManName;
	}
	public void setDeliveryManName(String deliveryManName) {
		this.deliveryManName = deliveryManName;
	}
	public String getDeliveryManPhone() {
		return deliveryManPhone;
	}
	public void setDeliveryManPhone(String deliveryManPhone) {
		this.deliveryManPhone = deliveryManPhone;
	}
	public String getDeliveryCarrierNo() {
		return deliveryCarrierNo;
	}
	public void setDeliveryCarrierNo(String deliveryCarrierNo) {
		this.deliveryCarrierNo = deliveryCarrierNo;
	}
	public String getDeliveryCarrierName() {
		return deliveryCarrierName;
	}
	public void setDeliveryCarrierName(String deliveryCarrierName) {
		this.deliveryCarrierName = deliveryCarrierName;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getFailType() {
		return failType;
	}
	public void setFailType(String failType) {
		this.failType = failType;
	}
	public String getCreatePin() {
		return createPin;
	}
	public void setCreatePin(String createPin) {
		this.createPin = createPin;
	}
	public String getOpTime() {
		return opTime;
	}
	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFetchTime() {
		return fetchTime;
	}
	public void setFetchTime(Date fetchTime) {
		this.fetchTime = fetchTime;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getFinishedTime() {
		return finishedTime;
	}
	public void setFinishedTime(Date finishedTime) {
		this.finishedTime = finishedTime;
	}
	
	
}
