package com.mdc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdc.dao.SingleDao;
import com.mdc.service.ISingleService;
import com.mdc.util.PageUtil;
import com.mdc.view.MlinkSingle;

@Service
@Transactional
public class SingleServiceImpl implements ISingleService {

	@Autowired
	private SingleDao singleDao;

	public int save(MlinkSingle single) throws Exception {
		// TODO Auto-generated method stub
		return singleDao.save(single);
	}

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return singleDao.getAllMapList(map);
	}

	public void getList(PageUtil<MlinkSingle> page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		singleDao.getList(page, map);
	}

	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return singleDao.delete(id);
	}

}
