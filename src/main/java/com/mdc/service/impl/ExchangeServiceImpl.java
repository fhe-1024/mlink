package com.mdc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdc.dao.ExchangeDao;
import com.mdc.service.IExchangeService;
import com.mdc.util.PageUtil;
import com.mdc.view.MlinkExchange;

@Service
@Transactional
public class ExchangeServiceImpl implements IExchangeService {
	@Autowired
	private ExchangeDao exchangeDao;

	public int save(MlinkExchange exchange) throws Exception {
		// TODO Auto-generated method stub
		return exchangeDao.save(exchange);
	}

	public MlinkExchange getLastExchange() throws Exception {
		// TODO Auto-generated method stub
		return exchangeDao.getLastExchange();
	}

	public List<MlinkExchange> getList(PageUtil<MlinkExchange> page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return exchangeDao.getList(page, map);
	}

}
