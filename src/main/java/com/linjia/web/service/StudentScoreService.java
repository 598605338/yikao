package com.linjia.web.service;


import com.linjia.base.service.BaseService;
import com.linjia.web.model.StudentScore;
import com.linjia.web.query.StudentScoreQuery;

import java.util.List;

public interface StudentScoreService extends BaseService<StudentScore, Long>{

	/**
	 * 根据query查询科目列表
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	List<StudentScore> selectBySerach(StudentScoreQuery query);

	/**
	 * 根据query查询总记录数
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @param query
	 * @return
	 */
	int countByExample(StudentScoreQuery query);

	/**
	 * 验证是否是重复数据
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @return
	 */
	int checkSameData(Long candidateNum,String collegeName,String specialtyName);

	/**
	 * 批量插入学生成绩信息列表
	 * lixinling
	 * 2016年8月22日 下午2:17:39
	 * @param list
	 * @return
	 */
	int insertBatch(List<StudentScore> list);
}
