package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the WISHLISTTABLE database table.
 * 
 */
@Entity

//@NamedQuery(name="Wishlisttable.findAll", query="SELECT w FROM Wishlisttable w")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productstable","usertable"})
public class Wishlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="WISHLIST_ID",length=20)
	private int wishlistId;

	//bi-directional many-to-one association to Productstable
	@ManyToOne
	@JoinColumn(name="PRO_ID")
	private Product productstable;

	//bi-directional many-to-one association to Usertable
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Customer usertable;

	public Wishlist() {
	}

	public int getWishlistId() {
		return this.wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public Product getProductstable() {
		return this.productstable;
	}

	public void setProductstable(Product productstable) {
		this.productstable = productstable;
	}

	public Customer getUsertable() {
		return this.usertable;
	}

	public void setUsertable(Customer usertable) {
		this.usertable = usertable;
	}

}