package com.linjia.web.thirdService.baidu.model;

import java.util.List;

public class Goods {

	//合作方商户唯一 ID	
	private String shop_id;
	//UPC码
	private String upc;
	//UPC名称
	private String name;
	//商品状态	1上架，0下架
	private Integer status;
	//品牌ID，和品牌名称必填其一。
	private Integer brand_id;
	//品牌名称，和品牌名称必填其一。
	private String brand_name;	
	//一级分类ID
	private Integer cat1_id;	
	//二级分类ID
	private Integer cat2_id;
	//三级分类ID
	private Integer cat3_id;
	//商品图片,图片上传为异步模式，不会立刻生效
	private List<Photo> photos;		
	//简介描述,长度限制：6000个字符
	private String desc;
	//库存数量	范围：0~9999
	private Integer left_num;
	//销售价格,单位：分	单位：分，范围：1~99999900
	private Integer sale_price;
	//市场价格，单位：分	单位：分，范围：1~99999900
	private Integer market_price;
	//商品skuId
	private String sku_id;
	//商品skuId对应库存
	private String skuid_stocks;
	//商品skuId对应价格
	private String skuid_price;
	
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public Integer getCat1_id() {
		return cat1_id;
	}
	public void setCat1_id(Integer cat1_id) {
		this.cat1_id = cat1_id;
	}
	public Integer getCat2_id() {
		return cat2_id;
	}
	public void setCat2_id(Integer cat2_id) {
		this.cat2_id = cat2_id;
	}
	public Integer getCat3_id() {
		return cat3_id;
	}
	public void setCat3_id(Integer cat3_id) {
		this.cat3_id = cat3_id;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getLeft_num() {
		return left_num;
	}
	public void setLeft_num(Integer left_num) {
		this.left_num = left_num;
	}
	public Integer getSale_price() {
		return sale_price;
	}
	public void setSale_price(Integer sale_price) {
		this.sale_price = sale_price;
	}
	public Integer getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Integer market_price) {
		this.market_price = market_price;
	}
	public String getSku_id() {
		return sku_id;
	}
	public void setSku_id(String sku_id) {
		this.sku_id = sku_id;
	}
	public String getSkuid_stocks() {
		return skuid_stocks;
	}
	public void setSkuid_stocks(String skuid_stocks) {
		this.skuid_stocks = skuid_stocks;
	}
	public String getSkuid_price() {
		return skuid_price;
	}
	public void setSkuid_price(String skuid_price) {
		this.skuid_price = skuid_price;
	}	
	
	
}
