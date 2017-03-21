package com.linjia.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.tools.DateComFunc;
import com.linjia.web.dao.CustMasterMapper;
import com.linjia.web.model.CustMaster;
import com.linjia.web.model.QueryCustMaster;
import com.linjia.web.query.MemberQuery;
import com.linjia.web.service.CustMasterService;

@Service
@Transactional
public class CustMasterServiceImpl extends BaseServiceImpl<CustMaster, Long> implements CustMasterService {
	
	@Resource
	private CustMasterMapper mapper;

	@Override
	public BaseDao<CustMaster, Long> getDao() {
		return mapper;
	}

	/**
	 * 当用户记录存在时进行更新，不存在时进行插入
	 * lixinling 
	 * 2016年8月12日 下午1:45:48
	 * @param model
	 * @return
	 */
	@Override
	public CustMaster insertOrUpdate(JSONObject data,String phone) {
		CustMaster model = new CustMaster();
		model.setUserId(Long.valueOf(phone));
		model.setCreator(phone);
		model.setCustid(phone);
		model.setLogin(data.optString("login"));
		model.setCustname(data.optString("name"));
		model.setEmail(data.optString("email"));
		model.setRankname("普通会员");
		model.setSex(data.optString("sex"));
		model.setPwd(data.optString("password"));
		model.setBirthday(DateComFunc.strToDate(data.optString("birthday"), "yyyy-MM-dd HH:mm:ss"));
		model.setPhone(data.optString("cellPhone"));
		model.setNickname(phone);
		model.setQq(data.optString("qq"));
		model.setMaritalstatus(data.optString("wedding"));
		model.setCardno(data.optString("code"));
		model.setOfflinePcustid(data.optString("code"));
		model.setAppName(data.optString("appName"));
		model.setOriginCode(data.optString("code"));
		model.setOrgCode(data.optJSONObject("org").optString("code"));
		model.setOrgName(data.optJSONObject("org").optString("name"));
		model.setRegisterDate(DateComFunc.strToDate(data.optString("registerDate"), "yyyy-MM-dd HH:mm:ss"));
		mapper.insertOrUpdate(model);
		return model;
	}

	@Override
	public String selectLoginByPrimaryKey(Long userId) {
		return mapper.selectLoginByPrimaryKey(userId);
	}

	@Override
	public List<QueryCustMaster> selectMembers(MemberQuery query) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curdate=sdf.format(new Date());
		String beginDate=query.getBeginDate();
		String endDate=query.getEndDate();
		if("".equals(beginDate)&&!"".equals(endDate)){
			beginDate=curdate;
		}
		if(!"".equals(beginDate)&&"".equals(endDate)){
			endDate=curdate;
		}
		query.setBeginDate(beginDate);
		query.setEndDate(endDate);
		List<QueryCustMaster> list=mapper.selectMembers(query);
		return list;
	}

	@Override
	public int updateMember(String phone,Integer deleted,Integer useFlg) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("phone",phone);
		map.put("deleted", deleted);
		map.put("useFlg", useFlg);
		int num=mapper.updateMember(map);
		return num;
	}

	@Override
	public int selectCustNums(MemberQuery query) {
		return mapper.selectCustNums(query);
	}

	@Override
	public List<Map<String, String>> selectUserIdByPhone(List<Map<String, String>> list) {
		return mapper.selectUserIdByPhone(list);
	}

}
