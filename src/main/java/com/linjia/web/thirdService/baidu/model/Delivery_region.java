package com.linjia.web.thirdService.baidu.model;

import java.util.List;

public class Delivery_region {

	private String name;
	
	private List<List<Coord>> region;
	
	private String delivery_time;
	
	private int delivery_fee;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<List<Coord>> getRegion() {
		return region;
	}

	public void setRegion(List<List<Coord>> region) {
		this.region = region;
	}


	public String getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}

	public int getDelivery_fee() {
		return delivery_fee;
	}

	public void setDelivery_fee(int delivery_fee) {
		this.delivery_fee = delivery_fee;
	}
	
	
}
