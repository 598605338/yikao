package com.linjia.web.query;

import java.math.BigDecimal;

import com.linjia.base.query.Query;

public class BdOrderProductQuery extends Query{

	//id
		private Integer id;
		//订单id
		private Long orderId;
		//商品code
		private String pCode;
		//商品名称
		private String pName;
		//商品数量
		private Integer quantity;
		//商品项价格
		private BigDecimal itemPrice;
		//商品图片地址
		private String imagePath;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Long getOrderId() {
			return orderId;
		}
		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}
		public String getpCode() {
			return pCode;
		}
		public void setpCode(String pCode) {
			this.pCode = pCode;
		}
		public String getpName() {
			return pName;
		}
		public void setpName(String pName) {
			this.pName = pName;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public BigDecimal getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(BigDecimal itemPrice) {
			this.itemPrice = itemPrice;
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
}
