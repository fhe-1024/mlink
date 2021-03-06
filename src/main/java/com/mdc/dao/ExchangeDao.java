package com.mdc.dao;

import java.util.List;
import java.util.Map;

import com.mdc.util.PageUtil;
import com.mdc.view.MlinkExchange;

public interface ExchangeDao {
	public int save(MlinkExchange exchange) throws Exception;
	
	public MlinkExchange getLastExchange() throws Exception;
	
	public List<MlinkExchange> getList(PageUtil<MlinkExchange> page, Map<String, Object> map) throws Exception;
}
