package com.linjia.web.query;

import java.util.Date;

import com.linjia.base.query.Query;

/**
 * 第三方订单查询封装参数类
 * @author xiangshouyi
 *
 */
public class ThirdLogisOrderQuery extends Query{

	//收货人手机号
	private String receive_name;
		
	//订单id
	private Long order_id;
	
	//收货人手机号
	private String receive_phone;
		
	//自家店铺id
	private String mall_code;
	
	//自家店铺名称
	private String mall_name;
	
	//送货类型(2级)
	private Integer send_type;
	
	//送货类型(2级)
	private Integer mtSend_type;
		
	//送货类型(2级)
	private Integer bdSend_type;
	
	//订单状态
	private Integer status;
	
	//支付状态
	private Integer pay_status;
	
	//查询商城来源订单
	private Integer queryLjSource;
	
	//查询美团来源订单
	private Integer queryMtSource;
		
	//查询百度来源订单来源
	private Integer queryBdSource;
	
	//查询京东来源订单来源
	private Integer queryJdSource;
	//查询饿了么来源订单来源
	private Integer queryElemeSource;
	
	//查询所有来源订单
	private Integer querySource;
	
	//查询订单连接符
	private Integer ifAddUnion;
	
	//百度店铺id
	private String shop_id;
		
	//美团店铺id
	private String app_poi_code;
	
	//京东店铺id
	private String produceStationNoIsv;

	//订单状态集合
	private int[] orderStatusList;
	
	//催单数
	private Integer urgeNum;
	
	//美团订单支付状态
	private Integer mtPatyStatus;
	
	//美团订单状态
	private Integer mtOrderStatus;
		
	//美团订单状态id集合(,隔开)
	private int[] mtOrderStatusList;
	
	//百度订单支付状态
	private Integer bdPatyStatus;
	
	//百度订单状态
	private Integer bdOrderStatus;
	
	//百度订单状态id集合(,隔开)
	private int[] bdOrderStatusList;
	
	//京东订单状态
	private Integer jdOrderStatus;
	
	//京东订单状态id集合(,隔开)
	private int[] jdOrderStatusList;
	
	//饿了么订单状态
	private Integer elemeOrderStatus;
		
	//饿了么订单状态集合(,隔开)
	private int[] elemeOrderStatusList;
	
	private Integer elemeExcludeStatus;
	
	//订单配送类型（1级）
	private Integer order_send_type;
	
	//订单配送方式（3级）
	private Integer send_logistics_type;
	
	private String beginDate;
	
	private String endDate;
	
	private Date start_time;
	
	private Date end_time;
	
	//预约时间、
	private Date send_date;
	
	//创建时间
	private Date cre_date;
	
	//预约计算时间
	private Date sumSend_date;
	
	//预约小时
	private Integer send_hour;
	
	private Integer add_score;
	
	//订单状态
	private Integer ptStatus;
	
	//物流取消产生状态
	private Integer logStatus;
	
	public Integer getPay_status() {
		return pay_status;
	}

	public void setPay_status(Integer pay_status) {
		this.pay_status = pay_status;
	}

	public Integer getSend_type() {
		return send_type;
	}

	public void setSend_type(Integer send_type) {
		this.send_type = send_type;
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getApp_poi_code() {
		return app_poi_code;
	}

	public void setApp_poi_code(String app_poi_code) {
		this.app_poi_code = app_poi_code;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getMall_code() {
		return mall_code;
	}

	public void setMall_code(String mall_code) {
		this.mall_code = mall_code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUrgeNum() {
		return urgeNum;
	}

	public void setUrgeNum(Integer urgeNum) {
		this.urgeNum = urgeNum;
	}

	public Integer getBdPatyStatus() {
		return bdPatyStatus;
	}

	public void setBdPatyStatus(Integer bdPatyStatus) {
		this.bdPatyStatus = bdPatyStatus;
	}

	public Integer getMtPatyStatus() {
		return mtPatyStatus;
	}

	public void setMtPatyStatus(Integer mtPatyStatus) {
		this.mtPatyStatus = mtPatyStatus;
	}

	public Integer getBdOrderStatus() {
		return bdOrderStatus;
	}

	public void setBdOrderStatus(Integer bdOrderStatus) {
		this.bdOrderStatus = bdOrderStatus;
	}

	public Integer getMtOrderStatus() {
		return mtOrderStatus;
	}

	public void setMtOrderStatus(Integer mtOrderStatus) {
		this.mtOrderStatus = mtOrderStatus;
	}

	public Integer getOrder_send_type() {
		return order_send_type;
	}

	public void setOrder_send_type(Integer order_send_type) {
		this.order_send_type = order_send_type;
	}

	public Integer getSend_logistics_type() {
		return send_logistics_type;
	}

	public void setSend_logistics_type(Integer send_logistics_type) {
		this.send_logistics_type = send_logistics_type;
	}

	public String getReceive_phone() {
		return receive_phone;
	}

	public void setReceive_phone(String receive_phone) {
		this.receive_phone = receive_phone;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	public Date getCre_date() {
		return cre_date;
	}

	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}

	public int[] getOrderStatusList() {
		return orderStatusList;
	}

	public void setOrderStatusList(int[] orderStatusList) {
		this.orderStatusList = orderStatusList;
	}

	public int[] getMtOrderStatusList() {
		return mtOrderStatusList;
	}

	public void setMtOrderStatusList(int[] mtOrderStatusList) {
		this.mtOrderStatusList = mtOrderStatusList;
	}

	public int[] getBdOrderStatusList() {
		return bdOrderStatusList;
	}

	public void setBdOrderStatusList(int[] bdOrderStatusList) {
		this.bdOrderStatusList = bdOrderStatusList;
	}

	public Date getSumSend_date() {
		return sumSend_date;
	}

	public void setSumSend_date(Date sumSend_date) {
		this.sumSend_date = sumSend_date;
	}

	public Integer getSend_hour() {
		return send_hour;
	}

	public void setSend_hour(Integer send_hour) {
		this.send_hour = send_hour;
	}

	public Integer getAdd_score() {
		return add_score;
	}

	public void setAdd_score(Integer add_score) {
		this.add_score = add_score;
	}

	public String getReceive_name() {
		return receive_name;
	}

	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}

	public String getMall_name() {
		return mall_name;
	}

	public void setMall_name(String mall_name) {
		this.mall_name = mall_name;
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

	public Integer getMtSend_type() {
		return mtSend_type;
	}

	public void setMtSend_type(Integer mtSend_type) {
		this.mtSend_type = mtSend_type;
	}

	public Integer getBdSend_type() {
		return bdSend_type;
	}

	public void setBdSend_type(Integer bdSend_type) {
		this.bdSend_type = bdSend_type;
	}

	public Integer getQueryLjSource() {
		return queryLjSource;
	}

	public void setQueryLjSource(Integer queryLjSource) {
		this.queryLjSource = queryLjSource;
	}

	public Integer getQueryMtSource() {
		return queryMtSource;
	}

	public void setQueryMtSource(Integer queryMtSource) {
		this.queryMtSource = queryMtSource;
	}

	public Integer getQueryBdSource() {
		return queryBdSource;
	}

	public void setQueryBdSource(Integer queryBdSource) {
		this.queryBdSource = queryBdSource;
	}

	public Integer getIfAddUnion() {
		return ifAddUnion;
	}

	public void setIfAddUnion(Integer ifAddUnion) {
		this.ifAddUnion = ifAddUnion;
	}

	public Integer getQuerySource() {
		return querySource;
	}

	public void setQuerySource(Integer querySource) {
		this.querySource = querySource;
	}

	public Integer getPtStatus() {
		return ptStatus;
	}

	public void setPtStatus(Integer ptStatus) {
		this.ptStatus = ptStatus;
	}

	public Integer getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}

	public Integer getQueryJdSource() {
		return queryJdSource;
	}

	public void setQueryJdSource(Integer queryJdSource) {
		this.queryJdSource = queryJdSource;
	}

	public Integer getJdOrderStatus() {
		return jdOrderStatus;
	}

	public void setJdOrderStatus(Integer jdOrderStatus) {
		this.jdOrderStatus = jdOrderStatus;
	}

	public int[] getJdOrderStatusList() {
		return jdOrderStatusList;
	}

	public void setJdOrderStatusList(int[] jdOrderStatusList) {
		this.jdOrderStatusList = jdOrderStatusList;
	}

	public String getProduceStationNoIsv() {
		return produceStationNoIsv;
	}

	public void setProduceStationNoIsv(String produceStationNoIsv) {
		this.produceStationNoIsv = produceStationNoIsv;
	}
	public Integer getQueryElemeSource() {
		return queryElemeSource;
	}

	public void setQueryElemeSource(Integer queryElemeSource) {
		this.queryElemeSource = queryElemeSource;
	}

	public Integer getElemeOrderStatus() {
		return elemeOrderStatus;
	}

	public void setElemeOrderStatus(Integer elemeOrderStatus) {
		this.elemeOrderStatus = elemeOrderStatus;
	}

	public int[] getElemeOrderStatusList() {
		return elemeOrderStatusList;
	}

	public void setElemeOrderStatusList(int[] elemeOrderStatusList) {
		this.elemeOrderStatusList = elemeOrderStatusList;
	}

	public Integer getElemeExcludeStatus() {
		return elemeExcludeStatus;
	}

	public void setElemeExcludeStatus(Integer elemeExcludeStatus) {
		this.elemeExcludeStatus = elemeExcludeStatus;
	}

}
