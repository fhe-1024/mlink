package com.mdc.dao;

import java.util.List;
import java.util.Map;

import com.mdc.util.PageUtil;
import com.mdc.view.MlinkTip;

public interface TipDao {
	public int save(MlinkTip tip) throws Exception;

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception;

	public List<MlinkTip> getList(PageUtil<MlinkTip> page, Map<String, Object> map) throws Exception;

	public int delete(String id) throws Exception;

	public int update(MlinkTip tip) throws Exception;

	public MlinkTip getTipByCountryId(String countryid) throws Exception;
}
