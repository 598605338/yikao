package com.linjia.web.query;

import java.util.Date;

import com.linjia.base.query.Query;

public class ActivityKaiTuanUsersQuery extends Query{
	
	//主键id
	private Integer id;
	
	//参团用户id
	private String userId;
	
	//开团主表id
	private String kt_id;
	
	//参团时间
    private Date create_time;
    
	//订单id
	private Long orderId;
    
	//是否已经删除表示符
	private Boolean deleted;
	
	public ActivityKaiTuanUsersQuery(){
		
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

	public String getKt_id() {
		return kt_id;
	}

	public void setKt_id(String kt_id) {
		this.kt_id = kt_id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

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
