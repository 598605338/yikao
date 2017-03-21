package com.linjia.web.query;


/** 
 * 请求ERP或CRM专用Bean
 * @author  lixinling: 
 * @date 2016年8月4日 下午5:13:33 
 * @version 1.0 
*/
public class OrderDirectionBean {
	private String field;
	private String direction;
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
