package com.linjia.web.model;


public class SelectCustSendCardCoupon {
	
	/** userId* */
	private String userId;

	/** 会员卡号* */
	private String userCardno;
	
	/** 会员名* */
	private String custname;

	/** 卡券Id* */
	private Integer cardCouponId;
	
	/** 本次发放数量* */
	private Integer willSendNum;
	
	/** 已发放数量* */
	private Integer alreadySendNum;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCardno() {
		return userCardno;
	}

	public void setUserCardno(String userCardno) {
		this.userCardno = userCardno;
	}

	public Integer getCardCouponId() {
		return cardCouponId;
	}

	public void setCardCouponId(Integer cardCouponId) {
		this.cardCouponId = cardCouponId;
	}

	public Integer getWillSendNum() {
		return willSendNum;
	}

	public void setWillSendNum(Integer willSendNum) {
		this.willSendNum = willSendNum;
	}

	public Integer getAlreadySendNum() {
		return alreadySendNum;
	}

	public void setAlreadySendNum(Integer alreadySendNum) {
		this.alreadySendNum = alreadySendNum;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	
}