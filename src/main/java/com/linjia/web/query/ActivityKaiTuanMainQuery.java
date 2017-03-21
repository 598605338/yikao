package com.linjia.web.query;

import java.math.BigDecimal;
import java.util.Date;

import com.linjia.base.query.Query;

public class ActivityKaiTuanMainQuery extends Query{
	
	//主键，开团id
	private Integer id;
	
	//拼团表Id
	private Integer baseId;
	
	//开团用户Id
	private String kt_userId;
	
	//当前参团人数
	private Integer cur_num;
	
	//当前拼团状态
	private Integer state;
	
	//创建时间
	private Date create_time;
	
	//加入拼团时间
	private Date joinTime;
	
	//团购结束时间
	private Date end_time;
	
	//拼团商品标题
	private String p_name;
	
	//拼团商品价格
	private BigDecimal pt_price;
	
	//参团用户Id
	private String userId;
	
	//是否已删除标识负(0,正常 ；1，已删除)
	private Boolean deleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBaseId() {
		return baseId;
	}

	public void setBaseId(Integer baseId) {
		this.baseId = baseId;
	}

	public String getKt_userId() {
		return kt_userId;
	}

	public void setKt_userId(String kt_userId) {
		this.kt_userId = kt_userId;
	}

	public Integer getCur_num() {
		return cur_num;
	}

	public void setCur_num(Integer cur_num) {
		this.cur_num = cur_num;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public BigDecimal getPt_price() {
		return pt_price;
	}

	public void setPt_price(BigDecimal pt_price) {
		this.pt_price = pt_price;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
}
