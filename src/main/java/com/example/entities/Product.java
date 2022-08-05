package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the PRODUCTSTABLE database table.
 * 
 */
@Entity

//@NamedQuery(name="Productstable.findAll", query="SELECT p FROM Productstable p")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","carttables","ordersdetails","wishlisttables","retailerstable"})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRO_ID",length=20)
	private int proId;

	@Column(name="PRO_BRAND",length=20)
	private String proBrand;

	@Column(name="PRO_CATEGORY",length=20)
	private String proCategory;

	@Column(name="PRO_DESCRIPTION",length=50)
	private String proDescription;

	@Column(name="PRO_IMG1")
	private String proImg1;

	@Column(name="PRO_IMG2")
	private String proImg2;

	@Column(name="PRO_IMG3")
	private String proImg3;

	@Column(name="PRO_NAME",length=20)
	private String proName;

	@Column(name="PRO_PRICE",length=10)
	private Float proPrice;

	@Column(name="PRO_QUANTITY",length=10)
	private int proQuantity;

	@Column(name="PRO_SUB_CATEGORY",length=20)
	private String proSubCategory;

	//bi-directional many-to-one association to Carttable
	@OneToMany(mappedBy="productstable", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Cart> carttables;

	//bi-directional many-to-one association to Ordersdetail
	@OneToMany(mappedBy="productstable", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrderDetails> ordersdetails;

	//bi-directional many-to-one association to Retailerstable
	@ManyToOne
	@JoinColumn(name="RETAILER_ID")
	private Retailer retailerstable;

	//bi-directional many-to-one association to Wishlisttable
	@OneToMany(mappedBy="productstable", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Wishlist> wishlisttables;

	public Product() {
	}

	public int getProId() {
		return this.proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProBrand() {
		return this.proBrand;
	}

	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}

	public String getProCategory() {
		return this.proCategory;
	}

	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}

	public String getProDescription() {
		return this.proDescription;
	}

	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}

	public String getProImg1() {
		return this.proImg1;
	}

	public void setProImg1(String proImg1) {
		this.proImg1 = proImg1;
	}

	public String getProImg2() {
		return this.proImg2;
	}

	public void setProImg2(String proImg2) {
		this.proImg2 = proImg2;
	}

	public String getProImg3() {
		return this.proImg3;
	}

	public void setProImg3(String proImg3) {
		this.proImg3 = proImg3;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Float getProPrice() {
		return this.proPrice;
	}

	public void setProPrice(Float proPrice) {
		this.proPrice = proPrice;
	}

	public int getProQuantity() {
		return this.proQuantity;
	}

	public void setProQuantity(int proQuantity) {
		this.proQuantity = proQuantity;
	}

	public String getProSubCategory() {
		return this.proSubCategory;
	}

	public void setProSubCategory(String proSubCategory) {
		this.proSubCategory = proSubCategory;
	}

	public List<Cart> getCarttables() {
		return this.carttables;
	}

	public void setCarttables(List<Cart> carttables) {
		this.carttables = carttables;
	}

	public Cart addCarttable(Cart carttable) {
		getCarttables().add(carttable);
		carttable.setProductstable(this);

		return carttable;
	}

	public Cart removeCarttable(Cart carttable) {
		getCarttables().remove(carttable);
		carttable.setProductstable(null);

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
		ordersdetail.setProductstable(this);

		return ordersdetail;
	}

	public OrderDetails removeOrdersdetail(OrderDetails ordersdetail) {
		getOrdersdetails().remove(ordersdetail);
		ordersdetail.setProductstable(null);

		return ordersdetail;
	}

	public Retailer getRetailerstable() {
		return this.retailerstable;
	}

	public void setRetailerstable(Retailer retailerstable) {
		this.retailerstable = retailerstable;
	}

	public List<Wishlist> getWishlisttables() {
		return this.wishlisttables;
	}

	public void setWishlisttables(List<Wishlist> wishlisttables) {
		this.wishlisttables = wishlisttables;
	}

	public Wishlist addWishlisttable(Wishlist wishlisttable) {
		getWishlisttables().add(wishlisttable);
		wishlisttable.setProductstable(this);

		return wishlisttable;
	}

	public Wishlist removeWishlisttable(Wishlist wishlisttable) {
		getWishlisttables().remove(wishlisttable);
		wishlisttable.setProductstable(null);

		return wishlisttable;
	}

	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proBrand=" + proBrand + ", proCategory=" + proCategory
				+ ", proDescription=" + proDescription + ", proImg1=" + proImg1 + ", proImg2=" + proImg2 + ", proImg3="
				+ proImg3 + ", proName=" + proName + ", proPrice=" + proPrice + ", proQuantity=" + proQuantity
				+ ", proSubCategory=" + proSubCategory + ", carttables=" + carttables + ", ordersdetails="
				+ ordersdetails + ", retailerstable=" + retailerstable + ", wishlisttables=" + wishlisttables + "]";
	}

}