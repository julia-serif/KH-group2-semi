package com.seller.model;

public class ProductOrderDTO {
	private int product_order_no;
	private String order_no;
	private int product_no;
	private int product_quantity;
	private int product_price;
	private String expected_date;
	private String order_status;
	private String seller_id;
	
	
	public int getProduct_order_no() {
		return product_order_no;
	}
	public void setProduct_order_no(int product_order_no) {
		this.product_order_no = product_order_no;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
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
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
}
