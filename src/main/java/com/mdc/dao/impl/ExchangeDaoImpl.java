package com.mdc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mdc.dao.ExchangeDao;
import com.mdc.view.MlinkCountry;
import com.mdc.view.MlinkExchange;

@Repository
public class ExchangeDaoImpl implements ExchangeDao {

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

	public int save(MlinkExchange exchange) throws Exception {
		// TODO Auto-generated method stub
		int test = this.jdbctemplate.update(
				"insert into mlink_exchange (id,fromcurrency,tocurrency,exchange,createtime) values (?,?,?,?,?)",
				exchange.getId(), exchange.getFromcurrency(), exchange.getTocurrency(), exchange.getExchange(),
				exchange.getCreatetime());
		return test;
	}

	public MlinkExchange getLastExchange() throws Exception {
		// TODO Auto-generated method stub
		MlinkExchange exchange = this.jdbctemplate.queryForObject(
				"select id,fromcurrency,tocurrency,exchange,createtime from mlink_exchange where 1=1 order by createtime desc limit ?,?",
				new Object[] { 0, 1 }, new RowMapper<MlinkExchange>() {
					public MlinkExchange mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						MlinkExchange actor = new MlinkExchange();
						actor.setId(rs.getString("id"));
						actor.setFromcurrency(rs.getString("fromcurrency"));
						actor.setTocurrency(rs.getString("tocurrency"));
						actor.setExchange(rs.getDouble("exchange"));
						actor.setCreatetime(rs.getTimestamp("createtime"));
						return actor;
					}
				});
		return exchange;
	}

}
