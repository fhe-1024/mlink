package com.mdc.dao;

import java.util.List;
import java.util.Map;

public interface CityDao {
	public List<Map<String, Object>> getValueByCountryID(String countryid) throws Exception;

	public void save(String name,int sort) throws Exception;
}
