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
}
