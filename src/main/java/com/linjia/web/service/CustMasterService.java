package com.linjia.web.service;


import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.linjia.base.service.BaseService;
import com.linjia.web.model.CustMaster;
import com.linjia.web.model.QueryCustMaster;
import com.linjia.web.query.MemberQuery;

public interface CustMasterService extends BaseService<CustMaster, Long>{
	
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
	CustMaster insertOrUpdate(JSONObject data,String phone);
	
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
	 * @param deleted
	 * @param useFlg
	 * @return
	 */
	int updateMember(String phone,Integer deleted,Integer useFlg);
	
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
