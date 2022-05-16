package com.shop.model;

public class OrderJoinProductDTO {

	private String order_no;
	private String user_id;
	private String order_date;
	private String recipient;
	private String recipient_phone;
	private String address;
	private int product_quantity;
	private int product_price;
	private String expected_date;
	private String order_status;
	
	
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecipient_phone() {
		return recipient_phone;
	}
	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getExpected_date() {
		return expected_date;
	}
	public void setExpected_date(String expected_date) {
		this.expected_date = expected_date;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	
	
	
}
