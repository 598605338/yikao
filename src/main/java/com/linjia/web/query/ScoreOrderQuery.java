package com.linjia.web.query;

import java.math.BigDecimal;
import java.util.Date;

import com.linjia.base.query.Query;

public class ScoreOrderQuery extends Query{
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.score_product_id
     *
     * @mbggenerated
     */
    private Long scoreProductId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.quantity
     *
     * @mbggenerated
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.order_status
     *
     * @mbggenerated
     */
    private Integer orderStatus;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.price
     *
     * @mbggenerated
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.score
     *
     * @mbggenerated
     */
    private Integer score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.comment
     *
     * @mbggenerated
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.cre_date
     *
     * @mbggenerated
     */
    private Date creDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_score_order.id
     *
     * @return the value of b_score_order.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_score_order.id
     *
     * @param id the value for b_score_order.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_score_order.score_product_id
     *
     * @return the value of b_score_order.score_product_id
     *
     * @mbggenerated
     */
    public Long getScoreProductId() {
        return scoreProductId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_score_order.score_product_id
     *
     * @param scoreProductId the value for b_score_order.score_product_id
     *
     * @mbggenerated
     */
    public void setScoreProductId(Long scoreProductId) {
        this.scoreProductId = scoreProductId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_score_order.quantity
     *
     * @return the value of b_score_order.quantity
     *
     * @mbggenerated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_score_order.quantity
     *
     * @param quantity the value for b_score_order.quantity
     *
     * @mbggenerated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_score_order.type
     *
     * @return the value of b_score_order.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_score_order.type
     *
     * @param type the value for b_score_order.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_score_order.order_status
     *
     * @return the value of b_score_order.order_status
     *
     * @mbggenerated
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_score_order.order_status
     *
     * @param orderStatus the value for b_score_order.order_status
     *
     * @mbggenerated
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_score_order.price
     *
     * @return the value of b_score_order.price
     *
     * @mbggenerated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_score_order.price
     *
     * @param price the value for b_score_order.price
     *
     * @mbggenerated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_score_order.score
     *
     * @return the value of b_score_order.score
     *
     * @mbggenerated
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_score_order.score
     *
     * @param score the value for b_score_order.score
     *
     * @mbggenerated
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_score_order.comment
     *
     * @return the value of b_score_order.comment
     *
     * @mbggenerated
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_score_order.comment
     *
     * @param comment the value for b_score_order.comment
     *
     * @mbggenerated
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_score_order.cre_date
     *
     * @return the value of b_score_order.cre_date
     *
     * @mbggenerated
     */
    public Date getCreDate() {
        return creDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_score_order.cre_date
     *
     * @param creDate the value for b_score_order.cre_date
     *
     * @mbggenerated
     */
    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.type
     *
     * @mbggenerated
     */
    private String userId;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.cre_date
     *
     * @mbggenerated
     */
    private Date startTime;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.cre_date
     *
     * @mbggenerated
     */
    private Date endTime;
    
    /**
     * 支付方式：2：微信支付+积分；1：钱包支付+积分; 0:纯积分兑换;
     *
     * @mbggenerated
     */
    private Integer payType;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_score_order.score_product_id
     *
     * @mbggenerated
     */
    private String name;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}