package com.linjia.web.thirdService.baidu.model;

public class Discount {

	private String type;
	
	private Integer fee;
	
	private String acticity_id;
	
	private String rule_id;
	
	private String baidu_rate;
	
	private String shop_rate;
	
	private String agent_rate;
	
	private String logistics_rate;
	
	private String desc;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActicity_id() {
		return acticity_id;
	}

	public void setActicity_id(String acticity_id) {
		this.acticity_id = acticity_id;
	}

	public String getRule_id() {
		return rule_id;
	}

	public void setRule_id(String rule_id) {
		this.rule_id = rule_id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public String getBaidu_rate() {
		return baidu_rate;
	}

	public void setBaidu_rate(String baidu_rate) {
		this.baidu_rate = baidu_rate;
	}

	public String getShop_rate() {
		return shop_rate;
	}

	public void setShop_rate(String shop_rate) {
		this.shop_rate = shop_rate;
	}

	public String getAgent_rate() {
		return agent_rate;
	}

	public void setAgent_rate(String agent_rate) {
		this.agent_rate = agent_rate;
	}

	public String getLogistics_rate() {
		return logistics_rate;
	}

	public void setLogistics_rate(String logistics_rate) {
		this.logistics_rate = logistics_rate;
	}
	
}
