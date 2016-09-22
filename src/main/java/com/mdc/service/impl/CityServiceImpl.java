package com.mdc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdc.dao.CityDao;
import com.mdc.service.ICityService;
import com.mdc.util.PageUtil;
import com.mdc.view.MlinkCity;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

	@Autowired
	private CityDao cityDao;

	public List<Map<String, Object>> getValueByCountryID(String countryid) throws Exception {
		// TODO Auto-generated method stub
		return cityDao.getValueByCountryID(countryid);
	}

	public void save() throws Exception {
		// TODO Auto-generated method stub

	}

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return cityDao.getAllMapList(map);
	}

	public void getList(PageUtil<MlinkCity> page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		cityDao.getList(page, map);
	}

}
