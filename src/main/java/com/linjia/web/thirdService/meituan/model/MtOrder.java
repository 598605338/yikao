package com.linjia.web.thirdService.meituan.model;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.linjia.web.thirdService.meituan.vo.OrderExtraParam;
import com.linjia.web.thirdService.meituan.vo.OrderFoodDetailParam;

/**
 * 数据库订单查询返回数据
 * @author xiangshouyi
 *
 */
public class MtOrder{
    
	private Integer id;
	
	//订单ID
	private String order_id;
	
	//订单展示ID
	private String wm_order_id_view;	
	
	//APP方商家ID
	private String app_poi_code;	
	
	//美团商家名称
	private String wm_poi_name;	
	
	//美团商家地址
	private String wm_poi_address;	
	
	//美团商家电话
	private String wm_poi_phone;	
	
	//收件人地址
	private String recipient_address;	
	
	//收件人电话
	private String recipient_phone;	
	
	//收件人姓名
	private String recipient_name;	
	
	//期望收货时间
	private Date recive_time;
	
	//门店配送费
	private String shipping_fee;	
	
	//总价
	private String total;	
	
	//原价
	private String original_price;	
	
	//忌口或备注
	private String caution;	
	
	//送餐员电话
	private String shipper_phone;	
	
	//订单状态
	private String status;	
	
	//城市ID（目前暂时用不到此信息）
	private String city_id;	
	
	//是否开发票
	private String has_invoiced;	
	
	//发票抬头
	private String invoice_title;	
	
	//用户预计送达时间，“立即送达”时为0
	private String delivery_time;	
	
	//是否是第三方配送平台配送（0：否；1：是）
	private String is_third_shipping;	
	
	//***********未定**************
	//创建时间
	private Long ctime;	
	
	//更新时间
	private Long utime;	

	//支付类型（1：货到付款；2：在线支付）
	private int pay_type;	
	
	//实际送餐地址纬度
	private float latitude;	
	
	//实际送餐地址经度
	private float longitude;	
	
	//门店当天的推单流水号，该信息默认不推送，如有需求请联系美团 
	private String day_seq;	
	
	//***********未定**************
	
	//订单信息，返回前台对象
	private List<OrderFoodDetailParam> detailList;
	
	//订单信息，后台返回字符窜
	private String detail;
	
	//优惠信息，返回前台对象
	private List<OrderExtraParam> extraList;
	
	//优惠信息后台返回字符窜
	private String  extras;
	
	//取消原因
	private String cancelReason;
	
	//取消原因code
	private Integer cancelCode;
	
	private Integer deleted;
	
	//当天第几单
	private Integer orderNum;
	
	//支付状态
	private String pay_status;
	
	private String uhd_order_id;
	
	private String uhd_refund_order_id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getApp_poi_code() {
		return app_poi_code;
	}

	public void setApp_poi_code(String app_poi_code) {
		this.app_poi_code = app_poi_code;
	}

	public String getWm_poi_name() {
		return wm_poi_name;
	}

	public void setWm_poi_name(String wm_poi_name) {
		if(wm_poi_name!=null && !"".equals(wm_poi_name)){
			wm_poi_name=URLDecoder.decode(wm_poi_name);
		}
		this.wm_poi_name = wm_poi_name;
	}

	public String getWm_poi_address() {
		return wm_poi_address;
	}

	public void setWm_poi_address(String wm_poi_address) {
		if(wm_poi_address!=null && !"".equals(wm_poi_address)){
			wm_poi_address=URLDecoder.decode(wm_poi_address);
		}
		this.wm_poi_address = wm_poi_address;
	}

	public String getWm_poi_phone() {
		return wm_poi_phone;
	}

	public void setWm_poi_phone(String wm_poi_phone) {
		this.wm_poi_phone = wm_poi_phone;
	}

	public String getRecipient_address() {
		return recipient_address;
	}

	public void setRecipient_address(String recipient_address) {
		if(recipient_address!=null && !"".equals(recipient_address)){
			recipient_address=URLDecoder.decode(recipient_address);
		}
		this.recipient_address = recipient_address;
	}

	public String getRecipient_phone() {
		return recipient_phone;
	}

	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}

	public String getRecipient_name() {
		return recipient_name;
	}

	public void setRecipient_name(String recipient_name) {
		if(recipient_name!=null && !"".equals(recipient_name)){
			recipient_name=URLDecoder.decode(recipient_name);
		}
		this.recipient_name = recipient_name;
	}

	public Date getRecive_time() {
		return recive_time;
	}

	public void setRecive_time(Date recive_time) {
		this.recive_time = recive_time;
	}

	public String getShipping_fee() {
		return shipping_fee;
	}

	public void setShipping_fee(String shipping_fee) {
		this.shipping_fee = shipping_fee;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(String original_price) {
		this.original_price = original_price;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		if(caution!=null && !"".equals(caution)){
			caution=URLDecoder.decode(caution);
		}
		this.caution = caution;
	}

	public String getShipper_phone() {
		return shipper_phone;
	}

	public void setShipper_phone(String shipper_phone) {
		this.shipper_phone = shipper_phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getHas_invoiced() {
		return has_invoiced;
	}

	public void setHas_invoiced(String has_invoiced) {
		this.has_invoiced = has_invoiced;
	}

	public String getInvoice_title() {
		return invoice_title;
	}

	public void setInvoice_title(String invoice_title) {
		if(invoice_title!=null && !"".equals(invoice_title)){
			invoice_title=URLDecoder.decode(invoice_title);
		} 
		this.invoice_title = invoice_title;
	}

	public String getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}

	public String getIs_third_shipping() {
		return is_third_shipping;
	}

	public void setIs_third_shipping(String is_third_shipping) {
		this.is_third_shipping = is_third_shipping;
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
		if(detail!=null && !"".equals(detail)){
			String detaill=this.getDetail();
			if(detaill!=null&&detaill!=""){
				 detailList= JSONArray.parseArray(detaill, OrderFoodDetailParam.class);
			}
		}
		return detailList;
	}

	public List<OrderExtraParam> getExtraList() {
		if(extras!=null && !"".equals(extras)){
			String extrasl=this.getExtras();
			if(extrasl!=null&&extrasl!=""){
				extraList= JSONArray.parseArray(extrasl, OrderExtraParam.class);
			}
		}
		return extraList;
	}

	public void setExtraList(List<OrderExtraParam> extraList) {
		this.extraList = extraList;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		if(extras!=null && !"".equals(extras)){
			extras=URLDecoder.decode(extras);
		} 
		this.extras = extras;
	}

	public void setDetailList(List<OrderFoodDetailParam> detailList) {
		this.detailList = detailList;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		if(detail!=null && !"".equals(detail)){
			detail=URLDecoder.decode(detail);
		} 
		this.detail = detail;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		if(cancelReason!=null && !"".equals(cancelReason)){
			cancelReason=URLDecoder.decode(cancelReason);
		}
		this.cancelReason = cancelReason;
	}

	public Integer getCancelCode() {
		return cancelCode;
	}

	public void setCancelCode(Integer cancelCode) {
		this.cancelCode = cancelCode;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
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
