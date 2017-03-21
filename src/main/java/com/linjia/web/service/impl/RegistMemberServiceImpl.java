package com.linjia.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.constants.Constants;
import com.linjia.tools.Util;
import com.linjia.web.dao.RegistMemberMapper;
import com.linjia.web.model.RegistMember;
import com.linjia.web.service.RegistMemberService;

@Service
@Transactional
public class RegistMemberServiceImpl extends BaseServiceImpl<RegistMember, Long> implements RegistMemberService {

	@Resource
	private RegistMemberMapper mapper;

	@Override
	public BaseDao<RegistMember, Long> getDao() {
		return mapper;
	}

	/**
	 * 根据手机号查询用户注册状态
	 * lixinling 
	 * 2016年8月8日 上午9:59:21
	 * @param phone
	 * @return
	 */
	@Override
	public RegistMember selectByPhone(String phone) {
		return mapper.selectByPhone(phone);
	}

	/**
	 * 注册会员
	 * lixinling 
	 * 2016年8月8日 上午9:59:21
	 * @param phone
	 * @return
	 */
	@Override
	public Map<String,Object> insertRegistMember(String phone) {
		Map<String,Object> res = new HashMap<String,Object>();
		try {
				// 注册CRM会员
				JSONObject result = Util.registMember(phone, 1l);
				if (result.optString("error_code") != null) {
					res.put("status", result.optInt("error_code"));
					res.put("message", result.optInt("message"));
					return res;
				} else if (result.optString("code") != null) {
					res.put("code", result.optString("code"));
					res.put("status", Constants.STATUS.SUCCESS);
				}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", Constants.STATUS.FAIL);
			return res;
		}
		return res;
	}

}
