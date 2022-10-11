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
    //削除処理
    public void delete(Integer id) {
    	String sql = "DELETE from account WHERE id=:id";
    	SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
    	template.update(sql, param);
    }
    //ID検索
    public Account findByAccountId(Integer id) {
    	String sql = "SELECT id, date, type, item, price FROM account where id=:id";
    	SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
    	Account account = template.queryForObject(sql, param, ACCOUNT_ROW_MAPPER);
    	return account;
    }
    
    //年別集計
    public List<Account> findByYear(String startDate, String endDate){
    	String sql = "SELECT id, date, type, item, price FROM account where date between :startDate and :endDate order by date, id";
    	SqlParameterSource param = new MapSqlParameterSource().addValue("startDate", startDate).addValue("endDate" , endDate);
    	List<Account> yearList = template.query(sql, param, ACCOUNT_ROW_MAPPER);
    	return yearList;
    }
}
