package com.linjia.web.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.linjia.web.poi.PoiIgnore;

public class ThirdOrder {

	//订单id
	private Long id;
	//创建时间
	private Timestamp create_time;
	//订单状态
	private Integer status;
	//1,商城订单;2,美团订单;3,百度订单
	private Integer order_type;
	//收货人姓名
	private String receive_name;
	//收货人姓名
	private String receive_phone;
	//店铺cod
	private String mall_code;
	//店铺名称
	private String mall_name;
	//提货方式
	private int send_type;
	//支付方式
	private int pay_type;
	
	//支付时间
	private Timestamp pay_time;
	
	//订单总金额
	private BigDecimal  total_price;
	//实付款
	private BigDecimal real_price;
	//运费
	private BigDecimal send_price;
	//优惠金额
	private BigDecimal benefit_price;
	//订单来源
	private int orderSource;
	
	private Integer add_score;
	
	//期望送达时间
	@PoiIgnore
	private Timestamp send_date;

	//收货人地址
	@PoiIgnore
	private String receive_address;
	//接单时间
	@PoiIgnore
	private Timestamp recive_time;
	//物流名称
	@PoiIgnore
	private String logisticsName;
	//配送员电话
	@PoiIgnore
	private String deliverPhone;
	//当天第几单单数
	@PoiIgnore
	private int orderNum;
	//催单数
	@PoiIgnore
	private int urgeNum;
	//订单列表
	@PoiIgnore
	private List<ThirdOrderProduct> products;
	//送达时间（小时数）
	@PoiIgnore
	private String send_hour;
	//当前时间
	@PoiIgnore
	private Long currentTime;
	//取消原因
	@PoiIgnore
	private String cancelReason;
	@PoiIgnore
	private String remark;
	@PoiIgnore
	private Integer pay_status;
	
	//订单预约配送方式(订单配送方式：0立即配送；1预约配送；2立即配送+预约配送)
	@PoiIgnore
	private Integer order_send_type;
	
	//订单自配送方式(0,达达配送；1，自配送；2,百度配送)
	@PoiIgnore
	private Integer send_logistics_type;
	
	@PoiIgnore
	private String user_id;
	@PoiIgnore
	private Long pt_base_id;
	@PoiIgnore
	private Date cust_send_date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMall_code() {
		return mall_code;
	}
	public void setMall_code(String mall_code) {
		this.mall_code = mall_code;
	}
	public String getLogisticsName() {
		return logisticsName;
	}
	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}
	public String getDeliverPhone() {
		return deliverPhone;
	}
	public void setDeliverPhone(String deliverPhone) {
		this.deliverPhone = deliverPhone;
	}
	public String getMall_name() {
		return mall_name;
	}
	public void setMall_name(String mall_name) {
		this.mall_name = mall_name;
	}
	public String getReceive_address() {
		return receive_address;
	}
	public void setReceive_address(String receive_address) {
		this.receive_address = receive_address;
	}
	public String getReceive_phone() {
		return receive_phone;
	}
	public void setReceive_phone(String receive_phone) {
		this.receive_phone = receive_phone;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	public int getSend_type() {
		return send_type;
	}
	public void setSend_type(int send_type) {
		this.send_type = send_type;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public int getPay_type() {
		return pay_type;
	}
	public void setPay_type(int pay_type) {
		this.pay_type = pay_type;
	}

	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	public int getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(int orderSource) {
		this.orderSource = orderSource;
	}
	public Timestamp getSend_date() {
		return send_date;
	}
	public void setSend_date(Timestamp send_date) {
		this.send_date = send_date;
	}
	public List<ThirdOrderProduct> getProducts() {
		return products;
	}
	public void setProducts(List<ThirdOrderProduct> products) {
		this.products = products;
	}
	public Timestamp getRecive_time() {
		return recive_time;
	}
	public void setRecive_time(Timestamp recive_time) {
		this.recive_time = recive_time;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getUrgeNum() {
		return urgeNum;
	}
	public void setUrgeNum(int urgeNum) {
		this.urgeNum = urgeNum;
	}
	public String getSend_hour() {
		return send_hour;
	}
	public void setSend_hour(String send_hour) {
		this.send_hour = send_hour;
	}
	public Integer getOrder_send_type() {
		return order_send_type;
	}
	public void setOrder_send_type(Integer order_send_type) {
		this.order_send_type = order_send_type;
	}
	public Long getCurrentTime() {
		currentTime=System.currentTimeMillis();
		return currentTime;
	}
	public void setCurrentTime(Long currentTime) {
		this.currentTime = currentTime;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public BigDecimal getSend_price() {
		return send_price;
	}
	public void setSend_price(BigDecimal send_price) {
		this.send_price = send_price;
	}
	public BigDecimal getReal_price() {
		return real_price;
	}
	public void setReal_price(BigDecimal real_price) {
		this.real_price = real_price;
	}
	public Integer getStatus() { 
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSend_logistics_type() {
		return send_logistics_type;
	}
	public void setSend_logistics_type(Integer send_logistics_type) {
		this.send_logistics_type = send_logistics_type;
	}
	public Integer getAdd_score() {
		return add_score;
	}
	public void setAdd_score(Integer add_score) {
		this.add_score = add_score;
	}
	public Integer getOrder_type() {
		return order_type;
	}
	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	public Timestamp getPay_time() {
		return pay_time;
	}
	public void setPay_time(Timestamp pay_time) {
		this.pay_time = pay_time;
	}
	public BigDecimal getBenefit_price() {
		return benefit_price;
	}
	public void setBenefit_price(BigDecimal benefit_price) {
		this.benefit_price = benefit_price;
	}
	public Integer getPay_status() {
		return pay_status;
	}
	public void setPay_status(Integer pay_status) {
		this.pay_status = pay_status;
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
	public Long getPt_base_id() {
		return pt_base_id;
	}
	public void setPt_base_id(Long pt_base_id) {
		this.pt_base_id = pt_base_id;
	}
	public Date getCust_send_date() {
		return cust_send_date;
	}
	public void setCust_send_date(Date cust_send_date) {
		this.cust_send_date = cust_send_date;
	}
	
}
