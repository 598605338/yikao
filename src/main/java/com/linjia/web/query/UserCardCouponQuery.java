package com.linjia.web.query;

import java.math.BigDecimal;
import java.util.Date;

import com.linjia.base.query.Query;

public class UserCardCouponQuery extends Query{
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.user_cardNo
     *
     * @mbggenerated
     */
    private String userCardno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.card_coupon_id
     *
     * @mbggenerated
     */
    private Long cardCouponId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.receive_time
     *
     * @mbggenerated
     */
    private Date receiveTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.use_start_time
     *
     * @mbggenerated
     */
    private Date useStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.use_end_time
     *
     * @mbggenerated
     */
    private Date useEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.use_status
     *
     * @mbggenerated
     */
    private Integer useStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.update_date
     *
     * @mbggenerated
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.use_time
     *
     * @mbggenerated
     */
    private Date useTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.mall_code
     *
     * @mbggenerated
     */
    private String mallCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.card_coupon_price
     *
     * @mbggenerated
     */
    private BigDecimal cardCouponPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.group_id
     *
     * @mbggenerated
     */
    private Long groupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.p_code
     *
     * @mbggenerated
     */
    private String pCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.p_name
     *
     * @mbggenerated
     */
    private String pName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_user_card_coupon.deleted
     *
     * @mbggenerated
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.id
     *
     * @return the value of b_user_card_coupon.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.id
     *
     * @param id the value for b_user_card_coupon.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.user_id
     *
     * @return the value of b_user_card_coupon.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.user_id
     *
     * @param userId the value for b_user_card_coupon.user_id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.user_cardNo
     *
     * @return the value of b_user_card_coupon.user_cardNo
     *
     * @mbggenerated
     */
    public String getUserCardno() {
        return userCardno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.user_cardNo
     *
     * @param userCardno the value for b_user_card_coupon.user_cardNo
     *
     * @mbggenerated
     */
    public void setUserCardno(String userCardno) {
        this.userCardno = userCardno == null ? null : userCardno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.card_coupon_id
     *
     * @return the value of b_user_card_coupon.card_coupon_id
     *
     * @mbggenerated
     */
    public Long getCardCouponId() {
        return cardCouponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.card_coupon_id
     *
     * @param cardCouponId the value for b_user_card_coupon.card_coupon_id
     *
     * @mbggenerated
     */
    public void setCardCouponId(Long cardCouponId) {
        this.cardCouponId = cardCouponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.receive_time
     *
     * @return the value of b_user_card_coupon.receive_time
     *
     * @mbggenerated
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.receive_time
     *
     * @param receiveTime the value for b_user_card_coupon.receive_time
     *
     * @mbggenerated
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.use_start_time
     *
     * @return the value of b_user_card_coupon.use_start_time
     *
     * @mbggenerated
     */
    public Date getUseStartTime() {
        return useStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.use_start_time
     *
     * @param useStartTime the value for b_user_card_coupon.use_start_time
     *
     * @mbggenerated
     */
    public void setUseStartTime(Date useStartTime) {
        this.useStartTime = useStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.use_end_time
     *
     * @return the value of b_user_card_coupon.use_end_time
     *
     * @mbggenerated
     */
    public Date getUseEndTime() {
        return useEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.use_end_time
     *
     * @param useEndTime the value for b_user_card_coupon.use_end_time
     *
     * @mbggenerated
     */
    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.use_status
     *
     * @return the value of b_user_card_coupon.use_status
     *
     * @mbggenerated
     */
    public Integer getUseStatus() {
        return useStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.use_status
     *
     * @param useStatus the value for b_user_card_coupon.use_status
     *
     * @mbggenerated
     */
    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.update_date
     *
     * @return the value of b_user_card_coupon.update_date
     *
     * @mbggenerated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.update_date
     *
     * @param updateDate the value for b_user_card_coupon.update_date
     *
     * @mbggenerated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.use_time
     *
     * @return the value of b_user_card_coupon.use_time
     *
     * @mbggenerated
     */
    public Date getUseTime() {
        return useTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.use_time
     *
     * @param useTime the value for b_user_card_coupon.use_time
     *
     * @mbggenerated
     */
    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.mall_code
     *
     * @return the value of b_user_card_coupon.mall_code
     *
     * @mbggenerated
     */
    public String getMallCode() {
        return mallCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.mall_code
     *
     * @param mallCode the value for b_user_card_coupon.mall_code
     *
     * @mbggenerated
     */
    public void setMallCode(String mallCode) {
        this.mallCode = mallCode == null ? null : mallCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.card_coupon_price
     *
     * @return the value of b_user_card_coupon.card_coupon_price
     *
     * @mbggenerated
     */
    public BigDecimal getCardCouponPrice() {
        return cardCouponPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.card_coupon_price
     *
     * @param cardCouponPrice the value for b_user_card_coupon.card_coupon_price
     *
     * @mbggenerated
     */
    public void setCardCouponPrice(BigDecimal cardCouponPrice) {
        this.cardCouponPrice = cardCouponPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.group_id
     *
     * @return the value of b_user_card_coupon.group_id
     *
     * @mbggenerated
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.group_id
     *
     * @param groupId the value for b_user_card_coupon.group_id
     *
     * @mbggenerated
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.p_code
     *
     * @return the value of b_user_card_coupon.p_code
     *
     * @mbggenerated
     */
    public String getpCode() {
        return pCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.p_code
     *
     * @param pCode the value for b_user_card_coupon.p_code
     *
     * @mbggenerated
     */
    public void setpCode(String pCode) {
        this.pCode = pCode == null ? null : pCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.p_name
     *
     * @return the value of b_user_card_coupon.p_name
     *
     * @mbggenerated
     */
    public String getpName() {
        return pName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.p_name
     *
     * @param pName the value for b_user_card_coupon.p_name
     *
     * @mbggenerated
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_user_card_coupon.deleted
     *
     * @return the value of b_user_card_coupon.deleted
     *
     * @mbggenerated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_user_card_coupon.deleted
     *
     * @param deleted the value for b_user_card_coupon.deleted
     *
     * @mbggenerated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    
    private Date nowTime;
    
    private Integer cardType;
    
    private String custname;
    
    private String phone;
    
	public Date getNowTime() {
		return nowTime;
	}

	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
	
}