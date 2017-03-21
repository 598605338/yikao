package com.linjia.web.query;


/** 
 * 请求ERP或CRM专用Bean
 * @author  lixinling: 
 * @date 2016年8月4日 下午5:11:49 
 * @version 1.0 
*/
public class QueryParameterBean {
	String type;
	String value;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
