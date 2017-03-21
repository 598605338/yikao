package com.linjia.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductPickup {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_product_pickup.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_product_pickup.product_id
     *
     * @mbggenerated
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_product_pickup.p_code
     *
     * @mbggenerated
     */
    private String pCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_product_pickup.cre_date
     *
     * @mbggenerated
     */
    private Date creDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_product_pickup.id
     *
     * @return the value of b_product_pickup.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_product_pickup.id
     *
     * @param id the value for b_product_pickup.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_product_pickup.product_id
     *
     * @return the value of b_product_pickup.product_id
     *
     * @mbggenerated
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_product_pickup.product_id
     *
     * @param productId the value for b_product_pickup.product_id
     *
     * @mbggenerated
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_product_pickup.p_code
     *
     * @return the value of b_product_pickup.p_code
     *
     * @mbggenerated
     */
    public String getpCode() {
        return pCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_product_pickup.p_code
     *
     * @param pCode the value for b_product_pickup.p_code
     *
     * @mbggenerated
     */
    public void setpCode(String pCode) {
        this.pCode = pCode == null ? null : pCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_product_pickup.cre_date
     *
     * @return the value of b_product_pickup.cre_date
     *
     * @mbggenerated
     */
    public Date getCreDate() {
        return creDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_product_pickup.cre_date
     *
     * @param creDate the value for b_product_pickup.cre_date
     *
     * @mbggenerated
     */
    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }
    
    private String userId;
    private String pName;
    private String imagePath;
    private BigDecimal salePrice;
    private BigDecimal marketPrice;
    /**
     * 购物车每条记录的状态
     * (0:正常；1：库存不足)
     */
    private int itemStatus;

    
    
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public int getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}
    
    
}