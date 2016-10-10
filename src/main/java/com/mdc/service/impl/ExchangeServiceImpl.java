package com.mdc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdc.dao.ExchangeDao;
import com.mdc.service.IExchangeService;
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

}
