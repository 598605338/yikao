package com.linjia.web.model;

import java.math.BigDecimal;
import java.util.Date;

import com.linjia.web.poi.PoiIgnore;

public class PinTuanOrder {

	//主键
	@PoiIgnore
	private Integer id;
	//订单号
	private Long order_id;
	//团id
	private Long teamId;
	//订单开始时间
	@PoiIgnore
	private Date start_time;
	//订单结束时间
	@PoiIgnore
	private Date end_time;
	//创建时间
	private Date cre_date;
	//用户id
	@PoiIgnore
	private String user_id;
	//订单状态
	private Integer status;
	//拼团状态
	private Integer pt_status;
	
	private Integer order_type;
	
	//支付状态
	@PoiIgnore
	private Integer pay_status;
	
	//参团人数
	private Integer ptp_nums;
	
	private String custname;
	
	private String phone;
	
	private String address;
	@PoiIgnore
	private Integer send_type;
	
	private String third_logistics_name;
	
	private String third_logistics_no;
	
	//支付类型
	private Integer pay_type;
	
	private Date pay_time;	
	
	//商品价格
	private BigDecimal price;
	
	private BigDecimal real_price;
	
	//配送费
	private BigDecimal send_fee;
	
	private BigDecimal benefit_price;
	
	//商品名称
	@PoiIgnore
	private String p_name;
	//地址id
	@PoiIgnore
	private Integer address_id;
	//商品id
	@PoiIgnore
	private Long product_id;
	//商品code
	@PoiIgnore
	private String p_code;
	//商品数量
	private Integer quanty;
	//
	@PoiIgnore
	private String remark;
	@PoiIgnore
	private String mall_code;
	@PoiIgnore
	private String mall_name;
	
	private Integer add_score;
	@PoiIgnore
	private String cardNo;
	
	@PoiIgnore
	private Date send_date;
	@PoiIgnore
	private Integer send_hour;
	
	@PoiIgnore
	private Long pt_base_id;
	@PoiIgnore
	private Date send_time;
	@PoiIgnore
	private BigDecimal onebuy_price;
	@PoiIgnore
	private Date cancel_time;
	@PoiIgnore
	private Date order_success_time;
	@PoiIgnore
	private String cancel_reason;
	@PoiIgnore
	private Integer buyPersonNum;
	@PoiIgnore
	private Integer pt_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getCre_date() {
		return cre_date;
	}
	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getPay_type() {
		return pay_type;
	}
	public void setPay_type(Integer pay_type) {
		this.pay_type = pay_type;
	}
	public Integer getPay_status() {
		return pay_status;
	}
	public void setPay_status(Integer pay_status) {
		this.pay_status = pay_status;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public Integer getPt_status() {
		return pt_status;
	}
	public void setPt_status(Integer pt_status) {
		this.pt_status = pt_status;
	}
	public BigDecimal getSend_fee() {
		return send_fee;
	}
	public void setSend_fee(BigDecimal send_fee) {
		this.send_fee = send_fee;
	}
	public Integer getQuanty() {
		return quanty;
	}
	public void setQuanty(Integer quanty) {
		this.quanty = quanty;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public BigDecimal getReal_price() {
		return real_price;
	}
	public void setReal_price(BigDecimal real_price) {
		this.real_price = real_price;
	}
	public BigDecimal getBenefit_price() {
		return benefit_price;
	}
	public void setBenefit_price(BigDecimal benefit_price) {
		this.benefit_price = benefit_price;
	}
	public Integer getPtp_nums() {
		return ptp_nums;
	}
	public void setPtp_nums(Integer ptp_nums) {
		this.ptp_nums = ptp_nums;
	}
	public Integer getSend_type() {
		return send_type;
	}
	public void setSend_type(Integer send_type) {
		this.send_type = send_type;
	}
	public String getThird_logistics_no() {
		return third_logistics_no;
	}
	public void setThird_logistics_no(String third_logistics_no) {
		this.third_logistics_no = third_logistics_no;
	}
	public Date getPay_time() {
		return pay_time;
	}
	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
	public Integer getAdd_score() {
		return add_score;
	}
	public void setAdd_score(Integer add_score) {
		this.add_score = add_score;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Integer getOrder_type() {
		return order_type;
	}
	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public Integer getSend_hour() {
		return send_hour;
	}
	public void setSend_hour(Integer send_hour) {
		this.send_hour = send_hour;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPt_base_id() {
		return pt_base_id;
	}
	public void setPt_base_id(Long pt_base_id) {
		this.pt_base_id = pt_base_id;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public String getThird_logistics_name() {
		return third_logistics_name;
	}
	public void setThird_logistics_name(String third_logistics_name) {
		this.third_logistics_name = third_logistics_name;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public BigDecimal getOnebuy_price() {
		return onebuy_price;
	}
	public void setOnebuy_price(BigDecimal onebuy_price) {
		this.onebuy_price = onebuy_price;
	}
	public Date getCancel_time() {
		return cancel_time;
	}
	public void setCancel_time(Date cancel_time) {
		this.cancel_time = cancel_time;
	}
	public Date getOrder_success_time() {
		return order_success_time;
	}
	public void setOrder_success_time(Date order_success_time) {
		this.order_success_time = order_success_time;
	}
	public String getCancel_reason() {
		return cancel_reason;
	}
	public void setCancel_reason(String cancel_reason) {
		this.cancel_reason = cancel_reason;
	}
	public Integer getBuyPersonNum() {
		return buyPersonNum;
	}
	public void setBuyPersonNum(Integer buyPersonNum) {
		this.buyPersonNum = buyPersonNum;
	}
	public Integer getPt_id() {
		return pt_id;
	}
	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
	}
	
}
