package com.linjia.web.thirdService.baidu.model;

public class Page {

	//查询起始时间
	private Integer start_time;
	//查询结束时间
	private Integer end_time;
	//查询特定状态订单，订单状态参考附录。可以指定多个状态，需用逗号分隔
	private String status;
	//订单列表分页返回，该参数指定页数
	private Integer page;
	
	public Integer getStart_time() {
		return start_time;
	}
	public void setStart_time(Integer start_time) {
		this.start_time = start_time;
	}
	public Integer getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Integer end_time) {
		this.end_time = end_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
}
