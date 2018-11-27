package com.bestshoes;

/**
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 26, 2018 
 * modified Date : Nov 26, 2018
 * --------------------------------------------- 
 *
 * Page Task	: Cart Bean     
 *
 */ 

public class Cart {

	private int CartNo;
	private int itemId;
	private int customerNo;
	private int quantity;
	private double price;
	
	public int getCartNo() {
		return CartNo;
	}
	public void setCartNo(int cartNo) {
		CartNo = cartNo;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
