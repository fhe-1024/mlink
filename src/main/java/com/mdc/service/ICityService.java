package com.mdc.service;

import java.util.List;
import java.util.Map;

public interface ICityService {
	public List<Map<String, Object>> getValueByCountryID(String countryid) throws Exception;

	public void save() throws Exception;
}
