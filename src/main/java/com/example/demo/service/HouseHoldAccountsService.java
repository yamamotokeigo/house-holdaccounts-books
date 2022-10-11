package com.example.demo.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Account;
import com.example.demo.repository.HouseholdRepository;

@Service
public class HouseHoldAccountsService {

	private HouseholdRepository repository;

	// 合計金額格納用
	private int totalPrice;

	@Autowired
	public HouseHoldAccountsService(HouseholdRepository repository) {
		this.repository = repository;
	}

	// 全件検索
	public List<Account> findAll() {

		List<Account> list = repository.findAll();
		totalPrice = 0;
		for (Account account : list) {
			totalPrice += account.getPrice();
		}
		return list;
	}
	
	//新規登録
	public Account insert(Account account) {
		repository.insert(account);
		return account;
	}
	
	//削除画面
	public void delete(Integer id) {
		repository.delete(id);
	}
	//削除確認画面
	public Account deleteFindById(Integer id) {
		return repository.findByAccountId(id);
	}
	
	//年別集計
	public List<Account> findByYear(String year){
		String startDate = year + "-01-01";
		String endDate = year + "-12-31";
		List<Account> list = repository.findByYear(startDate, endDate);
		totalPrice = 0;
		for (Account account : list) {
			totalPrice += account.getPrice();
		}
		return list;
	}
	//年別月別集計
	public List<Account> findByYearAndMonth(String year , String month){
		int searchYear = Integer.parseInt(year);
		int searchMonth = Integer.parseInt(month);
		String startDate = year + "-" + month + "-" + "01";
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, searchYear);
        calendar.set(Calendar.MONTH, searchMonth - 1);
        int result = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String endDate = year + "-" + month + "-" + result;
        List<Account> yearAndMonthList = repository.findByYearAndMonth(startDate, endDate);
        totalPrice = 0;
		for (Account account : yearAndMonthList) {
			totalPrice += account.getPrice();
		}
		return yearAndMonthList;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}