package com.linjia.web.dao;

import com.linjia.base.dao.BaseDao;
import com.linjia.web.model.AdmissionRule;

import java.util.List;

public interface AdmissionRuleMapper extends BaseDao<AdmissionRule, Long> {

    /**
     * 根据院校Id查询录取规则列表
     * @param collegeId
     * @return
     */
    List<AdmissionRule> selectDownListByCollegeId(Long collegeId);
}