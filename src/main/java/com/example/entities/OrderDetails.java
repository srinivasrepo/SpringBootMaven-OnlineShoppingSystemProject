package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the ORDERSDETAILS database table.
 * 
 */
@Entity
//@NamedQuery(name="Ordersdetail.findAll", query="SELECT o FROM Ordersdetail o")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ordertable","productstable","usertable"})
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDERDETAILS_ID")
	private int orderdetailsId;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_DELIVERY_DATE")
	private Date orderDeliveryDate;

	@Column(name="ORDER_PRICE",length=20)
	private Float orderPrice;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_PURCHASE_DATE")
	private Date orderPurchaseDate;

	@Column(name="ORDER_QUANTITY",length=20)
	private int orderQuantity;

	//bi-directional many-to-one association to Ordertable
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private OrdersTable ordertable;

	//bi-directional many-to-one association to Productstable
	@ManyToOne
	@JoinColumn(name="PRO_ID")
	private Product productstable;

	//bi-directional many-to-one association to Usertable
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Customer usertable;

	public OrderDetails() {
	}

	public int getOrderdetailsId() {
		return this.orderdetailsId;
	}

	public void setOrderdetailsId(int orderdetailsId) {
		this.orderdetailsId = orderdetailsId;
	}

	public Date getOrderDeliveryDate() {
		return this.orderDeliveryDate;
	}

	public void setOrderDeliveryDate(Date orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}

	public Float getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getOrderPurchaseDate() {
		return this.orderPurchaseDate;
	}

	public void setOrderPurchaseDate(Date orderPurchaseDate) {
		this.orderPurchaseDate = orderPurchaseDate;
	}

	public int getOrderQuantity() {
		return this.orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public OrdersTable getOrdertable() {
		return this.ordertable;
	}

	public void setOrdertable(OrdersTable ordertable) {
		this.ordertable = ordertable;
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