package com.linjia.web.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderProductModel {
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group._send_date
     *
     * @mbggenerated
     */
    private Date sendDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group._send_hour
     *
     * @mbggenerated
     */
    private Integer sendHour;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group._remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group._send_price
     *
     * @mbggenerated
     */
    private BigDecimal sendPrice;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group.coupon_type
     *
     * @mbggenerated
     */
    private Long userCardCouponId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group.is_full_subtract
     *
     * @mbggenerated
     */
    private Boolean isFullSubtract;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group.full_subtract_price
     *
     * @mbggenerated
     */
    private BigDecimal cardCouponPrice;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group.full_subtract_price
     *
     * @mbggenerated
     */
    private BigDecimal fullSubtractPrice;
    

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group.send_type
     *
     * @mbggenerated
     */
    private Integer sendType;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_group.real_price
     *
     * @mbggenerated
     */
    private BigDecimal realPrice;
    
    /**
     * 商品数量
     * @mbggenerated
     */
    private Integer productNum = 0;

    /**
     * 商品金额
     * @mbggenerated
     */
    private BigDecimal productPrice;

    /**
     * 合计
     * @mbggenerated
     */
    private BigDecimal price;
    
    /**
     * 商品列表
     *
     * @mbggenerated
     */
    private List<ShoppingCar> shoppingCarList;


	public Date getSendDate() {
		return sendDate;
	}



	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}



	public Integer getSendHour() {
		return sendHour;
	}



	public void setSendHour(Integer sendHour) {
		this.sendHour = sendHour;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public BigDecimal getSendPrice() {
		return sendPrice;
	}



	public void setSendPrice(BigDecimal sendPrice) {
		this.sendPrice = sendPrice;
	}



	public Integer getProductNum() {
		return productNum;
	}



	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}



	public BigDecimal getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public List<ShoppingCar> getShoppingCarList() {
		return shoppingCarList;
	}



	public void setShoppingCarList(List<ShoppingCar> shoppingCarList) {
		this.shoppingCarList = shoppingCarList;
	}



	public Long getUserCardCouponId() {
		return userCardCouponId;
	}



	public void setUserCardCouponId(Long userCardCouponId) {
		this.userCardCouponId = userCardCouponId;
	}



	public Boolean getIsFullSubtract() {
		return isFullSubtract;
	}



	public void setIsFullSubtract(Boolean isFullSubtract) {
		this.isFullSubtract = isFullSubtract;
	}



	public BigDecimal getCardCouponPrice() {
		return cardCouponPrice;
	}



	public void setCardCouponPrice(BigDecimal cardCouponPrice) {
		this.cardCouponPrice = cardCouponPrice;
	}



	public BigDecimal getFullSubtractPrice() {
		return fullSubtractPrice;
	}



	public void setFullSubtractPrice(BigDecimal fullSubtractPrice) {
		this.fullSubtractPrice = fullSubtractPrice;
	}



	public Integer getSendType() {
		return sendType;
	}



	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}



	public BigDecimal getRealPrice() {
		return realPrice;
	}



	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}



	public OrderProductModel() {
	}

    
    
}