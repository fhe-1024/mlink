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
import org.springframework.stereotype.Repository;

import com.mdc.dao.CountryDao;
import com.mdc.view.MlinkCountry;

@Repository
public class CountryDaoImpl implements CountryDao {

	private Log log = LogFactory.getLog(getClass());

	private JdbcTemplate jdbctemplate;

	@Autowired
	public void init(DataSource dataSource) {
		jdbctemplate = new JdbcTemplate(dataSource);

	}

	public List<Map<String, Object>> get() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> actors = this.jdbctemplate.query("select id, name,sort from mlink_country order by sort",
				new RowMapper<Map<String, Object>>() {
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

}
