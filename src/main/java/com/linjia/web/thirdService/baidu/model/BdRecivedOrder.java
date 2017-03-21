package com.linjia.web.thirdService.baidu.model;

public class BdRecivedOrder {

	public BaiduData body;
	public String cmd;
	public String  sign;
	public String  source;
	public String  ticket;
	public String  timestamp;
	public String  version;
	public BaiduData getBody() {
		return body;
	}
	public void setBody(BaiduData body) {
		this.body = body;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
