package com.linjia.web.query;

import java.math.BigDecimal;
import java.util.Date;

import com.linjia.base.query.Query;

public class ActivityPintuanBaseQuery extends Query{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.product_id
     *
     * @mbggenerated
     */
    private Long productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.start_time
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.end_time
     *
     * @mbggenerated
     */
    private Date endTime;
    
    private Date activityTime;
    
    private String activityTimeStr;
    private String activityEndTimeStr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.p_name
     *
     * @mbggenerated
     */
    private String pName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.image_path
     *
     * @mbggenerated
     */
    private String imagePath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.p_unit
     *
     * @mbggenerated
     */
    private String pUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.market_price
     *
     * @mbggenerated
     */
    private BigDecimal marketPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.pt_price
     *
     * @mbggenerated
     */
    private BigDecimal ptPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.quantity
     *
     * @mbggenerated
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.sort_index
     *
     * @mbggenerated
     */
    private Integer sortIndex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.lower_limit
     *
     * @mbggenerated
     */
    private Integer lowerLimit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.upper_limit
     *
     * @mbggenerated
     */
    private Integer upperLimit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.sales_num
     *
     * @mbggenerated
     */
    private Integer salesNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.cluster_num
     *
     * @mbggenerated
     */
    private Integer clusterNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.cluster_success_num
     *
     * @mbggenerated
     */
    private Integer clusterSuccessNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.cre_date
     *
     * @mbggenerated
     */
    private Date creDate;
    
    private Date creEndDate;
    
    private String createTime;
    
    private String createEndTime;
    
    private String startTimeStr;
    
    private String endTimeStr;

    private Integer work_time;
    
    private Integer online;
    
    private Integer giveScore;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.update_date
     *
     * @mbggenerated
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_activity_pintuan_base.deleted
     *
     * @mbggenerated
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.id
     *
     * @return the value of b_activity_pintuan_base.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.id
     *
     * @param id the value for b_activity_pintuan_base.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.product_id
     *
     * @return the value of b_activity_pintuan_base.product_id
     *
     * @mbggenerated
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.product_id
     *
     * @param productId the value for b_activity_pintuan_base.product_id
     *
     * @mbggenerated
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.start_time
     *
     * @return the value of b_activity_pintuan_base.start_time
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.start_time
     *
     * @param startTime the value for b_activity_pintuan_base.start_time
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.end_time
     *
     * @return the value of b_activity_pintuan_base.end_time
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.end_time
     *
     * @param endTime the value for b_activity_pintuan_base.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.p_name
     *
     * @return the value of b_activity_pintuan_base.p_name
     *
     * @mbggenerated
     */
    public String getpName() {
        return pName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.p_name
     *
     * @param pName the value for b_activity_pintuan_base.p_name
     *
     * @mbggenerated
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.description
     *
     * @return the value of b_activity_pintuan_base.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.description
     *
     * @param description the value for b_activity_pintuan_base.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.image_path
     *
     * @return the value of b_activity_pintuan_base.image_path
     *
     * @mbggenerated
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.image_path
     *
     * @param imagePath the value for b_activity_pintuan_base.image_path
     *
     * @mbggenerated
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.p_unit
     *
     * @return the value of b_activity_pintuan_base.p_unit
     *
     * @mbggenerated
     */
    public String getpUnit() {
        return pUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.p_unit
     *
     * @param pUnit the value for b_activity_pintuan_base.p_unit
     *
     * @mbggenerated
     */
    public void setpUnit(String pUnit) {
        this.pUnit = pUnit == null ? null : pUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.market_price
     *
     * @return the value of b_activity_pintuan_base.market_price
     *
     * @mbggenerated
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.market_price
     *
     * @param marketPrice the value for b_activity_pintuan_base.market_price
     *
     * @mbggenerated
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.pt_price
     *
     * @return the value of b_activity_pintuan_base.pt_price
     *
     * @mbggenerated
     */
    public BigDecimal getPtPrice() {
        return ptPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.pt_price
     *
     * @param ptPrice the value for b_activity_pintuan_base.pt_price
     *
     * @mbggenerated
     */
    public void setPtPrice(BigDecimal ptPrice) {
        this.ptPrice = ptPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.quantity
     *
     * @return the value of b_activity_pintuan_base.quantity
     *
     * @mbggenerated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.quantity
     *
     * @param quantity the value for b_activity_pintuan_base.quantity
     *
     * @mbggenerated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.sort_index
     *
     * @return the value of b_activity_pintuan_base.sort_index
     *
     * @mbggenerated
     */
    public Integer getSortIndex() {
        return sortIndex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.sort_index
     *
     * @param sortIndex the value for b_activity_pintuan_base.sort_index
     *
     * @mbggenerated
     */
    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.lower_limit
     *
     * @return the value of b_activity_pintuan_base.lower_limit
     *
     * @mbggenerated
     */
    public Integer getLowerLimit() {
        return lowerLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.lower_limit
     *
     * @param lowerLimit the value for b_activity_pintuan_base.lower_limit
     *
     * @mbggenerated
     */
    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.upper_limit
     *
     * @return the value of b_activity_pintuan_base.upper_limit
     *
     * @mbggenerated
     */
    public Integer getUpperLimit() {
        return upperLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.upper_limit
     *
     * @param upperLimit the value for b_activity_pintuan_base.upper_limit
     *
     * @mbggenerated
     */
    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.sales_num
     *
     * @return the value of b_activity_pintuan_base.sales_num
     *
     * @mbggenerated
     */
    public Integer getSalesNum() {
        return salesNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.sales_num
     *
     * @param salesNum the value for b_activity_pintuan_base.sales_num
     *
     * @mbggenerated
     */
    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.cluster_num
     *
     * @return the value of b_activity_pintuan_base.cluster_num
     *
     * @mbggenerated
     */
    public Integer getClusterNum() {
        return clusterNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.cluster_num
     *
     * @param clusterNum the value for b_activity_pintuan_base.cluster_num
     *
     * @mbggenerated
     */
    public void setClusterNum(Integer clusterNum) {
        this.clusterNum = clusterNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.cluster_success_num
     *
     * @return the value of b_activity_pintuan_base.cluster_success_num
     *
     * @mbggenerated
     */
    public Integer getClusterSuccessNum() {
        return clusterSuccessNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.cluster_success_num
     *
     * @param clusterSuccessNum the value for b_activity_pintuan_base.cluster_success_num
     *
     * @mbggenerated
     */
    public void setClusterSuccessNum(Integer clusterSuccessNum) {
        this.clusterSuccessNum = clusterSuccessNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.cre_date
     *
     * @return the value of b_activity_pintuan_base.cre_date
     *
     * @mbggenerated
     */
    public Date getCreDate() {
        return creDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.cre_date
     *
     * @param creDate the value for b_activity_pintuan_base.cre_date
     *
     * @mbggenerated
     */
    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.update_date
     *
     * @return the value of b_activity_pintuan_base.update_date
     *
     * @mbggenerated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.update_date
     *
     * @param updateDate the value for b_activity_pintuan_base.update_date
     *
     * @mbggenerated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_activity_pintuan_base.deleted
     *
     * @return the value of b_activity_pintuan_base.deleted
     *
     * @mbggenerated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_activity_pintuan_base.deleted
     *
     * @param deleted the value for b_activity_pintuan_base.deleted
     *
     * @mbggenerated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public Integer getWork_time() {
		return work_time;
	}

	public void setWork_time(Integer work_time) {
		this.work_time = work_time;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	public String getActivityTimeStr() {
		return activityTimeStr;
	}

	public void setActivityTimeStr(String activityTimeStr) {
		this.activityTimeStr = activityTimeStr;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Integer getGiveScore() {
		return giveScore;
	}
	
	public void setGiveScore(Integer giveScore) {
		this.giveScore = giveScore;
	}

	public String getActivityEndTimeStr() {
		return activityEndTimeStr;
	}

	public void setActivityEndTimeStr(String activityEndTimeStr) {
		this.activityEndTimeStr = activityEndTimeStr;
	}

	public String getCreateEndTime() {
		return createEndTime;
	}

	public void setCreateEndTime(String createEndTime) {
		this.createEndTime = createEndTime;
	}

	public Date getCreEndDate() {
		return creEndDate;
	}

	public void setCreEndDate(Date creEndDate) {
		this.creEndDate = creEndDate;
	}
	
}