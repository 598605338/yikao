package com.linjia.web.thirdService.meituan.model;

public class MtPoiReceiveDetail {
	
	//美团承担明细
	private MtActOrderChargeByMt actOrderChargeByMt;
	//(商家承担明细)
	private MtActOrderChargeByPoi actOrderChargeByPoi;
	//(菜品分成 (分)
	private Integer	foodShareFeeChargeByPoi;
	//(配送费 (分)
	private Integer	logisticsFee; 
	//(在线支付款 (分)
	private Integer	onlinePayment;
	//(商家应收款（分）)
	private Integer	wmPoiReceiveCent;
	public MtActOrderChargeByMt getActOrderChargeByMt() {
		return actOrderChargeByMt;
	}
	public void setActOrderChargeByMt(MtActOrderChargeByMt actOrderChargeByMt) {
		this.actOrderChargeByMt = actOrderChargeByMt;
	}
	public MtActOrderChargeByPoi getActOrderChargeByPoi() {
		return actOrderChargeByPoi;
	}
	public void setActOrderChargeByPoi(MtActOrderChargeByPoi actOrderChargeByPoi) {
		this.actOrderChargeByPoi = actOrderChargeByPoi;
	}
	public Integer getFoodShareFeeChargeByPoi() {
		return foodShareFeeChargeByPoi;
	}
	public void setFoodShareFeeChargeByPoi(Integer foodShareFeeChargeByPoi) {
		this.foodShareFeeChargeByPoi = foodShareFeeChargeByPoi;
	}
	public Integer getLogisticsFee() {
		return logisticsFee;
	}
	public void setLogisticsFee(Integer logisticsFee) {
		this.logisticsFee = logisticsFee;
	}
	public Integer getOnlinePayment() {
		return onlinePayment;
	}
	public void setOnlinePayment(Integer onlinePayment) {
		this.onlinePayment = onlinePayment;
	}
	public Integer getWmPoiReceiveCent() {
		return wmPoiReceiveCent;
	}
	public void setWmPoiReceiveCent(Integer wmPoiReceiveCent) {
		this.wmPoiReceiveCent = wmPoiReceiveCent;
	}

}
