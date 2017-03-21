package com.linjia.web.model;

import java.util.Date;

public class ReceiveCardCoupon {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_receive_card_coupon.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_receive_card_coupon.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_receive_card_coupon.publish_start_time
     *
     * @mbggenerated
     */
    private Date publishStartTime;
    private String publishStartTimeStr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_receive_card_coupon.publish_end_time
     *
     * @mbggenerated
     */
    private Date publishEndTime;
    private String publishEndTimeStr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_receive_card_coupon.publish_type
     *
     * @mbggenerated
     */
    private Integer publishType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_receive_card_coupon.use_status
     *
     * @mbggenerated
     */
    private Boolean useStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_receive_card_coupon.publish_end_time
     *
     * @mbggenerated
     */
    private Date creDate;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_receive_card_coupon.publish_end_time
     *
     * @mbggenerated
     */
    private String creator;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_receive_card_coupon.id
     *
     * @return the value of b_receive_card_coupon.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_receive_card_coupon.id
     *
     * @param id the value for b_receive_card_coupon.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_receive_card_coupon.name
     *
     * @return the value of b_receive_card_coupon.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_receive_card_coupon.name
     *
     * @param name the value for b_receive_card_coupon.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_receive_card_coupon.publish_start_time
     *
     * @return the value of b_receive_card_coupon.publish_start_time
     *
     * @mbggenerated
     */
    public Date getPublishStartTime() {
        return publishStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_receive_card_coupon.publish_start_time
     *
     * @param publishStartTime the value for b_receive_card_coupon.publish_start_time
     *
     * @mbggenerated
     */
    public void setPublishStartTime(Date publishStartTime) {
        this.publishStartTime = publishStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_receive_card_coupon.publish_end_time
     *
     * @return the value of b_receive_card_coupon.publish_end_time
     *
     * @mbggenerated
     */
    public Date getPublishEndTime() {
        return publishEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_receive_card_coupon.publish_end_time
     *
     * @param publishEndTime the value for b_receive_card_coupon.publish_end_time
     *
     * @mbggenerated
     */
    public void setPublishEndTime(Date publishEndTime) {
        this.publishEndTime = publishEndTime;
    }


    public Integer getPublishType() {
		return publishType;
	}

	public void setPublishType(Integer publishType) {
		this.publishType = publishType;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_receive_card_coupon.use_status
     *
     * @return the value of b_receive_card_coupon.use_status
     *
     * @mbggenerated
     */
    public Boolean getUseStatus() {
        return useStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_receive_card_coupon.use_status
     *
     * @param useStatus the value for b_receive_card_coupon.use_status
     *
     * @mbggenerated
     */
    public void setUseStatus(Boolean useStatus) {
        this.useStatus = useStatus;
    }

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

    
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}


	/** 发布张数* */
	private Integer publishNum;
	/** 卡券Id* */
	private Long cardCouponId;
	/** 卡券名称* */
	private String cardName;

	public Integer getPublishNum() {
		return publishNum;
	}

	public void setPublishNum(Integer publishNum) {
		this.publishNum = publishNum;
	}

	public Long getCardCouponId() {
		return cardCouponId;
	}

	public void setCardCouponId(Long cardCouponId) {
		this.cardCouponId = cardCouponId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getPublishStartTimeStr() {
		return publishStartTimeStr;
	}

	public void setPublishStartTimeStr(String publishStartTimeStr) {
		this.publishStartTimeStr = publishStartTimeStr;
	}

	public String getPublishEndTimeStr() {
		return publishEndTimeStr;
	}

	public void setPublishEndTimeStr(String publishEndTimeStr) {
		this.publishEndTimeStr = publishEndTimeStr;
	}
	
	
}