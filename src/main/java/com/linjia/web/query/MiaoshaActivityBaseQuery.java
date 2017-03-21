package com.linjia.web.query;

import java.util.Date;

import com.linjia.base.query.Query;


/** 
 * @author  lixinling: 
 * @date 2016年7月6日 上午10:14:33 
 * @version 1.0 
 */
public class MiaoshaActivityBaseQuery extends Query {
	private Long id;
	private String name;
	private String nameQuery;
	private String bannerPath;
	private Date panicBuyingStartTime;
	private Date panicBuyingEndTime;
	private boolean qmType;
	private boolean checkSellType;
	private String unstartActivityTip;
	private String endedActivityTip;
	private String sellOutTip;
	private String description;
	
	
	/** 活动状态(1：即将开始；2:抢购中；3:已结束；)* */
	private String activityStatus;
	
	/**
	 * 当前时间(1:9点；2:12点；3:15点；4:18点)
	 */
	private Date currentTime;
	/**
	 * 时间节点(1:9点；2:12点；3:15点；4:18点)
	 */
	private Integer timeNode;
	/**
	 * 发布日期start
	 */
	private String publishDateStart;
	/**
	 * 发布日期end
	 */
	private String publishDateEnd;
	
	private Date creDateStart;
	private Date creDateEnd;
	private String creDateStartStr;
	private String creDateEndStr;
	
	/** 活动开始时间* */
	private Date startTime;
	
	/** 活动结束时间* */
	private Date endTime;
	
	/** 活动开始时间* */
	private String startTimeStr;
	
	/** 活动结束时间* */
	private String endTimeStr;
	
	/** 时间段* */
    private String timeSlot;
	
	
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBannerPath() {
		return bannerPath;
	}
	public void setBannerPath(String bannerPath) {
		this.bannerPath = bannerPath;
	}
	public Date getPanicBuyingStartTime() {
		return panicBuyingStartTime;
	}
	public void setPanicBuyingStartTime(Date panicBuyingStartTime) {
		this.panicBuyingStartTime = panicBuyingStartTime;
	}
	public Date getPanicBuyingEndTime() {
		return panicBuyingEndTime;
	}
	public void setPanicBuyingEndTime(Date panicBuyingEndTime) {
		this.panicBuyingEndTime = panicBuyingEndTime;
	}
	public boolean isQmType() {
		return qmType;
	}
	public void setQmType(boolean qmType) {
		this.qmType = qmType;
	}
	public boolean isCheckSellType() {
		return checkSellType;
	}
	public void setCheckSellType(boolean checkSellType) {
		this.checkSellType = checkSellType;
	}
	public String getUnstartActivityTip() {
		return unstartActivityTip;
	}
	public void setUnstartActivityTip(String unstartActivityTip) {
		this.unstartActivityTip = unstartActivityTip;
	}
	public String getEndedActivityTip() {
		return endedActivityTip;
	}
	public void setEndedActivityTip(String endedActivityTip) {
		this.endedActivityTip = endedActivityTip;
	}
	public String getSellOutTip() {
		return sellOutTip;
	}
	public void setSellOutTip(String sellOutTip) {
		this.sellOutTip = sellOutTip;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getTimeNode() {
		return timeNode;
	}
	public void setTimeNode(Integer timeNode) {
		this.timeNode = timeNode;
	}
	public Date getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}
	public String getPublishDateStart() {
		return publishDateStart;
	}
	public void setPublishDateStart(String publishDateStart) {
		this.publishDateStart = publishDateStart;
	}
	public String getPublishDateEnd() {
		return publishDateEnd;
	}
	public void setPublishDateEnd(String publishDateEnd) {
		this.publishDateEnd = publishDateEnd;
	}
	public Date getCreDateStart() {
		return creDateStart;
	}
	public void setCreDateStart(Date creDateStart) {
		this.creDateStart = creDateStart;
	}
	public Date getCreDateEnd() {
		return creDateEnd;
	}
	public void setCreDateEnd(Date creDateEnd) {
		this.creDateEnd = creDateEnd;
	}
	public String getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStartTimeStr() {
		return startTimeStr;
	}
	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}
	public String getEndTimeStr() {
		return endTimeStr;
	}
	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}
	public String getCreDateStartStr() {
		return creDateStartStr;
	}
	public void setCreDateStartStr(String creDateStartStr) {
		this.creDateStartStr = creDateStartStr;
	}
	public String getCreDateEndStr() {
		return creDateEndStr;
	}
	public void setCreDateEndStr(String creDateEndStr) {
		this.creDateEndStr = creDateEndStr;
	}
	public String getNameQuery() {
		return nameQuery;
	}
	public void setNameQuery(String nameQuery) {
		this.nameQuery = nameQuery;
	}
	
	
}
