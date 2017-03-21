package com.linjia.web.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.linjia.web.dao.AdvertisePageMapper;
import com.linjia.web.model.AdvitisePage;
import com.linjia.web.service.AdvertisePageService;

@Service
@Transactional
public class AdvertisePageServiceImpl  implements AdvertisePageService {
	
	@Resource
	private AdvertisePageMapper advertisePageMapper;
	
	@Override
	public boolean insertAdvPage(AdvitisePage info) {
		return advertisePageMapper.insertAdvPage(info);
	}

	@Override
	public boolean updateAdvPageById(AdvitisePage info) {
		return advertisePageMapper.updateAdvPageById(info);
	}

	@Override
	public boolean deleteAdvPageById(int id) {
		return advertisePageMapper.deleteAdvPageById(id);
	}

	@Override
	public AdvitisePage selectAdvPageById(int id) {
		return advertisePageMapper.selectAdvPageById(id);
	}

	@Override
	public List<AdvitisePage> selectAdvPageAll() {
		return advertisePageMapper.selectAdvPageAll();
	}

}
