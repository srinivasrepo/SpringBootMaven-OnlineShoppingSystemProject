package com.example.dto;

public class UserSignUp {
	public UserSignUp() {
		
	}
	public UserSignUp(String uName, String uEmail, String uPassword, String uAddress, String uPhone,String uGender) {
		super();
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uMobile = uPhone;
		this.uGender = uGender;
	}
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
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuPhone() {
		return uMobile;
	}
	public void setuPhone(String uPhone) {
		this.uMobile = uPhone;
	}
	private String uName;
	private String uEmail;
	private String uPassword;
	private String uAddress;
	private String uMobile;
	private String uGender;
	public String getuGender() {
		return uGender;
	}
	public void setuGender(String uGender) {
		this.uGender = uGender;
	}
	
}
