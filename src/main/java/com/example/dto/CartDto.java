package com.example.dto;

public class CartDto {
	private int cId;
	private int pId;
	private int qty;
	private String pImage1;
	private String pName;
	private String pBrand;
	private float pPrice;
	private float totalPrice;
	public String getpName() {
		return pName;
	}
	public CartDto(int pId, int qty, String pName, String pBrand, float pPrice2, int cId, float totalPrice2, String pImage1) {
		super();
		this.pId = pId;
		this.qty = qty;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pPrice = pPrice2;
		this.cId = cId;
		this.totalPrice = totalPrice2;
		this.pImage1 = pImage1;
	}
	public String getpImage1() {
		return pImage1;
	}
	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public float getpPrice() {
		return pPrice;
	}
	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
