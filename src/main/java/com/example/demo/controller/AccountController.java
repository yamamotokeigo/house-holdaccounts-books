package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.domain.Account;
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
	//新規登録完了
	@RequestMapping("/insertFinish")
	public String insertFinish(Model model , Account account) {
		account = service.insert(account);
		model.addAttribute("account" , account);
		return "account/InsertFinish";
	}
	//削除画面
	@RequestMapping("/delete")
	public String deleteList(Model model) {

		List<Account> list = service.findAll();
		int totalPrice = service.getTotalPrice();
		model.addAttribute("list", list);
		model.addAttribute("totalPrice", totalPrice);
		return "account/delete";
	}
	//削除確認画面
	@RequestMapping("/deleteConfirm")
	public String findById(Integer id ,  Model model) {

		Account account = service.deleteFindById(id);
		model.addAttribute("account" , account);
		return "account/deleteConfirm";

	}
	//削除完了画面
	@RequestMapping("/deleteComplete")
	public String deleteComplete(Model model , Integer id) {

		Account account = service.deleteFindById(id);
		model.addAttribute("account", account);
		service.delete(id);
		return "account/deleteComplete";
	}
	//更新画面
	@RequestMapping("/update")
	public String updateList(Model model) {
		
		List<Account> list = service.findAll();
		int totalPrice = service.getTotalPrice();
		model.addAttribute("list", list);
		model.addAttribute("totalPrice", totalPrice);
		return "account/update";
	}
	
	//更新情報入力画面
	@RequestMapping("/updateInsert")
	public String findById2(Integer id , Model model , Account account) {
		 
		account = service.updateFindById(id);
		model.addAttribute("account", account);
		return "account/updateInsert";
	}
	//更新確認画面
	@RequestMapping("/updateConfirm")
	public String findById2(Account account ,  Model model) {

		model.addAttribute("account" , account);
		return "account/updateConfirm";
	}
	
	//更新完了画面
	@RequestMapping("/updateComplete")
	public String updateComplate(Model model , Account account) {
		
		model.addAttribute("account", account);
		service.update(account);
		return "account/updateComplete";
		
	}

	// 年別集計画面へ遷移
	@GetMapping("/searchByYear")
	public String searchByYear() {

		return "account/findByYear";
	}
	//年別集計
	@PostMapping("/findByYear")
	public String findByYear(Model model , String year) {
		List<Account> list2 = service.findByYear(year);
		int totalPrice = service.getTotalPrice();
		model.addAttribute("list" , list2);
		model.addAttribute("year" , year);
		model.addAttribute("totalPrice" , totalPrice);
		return "account/findByYear";
	}

	// 年別月別集計画面へ遷移
	@GetMapping("/findByYearAndMonth")
	public String searchByYearAndMonth() {

		return "account/findByYearAndMonth";
	}

	//年別月別集計
	@PostMapping("/findByYearAndMonth")
	public String findByYearAndMonth(Model model , String year , String month) {
		List<Account> list3 = service.findByYearAndMonth(year, month);
		int totalPrice = service.getTotalPrice();
		model.addAttribute("list" , list3);
		model.addAttribute("year" , year);
		model.addAttribute("month" , month);
		model.addAttribute("totalPrice" , totalPrice);
		return "account/findByYearAndMonth";
	}
}