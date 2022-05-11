package com.shop.model;

public class ProductDTO {

	private int pno;				//상품번호
	private String pname;				//상품명
	private String pcode;				//카테고리 코드
	private String pcompany;			//제조사
	private String pimage;				//상품이미지
	private int pqty;				//상품 수량
	private int price;				//가격
	private String pspec;				//스펙
	private String pcontents;			//설명
	private int point;				//포인트
	private String pinputdate;			//입고일
	private String pseller;				//판매자
	
	public String getPseller() {
		return pseller;
	}
	public void setPseller(String pseller) {
		this.pseller = pseller;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPcompany() {
		return pcompany;
	}
	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPspec() {
		return pspec;
	}
	public void setPspec(String pspec) {
		this.pspec = pspec;
	}
	public String getPcontents() {
		return pcontents;
	}
	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPinputdate() {
		return pinputdate;
	}
	public void setPinputdate(String pinputdate) {
		this.pinputdate = pinputdate;
	}
	
	
}	
