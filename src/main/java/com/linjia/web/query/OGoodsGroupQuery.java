package com.linjia.web.query;

import com.linjia.base.query.Query;

public class OGoodsGroupQuery extends Query{
	
	private String order_id;
	
	private Long categoryId;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	
}
