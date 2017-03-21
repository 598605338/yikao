package com.linjia.web.model;

import java.util.Date;

public class AdvitisePage {

	private Integer id;
	private String page_name;
	private Integer page_type;
	private String page_link;
	private Date create_time;
	private Date update_time;
	private String htmlContent;
	private Integer typeNo;
	private Integer deleted;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPage_name() {
		return page_name;
	}
	public void setPage_name(String page_name) {
		this.page_name = page_name;
	}
	public Integer getPage_type() {
		return page_type;
	}
	public void setPage_type(Integer page_type) {
		this.page_type = page_type;
	}
	public String getPage_link() {
		return page_link;
	}
	public void setPage_link(String page_link) {
		this.page_link = page_link;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public String getHtmlContent() {
		return htmlContent;
	}
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	public Integer getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(Integer typeNo) {
		this.typeNo = typeNo;
	}
	
}
