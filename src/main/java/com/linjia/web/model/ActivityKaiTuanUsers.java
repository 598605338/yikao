package com.linjia.web.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.linjia.tools.DateSerializeUtils;

public class ActivityKaiTuanUsers{

	//主键id
	private Integer id;
	
	//参团用户id
	private String userId;
	
	//开团主表id
	private Integer kt_id;
	
	//订单id
	private Long orderId;
	
	//参团时间
	private Date create_time;
	
	//是否已经删除表示符
	@JsonIgnore
	private Boolean deleted;
	
	public ActivityKaiTuanUsers(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getKt_id() {
		return kt_id;
	}

	public void setKt_id(Integer kt_id) {
		this.kt_id = kt_id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@JsonSerialize(using = DateSerializeUtils.class)
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}
