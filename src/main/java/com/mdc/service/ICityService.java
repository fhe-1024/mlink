package com.mdc.service;

import java.util.List;
import java.util.Map;

import com.mdc.util.PageUtil;
import com.mdc.view.MlinkCity;

public interface ICityService {
	public List<Map<String, Object>> getValueByCountryID(String countryid) throws Exception;

	public int save(MlinkCity city) throws Exception;

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception;

	public List<MlinkCity> getList(PageUtil<MlinkCity> page, Map<String, Object> map) throws Exception;

	public int delete(String id) throws Exception;

	public int update(MlinkCity city) throws Exception;
}
