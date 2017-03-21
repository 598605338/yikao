package com.linjia.web.thirdService.baidu.model;

import java.util.Date;
import java.util.List;

import com.linjia.tools.JSONUtil;

/**
 * 百度官网返回数据，用于插入数据到本地数据库
 * @author xiangshouyi
 *
 */
public class BaiduData{

	//id
	private Integer id;
	
	//合作方账号
	private String source;
	
	//商户信息
	private BdShop shop;
	
	//订单信息
	private Order order;
	
	//顾客信息
	private BdUser user;
	
	//商品信息,插入数据库数据
	private String proListStr;
	
	//优惠信息,插入数据库数据
	private String discLListStr;
	
	//商品信息 ,接收前台数据
	private List<Product> products;
	
	//优惠信息,接收前台数据
	private List<Discount> discount;
	
	//
	private Integer errno;
	
	//
	private String error;
	
	//
	private Date createtime;
	
	private Integer deleted;
	
	private String uhd_order_id;
	
	private String uhd_refund_order_id;
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public BdShop getShop() {
		return shop;
	}

	public void setShop(BdShop shop) {
		this.shop = shop;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BdUser getUser() {
		return user;
	}

	public void setUser(BdUser user) {
		this.user = user;
	}

	public String getProListStr() {
		List<Product> proList=this.getProducts();
		if(proList!=null){
		 if(proList.size()>0){
			 proListStr=JSONUtil.toJson(proList).toString();
		 }
		}
		return proListStr;
	}

	public void setProListStr(String proListStr) {
		this.proListStr = proListStr;
	}

	public String getDiscLListStr() {
		List<Discount> disList=this.getDiscount();
		if(disList!=null){
			 if(disList.size()>0){
				 discLListStr=JSONUtil.toJson(disList).toString();
			 }
		}
		return discLListStr;
	}

	public void setDiscLListStr(String discLListStr) {
		this.discLListStr = discLListStr;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Discount> getDiscount() {
		return discount;
	}

	public void setDiscount(List<Discount> discount) {
		this.discount = discount;
	}

	public Integer getErrno() {
		return errno;
	}

	public void setErrno(Integer errno) {
		this.errno = errno;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
