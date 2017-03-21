package com.linjia.web.query;

import java.math.BigDecimal;
import java.util.Date;

import com.linjia.base.query.Query;

public class ActivityInfoQuery extends Query{


	private Integer activity_id;
	private String activity_name;
	private Integer activity_type;
	private Date start_time;
	private Date end_time;
	private Integer priority;
	private BigDecimal discount;
	private String mall_codes;
	private String promotion_label;
	private Integer if_add;
	private Integer if_useCardCoupons;
	private Integer if_useCashCoupons;
	private Integer if_first_work;
	private Integer status;
	private Date create_time;
	private Date update_time;
	private BigDecimal promotion_condition_1;
	private Integer promotion_condition_2;
	private String fullReduceMoney;
	private Integer selector_goods;
	private String beginDate;
	private String endDate;
	
	public Integer getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public Integer getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(Integer activity_type) {
		this.activity_type = activity_type;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public String getMall_codes() {
		return mall_codes;
	}
	public void setMall_codes(String mall_codes) {
		this.mall_codes = mall_codes;
	}
	public String getPromotion_label() {
		return promotion_label;
	}
	public void setPromotion_label(String promotion_label) {
		this.promotion_label = promotion_label;
	}
	public Integer getIf_add() {
		return if_add;
	}
	public void setIf_add(Integer if_add) {
		this.if_add = if_add;
	}
	public Integer getIf_useCardCoupons() {
		return if_useCardCoupons;
	}
	public void setIf_useCardCoupons(Integer if_useCardCoupons) {
		this.if_useCardCoupons = if_useCardCoupons;
	}
	public Integer getIf_useCashCoupons() {
		return if_useCashCoupons;
	}
	public void setIf_useCashCoupons(Integer if_useCashCoupons) {
		this.if_useCashCoupons = if_useCashCoupons;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public Integer getIf_first_work() {
		return if_first_work;
	}
	public void setIf_first_work(Integer if_first_work) {
		this.if_first_work = if_first_work;
	}
	public BigDecimal getPromotion_condition_1() {
		return promotion_condition_1;
	}
	public void setPromotion_condition_1(BigDecimal promotion_condition_1) {
		this.promotion_condition_1 = promotion_condition_1;
	}
	public Integer getPromotion_condition_2() {
		return promotion_condition_2;
	}
	public void setPromotion_condition_2(Integer promotion_condition_2) {
		this.promotion_condition_2 = promotion_condition_2;
	}
	public String getFullReduceMoney() {
		return fullReduceMoney;
	}
	public void setFullReduceMoney(String fullReduceMoney) {
		this.fullReduceMoney = fullReduceMoney;
	}
	public Integer getSelector_goods() {
		return selector_goods;
	}
	public void setSelector_goods(Integer selector_goods) {
		this.selector_goods = selector_goods;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
