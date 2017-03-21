package com.linjia.web.thirdService.baidu.model;

public class Photo{

	//图片地址	格式为PNG、JPG、JPEG，单张小于1.2M，尺寸为500*500像素
	private String url;
	//是否为首图	（1是 0否）,必需有一张首图
	private Integer is_master;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIs_master() {
		return is_master;
	}
	public void setIs_master(Integer is_master) {
		this.is_master = is_master;
	}
	
}
