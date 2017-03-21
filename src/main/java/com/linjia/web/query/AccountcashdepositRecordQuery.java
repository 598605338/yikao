package com.linjia.web.query;

import java.math.BigDecimal;
import java.util.Date;

import com.linjia.base.query.Query;

public class AccountcashdepositRecordQuery extends Query{
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_record.tranId
     *
     * @mbggenerated
     */
    private Integer tranId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_record.accountAccessCode
     *
     * @mbggenerated
     */
    private String accountaccesscode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_record.accountAccessType
     *
     * @mbggenerated
     */
    private Integer accountaccesstype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_record.orgCode
     *
     * @mbggenerated
     */
    private String orgcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_record.occur
     *
     * @mbggenerated
     */
    private BigDecimal occur;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_record.realPay
     *
     * @mbggenerated
     */
    private BigDecimal realpay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_record.tranTime
     *
     * @mbggenerated
     */
    private Date trantime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_record.xid
     *
     * @mbggenerated
     */
    private Long xid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_accountcashdeposit_record.tranStatus
     *
     * @mbggenerated
     */
    private Integer transtatus;

    private String transactionId;
    
    private String custname;
    
    /** 充值起始时间* */
    private Date startTrantime;
    /** 充值结束时间* */
    private Date endTrantime;

    private String beginDate;
    
    private String endDate;
    
    private String phone;

    public Integer getTranId() {
		return tranId;
	}

	public void setTranId(Integer tranId) {
		this.tranId = tranId;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_record.accountAccessCode
     *
     * @return the value of b_accountcashdeposit_record.accountAccessCode
     *
     * @mbggenerated
     */
    public String getAccountaccesscode() {
        return accountaccesscode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_record.accountAccessCode
     *
     * @param accountaccesscode the value for b_accountcashdeposit_record.accountAccessCode
     *
     * @mbggenerated
     */
    public void setAccountaccesscode(String accountaccesscode) {
        this.accountaccesscode = accountaccesscode == null ? null : accountaccesscode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_record.accountAccessType
     *
     * @return the value of b_accountcashdeposit_record.accountAccessType
     *
     * @mbggenerated
     */
    public Integer getAccountaccesstype() {
        return accountaccesstype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_record.accountAccessType
     *
     * @param accountaccesstype the value for b_accountcashdeposit_record.accountAccessType
     *
     * @mbggenerated
     */
    public void setAccountaccesstype(Integer accountaccesstype) {
        this.accountaccesstype = accountaccesstype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_record.orgCode
     *
     * @return the value of b_accountcashdeposit_record.orgCode
     *
     * @mbggenerated
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_record.orgCode
     *
     * @param orgcode the value for b_accountcashdeposit_record.orgCode
     *
     * @mbggenerated
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_record.occur
     *
     * @return the value of b_accountcashdeposit_record.occur
     *
     * @mbggenerated
     */
    public BigDecimal getOccur() {
        return occur;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_record.occur
     *
     * @param occur the value for b_accountcashdeposit_record.occur
     *
     * @mbggenerated
     */
    public void setOccur(BigDecimal occur) {
        this.occur = occur;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_record.realPay
     *
     * @return the value of b_accountcashdeposit_record.realPay
     *
     * @mbggenerated
     */
    public BigDecimal getRealpay() {
        return realpay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_record.realPay
     *
     * @param realpay the value for b_accountcashdeposit_record.realPay
     *
     * @mbggenerated
     */
    public void setRealpay(BigDecimal realpay) {
        this.realpay = realpay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_record.tranTime
     *
     * @return the value of b_accountcashdeposit_record.tranTime
     *
     * @mbggenerated
     */
    public Date getTrantime() {
        return trantime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_record.tranTime
     *
     * @param trantime the value for b_accountcashdeposit_record.tranTime
     *
     * @mbggenerated
     */
    public void setTrantime(Date trantime) {
        this.trantime = trantime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_record.xid
     *
     * @return the value of b_accountcashdeposit_record.xid
     *
     * @mbggenerated
     */
    public Long getXid() {
        return xid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_record.xid
     *
     * @param xid the value for b_accountcashdeposit_record.xid
     *
     * @mbggenerated
     */
    public void setXid(Long xid) {
        this.xid = xid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_accountcashdeposit_record.tranStatus
     *
     * @return the value of b_accountcashdeposit_record.tranStatus
     *
     * @mbggenerated
     */
    public Integer getTranstatus() {
        return transtatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_accountcashdeposit_record.tranStatus
     *
     * @param transtatus the value for b_accountcashdeposit_record.tranStatus
     *
     * @mbggenerated
     */
    public void setTranstatus(Integer transtatus) {
        this.transtatus = transtatus;
    }

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public Date getStartTrantime() {
		return startTrantime;
	}

	public void setStartTrantime(Date startTrantime) {
		this.startTrantime = startTrantime;
	}

	public Date getEndTrantime() {
		return endTrantime;
	}

	public void setEndTrantime(Date endTrantime) {
		this.endTrantime = endTrantime;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
	
}