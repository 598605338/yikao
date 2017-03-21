package com.linjia.web.thirdService.eleme.interfaces.entity.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.linjia.web.thirdService.eleme.deserializer.DateDeserializer;
import com.linjia.web.thirdService.eleme.interfaces.enumeration.order.OOrderRefundStatus;
import com.linjia.web.thirdService.eleme.interfaces.enumeration.order.OOrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class OOrder {

    /**
     * 顾客送餐地址||"近铁城市广场"
     */
    private String address;

    /**
     * 下单时间||"2016-11-30T12:15:53"
     */
    @JsonDeserialize(using = DateDeserializer.class)
    private Date createdAt;

    /**
     * 订单生效时间||"2016-11-30T12:15:53"
     *
     * @desc 即支付时间
     */
    @JsonDeserialize(using = DateDeserializer.class)
    private Date activeAt;

    /**
     * 配送费||2.0
     */
    private double deliverFee;

    /**
     * 预计送达时间||"2016-11-30T13:15:53"
     */
    @JsonDeserialize(using = DateDeserializer.class)
    private Date deliverTime;

    /**
     * 订单备注||"不要香菜"
     */
    private String description;

    /**
     * 订单详细类目的列表||"[{"items":[{"categoryId":1123123,"id":2341123,"name":"奶茶","price":10.0,"quantity":30,"total":300.0}],"name":"一个分组","type":"discount"}]"
     */
    private List<OGoodsGroup> groups = new ArrayList();

    /**
     * 发票抬头||"拉扎斯网络科技(上海)有限公司"
     */
    private String invoice;

    /**
     * 是否预订单||true
     */
    private boolean book;

    /**
     * 是否在线支付||false
     */
    private boolean onlinePaid;

    /**
     * 订单Id||"100027455049038461"
     */
    private String id;

    /**
     * 顾客联系电话||["13507701342"]
     */
    private List<String> phoneList = new ArrayList();

    /**
     * 店铺Id||968514
     */
    private long shopId;

    /**
     * 店铺名称||"实验餐厅"
     */
    private String shopName;

    /**
     * 店铺当日订单流水号||89
     */
    private int daySn;

    /**
     * 订单状态||"settled"
     */
    private OOrderStatus status;

    /**
     * 退单状态||"noRefund"
     */
    private OOrderRefundStatus refundStatus;

    /**
     * 用户Id||13524069
     */
    private int userId;

    /**
     * 订单总价||5.0
     *
     * @desc 用户实付(单位：元）
     */
    private double totalPrice;

    /**
     * 原始价格||5.0
     *
     * @desc 优惠前的价格，即菜价加上配送费和打包费，单位：元
     */
    private double originalPrice;

    /**
     * 订单收货人||"张三"
     */
    private String consignee;

    /**
     * 订单收货地址经纬度||"121.83317,31.514559"
     */
    private String deliveryGeo;

    /**
     * 顾客送餐详情地址||"近铁城市广场（普陀区金沙江路1518弄)"
     */
    private String deliveryPoiAddress;

    /**
     * 是否需要发票||true
     */
    private boolean invoiced;

    /**
     * 店铺实收||7.0
     */
    private double income;

    /**
     * 饿了么服务费率||0.0
     */
    private double serviceRate;

    /**
     * 饿了么服务费||0.0
     */
    private double serviceFee;

    /**
     * 订单中红包金额||1.0
     */
    private double hongbao;

    /**
     * 餐盒费||1.0
     */
    private double packageFee;

    /**
     * 订单活动总额||12.0
     */
    private double activityTotal;

    /**
     * 店铺承担活动费用||6.0
     */
    private double shopPart;

    /**
     * 饿了么承担活动费用||6.0
     */
    private double elemePart;

    /**
     * 降级标识||false
     *
     * @desc true为已降级，false为未降级。
     * 平台为尽可能促成交易，会在一部分字段未生成的时候（如活动补贴），将订单生成。
     * 如果需要完整的订单的订单信息，需要事后在降级标记为false时再进行读取。
     */
    private boolean downgraded;
    
    //主键
    @JsonIgnore
    private Long tid;
    
    private String phone;
    
    
    private Date recive_time;
    private int orderNum;
    private int urgeNum;
    private String cancelReason;
    private Date order_cancel_time;
    private Date order_success_time;
    private String uhd_order_id;
    private String uhd_refund_order_id;
    private Integer msg_type;
    private Integer order_status;
    
    private String subState;
    private String deliveryman;
    private String deliveryphone;
    private Date deliverytime;
    private String deliveryremark;
    private String orderremark;
    private String logisMainStatus;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getActiveAt() {
        return activeAt;
    }

    public void setActiveAt(Date activeAt) {
        this.activeAt = activeAt;
    }

    public double getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(double deliverFee) {
        this.deliverFee = deliverFee;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OGoodsGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<OGoodsGroup> groups) {
        this.groups = groups;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public boolean isBook() {
        return book;
    }

    public void setBook(boolean book) {
        this.book = book;
    }

    public boolean isOnlinePaid() {
        return onlinePaid;
    }

    public void setOnlinePaid(boolean onlinePaid) {
        this.onlinePaid = onlinePaid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getDaySn() {
        return daySn;
    }

    public void setDaySn(int daySn) {
        this.daySn = daySn;
    }

    public OOrderStatus getStatus() {
        return status;
    }

    public void setStatus(OOrderStatus status) {
        this.status = status;
    }

    public OOrderRefundStatus getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(OOrderRefundStatus refundStatus) {
        this.refundStatus = refundStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getDeliveryGeo() {
        return deliveryGeo;
    }

    public void setDeliveryGeo(String deliveryGeo) {
        this.deliveryGeo = deliveryGeo;
    }

    public String getDeliveryPoiAddress() {
        return deliveryPoiAddress;
    }

    public void setDeliveryPoiAddress(String deliveryPoiAddress) {
        this.deliveryPoiAddress = deliveryPoiAddress;
    }

    public boolean isInvoiced() {
        return invoiced;
    }

    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(double serviceRate) {
        this.serviceRate = serviceRate;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public double getHongbao() {
        return hongbao;
    }

    public void setHongbao(double hongbao) {
        this.hongbao = hongbao;
    }

    public double getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(double packageFee) {
        this.packageFee = packageFee;
    }

    public double getActivityTotal() {
        return activityTotal;
    }

    public void setActivityTotal(double activityTotal) {
        this.activityTotal = activityTotal;
    }

    public double getShopPart() {
        return shopPart;
    }

    public void setShopPart(double shopPart) {
        this.shopPart = shopPart;
    }

    public double getElemePart() {
        return elemePart;
    }

    public void setElemePart(double elemePart) {
        this.elemePart = elemePart;
    }

    public boolean isDowngraded() {
        return downgraded;
    }

    public void setDowngraded(boolean downgraded) {
        this.downgraded = downgraded;
    }

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRecive_time() {
		return recive_time;
	}

	public void setRecive_time(Date recive_time) {
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

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Date getOrder_cancel_time() {
		return order_cancel_time;
	}

	public void setOrder_cancel_time(Date order_cancel_time) {
		this.order_cancel_time = order_cancel_time;
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

	public Date getOrder_success_time() {
		return order_success_time;
	}

	public void setOrder_success_time(Date order_success_time) {
		this.order_success_time = order_success_time;
	}

	public Integer getMsg_type() {
		return msg_type;
	}

	public void setMsg_type(Integer msg_type) {
		this.msg_type = msg_type;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	public String getSubState() {
		return subState;
	}

	public void setSubState(String subState) {
		this.subState = subState;
	}

	public String getDeliveryman() {
		return deliveryman;
	}

	public void setDeliveryman(String deliveryman) {
		this.deliveryman = deliveryman;
	}

	public String getDeliveryphone() {
		return deliveryphone;
	}

	public void setDeliveryphone(String deliveryphone) {
		this.deliveryphone = deliveryphone;
	}

	public Date getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(Date deliverytime) {
		this.deliverytime = deliverytime;
	}

	public String getDeliveryremark() {
		return deliveryremark;
	}

	public void setDeliveryremark(String deliveryremark) {
		this.deliveryremark = deliveryremark;
	}

	public String getOrderremark() {
		return orderremark;
	}

	public void setOrderremark(String orderremark) {
		this.orderremark = orderremark;
	}

	public String getLogisMainStatus() {
		return logisMainStatus;
	}

	public void setLogisMainStatus(String logisMainStatus) {
		this.logisMainStatus = logisMainStatus;
	}
    
	
}
