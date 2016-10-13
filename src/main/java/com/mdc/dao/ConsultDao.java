package com.mdc.dao;

import java.util.List;
import java.util.Map;

import com.mdc.util.PageUtil;
import com.mdc.view.MlinkConsult;

public interface ConsultDao {
	public int save(MlinkConsult consult) throws Exception;

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception;

	public List<MlinkConsult> getList(PageUtil<MlinkConsult> page, Map<String, Object> map) throws Exception;

	public int delete(String id) throws Exception;

	public int update(MlinkConsult consult) throws Exception;
}
