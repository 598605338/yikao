package com.linjia.web.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class AdvertisePosition {

	//主键
	private Integer id;
	//首页功能区位
	private Integer position;
	//广告位名称
	private String ad_position_name;
	//图片
	private String picture;
	private MultipartFile uploadImage;
	//链接
	private String ad_link;
	//数量
	private Integer nums;
	//创建时间
	private Date create_time; 
	//更新时间
	private Date update_time;
	//数量减1
	private Integer downNums;
	//广告类型(1,banner;2,秒杀；3，新品试吃；4，拼团；5，会员活动；6，预约购买；
	//7，尾货清仓；8，领券中心；9，积分商城；10，新品推荐)
	private Integer ad_type;
	
	private String updPicture;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public String getAd_position_name() {
		return ad_position_name;
	}
	public void setAd_position_name(String ad_position_name) {
		this.ad_position_name = ad_position_name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getAd_link() {
		return ad_link;
	}
	public void setAd_link(String ad_link) {
		this.ad_link = ad_link;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
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
	public Integer getDownNums() {
		return downNums;
	}
	public void setDownNums(Integer downNums) {
		this.downNums = downNums;
	}
	public String getUpdPicture() {
		return updPicture;
	}
	public void setUpdPicture(String updPicture) {
		this.updPicture = updPicture;
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
}
