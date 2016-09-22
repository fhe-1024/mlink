package com.mdc.dao;

import java.util.List;
import java.util.Map;

import com.mdc.view.MlinkCountry;

public interface CountryDao {
	public List<Map<String, Object>> get() throws Exception;

	public int save(MlinkCountry country) throws Exception;
}
