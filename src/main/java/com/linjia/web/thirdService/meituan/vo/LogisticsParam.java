package com.linjia.web.thirdService.meituan.vo;

import java.math.BigDecimal;

/**
 * Created by zhangzhidong on 15/10/29.
 */
public class LogisticsParam {
	
    private String result;
    private Long order_id;
    // "自建", 配送方名称
    private Integer logistics_status;
    //配送单下单时间
    private String logistics_name;
    //配送单下单时间
    private Long send_time;
    //配送单确认时间
    private Long confirm_time;
    //配送单取消时间
    private Long cancel_time;
    //骑手取单时间
    private Long fetch_time;
    //订单完成时间
    private Long completed_time;
    //骑手姓名
    private String dispatcher_name;
    //骑手电话
    private String dispatcher_mobile;
    //商家承担运费
    private BigDecimal poi_shipping_fee;
    //商家承担运费的具体说明
    private String shipping_tips;
    //商家给定的小费金额
    private BigDecimal tip_amount;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Integer getLogistics_status() {
		return logistics_status;
	}
	public void setLogistics_status(Integer logistics_status) {
		this.logistics_status = logistics_status;
	}
	public String getLogistics_name() {
		return logistics_name;
	}
	public void setLogistics_name(String logistics_name) {
		this.logistics_name = logistics_name;
	}
	public Long getSend_time() {
		return send_time;
	}
	public void setSend_time(Long send_time) {
		this.send_time = send_time;
	}
	public Long getConfirm_time() {
		return confirm_time;
	}
	public void setConfirm_time(Long confirm_time) {
		this.confirm_time = confirm_time;
	}
	public Long getCancel_time() {
		return cancel_time;
	}
	public void setCancel_time(Long cancel_time) {
		this.cancel_time = cancel_time;
	}
	public Long getFetch_time() {
		return fetch_time;
	}
	public void setFetch_time(Long fetch_time) {
		this.fetch_time = fetch_time;
	}
	public Long getCompleted_time() {
		return completed_time;
	}
	public void setCompleted_time(Long completed_time) {
		this.completed_time = completed_time;
	}
	public String getDispatcher_name() {
		return dispatcher_name;
	}
	public void setDispatcher_name(String dispatcher_name) {
		this.dispatcher_name = dispatcher_name;
	}
	public String getDispatcher_mobile() {
		return dispatcher_mobile;
	}
	public void setDispatcher_mobile(String dispatcher_mobile) {
		this.dispatcher_mobile = dispatcher_mobile;
	}
	public BigDecimal getPoi_shipping_fee() {
		return poi_shipping_fee;
	}
	public void setPoi_shipping_fee(BigDecimal poi_shipping_fee) {
		this.poi_shipping_fee = poi_shipping_fee;
	}
	public String getShipping_tips() {
		return shipping_tips;
	}
	public void setShipping_tips(String shipping_tips) {
		this.shipping_tips = shipping_tips;
	}
	public BigDecimal getTip_amount() {
		return tip_amount;
	}
	public void setTip_amount(BigDecimal tip_amount) {
		this.tip_amount = tip_amount;
	}
    
   
}
