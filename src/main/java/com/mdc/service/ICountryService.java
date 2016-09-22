package com.mdc.service;

import java.util.List;
import java.util.Map;

import com.mdc.view.MlinkCountry;

public interface ICountryService {
	public List<Map<String, Object>> get() throws Exception;

	public int save(MlinkCountry country) throws Exception;
//
//	public List<Map<String, Object>> getAllMapList() throws Exception;
//
//	public List<MlinkCountry> getAllViewList() throws Exception;
}
