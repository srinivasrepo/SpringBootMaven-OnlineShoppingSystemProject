package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the RETAILERSTABLE database table.
 * 
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productstables","admintable"})
public class Retailer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RETAILER_ID",length=20)
	private int retailerId;

	@Column(name="RETAILER_ADDRESS")
	private String retailerAddress;

	@Column(name="RETAILER_EMAIL",length=20)
	private String retailerEmail;

	@Column(name="RETAILER_MOBILE",length=20)
	private String retailerMobile;

	@Column(name="RETAILER_NAME",length=20)
	private String retailerName;

	@Column(name="RETAILER_PASSWORD",length=20)
	private String retailerPassword;

	//bi-directional many-to-one association to Productstable
	@OneToMany(mappedBy="retailerstable",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Product> productstables;

	//bi-directional many-to-one association to Admintable  ***one to one and many to one FETCH TYPE IS EAGER****
	@ManyToOne
	@JoinColumn(name="ADMIN_ID")
	private Admin admintable;

	public Retailer() {
	}

	public int getRetailerId() {
		return this.retailerId;
	}

	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerAddress() {
		return this.retailerAddress;
	}

	public void setRetailerAddress(String retailerAddress) {
		this.retailerAddress = retailerAddress;
	}

	public String getRetailerEmail() {
		return this.retailerEmail;
	}

	public void setRetailerEmail(String retailerEmail) {
		this.retailerEmail = retailerEmail;
	}

	public String getRetailerMobile() {
		return this.retailerMobile;
	}

	public void setRetailerMobile(String retailerMobile) {
		this.retailerMobile = retailerMobile;
	}

	public String getRetailerName() {
		return this.retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getRetailerPassword() {
		return this.retailerPassword;
	}

	public void setRetailerPassword(String retailerPassword) {
		this.retailerPassword = retailerPassword;
	}

	public List<Product> getProductstables() {
		return this.productstables;
	}

	public void setProductstables(List<Product> productstables) {
		this.productstables = productstables;
	}

	public Product addProductstable(Product productstable) {
		getProductstables().add(productstable);
		productstable.setRetailerstable(this);

		return productstable;
	}

	public Product removeProductstable(Product productstable) {
		getProductstables().remove(productstable);
		productstable.setRetailerstable(null);

		return productstable;
	}

	public Admin getAdmintable() {
		return this.admintable;
	}

	public void setAdmintable(Admin admintable) {
		this.admintable = admintable;
	}

	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", retailerAddress=" + retailerAddress + ", retailerEmail="
				+ retailerEmail + ", retailerMobile=" + retailerMobile + ", retailerName=" + retailerName
				+ ", retailerPassword=" + retailerPassword + ", productstables=" + productstables + ", admintable="
				+ admintable + "]";
	}
	

}