package com.linjia.web.model;

import java.math.BigDecimal;
import java.util.List;

public class AccountcashdepositConfigBase {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_config_base.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_config_base.single_limit_amount
     *
     * @mbggenerated
     */
    private BigDecimal singleLimitAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_config_base.day_limit_amount
     *
     * @mbggenerated
     */
    private BigDecimal dayLimitAmount;

    private Integer pay_type;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_config_base.id
     *
     * @return the value of b_accountcashdeposit_config_base.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_config_base.id
     *
     * @param id the value for b_accountcashdeposit_config_base.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_config_base.single_limit_amount
     *
     * @return the value of b_accountcashdeposit_config_base.single_limit_amount
     *
     * @mbggenerated
     */
    public BigDecimal getSingleLimitAmount() {
        return singleLimitAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_config_base.single_limit_amount
     *
     * @param singleLimitAmount the value for b_accountcashdeposit_config_base.single_limit_amount
     *
     * @mbggenerated
     */
    public void setSingleLimitAmount(BigDecimal singleLimitAmount) {
        this.singleLimitAmount = singleLimitAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_config_base.day_limit_amount
     *
     * @return the value of b_accountcashdeposit_config_base.day_limit_amount
     *
     * @mbggenerated
     */
    public BigDecimal getDayLimitAmount() {
        return dayLimitAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_config_base.day_limit_amount
     *
     * @param dayLimitAmount the value for b_accountcashdeposit_config_base.day_limit_amount
     *
     * @mbggenerated
     */
    public void setDayLimitAmount(BigDecimal dayLimitAmount) {
        this.dayLimitAmount = dayLimitAmount;
    }
    
    private String amountSetStr;
    
    private List<AccountcashdepositConfigAmount> amountList;

	public List<AccountcashdepositConfigAmount> getAmountList() {
		return amountList;
	}

	public void setAmountList(List<AccountcashdepositConfigAmount> amountList) {
		this.amountList = amountList;
	}

	public Integer getPay_type() {
		return pay_type;
	}

	public void setPay_type(Integer pay_type) {
		this.pay_type = pay_type;
	}

	public String getAmountSetStr() {
		return amountSetStr;
	}

	public void setAmountSetStr(String amountSetStr) {
		this.amountSetStr = amountSetStr;
	}

    
}