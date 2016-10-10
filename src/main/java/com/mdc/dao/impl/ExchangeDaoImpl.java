package com.mdc.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mdc.dao.ExchangeDao;
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
		int test = this.jdbctemplate.update("insert into mlink_exchange (id,fromcurrency,tocurrency,exchange,createtime) values (?,?,?,?,?)",
				exchange.getId(), exchange.getFromcurrency(), exchange.getTocurrency(), exchange.getExchange(),exchange.getCreatetime());
		return test;
	}

}
