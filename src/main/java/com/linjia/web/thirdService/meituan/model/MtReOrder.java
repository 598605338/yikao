package com.linjia.web.thirdService.meituan.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.linjia.web.thirdService.meituan.vo.OrderExtraParam;
import com.linjia.web.thirdService.meituan.vo.OrderFoodDetailParam;

/**
 * 数据库订单查询返回数据
 * @author xiangshouyi
 *
 */
public class MtReOrder{
    
	private long  id;
	
	//订单ID
	private String order_id;
	
	//订单展示ID
	private String wm_order_id_view;	
	
	//APP方商家ID
	private String mall_code;	
	
	//美团商家名称
	private String mall_name;	
	
	//美团商家地址
	private String wm_poi_address;	
	
	//美团商家电话
	private String mall_phone;	
	
	//收件人地址
	private String receive_address;	
	
	//收件人电话
	private String receive_phone;	
	
	//收件人姓名
	private String receive_name;	
	
	//门店配送费
	private float shipping_fee;	
	
	//总价
	private float total;	
	
	//原价
	private float original_price;	
	
	//忌口或备注
	private String caution;	
	
	//送餐员电话
	private String shipper_phone;	
	
	//订单状态
	private int status;	
	
	//城市ID（目前暂时用不到此信息）
	private int city_id;	
	
	//是否开发票
	private byte has_invoiced;	
	
	//发票抬头
	private String invoice_title;	
	
	//创建时间
	private Long ctime;	
	
	//更新时间
	private Long utime;	

	//用户预计送达时间，“立即送达”时为0
	private String delivery_time;	
	
	//是否是第三方配送平台配送（0：否；1：是）
	private byte is_third_shipping;	
	
	//支付类型（1：货到付款；2：在线支付）
	private int pay_type;	
	
	//实际送餐地址纬度
	private float latitude;	
	
	//实际送餐地址经度
	private float longitude;	
	
	//门店当天的推单流水号，该信息默认不推送，如有需求请联系美团 
	private String day_seq;	
	
	//订单信息，返回前台对象
	private List<OrderFoodDetailParam> detailList;
	
	//订单信息，后台返回字符窜
	@JsonIgnore
	private String detail;
	
	//优惠信息，返回前台对象
	private List<OrderExtraParam> extraList;
	
	//优惠信息后台返回字符窜
	@JsonIgnore
	private String extras;
	
	@JsonIgnore
	private Integer deleted;
	
	private String pay_status;
	
	private Date order_cancel_time;
	
	private Integer orderNum;
	
	private Integer urgeNum;
	
	private String cancelReason;
	
	private Integer cancelCode;
	
	private String uhd_order_id;
	
	private String uhd_refund_order_id;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getWm_order_id_view() {
		return wm_order_id_view;
	}

	public void setWm_order_id_view(String wm_order_id_view) {
		this.wm_order_id_view = wm_order_id_view;
	}

	public String getWm_poi_address() {
		return wm_poi_address;
	}

	public void setWm_poi_address(String wm_poi_address) {
		this.wm_poi_address = wm_poi_address;
	}

	public float getShipping_fee() {
		return shipping_fee;
	}

	public void setShipping_fee(float shipping_fee) {
		this.shipping_fee = shipping_fee;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(float original_price) {
		this.original_price = original_price;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public String getShipper_phone() {
		return shipper_phone;
	}

	public void setShipper_phone(String shipper_phone) {
		this.shipper_phone = shipper_phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public byte getHas_invoiced() {
		return has_invoiced;
	}

	public void setHas_invoiced(byte has_invoiced) {
		this.has_invoiced = has_invoiced;
	}

	public String getInvoice_title() {
		return invoice_title;
	}

	public void setInvoice_title(String invoice_title) {
		this.invoice_title = invoice_title;
	}

	public Long getCtime() {
		return ctime;
	}

	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}

	public Long getUtime() {
		return utime;
	}

	public void setUtime(Long utime) {
		this.utime = utime;
	}

	public String getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}

	public byte getIs_third_shipping() {
		return is_third_shipping;
	}

	public void setIs_third_shipping(byte is_third_shipping) {
		this.is_third_shipping = is_third_shipping;
	}

	public int getPay_type() {
		return pay_type;
	}

	public void setPay_type(int pay_type) {
		this.pay_type = pay_type;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getDay_seq() {
		return day_seq;
	}

	public void setDay_seq(String day_seq) {
		this.day_seq = day_seq;
	}

	public List<OrderFoodDetailParam> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OrderFoodDetailParam> detailList) {
		this.detailList = detailList;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<OrderExtraParam> getExtraList() {
		return extraList;
	}

	public void setExtraList(List<OrderExtraParam> extraList) {
		this.extraList = extraList;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getMall_phone() {
		return mall_phone;
	}

	public void setMall_phone(String mall_phone) {
		this.mall_phone = mall_phone;
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

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	public Date getOrder_cancel_time() {
		return order_cancel_time;
	}

	public void setOrder_cancel_time(Date order_cancel_time) {
		this.order_cancel_time = order_cancel_time;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getUrgeNum() {
		return urgeNum;
	}

	public void setUrgeNum(Integer urgeNum) {
		this.urgeNum = urgeNum;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Integer getCancelCode() {
		return cancelCode;
	}

	public void setCancelCode(Integer cancelCode) {
		this.cancelCode = cancelCode;
	}

	public String getUhd_order_id() {
		return uhd_order_id;
	}

	public void setUhd_order_id(String uhd_order_id) {
		this.uhd_order_id = uhd_order_id;
	}

	public String getUhd_refund_order_id() {
		return uhd_refund_order_id;
	}

	public void setUhd_refund_order_id(String uhd_refund_order_id) {
		this.uhd_refund_order_id = uhd_refund_order_id;
	}
	
	
}
