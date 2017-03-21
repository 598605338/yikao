package com.linjia.web.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.linjia.base.query.Query;

public class OrderRefundManageQuery extends Query{

	private Long id;
	private Long order_group_id;
	private String serial_no;
	private Integer status;
	private Timestamp create_time;
	private Timestamp confirm_time;
	private String custname;
	private String custphone;
	private String mall_code;
	private String  mall_name;
	private Integer refund_type;
	private BigDecimal refund_amount;
	private BigDecimal return_points;
	private Integer refund_source;
	private Integer refund_onlinepay_status;
	private String beginDate;
	private String endDate;
	private Date start_time;
	private Date end_time;
	//审核状态
	private Integer refund_status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrder_group_id() {
		return order_group_id;
	}
	public void setOrder_group_id(Long order_group_id) {
		this.order_group_id = order_group_id;
	}
	public String getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public Timestamp getConfirm_time() {
		return confirm_time;
	}
	public void setConfirm_time(Timestamp confirm_time) {
		this.confirm_time = confirm_time;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustphone() {
		return custphone;
	}
	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	public String getMall_code() {
		return mall_code;
	}
	public void setMall_code(String mall_code) {
		this.mall_code = mall_code;
	}
	public String getMall_name() {
		return mall_name;
	}
	public void setMall_name(String mall_name) {
		this.mall_name = mall_name;
	}
	public Integer getRefund_type() {
		return refund_type;
	}
	public void setRefund_type(Integer refund_type) {
		this.refund_type = refund_type;
	}
	public BigDecimal getRefund_amount() {
		return refund_amount;
	}
	public void setRefund_amount(BigDecimal refund_amount) {
		this.refund_amount = refund_amount;
	}
	public BigDecimal getReturn_points() {
		return return_points;
	}
	public void setReturn_points(BigDecimal return_points) {
		this.return_points = return_points;
	}
	public Integer getRefund_source() {
		return refund_source;
	}
	public void setRefund_source(Integer refund_source) {
		this.refund_source = refund_source;
	}
	public Integer getRefund_onlinepay_status() {
		return refund_onlinepay_status;
	}
	public void setRefund_onlinepay_status(Integer refund_onlinepay_status) {
		this.refund_onlinepay_status = refund_onlinepay_status;
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
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Integer getRefund_status() {
		return refund_status;
	}
	public void setRefund_status(Integer refund_status) {
		this.refund_status = refund_status;
	}
	
	
}
