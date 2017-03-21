package com.linjia.web.thirdService.baidu.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.linjia.web.thirdService.baidu.model.Order;
import com.linjia.web.thirdService.baidu.model.Shop;
import com.linjia.web.thirdService.baidu.model.User;

/**
 * 数据库订单查询返回数据
 * @author xiangshouyi
 *
 */
public class BaiduReOrder{

		//id
		private long id;
		
	    //订单id
		private String order_id;
		
		//合作方账号
		private String source;
		
		//商户信息
		private Shop shop;
		
		//订单信息
		private Order order;
		
		//顾客信息
		private User user;
		
		//产品信息，后台返回对象
		@JsonIgnore
		private String productList;
		
		//产品信息，返回前台对象
		private List<Product> products;
		
		//优惠信息后台返回字符窜
		@JsonIgnore
		private String discountList;
		
		//优惠信息，返回前台对象
		private List<Discount> discount;

		//
		private String ticket;
		
		//
		private Long timestamp;
		
		//
		private String version;
		
		//
		private Date createtime;
		
		@JsonIgnore
		private Integer deleted;
		
		
		private Integer status;
		private Date recive_time;
		private Integer orderNum;
		private Integer urgeNum;
		private String cancelReason;
		private Integer cancelCode;
		
		private String uhd_order_id;
		
		private String uhd_refund_order_id;

		
		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public Shop getShop() {
			return shop;
		}

		public void setShop(Shop shop) {
			this.shop = shop;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		

		public String getProductList() {
			return productList;
		}

		public void setProductList(String productList) {
			this.productList = productList;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		public String getDiscountList() {
			return discountList;
		}

		public void setDiscountList(String discountList) {
			this.discountList = discountList;
		}

		public List<Discount> getDiscount() {
			return discount;
		}

		public void setDiscount(List<Discount> discount) {
			this.discount = discount;
		}

		public String getTicket() {
			return ticket;
		}

		public void setTicket(String ticket) {
			this.ticket = ticket;
		}

		public Long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Long timestamp) {
			this.timestamp = timestamp;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getOrder_id() {
			return order_id;
		}

		public void setOrder_id(String order_id) {
			this.order_id = order_id;
		}

		public Date getCreatetime() {
			return createtime;
		}

		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
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

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Date getRecive_time() {
			return recive_time;
		}

		public void setRecive_time(Date recive_time) {
			this.recive_time = recive_time;
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
