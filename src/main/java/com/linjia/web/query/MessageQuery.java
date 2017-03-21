package com.linjia.web.query;

import java.util.Date;

import com.linjia.base.query.Query;

public class MessageQuery extends Query{

	//id
	private int id;
	//手机号
	private String mobile;
	//验证码
	private String checkcode;
	//创建时间
	private Date createtime;
	//失效时间
	private Date endtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	
}
