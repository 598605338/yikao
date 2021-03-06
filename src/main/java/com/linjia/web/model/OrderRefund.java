package com.linjia.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderRefund {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.order_group_id
     *
     * @mbggenerated
     */
    private Long orderGroupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.return_no
     *
     * @mbggenerated
     */
    private String returnNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.login_phone
     *
     * @mbggenerated
     */
    private String loginPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.refund_type
     *
     * @mbggenerated
     */
    private Integer refundType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.refund_amount
     *
     * @mbggenerated
     */
    private BigDecimal refundAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.return_balance
     *
     * @mbggenerated
     */
    private BigDecimal returnBalance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.return_points
     *
     * @mbggenerated
     */
    private BigDecimal returnPoints;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.refund_source
     *
     * @mbggenerated
     */
    private Integer refundSource;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.refund_status
     *
     * @mbggenerated
     */
    private Integer refundStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.confirmor
     *
     * @mbggenerated
     */
    private String confirmor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.confirm_time
     *
     * @mbggenerated
     */
    private Date confirmTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.cancel_reason
     *
     * @mbggenerated
     */
    private String cancelReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.mobile
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.refund_account
     *
     * @mbggenerated
     */
    private String refundAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.return_bank_name
     *
     * @mbggenerated
     */
    private String returnBankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.refund_payee
     *
     * @mbggenerated
     */
    private String refundPayee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.refund_reason_id
     *
     * @mbggenerated
     */
    private Integer refundReasonId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.refund_reason
     *
     * @mbggenerated
     */
    private String refundReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.mall_id
     *
     * @mbggenerated
     */
    private Long mallId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.mall_code
     *
     * @mbggenerated
     */
    private String mallCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.mall_name
     *
     * @mbggenerated
     */
    private String mallName;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.mall_name
     *
     * @mbggenerated
     */
    private String mallPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.refund_onlinepay_status
     *
     * @mbggenerated
     */
    private Integer refundOnlinepayStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.serial_no
     *
     * @mbggenerated
     */
    private String serialNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.pay_type_id
     *
     * @mbggenerated
     */
    private Integer payTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.pay_type_name
     *
     * @mbggenerated
     */
    private String payTypeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.pay_code
     *
     * @mbggenerated
     */
    private String payCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.remark
     *
     * @mbggenerated
     */
    private String remark;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_refund.remark
     *
     * @mbggenerated
     */
    private String refundId;
    
    private BigDecimal send_price;
    private BigDecimal benefit_price;
    private BigDecimal order_price;
    private Date create_time;
    private Integer order_type;
    private BigDecimal real_payPrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.id
     *
     * @return the value of b_order_refund.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.id
     *
     * @param id the value for b_order_refund.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.order_group_id
     *
     * @return the value of b_order_refund.order_group_id
     *
     * @mbggenerated
     */
    public Long getOrderGroupId() {
        return orderGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.order_group_id
     *
     * @param orderGroupId the value for b_order_refund.order_group_id
     *
     * @mbggenerated
     */
    public void setOrderGroupId(Long orderGroupId) {
        this.orderGroupId = orderGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.return_no
     *
     * @return the value of b_order_refund.return_no
     *
     * @mbggenerated
     */
    public String getReturnNo() {
        return returnNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.return_no
     *
     * @param returnNo the value for b_order_refund.return_no
     *
     * @mbggenerated
     */
    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo == null ? null : returnNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.user_id
     *
     * @return the value of b_order_refund.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.user_id
     *
     * @param userId the value for b_order_refund.user_id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.login_phone
     *
     * @return the value of b_order_refund.login_phone
     *
     * @mbggenerated
     */
    public String getLoginPhone() {
        return loginPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.login_phone
     *
     * @param loginPhone the value for b_order_refund.login_phone
     *
     * @mbggenerated
     */
    public void setLoginPhone(String loginPhone) {
        this.loginPhone = loginPhone == null ? null : loginPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.refund_amount
     *
     * @return the value of b_order_refund.refund_amount
     *
     * @mbggenerated
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.refund_amount
     *
     * @param refundAmount the value for b_order_refund.refund_amount
     *
     * @mbggenerated
     */
    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.return_balance
     *
     * @return the value of b_order_refund.return_balance
     *
     * @mbggenerated
     */
    public BigDecimal getReturnBalance() {
        return returnBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.return_balance
     *
     * @param returnBalance the value for b_order_refund.return_balance
     *
     * @mbggenerated
     */
    public void setReturnBalance(BigDecimal returnBalance) {
        this.returnBalance = returnBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.return_points
     *
     * @return the value of b_order_refund.return_points
     *
     * @mbggenerated
     */
    public BigDecimal getReturnPoints() {
        return returnPoints;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.return_points
     *
     * @param returnPoints the value for b_order_refund.return_points
     *
     * @mbggenerated
     */
    public void setReturnPoints(BigDecimal returnPoints) {
        this.returnPoints = returnPoints;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.confirmor
     *
     * @return the value of b_order_refund.confirmor
     *
     * @mbggenerated
     */
    public String getConfirmor() {
        return confirmor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.confirmor
     *
     * @param confirmor the value for b_order_refund.confirmor
     *
     * @mbggenerated
     */
    public void setConfirmor(String confirmor) {
        this.confirmor = confirmor == null ? null : confirmor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.confirm_time
     *
     * @return the value of b_order_refund.confirm_time
     *
     * @mbggenerated
     */
    public Date getConfirmTime() {
        return confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.confirm_time
     *
     * @param confirmTime the value for b_order_refund.confirm_time
     *
     * @mbggenerated
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.cancel_reason
     *
     * @return the value of b_order_refund.cancel_reason
     *
     * @mbggenerated
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.cancel_reason
     *
     * @param cancelReason the value for b_order_refund.cancel_reason
     *
     * @mbggenerated
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.mobile
     *
     * @return the value of b_order_refund.mobile
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.mobile
     *
     * @param mobile the value for b_order_refund.mobile
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.refund_account
     *
     * @return the value of b_order_refund.refund_account
     *
     * @mbggenerated
     */
    public String getRefundAccount() {
        return refundAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.refund_account
     *
     * @param refundAccount the value for b_order_refund.refund_account
     *
     * @mbggenerated
     */
    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount == null ? null : refundAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.return_bank_name
     *
     * @return the value of b_order_refund.return_bank_name
     *
     * @mbggenerated
     */
    public String getReturnBankName() {
        return returnBankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.return_bank_name
     *
     * @param returnBankName the value for b_order_refund.return_bank_name
     *
     * @mbggenerated
     */
    public void setReturnBankName(String returnBankName) {
        this.returnBankName = returnBankName == null ? null : returnBankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.refund_payee
     *
     * @return the value of b_order_refund.refund_payee
     *
     * @mbggenerated
     */
    public String getRefundPayee() {
        return refundPayee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.refund_payee
     *
     * @param refundPayee the value for b_order_refund.refund_payee
     *
     * @mbggenerated
     */
    public void setRefundPayee(String refundPayee) {
        this.refundPayee = refundPayee == null ? null : refundPayee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.refund_reason_id
     *
     * @return the value of b_order_refund.refund_reason_id
     *
     * @mbggenerated
     */
    public Integer getRefundReasonId() {
        return refundReasonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.refund_reason_id
     *
     * @param refundReasonId the value for b_order_refund.refund_reason_id
     *
     * @mbggenerated
     */
    public void setRefundReasonId(Integer refundReasonId) {
        this.refundReasonId = refundReasonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.refund_reason
     *
     * @return the value of b_order_refund.refund_reason
     *
     * @mbggenerated
     */
    public String getRefundReason() {
        return refundReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.refund_reason
     *
     * @param refundReason the value for b_order_refund.refund_reason
     *
     * @mbggenerated
     */
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.mall_id
     *
     * @return the value of b_order_refund.mall_id
     *
     * @mbggenerated
     */
    public Long getMallId() {
        return mallId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.mall_id
     *
     * @param mallId the value for b_order_refund.mall_id
     *
     * @mbggenerated
     */
    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.mall_code
     *
     * @return the value of b_order_refund.mall_code
     *
     * @mbggenerated
     */
    public String getMallCode() {
        return mallCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.mall_code
     *
     * @param mallCode the value for b_order_refund.mall_code
     *
     * @mbggenerated
     */
    public void setMallCode(String mallCode) {
        this.mallCode = mallCode == null ? null : mallCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.mall_name
     *
     * @return the value of b_order_refund.mall_name
     *
     * @mbggenerated
     */
    public String getMallName() {
        return mallName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.mall_name
     *
     * @param mallName the value for b_order_refund.mall_name
     *
     * @mbggenerated
     */
    public void setMallName(String mallName) {
        this.mallName = mallName == null ? null : mallName.trim();
    }
    
    public String getMallPhone() {
		return mallPhone;
	}

	public void setMallPhone(String mallPhone) {
		this.mallPhone = mallPhone;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.serial_no
     *
     * @return the value of b_order_refund.serial_no
     *
     * @mbggenerated
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.serial_no
     *
     * @param serialNo the value for b_order_refund.serial_no
     *
     * @mbggenerated
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.pay_type_name
     *
     * @return the value of b_order_refund.pay_type_name
     *
     * @mbggenerated
     */
    public String getPayTypeName() {
        return payTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.pay_type_name
     *
     * @param payTypeName the value for b_order_refund.pay_type_name
     *
     * @mbggenerated
     */
    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName == null ? null : payTypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.pay_code
     *
     * @return the value of b_order_refund.pay_code
     *
     * @mbggenerated
     */
    public String getPayCode() {
        return payCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.pay_code
     *
     * @param payCode the value for b_order_refund.pay_code
     *
     * @mbggenerated
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_order_refund.remark
     *
     * @return the value of b_order_refund.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_refund.remark
     *
     * @param remark the value for b_order_refund.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Integer getRefundType() {
		return refundType;
	}

	public void setRefundType(Integer refundType) {
		this.refundType = refundType;
	}

	public Integer getRefundSource() {
		return refundSource;
	}

	public void setRefundSource(Integer refundSource) {
		this.refundSource = refundSource;
	}

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Integer getRefundOnlinepayStatus() {
		return refundOnlinepayStatus;
	}

	public void setRefundOnlinepayStatus(Integer refundOnlinepayStatus) {
		this.refundOnlinepayStatus = refundOnlinepayStatus;
	}

	public Integer getPayTypeId() {
		return payTypeId;
	}

	public void setPayTypeId(Integer payTypeId) {
		this.payTypeId = payTypeId;
	}

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public BigDecimal getSend_price() {
		return send_price;
	}

	public void setSend_price(BigDecimal send_price) {
		this.send_price = send_price;
	}

	public BigDecimal getBenefit_price() {
		return benefit_price;
	}

	public void setBenefit_price(BigDecimal benefit_price) {
		this.benefit_price = benefit_price;
	}

	public BigDecimal getOrder_price() {
		return order_price;
	}

	public void setOrder_price(BigDecimal order_price) {
		this.order_price = order_price;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getOrder_type() {
		return order_type;
	}

	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}

	public BigDecimal getReal_payPrice() {
		return real_payPrice;
	}

	public void setReal_payPrice(BigDecimal real_payPrice) {
		this.real_payPrice = real_payPrice;
	}
    
    
}