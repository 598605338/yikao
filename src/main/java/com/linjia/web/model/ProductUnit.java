package com.linjia.web.model;

public class ProductUnit {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_product_unit.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_product_unit.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_product_unit.use_status
     *
     * @mbggenerated
     */
    private Boolean useStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_product_unit.deleted
     *
     * @mbggenerated
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_product_unit.id
     *
     * @return the value of b_product_unit.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_product_unit.id
     *
     * @param id the value for b_product_unit.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_product_unit.name
     *
     * @return the value of b_product_unit.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_product_unit.name
     *
     * @param name the value for b_product_unit.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_product_unit.use_status
     *
     * @return the value of b_product_unit.use_status
     *
     * @mbggenerated
     */
    public Boolean getUseStatus() {
        return useStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_product_unit.use_status
     *
     * @param useStatus the value for b_product_unit.use_status
     *
     * @mbggenerated
     */
    public void setUseStatus(Boolean useStatus) {
        this.useStatus = useStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_product_unit.deleted
     *
     * @return the value of b_product_unit.deleted
     *
     * @mbggenerated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_product_unit.deleted
     *
     * @param deleted the value for b_product_unit.deleted
     *
     * @mbggenerated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}