package com.linjia.web.service.impl;

import com.linjia.base.dao.BaseDao;
import com.linjia.base.service.impl.BaseServiceImpl;
import com.linjia.web.dao.StudentScoreMapper;
import com.linjia.web.model.StudentScore;
import com.linjia.web.query.StudentScoreQuery;
import com.linjia.web.service.StudentScoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StudentScoreServiceImpl extends BaseServiceImpl<StudentScore, Long> implements StudentScoreService {
	
	@Resource
	private StudentScoreMapper mapper;

	@Override
	public BaseDao<StudentScore, Long> getDao() {
		return mapper;
	}

    @Override
    public List<StudentScore> selectBySerach(StudentScoreQuery query) {
        return mapper.selectBySerach(query);
    }

    @Override
    public int countByExample(StudentScoreQuery query) {
        return mapper.countByExample(query);
    }

    @Override
	public int checkSameData(Long candidateNum,String collegeName,String specialtyName) {
		StudentScoreQuery query = new StudentScoreQuery();
		query.setCandidateNum(candidateNum);
        query.setCollegeName(collegeName);
        query.setSpecialtyName(specialtyName);
		return mapper.checkSameData(query);
	}

	@Override
	public int insertBatch(List<StudentScore> list) {
		return mapper.insertBatch(list);
	}

	@Override
	public int createImportTemp() {
		String sql="create table t_student_score_temp (`candidate_num` bigint(18) DEFAULT NULL COMMENT '考号',\n" +
				"  `candidate_name` varchar(10) DEFAULT NULL COMMENT '考生姓名',\n" +
				"  `sex` tinyint(1) DEFAULT '0' COMMENT '性别：0男；1女',\n" +
				"  `college_name` varchar(50) DEFAULT NULL COMMENT '院校名称',\n" +
				"  `specialty_name` varchar(50) DEFAULT NULL COMMENT '专业名称',\n" +
				"  `score` decimal(4,1) DEFAULT NULL COMMENT '成绩'\n" +
				") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生成绩录取信息导入临时表';";

		return mapper.createImportTemp(sql);
	}

	@Override
	public void callProcImportInfo() {
		mapper.callProcImportInfo();
	}
}
