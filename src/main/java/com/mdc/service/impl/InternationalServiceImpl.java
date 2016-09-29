package com.mdc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdc.dao.InternationalDao;
import com.mdc.service.IInternationalService;
import com.mdc.util.PageUtil;
import com.mdc.view.MlinkInternational;

@Transactional
@Service
public class InternationalServiceImpl implements IInternationalService {

	@Autowired
	private InternationalDao internationalDao;

	public int save(MlinkInternational international) throws Exception {
		// TODO Auto-generated method stub
		return internationalDao.save(international);
	}

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return internationalDao.getAllMapList(map);
	}

	public void getList(PageUtil<MlinkInternational> page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		internationalDao.getList(page, map);
	}

}
