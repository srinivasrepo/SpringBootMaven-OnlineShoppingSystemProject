package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the CARTTABLE database table.
 * 
 */
@Entity
//@NamedQuery(name="Carttable.findAll", query="SELECT c FROM Carttable c")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productstable","usertable "})
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CART_ID")
	private int cartId;

	@Column(name="CART_QUANTITY",length=20)
	private int cartQuantity;

	//bi-directional many-to-one association to Productstable
	@ManyToOne
	@JoinColumn(name="PRO_ID")
	private Product productstable;

	//bi-directional many-to-one association to Usertable
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Customer usertable;

	public Cart() {
	}

	public int getCartId() {
		return this.cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartQuantity() {
		return this.cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
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

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartQuantity=" + cartQuantity + ", productstable=" + productstable
				+ ", usertable=" + usertable + "]";
	}

}