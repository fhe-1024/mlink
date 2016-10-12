package com.mdc.service;

import java.util.List;
import java.util.Map;

import com.mdc.util.PageUtil;
import com.mdc.view.MlinkNode;

public interface INodeService {
	public int save(MlinkNode node) throws Exception;

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception;

	public List<MlinkNode> getList(PageUtil<MlinkNode> page,Map<String, Object> map) throws Exception;
	
	public int delete(String id) throws Exception;
	
	public int update(MlinkNode node)throws Exception;
}
