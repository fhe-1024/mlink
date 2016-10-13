package com.mdc.service;

import com.mdc.view.MlinkExchange;

public interface IExchangeService {
	public int save(MlinkExchange exchange) throws Exception;

	public MlinkExchange getLastExchange() throws Exception;
}
