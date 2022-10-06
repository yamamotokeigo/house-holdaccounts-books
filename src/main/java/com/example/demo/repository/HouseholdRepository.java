package com.example.demo.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Account;

@Repository
public class HouseholdRepository {
	
	private static final RowMapper<Account> ACCOUNT_ROW_MAPPER
	= new BeanPropertyRowMapper<>(Account.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    // 全件検索処理
    public List<Account> findAll() {

        String sql = "SELECT id, date, type, item, price FROM account order by date, id";
        SqlParameterSource param = new MapSqlParameterSource();
        List<Account> accountList 
		= template.query(sql, param, ACCOUNT_ROW_MAPPER);
		return accountList;
    }
    //新規登録
    public void insert(Account account) {
    	SqlParameterSource param = new BeanPropertySqlParameterSource(account);
    	String sql = "INSERT INTO account(date, type, item, price)"
    				+ " values(:date, :type, :item, :price)";
    	template.update(sql, param);
    }

}
