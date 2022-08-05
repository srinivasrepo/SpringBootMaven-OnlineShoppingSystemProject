package com.example.dto;

public class RetailerSignUp {
	private int rId;
	public int getrId() {
		return rId;
	}
	public RetailerSignUp() {
		
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	private String uName;
	private String uEmail;
	private String uPassword;
	private String uPhone;
	private String address;
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public RetailerSignUp(String uName, String uEmail, String uPassword, String uPhone, int rId,String address) {
		super();
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uPhone = uPhone;
		this.rId = rId;
	}
	
}
