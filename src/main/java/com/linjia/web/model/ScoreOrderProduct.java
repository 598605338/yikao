package com.linjia.web.model;

import java.math.BigDecimal;

public class ScoreOrderProduct {

	private Long card_coupon_id;
	
	private Integer quantity;
	
	private String p_code;
	
	private String p_name;
	
	private BigDecimal market_price;
	
	private BigDecimal sale_price;
	
	private Integer score;

	public Long getCard_coupon_id() {
		return card_coupon_id;
	}

	public void setCard_coupon_id(Long card_coupon_id) {
		this.card_coupon_id = card_coupon_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public BigDecimal getMarket_price() {
		return market_price;
	}

	public void setMarket_price(BigDecimal market_price) {
		this.market_price = market_price;
	}

	public BigDecimal getSale_price() {
		return sale_price;
	}

	public void setSale_price(BigDecimal sale_price) {
		this.sale_price = sale_price;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}
