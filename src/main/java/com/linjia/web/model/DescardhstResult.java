package com.linjia.web.model;

import java.math.BigDecimal;


/** 
 * 根据自定义查询条件, 查询储值流水
 * @author  lixinling: 
 * @date 2016年8月4日 下午5:28:00 
 * @version 1.0 
*/
public class DescardhstResult {
	private String xid;
	private String tranId;
	private String terminalId;
	private String created;
	private String originCode;
	private String cardNum;
	private String state;
	private String tranTime;
	private String action;
	private String remark;
	private BigDecimal occur;
	public String getXid() {
		return xid;
	}
	public void setXid(String xid) {
		this.xid = xid;
	}
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getOriginCode() {
		return originCode;
	}
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public BigDecimal getOccur() {
		return occur;
	}
	public void setOccur(BigDecimal occur) {
		this.occur = occur;
	}
	
	
}
