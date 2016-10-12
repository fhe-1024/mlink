package com.mdc.dao;

import java.util.List;
import java.util.Map;

import com.mdc.util.PageUtil;
import com.mdc.view.MlinkFacility;

public interface FacilityDao {
	public int save(MlinkFacility facility) throws Exception;

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception;

	public List<MlinkFacility> getList(PageUtil<MlinkFacility> page, Map<String, Object> map) throws Exception;

	public int delete(String id) throws Exception;

	public int update(MlinkFacility facility) throws Exception;
}
