package com.linjia.web.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ActivityAdvertise {

	//主键id
	private Integer id;
	//活动id
	private Integer activity_id;
	//活动名称
	private String activity_name;
	//图片
	private String picture;
	private MultipartFile uploadImage;
	//活动规则
	private String activity_rule;
	//创建时间
	private Date create_time; 
	//更新时间
	private Date update_time;
	//活动广告类型(1,秒杀;2，拼团;3,预约;4,积分;5,尾货)
	private Integer activity_type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getActivity_rule() {
		return activity_rule;
	}
	public void setActivity_rule(String activity_rule) {
		this.activity_rule = activity_rule;
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
	public Integer getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(Integer activity_type) {
		this.activity_type = activity_type;
	}
	public MultipartFile getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(MultipartFile uploadImage) {
		this.uploadImage = uploadImage;
	}
}
