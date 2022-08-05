package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the USERTABLE database table.
 * 
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","carttables","ordersdetails","wishlisttables","ordertables"})
//@NamedQuery(name="Usertable.findAll", query="SELECT u FROM Usertable u")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID",length=20)
	private int userId;

	@Column(name="USER_ADDRESS")
	private String userAddress;

	@Column(name="USER_EMAIL",length=20)
	private String userEmail;

	@Column(name="USER_GENDER",length=10)
	private String userGender;

	@Column(name="USER_MOBILE",length=13)
	private String userMobile;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_PASSWORD")
	private String userPassword;

	//bi-directional many-to-one association to Carttable
	@OneToMany(mappedBy="usertable", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Cart> carttables; 

	//bi-directional many-to-one association to Ordersdetail
	@OneToMany(mappedBy="usertable", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrderDetails> ordersdetails;

	//bi-directional many-to-one association to Ordertable
	@OneToMany(mappedBy="usertable", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrdersTable> ordertables;

	//bi-directional many-to-one association to Paymenttable
	//@OneToMany(mappedBy="usertable", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	//private List<Payment> paymenttables;

	//bi-directional many-to-one association to Wishlisttable
	@OneToMany(mappedBy="usertable", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Wishlist> wishlisttables;

	public Customer() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Cart> getCarttables() {
		return this.carttables;
	}

	public void setCarttables(List<Cart> carttables) {
		this.carttables = carttables;
	}

	public Cart addCarttable(Cart carttable) {
		getCarttables().add(carttable);
		carttable.setUsertable(this);

		return carttable;
	}

	public Cart removeCarttable(Cart carttable) {
		getCarttables().remove(carttable);
		carttable.setUsertable(null);

		return carttable;
	}

	public List<OrderDetails> getOrdersdetails() {
		return this.ordersdetails;
	}

	public void setOrdersdetails(List<OrderDetails> ordersdetails) {
		this.ordersdetails = ordersdetails;
	}

	public OrderDetails addOrdersdetail(OrderDetails ordersdetail) {
		getOrdersdetails().add(ordersdetail);
		ordersdetail.setUsertable(this);

		return ordersdetail;
	}

	public OrderDetails removeOrdersdetail(OrderDetails ordersdetail) {
		getOrdersdetails().remove(ordersdetail);
		ordersdetail.setUsertable(null);

		return ordersdetail;
	}

	public List<OrdersTable> getOrdertables() {
		return this.ordertables;
	}

	public void setOrdertables(List<OrdersTable> ordertables) {
		this.ordertables = ordertables;
	}

	public OrdersTable addOrdertable(OrdersTable ordertable) {
		getOrdertables().add(ordertable);
		ordertable.setUsertable(this);

		return ordertable;
	}

	public OrdersTable removeOrdertable(OrdersTable ordertable) {
		getOrdertables().remove(ordertable);
		ordertable.setUsertable(null);

		return ordertable;
	}

	/*public List<Payment> getPaymenttables() {
		return this.paymenttables;
	}

	public void setPaymenttables(List<Payment> paymenttables) {
		this.paymenttables = paymenttables;
	}
*
	public Payment addPaymenttable(Payment paymenttable) {
		getPaymenttables().add(paymenttable);
		paymenttable.setUsertable(this);

		return paymenttable;
	}

	public Payment removePaymenttable(Payment paymenttable) {
		getPaymenttables().remove(paymenttable);
		paymenttable.setUsertable(null);

		return paymenttable;
	}*/

	public List<Wishlist> getWishlisttables() {
		return this.wishlisttables;
	}

	public void setWishlisttables(List<Wishlist> wishlisttables) {
		this.wishlisttables = wishlisttables;
	}

	public Wishlist addWishlisttable(Wishlist wishlisttable) {
		getWishlisttables().add(wishlisttable);
		wishlisttable.setUsertable(this);

		return wishlisttable;
	}

	public Wishlist removeWishlisttable(Wishlist wishlisttable) {
		getWishlisttables().remove(wishlisttable);
		wishlisttable.setUsertable(null);

		return wishlisttable;
	}

}