package com.linjia.web.thirdService.baidu.model;


public class BdUser {

	//id
	private String user_id;
	
	
	//顾客姓名
	private String name;
	//顾客电话
	private String phone;
	//顾客性别 1,男 2 女
	private Integer gender;
	//送餐地址百度经度
	private String address;
	//经纬度
	private Coord coord;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	
}
