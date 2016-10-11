package com.mdc.dao;

import java.util.List;
import java.util.Map;

import com.mdc.util.PageUtil;
import com.mdc.view.MlinkCountry;

public interface CountryDao {
	public List<Map<String, Object>> get() throws Exception;

	public int save(MlinkCountry country) throws Exception;

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception;

	public void getList(PageUtil<MlinkCountry> page, Map<String, Object> map) throws Exception;
	
	public int delete(String id)throws Exception;
	
	public int update(MlinkCountry country)throws Exception;
}
