package com.mdc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mdc.dao.SingleDao;
import com.mdc.util.PageUtil;
import com.mdc.view.MlinkNode;
import com.mdc.view.MlinkSingle;

@Repository
public class SingleDaoImpl implements SingleDao {
	private Log log = LogFactory.getLog(getClass());

	private JdbcTemplate jdbctemplate;

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	public void initJdbc(DataSource dataSource) {
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Autowired
	public void init(DataSource dataSource) {
		jdbctemplate = new JdbcTemplate(dataSource);
	}

	public int save(MlinkSingle single) throws Exception {
		// TODO Auto-generated method stub
		int test = this.jdbctemplate.update(
				"insert into mlink_single (id,area,protocol,electricity,authentication,nodeid) values (?,?,?,?,?,?)",
				single.getId(), single.getArea(), single.getProtocol(), single.getElectricity(),
				single.getAuthentication(), single.getNodeid());
		log.info(test);
		return test;
	}

	public List<Map<String, Object>> getAllMapList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select id,area,protocol,electricity,authentication,nodeid from mlink_single where 1=1 ");
		Map<String, Object> argsMap = new HashMap<String, Object>();
		if (StringUtils.isNotBlank((String) map.get("nodeid"))) {
			sb.append(" and nodeid=:nodeid ");
			argsMap.put("nodeid", map.get("nodeid"));
		}
		List<Map<String, Object>> actors = this.namedJdbcTemplate.query(sb.toString(), argsMap,
				new RowMapper<Map<String, Object>>() {
					public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", rs.getString("id"));
						map.put("area", rs.getString("area"));
						map.put("protocol", rs.getInt("protocol"));
						map.put("electricity", rs.getString("electricity"));
						map.put("authentication", rs.getString("authentication"));
						map.put("nodeid", rs.getString("nodeid"));
						return map;
					}
				});
		return actors;
	}

	public void getList(PageUtil<MlinkSingle> page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		StringBuilder countsb = new StringBuilder();
		Map<String, Object> searchMap = new HashMap<String, Object>();
		sb.append("select id,area,protocol,electricity,authentication,nodeid from mlink_single where 1=1 ");
		sb.append("limit :start,:end ");
		searchMap.put("start", page.getFirst());
		searchMap.put("end", page.getPageSize());
		countsb.append("select count(id) from mlink_single where 1=1");
		List<MlinkSingle> actors = this.namedJdbcTemplate.query(sb.toString(), searchMap, new RowMapper<MlinkSingle>() {
			public MlinkSingle mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				MlinkSingle single = new MlinkSingle();
				single.setId(rs.getString("id"));
				single.setArea(rs.getString("area"));
				single.setProtocol(rs.getString("protocol"));
				single.setElectricity(rs.getString("electricity"));
				single.setAuthentication(rs.getString("authentication"));
				single.setNodeid(rs.getString("nodeid"));
				return single;
			}
		});
		page.setResult(actors);
		Integer total = this.namedJdbcTemplate.queryForObject(sb.toString(), new HashMap<String, Object>(),
				Integer.class);
		page.setTotalCount(total);
	}

	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return jdbctemplate.update("delete from mlink_single where id=?", id);
	}

}
