package com.linjia.web.thirdService.baidu.model;

import java.util.List;

public class Shop {

	// id
	private String id;
	//商户名称
	private String mall_name;
//	//百度商户id
	private String baidu_shop_id;
	//合作方商户唯一 ID
	private String mall_code;
	
	private String name;
	
	private String shop_logo;
	
	private String province;
	
	private String city;
	
	private String county;
	
	private String address;
	
	private String brand;
	
	private List<Category> categorys;
	
	private String phone;
	
	private String service_phone;
	
	private Float longitude;
	
	private Float latitude;
	
	private String coord_type;

	private List<Delivery_region> delivery_region;
	
	private List<BusinessTime> business_time;

	private String book_ahead_time;
	
	private Integer invoice_support;
	
	private Integer min_order_price;
	
	private Integer package_box_price;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBaidu_shop_id() {
		return baidu_shop_id;
	}

	public void setBaidu_shop_id(String baidu_shop_id) {
		this.baidu_shop_id = baidu_shop_id;
	}

	public String getMall_name() {
		return mall_name;
	}

	public void setMall_name(String mall_name) {
		this.mall_name = mall_name;
	}

	public String getMall_code() {
		return mall_code;
	}

	public void setMall_code(String mall_code) {
		this.mall_code = mall_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShop_logo() {
		return shop_logo;
	}

	public void setShop_logo(String shop_logo) {
		this.shop_logo = shop_logo;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getService_phone() {
		return service_phone;
	}

	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}


	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String getCoord_type() {
		return coord_type;
	}

	public void setCoord_type(String coord_type) {
		this.coord_type = coord_type;
	}


	public String getBook_ahead_time() {
		return book_ahead_time;
	}

	public void setBook_ahead_time(String book_ahead_time) {
		this.book_ahead_time = book_ahead_time;
	}


	public Integer getInvoice_support() {
		return invoice_support;
	}

	public void setInvoice_support(Integer invoice_support) {
		this.invoice_support = invoice_support;
	}

	public Integer getMin_order_price() {
		return min_order_price;
	}

	public void setMin_order_price(Integer min_order_price) {
		this.min_order_price = min_order_price;
	}

	public Integer getPackage_box_price() {
		return package_box_price;
	}

	public void setPackage_box_price(Integer package_box_price) {
		this.package_box_price = package_box_price;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public List<Delivery_region> getDelivery_region() {
		return delivery_region;
	}

	public void setDelivery_region(List<Delivery_region> delivery_region) {
		this.delivery_region = delivery_region;
	}

	public List<BusinessTime> getBusiness_time() {
		return business_time;
	}

	public void setBusiness_time(List<BusinessTime> business_time) {
		this.business_time = business_time;
	}

	
}
