package com.linjia.web.service;

import java.util.List;

import com.linjia.web.model.AdvitisePage;

public interface AdvertisePageService{

	/**
	 * 插入制作页面信息数据
	 * @param info
	 * @return
	 */
	boolean insertAdvPage(AdvitisePage info);
	
	/**
	 * 更新制作页面信息数据
	 * @param info
	 * @return
	 */
	boolean updateAdvPageById(AdvitisePage info);
	
	/**
	 * 删除制作页面信息数据
	 * @param id
	 * @return
	 */
	boolean deleteAdvPageById(int id);
	

	/**
	 * 查询单条制作页面信息数据
	 * @param id
	 * @return
	 */
	AdvitisePage selectAdvPageById(int id);
	

	/**
	 * 查询多条制作页面信息数据
	 * @param
	 * @return
	 */
	List<AdvitisePage> selectAdvPageAll();
	
}
