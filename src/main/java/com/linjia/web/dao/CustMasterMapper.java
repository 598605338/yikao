package com.linjia.web.dao;

import java.util.List;
import java.util.Map;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.CustMaster;
import com.linjia.web.model.QueryCustMaster;
import com.linjia.web.query.MemberQuery;

public interface CustMasterMapper extends BaseDao<CustMaster, Long> {
	
	/**
	 * 根据登陆手机号查询用户的login
	 * lixinling 
	 * 2016年8月12日 下午1:45:48
	 * @param model
	 * @return
	 */
	String selectLoginByPrimaryKey(Long userId);
	
	/**
	 * 当用户记录存在时进行更新，不存在时进行插入
	 * lixinling 
	 * 2016年8月12日 下午1:45:48
	 * @param model
	 * @return
	 */
	int insertOrUpdate(CustMaster model);
	
	/**
	 * 查询会员列表
	 * lixinling 
	 * 2016年8月12日 下午1:45:48
	 * @param phone
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<QueryCustMaster> selectMembers(MemberQuery query);
	
	/**
	 * 更新会员状态和删除
	 * lixinling 
	 * 2016年8月12日 下午1:45:48
	 * @param phone
	 * @param useFlg
	 * @param deleted
	 * @return
	 */
	int updateMember(Map<String,Object> map);
	
	/**
	 * 查询会员总数
	 * @return
	 */
	int selectCustNums(MemberQuery query);
	
	/**
	 * 根据会员手机号查询userId
	 * @return
	 */
	List<Map<String, String>> selectUserIdByPhone(List<Map<String, String>> list);
}