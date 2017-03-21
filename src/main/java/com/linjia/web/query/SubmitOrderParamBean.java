package com.linjia.web.query;


/**
 * SubmitOrder使用参数
 * @author lixinling
 * 2016年7月22日 上午11:43:08
 */
public class SubmitOrderParamBean{
	private String[] pCodeArray;
	private String mallCode;
	
	public String[] getpCodeArray() {
		return pCodeArray;
	}
	public void setpCodeArray(String[] pCodeArray) {
		this.pCodeArray = pCodeArray;
	}
	public String getMallCode() {
		return mallCode;
	}
	public void setMallCode(String mallCode) {
		this.mallCode = mallCode;
	}
	public SubmitOrderParamBean(String[] pCodeArray, String mallCode) {
		this.pCodeArray = pCodeArray;
		this.mallCode = mallCode;
	}
	public SubmitOrderParamBean() {
	}
}