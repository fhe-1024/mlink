package com.mdc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdc.dao.NodeDao;
import com.mdc.service.INodeService;
import com.mdc.util.PageUtil;
import com.mdc.view.MlinkNode;

@Service
@Transactional
public class NodeServiceImpl implements INodeService {

	@Autowired
	private NodeDao nodeDao;

	public int save(MlinkNode node) throws Exception {
		// TODO Auto-generated method stub
		return nodeDao.save(node);
	}

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return nodeDao.getAllMapList(map);
	}

	public void getList(PageUtil<MlinkNode> page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		nodeDao.getList(page, map);
	}

	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return nodeDao.delete(id);
	}

	public int update(MlinkNode node) throws Exception {
		// TODO Auto-generated method stub
		return nodeDao.update(node);
	}

}
