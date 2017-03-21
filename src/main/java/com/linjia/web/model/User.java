package com.linjia.web.model;

public class User {
	private String userId;
	private int age;
	private int id;
	private String userName;
	private int type;
	private String pCode;
	private long num;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public User() {
	}
	public User(int id, int age, String userName, int type, String pCode, long num,String userId) {
		super();
		this.userId = userId;
		this.id = id;
		this.age = age;
		this.userName = userName;
		this.type = type;
		this.pCode = pCode;
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "[User:"+userId+":"+age+":"+userName+"]";
	}
}
