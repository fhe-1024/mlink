package com.mdc.dao;

import java.util.List;
import java.util.Map;

import com.mdc.util.PageUtil;
import com.mdc.view.MlinkInternational;

public interface InternationalDao {
	public int save(MlinkInternational international) throws Exception;

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception;

	public void getList(PageUtil<MlinkInternational> page, Map<String, Object> map) throws Exception;
	
	public int delete(String id)throws Exception;
}
