package com.linjia.web.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.linjia.web.poi.PoiIgnore;

public class OrderRefundManage {

	private Long id;
	private Long order_group_id;
	private String serial_no;
	private Integer refund_onlinepay_status;
	private Timestamp create_time;
	private Timestamp confirm_time;
	private String mall_code;
	private String  mall_name;
	private String custname;
	private String custphone;
	private Integer refund_type;
	private BigDecimal refund_amount;
	private BigDecimal return_points;
	private String pay_type_name;
	@PoiIgnore
	private Integer refund_source;
	@PoiIgnore
	private Integer status;
	@PoiIgnore
	private String refund_reason;
	@PoiIgnore
	private BigDecimal send_price;
	@PoiIgnore
	private BigDecimal benefit_price;
	@PoiIgnore
	private BigDecimal order_price;
	@PoiIgnore
	private String remark;
	@PoiIgnore
	private String user_id;
	@PoiIgnore
	private Integer order_type;
	@PoiIgnore
	private Long pt_base_id;
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
	public String getPay_type_name() {
		return pay_type_name;
	}
	public void setPay_type_name(String pay_type_name) {
		this.pay_type_name = pay_type_name;
	}
	public String getRefund_reason() {
		return refund_reason;
	}
	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getOrder_type() {
		return order_type;
	}
	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	public Long getPt_base_id() {
		return pt_base_id;
	}
	public void setPt_base_id(Long pt_base_id) {
		this.pt_base_id = pt_base_id;
	}
	public Integer getRefund_status() {
		return refund_status;
	}
	public void setRefund_status(Integer refund_status) {
		this.refund_status = refund_status;
	}
	
	
}
