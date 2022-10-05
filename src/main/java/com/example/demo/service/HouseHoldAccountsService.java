package com.example.demo.service;

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
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}