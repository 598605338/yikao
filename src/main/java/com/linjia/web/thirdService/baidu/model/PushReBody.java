package com.linjia.web.thirdService.baidu.model;

public class PushReBody {

	private Integer errno;
	
	private String error;
	
	private PushReData data;

	public Integer getErrno() {
		return errno;
	}

	public void setErrno(Integer errno) {
		this.errno = errno;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public PushReData getData() {
		return data;
	}

	public void setData(PushReData data) {
		this.data = data;
	}

	/**
	 * @param errno
	 * @param error
	 * @param data
	 */
	public PushReBody(Integer errno, String error, PushReData data) {
		super();
		this.errno = errno;
		this.error = error;
		this.data = data;
	}
	
}
