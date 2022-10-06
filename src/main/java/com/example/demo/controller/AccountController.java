package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Account;
import com.example.demo.form.AccountForm;
import com.example.demo.service.HouseHoldAccountsService;

@Controller
@RequestMapping("/")
public class AccountController {

	private HouseHoldAccountsService service;

	@Autowired
	public AccountController(HouseHoldAccountsService service) {
		this.service = service;
	
	}

	// 全件表示を行う
	@RequestMapping("/account")
	public String account(Model model) {

		List<Account> list = service.findAll();
		int totalPrice = service.getTotalPrice();
		model.addAttribute("list", list);
		model.addAttribute("totalPrice", totalPrice);
		return "account/HouseholdList";
	}
	
	//新規登録
	@RequestMapping("/insert")
	public String insert(Model model) {
		
		return "account/insert";
	}
	
	@RequestMapping("/insertFinish")
    public String insert(Model model, AccountForm form) {
		Account account = new Account();
		BeanUtils.copyProperties(form, account);
		service.insert(account);
        return "account/InsertFinish";
    }
}