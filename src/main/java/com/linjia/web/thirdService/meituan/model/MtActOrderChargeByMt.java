package com.linjia.web.thirdService.meituan.model;

public class MtActOrderChargeByMt {

	//"美团配送减3.0元" (备注), 
	private String	comment;
	//"活动款" (明细费用类型描述)
	private String  feeTypeDesc;
	//明细费用类型Id
	private Integer	feeTypeId;
	//明细金额（分）
	private Integer	moneyCent; 
		
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFeeTypeDesc() {
		return feeTypeDesc;
	}
	public void setFeeTypeDesc(String feeTypeDesc) {
		this.feeTypeDesc = feeTypeDesc;
	}
	public Integer getFeeTypeId() {
		return feeTypeId;
	}
	public void setFeeTypeId(Integer feeTypeId) {
		this.feeTypeId = feeTypeId;
	}
	public Integer getMoneyCent() {
		return moneyCent;
	}
	public void setMoneyCent(Integer moneyCent) {
		this.moneyCent = moneyCent;
	}
}
