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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mdc.dao.CountryDao;
import com.mdc.util.PageUtil;
import com.mdc.view.MlinkCountry;

@Repository
public class CountryDaoImpl implements CountryDao {

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

	public List<Map<String, Object>> get() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> actors = this.jdbctemplate
				.query("select id, name,sort from mlink_country order by sort", new RowMapper<Map<String, Object>>() {
					public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", rs.getString("id"));
						map.put("name", rs.getString("name"));
						map.put("sort", rs.getInt("sort"));
						return map;
					}
				});
		return actors;
	}

	public int save(MlinkCountry country) throws Exception {
		// TODO Auto-generated method stub
		int test = this.jdbctemplate.update("insert into mlink_country (id,name,sort) values (?,?,?)", country.getId(),
				country.getName(), country.getSort());
		log.info(test);
		return test;
	}

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select id,name,sort from mlink_country where 1=1 ");
		sb.append(" order by sort ");
		List<Map<String, Object>> actors = this.namedJdbcTemplate.query(sb.toString(), new HashMap<String, Object>(),
				new RowMapper<Map<String, Object>>() {
					public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", rs.getString("id"));
						map.put("name", rs.getString("name"));
						map.put("sort", rs.getInt("sort"));
						return map;
					}
				});
		return actors;
	}

	public void getList(PageUtil<MlinkCountry> page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		StringBuilder countsb = new StringBuilder();
		Map<String, Object> searchMap = new HashMap<String, Object>();
		sb.append("select id,name,sort from mlink_country where 1=1 ");
		sb.append("limit :start,:end ");
		searchMap.put("start", page.getFirst());
		searchMap.put("end", page.getPageSize());
		countsb.append("select count(id) from mlink_country where 1=1");
		List<MlinkCountry> actors = this.namedJdbcTemplate.query(sb.toString(), searchMap,
				new RowMapper<MlinkCountry>() {
					public MlinkCountry mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						MlinkCountry country = new MlinkCountry();
						country.setId(rs.getString("id"));
						country.setName(rs.getString("name"));
						country.setSort(rs.getInt("sort"));
						return country;
					}
				});
		page.setResult(actors);
		Integer total = this.namedJdbcTemplate.queryForObject(sb.toString(), new HashMap<String, Object>(),
				Integer.class);
		page.setTotalCount(total);
	}

}
