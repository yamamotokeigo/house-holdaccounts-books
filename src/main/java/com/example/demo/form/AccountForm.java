package com.example.demo.form;

public class AccountForm {
	
	private Integer id;
	private String date;
	private int type;
	private String item;
	private int price;
	
	
	
	public AccountForm(Integer id, String date, int type, String item, int price) {
		super();
		
		this.date = date;
		this.type = type;
		this.item = item;
		this.price = price;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "AccountForm [id=" + id + ", date=" + date + ", type=" + type + ", item=" + item + ", price=" + price
				+ "]";
	}
	
	
}
