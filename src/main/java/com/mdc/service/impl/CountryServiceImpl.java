package com.mdc.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdc.dao.CountryDao;
import com.mdc.service.ICountryService;
import com.mdc.util.PageUtil;
import com.mdc.view.MlinkCountry;

@Service
@Transactional
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private CountryDao countryDao;

	public List<Map<String, Object>> get() throws Exception {
		// TODO Auto-generated method stub
		return countryDao.get();
	}

	public int save(MlinkCountry country) throws Exception {
		// TODO Auto-generated method stub
		return countryDao.save(country);
	}

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub

		return countryDao.getAllMapList(map);
	}

	public void getList(PageUtil<MlinkCountry> page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		countryDao.getList(page, map);
	}

	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return countryDao.delete(id);
	}

	public int update(MlinkCountry country) throws Exception {
		// TODO Auto-generated method stub
		return countryDao.update(country);
	}

}
