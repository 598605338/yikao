package com.linjia.web.model;

import java.util.Date;
import java.util.List;

/** 
 * 到家订单Model
 * @author  lixinling: 
 * @date 2017年1月9日 下午5:55:24 
 * @version 1.0 
*/
/**
 * @author lixinling
 * 2017年1月9日 下午6:00:22
 */
public class OrderInfoDTO {

	/** 订单号* */
	private Long orderId;
	/** 来源订单号(外系统来源订单号)* */
	private String srcOrderId;
	/** 内部订单来源类型(0:原订单，10:退款单，20:补货单，30:直赔商品 40:退货 50:上门换新)* */
	private Integer srcInnerOrderId;
	/** 订单类型（10000：超市类订单；13000：美食订单；20000：服务订单）* */
	private Integer orderType;
	/** 订单状态（实物类：20010:锁定，20020:订单取消，20040:超时未支付系统取消，31000:等待付款，31020:已付款，41000:待处理，32000:等待出库，33040:配送中，33060:已妥投 34000:京东已收款，90000:订单完成；美食类：20010:锁定，20020:用户取消，20040:超时未支付系统取消，31000:等待付款，31020:已付款，41000:待接单,41010:已接单,33040:配送中，33060:已妥投,90000:订单完成; 服务类：20010:锁定，20020:订单取消，20040:超时未支付系统取消，31000:等待付款，31020:已付款，41000:待接单,41010:已接单,51010:开始服务 51020:结束服务，90000:订单完成）* */
	private Integer orderStatus;
	/** 订单状态最新更改时间* */
	private Date orderStatusTime;
	/** 下单时间* */
	private Date orderStartTime;
	/** 订单成交时间(在线支付类型订单的付款完成时间)* */
	private Date orderPurchaseTime;
	/** 订单时效类型(0:无时效;2:自定义时间;1:次日达;27:七小时达;24:六小时达;21:五小时达;18:四小时达;15:三小时达;12:两小时达;9:一小时达;6:半小时达;)* */
	private Integer orderAgingType;
	/** 预计送达开始时间* */
	private Date orderPreStartDeliveryTime;
	/** 预计结束送达开始时间* */
	private Date orderPreEndDeliveryTime;
	/** 订单取消时间* */
	private Date orderCancelTime;
	/** 订单取消备注* */
	private String orderCancelRemark;
	/** 商家编号* */
	private String orgCode;
	/** 收货人名称* */
	private String buyerFullName;
	/** 收货人地址* */
	private String buyerFullAddress;
	/** 收货人电话* */
	private String buyerTelephone;
	/** 收货人手机号* */
	private String buyerMobile;
	/** 京东门店编号* */
	private String produceStationNo;
	/** 京东门店名称* */
	private String produceStationName;
	/** 商家门店编号* */
	private String produceStationNoIsv;
	/** 配送门店编号* */
	private String deliveryStationNo;
	/** 配送门店名称* */
	private String deliveryStationName;
	/** 承运商编号(9966:京东众包;2938:商家自送)* */
	private String deliveryCarrierNo;
	/** 承运商名称* */
	private String deliveryCarrierName;
	/** 承运单号* */
	private String deliveryBillNo;
	/** 包裹重量* */
	private Double deliveryPackageWeight;
	/** 妥投时间* */
	private Date deliveryConfirmTime;
	/** 订单支付类型(4:在线支付;)* */
	private Integer orderPayType;
	/** 商品总金额* */
	private Long orderTotalMoney;
	/** 订单优惠金额* */
	private Long orderDiscountMoney;
	/** 订单运费金额* */
	private Long orderFreightMoney;
	/** 用户应付金额=商品总金额 -订单优惠总金额 +订单运费总金额 -余额支付金额 +包装金额* */
	private Long orderBuyerPayableMoney;
	/** 包装金额* */
	private Long packagingMoney;
	/** 用户未付金额 即商家需要向用户结清的尾款* */
	private Long orderVenderChargeMoney;
	/** 订单开发票标识* */
	private Integer orderInvoiceOpenMark;
	/** 是否存在调整单(0:否;1:是)* */
	private Boolean adjustIsExists;
	/** 调整单编号* */
	private Long adjustId;
	/** 收货人地址坐标类型(1:gps;2:sogou经纬度;3:baidu经纬度;4:mapbar经纬度;5:google经纬度（腾讯、高德坐标）;6:sogou墨卡托)* */
	private Integer buyerCoordType;
	/** 收货人地址坐标经度* */
	private Double buyerLng;
	/** 收货人地址坐标纬度* */
	private Double buyerLat;
	/** 发票类型* */
	private String orderInvoiceType;
	/** 发票抬头* */
	private String orderInvoiceTitle;
	/** 发票内容* */
	private String orderInvoiceContent;
	/** 订单买家备注* */
	private String orderBuyerRemark;
	/** 业务标识，用英文分号分隔（订单打标写入此字段，如one.dingshida）* */
	private String businessTag;
	/** 设备id* */
	private String equipmentId;
	/** 用户poi* */
	private String buyerPoi;
	private String businessTagId;
	/** 订购人姓名(此字段针对鲜花业务)* */
	private String ordererName;
	/** 订购人电话(此字段针对鲜花业务)* */
	private String ordererMobile;
	/** 技师头像URL* */
	private String artificerPortraitUrl;
	/** 包含需要查询订单的商品List列表* */
	private List<OrderProductDTO> product;
	/** 包含需要查询订单的优惠List列表* */
	private List<OrderDiscountDTO> discount;
	/** 业务处理详情* */
	private String detail;
	/** 调整次数* */
	private Integer adjustCount;
	/** 今日接单数* */
	private Integer orderNum;
	/** 承运类型：1：未召唤物流；0：已召唤物流* */
	private Integer deliveryType;
	/** 商家确认时间* */
	private Date busConfirmTime;
	/** 骑士取货时间* */
	private Date knightPickupTime;
	/** 配送员名称* */
	private String deliveryManName;
	/** 配送员电话* */
	private String deliveryManPhone;
	/** 单据状态(0未拣货；2:拣货完成)* */
	private Integer pickMark;
	/** 用户取消申请：0未申请；1已申请* */
	private Integer applyCancel;
	/** 用户预计送达时间，“立即送达”时为0* */
	private Long deliveryTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getSrcOrderId() {
		return srcOrderId;
	}

	public void setSrcOrderId(String srcOrderId) {
		this.srcOrderId = srcOrderId;
	}

	public Integer getSrcInnerOrderId() {
		return srcInnerOrderId;
	}

	public void setSrcInnerOrderId(Integer srcInnerOrderId) {
		this.srcInnerOrderId = srcInnerOrderId;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderStatusTime() {
		return orderStatusTime;
	}

	public void setOrderStatusTime(Date orderStatusTime) {
		this.orderStatusTime = orderStatusTime;
	}

	public Date getOrderStartTime() {
		return orderStartTime;
	}

	public void setOrderStartTime(Date orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

	public Date getOrderPurchaseTime() {
		return orderPurchaseTime;
	}

	public void setOrderPurchaseTime(Date orderPurchaseTime) {
		this.orderPurchaseTime = orderPurchaseTime;
	}

	public Integer getOrderAgingType() {
		return orderAgingType;
	}

	public void setOrderAgingType(Integer orderAgingType) {
		this.orderAgingType = orderAgingType;
	}

	public Date getOrderPreStartDeliveryTime() {
		return orderPreStartDeliveryTime;
	}

	public void setOrderPreStartDeliveryTime(Date orderPreStartDeliveryTime) {
		this.orderPreStartDeliveryTime = orderPreStartDeliveryTime;
	}

	public Date getOrderPreEndDeliveryTime() {
		return orderPreEndDeliveryTime;
	}

	public void setOrderPreEndDeliveryTime(Date orderPreEndDeliveryTime) {
		this.orderPreEndDeliveryTime = orderPreEndDeliveryTime;
	}

	public Date getOrderCancelTime() {
		return orderCancelTime;
	}

	public void setOrderCancelTime(Date orderCancelTime) {
		this.orderCancelTime = orderCancelTime;
	}

	public String getOrderCancelRemark() {
		return orderCancelRemark;
	}

	public void setOrderCancelRemark(String orderCancelRemark) {
		this.orderCancelRemark = orderCancelRemark;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getBuyerFullName() {
		return buyerFullName;
	}

	public void setBuyerFullName(String buyerFullName) {
		this.buyerFullName = buyerFullName;
	}

	public String getBuyerFullAddress() {
		return buyerFullAddress;
	}

	public void setBuyerFullAddress(String buyerFullAddress) {
		this.buyerFullAddress = buyerFullAddress;
	}

	public String getBuyerTelephone() {
		return buyerTelephone;
	}

	public void setBuyerTelephone(String buyerTelephone) {
		this.buyerTelephone = buyerTelephone;
	}

	public String getBuyerMobile() {
		return buyerMobile;
	}

	public void setBuyerMobile(String buyerMobile) {
		this.buyerMobile = buyerMobile;
	}

	public String getProduceStationNo() {
		return produceStationNo;
	}

	public void setProduceStationNo(String produceStationNo) {
		this.produceStationNo = produceStationNo;
	}

	public String getProduceStationName() {
		return produceStationName;
	}

	public void setProduceStationName(String produceStationName) {
		this.produceStationName = produceStationName;
	}

	public String getProduceStationNoIsv() {
		return produceStationNoIsv;
	}

	public void setProduceStationNoIsv(String produceStationNoIsv) {
		this.produceStationNoIsv = produceStationNoIsv;
	}

	public String getDeliveryStationNo() {
		return deliveryStationNo;
	}

	public void setDeliveryStationNo(String deliveryStationNo) {
		this.deliveryStationNo = deliveryStationNo;
	}

	public String getDeliveryStationName() {
		return deliveryStationName;
	}

	public void setDeliveryStationName(String deliveryStationName) {
		this.deliveryStationName = deliveryStationName;
	}

	public String getDeliveryCarrierNo() {
		return deliveryCarrierNo;
	}

	public void setDeliveryCarrierNo(String deliveryCarrierNo) {
		this.deliveryCarrierNo = deliveryCarrierNo;
	}

	public String getDeliveryCarrierName() {
		return deliveryCarrierName;
	}

	public void setDeliveryCarrierName(String deliveryCarrierName) {
		this.deliveryCarrierName = deliveryCarrierName;
	}

	public String getDeliveryBillNo() {
		return deliveryBillNo;
	}

	public void setDeliveryBillNo(String deliveryBillNo) {
		this.deliveryBillNo = deliveryBillNo;
	}

	public Double getDeliveryPackageWeight() {
		return deliveryPackageWeight;
	}

	public void setDeliveryPackageWeight(Double deliveryPackageWeight) {
		this.deliveryPackageWeight = deliveryPackageWeight;
	}

	public Date getDeliveryConfirmTime() {
		return deliveryConfirmTime;
	}

	public void setDeliveryConfirmTime(Date deliveryConfirmTime) {
		this.deliveryConfirmTime = deliveryConfirmTime;
	}

	public Integer getOrderPayType() {
		return orderPayType;
	}

	public void setOrderPayType(Integer orderPayType) {
		this.orderPayType = orderPayType;
	}

	public Long getOrderTotalMoney() {
		return orderTotalMoney;
	}

	public void setOrderTotalMoney(Long orderTotalMoney) {
		this.orderTotalMoney = orderTotalMoney;
	}

	public Long getOrderDiscountMoney() {
		return orderDiscountMoney;
	}

	public void setOrderDiscountMoney(Long orderDiscountMoney) {
		this.orderDiscountMoney = orderDiscountMoney;
	}

	public Long getOrderFreightMoney() {
		return orderFreightMoney;
	}

	public void setOrderFreightMoney(Long orderFreightMoney) {
		this.orderFreightMoney = orderFreightMoney;
	}

	public Long getOrderBuyerPayableMoney() {
		return orderBuyerPayableMoney;
	}

	public void setOrderBuyerPayableMoney(Long orderBuyerPayableMoney) {
		this.orderBuyerPayableMoney = orderBuyerPayableMoney;
	}

	public Long getPackagingMoney() {
		return packagingMoney;
	}

	public void setPackagingMoney(Long packagingMoney) {
		this.packagingMoney = packagingMoney;
	}

	public Integer getOrderInvoiceOpenMark() {
		return orderInvoiceOpenMark;
	}

	public void setOrderInvoiceOpenMark(Integer orderInvoiceOpenMark) {
		this.orderInvoiceOpenMark = orderInvoiceOpenMark;
	}

	public Boolean getAdjustIsExists() {
		return adjustIsExists;
	}

	public void setAdjustIsExists(Boolean adjustIsExists) {
		this.adjustIsExists = adjustIsExists;
	}

	public Long getAdjustId() {
		return adjustId;
	}

	public void setAdjustId(Long adjustId) {
		this.adjustId = adjustId;
	}

	public Integer getBuyerCoordType() {
		return buyerCoordType;
	}

	public void setBuyerCoordType(Integer buyerCoordType) {
		this.buyerCoordType = buyerCoordType;
	}

	public Double getBuyerLng() {
		return buyerLng;
	}

	public void setBuyerLng(Double buyerLng) {
		this.buyerLng = buyerLng;
	}

	public Double getBuyerLat() {
		return buyerLat;
	}

	public void setBuyerLat(Double buyerLat) {
		this.buyerLat = buyerLat;
	}

	public String getOrderInvoiceType() {
		return orderInvoiceType;
	}

	public void setOrderInvoiceType(String orderInvoiceType) {
		this.orderInvoiceType = orderInvoiceType;
	}

	public String getOrderInvoiceTitle() {
		return orderInvoiceTitle;
	}

	public void setOrderInvoiceTitle(String orderInvoiceTitle) {
		this.orderInvoiceTitle = orderInvoiceTitle;
	}

	public String getOrderInvoiceContent() {
		return orderInvoiceContent;
	}

	public void setOrderInvoiceContent(String orderInvoiceContent) {
		this.orderInvoiceContent = orderInvoiceContent;
	}

	public String getOrderBuyerRemark() {
		return orderBuyerRemark;
	}

	public void setOrderBuyerRemark(String orderBuyerRemark) {
		this.orderBuyerRemark = orderBuyerRemark;
	}

	public String getBusinessTag() {
		return businessTag;
	}

	public void setBusinessTag(String businessTag) {
		this.businessTag = businessTag;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getBuyerPoi() {
		return buyerPoi;
	}

	public void setBuyerPoi(String buyerPoi) {
		this.buyerPoi = buyerPoi;
	}

	public String getBusinessTagId() {
		return businessTagId;
	}

	public void setBusinessTagId(String businessTagId) {
		this.businessTagId = businessTagId;
	}

	public String getOrdererName() {
		return ordererName;
	}

	public void setOrdererName(String ordererName) {
		this.ordererName = ordererName;
	}

	public String getOrdererMobile() {
		return ordererMobile;
	}

	public void setOrdererMobile(String ordererMobile) {
		this.ordererMobile = ordererMobile;
	}

	public String getArtificerPortraitUrl() {
		return artificerPortraitUrl;
	}

	public void setArtificerPortraitUrl(String artificerPortraitUrl) {
		this.artificerPortraitUrl = artificerPortraitUrl;
	}

	public List<OrderProductDTO> getProduct() {
		return product;
	}

	public void setProduct(List<OrderProductDTO> product) {
		this.product = product;
	}

	public List<OrderDiscountDTO> getDiscount() {
		return discount;
	}

	public void setDiscount(List<OrderDiscountDTO> discount) {
		this.discount = discount;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getAdjustCount() {
		return adjustCount;
	}

	public void setAdjustCount(Integer adjustCount) {
		this.adjustCount = adjustCount;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Long getOrderVenderChargeMoney() {
		return orderVenderChargeMoney;
	}

	public void setOrderVenderChargeMoney(Long orderVenderChargeMoney) {
		this.orderVenderChargeMoney = orderVenderChargeMoney;
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Date getBusConfirmTime() {
		return busConfirmTime;
	}

	public void setBusConfirmTime(Date busConfirmTime) {
		this.busConfirmTime = busConfirmTime;
	}

	public Date getKnightPickupTime() {
		return knightPickupTime;
	}

	public void setKnightPickupTime(Date knightPickupTime) {
		this.knightPickupTime = knightPickupTime;
	}

	public String getDeliveryManName() {
		return deliveryManName;
	}

	public void setDeliveryManName(String deliveryManName) {
		this.deliveryManName = deliveryManName;
	}

	public String getDeliveryManPhone() {
		return deliveryManPhone;
	}

	public void setDeliveryManPhone(String deliveryManPhone) {
		this.deliveryManPhone = deliveryManPhone;
	}

	public Integer getPickMark() {
		return pickMark;
	}

	public void setPickMark(Integer pickMark) {
		this.pickMark = pickMark;
	}

	public Integer getApplyCancel() {
		return applyCancel;
	}

	public void setApplyCancel(Integer applyCancel) {
		this.applyCancel = applyCancel;
	}

	public Long getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Long deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	
}
