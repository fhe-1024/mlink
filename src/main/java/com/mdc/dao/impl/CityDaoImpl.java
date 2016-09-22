package com.mdc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mdc.dao.CityDao;


@Repository
public class CityDaoImpl implements CityDao {

	private Log log = LogFactory.getLog(getClass());

	private JdbcTemplate jdbctemplate;

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		jdbctemplate = new JdbcTemplate(dataSource);

	}

	@Autowired
	public void initJdbc(DataSource dataSource) {
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Map<String, Object>> getValueByCountryID(String countryid) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(
				"select id, name,sort,countryid from mlink_city where countryid=:countryid limit :pagestart,:pageend");
		Map<String, Object> argsMap = new HashMap<String, Object>();
		argsMap.put("countryid", countryid);
		argsMap.put("pagestart", 0);
		argsMap.put("pageend", 10);
		List<Map<String, Object>> actors = this.namedJdbcTemplate.query(sb.toString(), argsMap,
				new RowMapper<Map<String, Object>>() {
					public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", rs.getString("id"));
						map.put("name", rs.getString("name"));
						map.put("sort", rs.getInt("sort"));
						map.put("countryid", rs.getString("countryid"));
						return map;
					}
				});
		return actors;
		
	}

	public List<Map<String, Object>> getValueById() throws Exception {
		StringBuilder sb = new StringBuilder(
				"select id, name,sort,countryid from mlink_city where countryid=:countryid limit :pagestart,:pageend");
		Map<String, Object> argsMap = new HashMap<String, Object>();
		argsMap.put("countryid", "1");
		argsMap.put("pagestart", 0);
		argsMap.put("pageend", 10);
		List<Map<String, Object>> actors = this.namedJdbcTemplate.query(sb.toString(), argsMap,
				new RowMapper<Map<String, Object>>() {
					public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", rs.getString("id"));
						map.put("name", rs.getString("name"));
						map.put("sort", rs.getInt("sort"));
						map.put("countryid", rs.getString("countryid"));
						return map;
					}
				});
		return actors;
	}

	public void save(String name, int sort) throws Exception {
		// TODO Auto-generated method stub

	}

}
