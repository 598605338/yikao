package com.linjia.web.query;

import java.util.List;



/** 
 * 请求ERP或CRM专用Bean
 * @author  lixinling: 
 * @date 2016年8月4日 下午5:14:06 
 * @version 1.0 
*/
public class QueryDefinitionBean {
	List<QueryConditionBean> conditions;
	List<OrderDirectionBean> orders;
	int pageSize;
	int page;
	int probePages;
	public List<QueryConditionBean> getConditions() {
		return conditions;
	}
	public void setConditions(List<QueryConditionBean> conditions) {
		this.conditions = conditions;
	}
	public List<OrderDirectionBean> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDirectionBean> orders) {
		this.orders = orders;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getProbePages() {
		return probePages;
	}
	public void setProbePages(int probePages) {
		this.probePages = probePages;
	}
	public QueryDefinitionBean(int pageSize, int page, int probePages) {
		super();
		this.pageSize = pageSize;
		this.page = page;
		this.probePages = probePages;
	}
	public QueryDefinitionBean() {
	}
	
}
