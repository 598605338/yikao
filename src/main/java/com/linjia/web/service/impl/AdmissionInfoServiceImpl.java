package com.linjia.web.service.impl;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.AdmissionBatchMapper;
import com.linjia.web.dao.AdmissionInfoMapper;
import com.linjia.web.dao.AdmissionRuleMapper;
import com.linjia.web.model.AdmissionBatch;
import com.linjia.web.model.AdmissionInfo;
import com.linjia.web.model.AdmissionRule;
import com.linjia.web.query.AdmissionBatchQuery;
import com.linjia.web.query.AdmissionInfoQuery;
import com.linjia.web.service.AdmissionBatchService;
import com.linjia.web.service.AdmissionInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdmissionInfoServiceImpl extends BaseServiceImpl<AdmissionInfo, Long> implements AdmissionInfoService {

	@Resource
	private AdmissionInfoMapper mapper;

	@Resource
	private AdmissionRuleMapper admissionRuleMapper;

	@Override
	public BaseDao<AdmissionInfo, Long> getDao() {
		return mapper;
	}


	@Override
	public List<AdmissionInfo> selectBySerach(AdmissionInfoQuery query) {
		List<AdmissionInfo> list = mapper.selectBySerach(query);
		if(list != null && list.size() > 0){
			int j=0;
			int rowspan_college = 1;
			int rowspan_specialty = 1;
			int rowspan_year = 1;
			int rowspan_batch = 1;
			int rowspan_rule = 1;
			for(int i=list.size()-1;i>-1;i--){
				j=i-1;
				AdmissionInfo info_i = list.get(i);
				AdmissionInfo info_j = null;
				if(i==0){
					info_i.setFirstRowFlag_college(true);
					info_i.setRowspanNum_college(rowspan_college);
					info_i.setFirstRowFlag_spceialty(true);
					info_i.setRowspanNum_spceialty(rowspan_specialty);
					info_i.setFirstRowFlag_year(true);
					info_i.setRowspanNum_year(rowspan_year);
					info_i.setFirstRowFlag_batch(true);
					info_i.setRowspanNum_batch(rowspan_batch);
					info_i.setFirstRowFlag_rule(true);
					info_i.setRowspanNum_rule(rowspan_rule);
					continue;
				}else{
					info_j = list.get(j);
				}

				//合并同院校
				if(info_i.getCollegeId().intValue() == info_j.getCollegeId().intValue()) {
					rowspan_college++;
				}else{
					info_i.setFirstRowFlag_college(true);
					info_i.setRowspanNum_college(rowspan_college);
					rowspan_college = 1;
				}

				//合并同院校同专业
				if(info_i.getCollegeId().intValue() == info_j.getCollegeId().intValue() && info_i.getSpecialtyId().intValue() == info_j.getSpecialtyId().intValue()) {
					rowspan_specialty++;
				}else{
					info_i.setFirstRowFlag_spceialty(true);
					info_i.setRowspanNum_spceialty(rowspan_specialty);
					rowspan_specialty = 1;
				}

				//合并同院校同专业同年份
				if(info_i.getCollegeId().intValue() == info_j.getCollegeId().intValue() && info_i.getSpecialtyId().intValue() == info_j.getSpecialtyId().intValue() && info_i.getYear().intValue() == info_j.getYear().intValue()) {
					rowspan_year++;
				}else{
					info_i.setFirstRowFlag_year(true);
					info_i.setRowspanNum_year(rowspan_year);
					rowspan_year = 1;
				}

				//合并同院校同专业同年份同批次
				if(info_i.getCollegeId().intValue() == info_j.getCollegeId().intValue() && info_i.getSpecialtyId().intValue() == info_j.getSpecialtyId().intValue() && info_i.getYear().intValue() == info_j.getYear().intValue() && info_i.getBatchId().intValue() == info_j.getBatchId().intValue()) {
					rowspan_batch++;
				}else{
					info_i.setFirstRowFlag_batch(true);
					info_i.setRowspanNum_batch(rowspan_batch);
					rowspan_batch = 1;
				}

				//合并同院校同录取规则
				if(info_i.getCollegeId().intValue() == info_j.getCollegeId().intValue() && info_i.getAdmissionRuleId().intValue() == info_j.getAdmissionRuleId().intValue()) {
					rowspan_rule++;
				}else{
					info_i.setFirstRowFlag_rule(true);
					info_i.setRowspanNum_rule(rowspan_rule);
					rowspan_rule = 1;
				}
			}
		}
		return mapper.selectBySerach(query);
	}

	@Override
	public int countByExample(AdmissionInfoQuery query) {
		return mapper.countByExample(query);
	}

	@Override
	public List<AdmissionRule> selectAdmiRuleDownListByCollegeId(Long collegeId) {
		return admissionRuleMapper.selectDownListByCollegeId(collegeId);
	}

	@Override
	public int insertAdmissionInfo(AdmissionInfo info) {

		//判断选择规则模式
		judgeRuleTab(info);

		//插入录取信息
		return mapper.insertSelective(info);
	}

	@Override
	public boolean updateAdmissionInfo(AdmissionInfo info) {
		//判断选择规则模式
		judgeRuleTab(info);
		return mapper.updateByPrimaryKeySelective(info);
	}

	/**
	 * 判断选择模式
	 * @param info
	 */
	private void judgeRuleTab(AdmissionInfo info){
		if(info.getRuleTab() == 1){
			//新增录取规则模式
			AdmissionRule rule = new AdmissionRule();
			rule.setCollegeId(info.getCollegeId());
			rule.setDescription(info.getDescription());
			admissionRuleMapper.insertSelective(rule);

			info.setAdmissionRuleId(rule.getId());
		}
	}

    @Override
    public AdmissionRule selectAdmissionRule(Long ruleId) {
        return admissionRuleMapper.selectByPrimaryKey(ruleId);
    }

    @Override
	public boolean deleteAdmissionRule(Long ruleId) {
		return admissionRuleMapper.deleteByPrimaryKey(ruleId);
	}

    @Override
    public boolean updateAdmissionRule(AdmissionRule rule) {
        return admissionRuleMapper.updateByPrimaryKeySelective(rule);
    }
}
