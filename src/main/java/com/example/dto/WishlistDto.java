package com.example.dto;

public class WishlistDto {
	private int wId;
	private int pId;
	private String pImage1;
	private String pName;
	private String pBrand;
	private float pPrice;
	public WishlistDto(int pId, String pName, String pBrand, float pPrice, int wId, String pImage1) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pPrice = pPrice;
		this.wId = wId;
		this.pImage1 = pImage1;
	}
	
	public String getpImage1() {
		return pImage1;
	}

	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}

	public int getwId() {
		return wId;
	}

	public void setwId(int wId) {
		this.wId = wId;
	}

	public float getpPrice() {
		return pPrice;
	}
	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
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
	
}
