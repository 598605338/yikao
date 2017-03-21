package com.linjia.web.query;

import java.util.List;




/** 
 * 请求ERP或CRM专用Bean
 * @author  lixinling: 
 * @date 2016年8月4日 下午5:12:38 
 * @version 1.0 
*/
public class QueryConditionBean {
	private String operation;
	private List<QueryParameterBean> parameters;
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public List<QueryParameterBean> getParameters() {
		return parameters;
	}
	public void setParameters(List<QueryParameterBean> parameters) {
		this.parameters = parameters;
	} 
}
