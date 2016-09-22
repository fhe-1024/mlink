package com.mdc.service;

import java.util.List;
import java.util.Map;

import com.mdc.util.PageUtil;
import com.mdc.view.MlinkCountry;

public interface ICountryService {
	public List<Map<String, Object>> get() throws Exception;

	public int save(MlinkCountry country) throws Exception;

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception;

	public void getList(PageUtil<MlinkCountry> page,Map<String, Object> map) throws Exception;
}
