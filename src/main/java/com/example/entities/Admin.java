package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the ADMINTABLE database table.
 * 
 */
@Entity

//@NamedQuery(name="Admintable.findAll", query="SELECT a FROM Admintable a")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","retailerstable"})
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADMIN_ID",length=20)
	private int adminId;

	@Column(name="ADMIN_EMAIL",length=20)
	private String adminEmail;

	@Column(name="ADMIN_MOBILE",length=20)
	private String adminMobile;

	@Column(name="ADMIN_NAME",length=20)
	private String adminName;

	@Column(name="ADMIN_PASSWORD",length=20)
	private String adminPassword;

	//bi-directional many-to-one association to Retailerstable
	@OneToMany(mappedBy="admintable", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Retailer> retailerstables;

	public Admin() {
	}

	public int getAdminId() {
		return this.adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmail() {
		return this.adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminMobile() {
		return this.adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public List<Retailer> getRetailerstables() {
		return this.retailerstables;
	}

	public void setRetailerstables(List<Retailer> retailerstables) {
		this.retailerstables = retailerstables;
	}

	public Retailer addRetailerstable(Retailer retailerstable) {
		getRetailerstables().add(retailerstable);
		retailerstable.setAdmintable(this);

		return retailerstable;
	}

	public Retailer removeRetailerstable(Retailer retailerstable) {
		getRetailerstables().remove(retailerstable);
		retailerstable.setAdmintable(null);

		return retailerstable;
	}

}