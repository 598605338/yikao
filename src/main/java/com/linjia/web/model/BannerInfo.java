package com.linjia.web.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BannerInfo {

	//主键
	private Integer id;
	//排序
	private Integer order_px;
	//banner名称
	private String banner_name;
	//图片
	private String ban_picture;
	//
	private MultipartFile uploadImage;
	//链接
	private String ban_link;
	//关联广告id
	private Integer ad_id;
	//广告类型(1,banner;2,秒杀；3，新品试吃；4，拼团；5，会员活动；6，预约购买；
	//7，尾货清仓；8，领券中心；9，积分商城；10，新品推荐)
	private Integer ad_type;
	//创建时间
	private Date create_time; 
	//更新时间
	private Date update_time;
	
	private String p_code;
	
	private Long productId;
	
	private String baseInfos;
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrder_px() {
		return order_px;
	}
	public void setOrder_px(Integer order_px) {
		this.order_px = order_px;
	}
	public String getBanner_name() {
		return banner_name;
	}
	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}
	public String getBan_picture() {
		return ban_picture;
	}
	public void setBan_picture(String ban_picture) {
		this.ban_picture = ban_picture;
	}
	public String getBan_link() {
		return ban_link;
	}
	public void setBan_link(String ban_link) {
		this.ban_link = ban_link;
	}
	public Integer getAd_id() {
		return ad_id;
	}
	public void setAd_id(Integer ad_id) {
		this.ad_id = ad_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Integer getAd_type() {
		return ad_type;
	}
	public void setAd_type(Integer ad_type) {
		this.ad_type = ad_type;
	}
	
	public MultipartFile getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(MultipartFile uploadImage) {
		this.uploadImage = uploadImage;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getBaseInfos() {
		return baseInfos;
	}
	public void setBaseInfos(String baseInfos) {
		this.baseInfos = baseInfos;
	}
	
	
}
