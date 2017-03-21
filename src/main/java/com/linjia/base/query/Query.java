package com.linjia.base.query;

/** 
 * 公共查询类
 * @author  lixinling: 
 * @date 2016年7月6日 上午9:37:39 
 * @version 1.0 
 */
public class Query {
	/**
	 * 分页后的记录开始的地方 
	 */
	private int startRow;
	/**
	 * 分页后的记录结束的地方
	 */
	private int endRow;

	/** 每页大小 */
	private int pageSize;

	/** 当前页 */
	private Integer pageIndex;

	/** 开始记录（Mysql） */
	private int startIndex;
	/**当前页*/
	private int page;
	/**每页记录数*/
	private int rows;
	/**总记录数*/
	private int totalNums;
	
	/**导出flag*/
	private Integer exportFlag;

	public int getStartIndex() {
		if (startIndex == 0 && getStartRow() > 0) {
			return getStartRow() - 1;
		}

		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPageIndex() {
		return (pageIndex == null || pageIndex == 0) ? 1 : pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * 默认构造函数
	 */
	public Query() {
	}

	/**
	 * 构造函数（带分页信息）
	 */
	public Query(int pageIndex, int pageSize) {
		setPageIndex(pageIndex);
		setPageSize(pageSize);
	}

	public int getStartRow() {
		int start = this.startRow;
		if (start == 0) {
			start = (getPageIndex() - 1) * getPageSize() + 1;
		}
		return start;
	}

	public int getEndRow() {
		int end = this.endRow;
		if (end == 0) {
			end = getPageIndex() * getPageSize();
		}
		return end;
	}

	public int getPageSize() {
		if (pageSize == 0)
			pageSize = 10;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getPage() {
		return (page == 0) ? 1 : page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Integer getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(Integer exportFlag) {
		this.exportFlag = exportFlag;
	}

	public int getTotalNums() {
		return totalNums;
	}

	public void setTotalNums(int totalNums) {
		this.totalNums = totalNums;
	}
	
}
