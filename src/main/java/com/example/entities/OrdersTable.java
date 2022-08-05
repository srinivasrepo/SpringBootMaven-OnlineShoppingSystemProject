package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the ORDERTABLE database table.
 * 
 */
@Entity

//@NamedQuery(name="Ordertable.findAll", query="SELECT o FROM Ordertable o")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","paymenttable","usertable","ordersdetails"})
public class OrdersTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID",length=20)
	private int orderId;
	

	//bi-directional many-to-one association to Ordersdetail
	@OneToMany(mappedBy="ordertable", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrderDetails> ordersdetails;

	//bi-directional many-to-one association to Paymenttable
	@ManyToOne
	@JoinColumn(name="PAYMENT_ID")
	private Payment paymenttable;

	//bi-directional many-to-one association to Usertable
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Customer usertable;

	public OrdersTable() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderDetails> getOrdersdetails() {
		return this.ordersdetails;
	}

	public void setOrdersdetails(List<OrderDetails> ordersdetails) {
		this.ordersdetails = ordersdetails;
	}

	public OrderDetails addOrdersdetail(OrderDetails ordersdetail) {
		getOrdersdetails().add(ordersdetail);
		ordersdetail.setOrdertable(this);

		return ordersdetail;
	}

	public OrderDetails removeOrdersdetail(OrderDetails ordersdetail) {
		getOrdersdetails().remove(ordersdetail);
		ordersdetail.setOrdertable(null);

		return ordersdetail;
	}

	public Payment getPaymenttable() {
		return this.paymenttable;
	}

	public void setPaymenttable(Payment paymenttable) {
		this.paymenttable = paymenttable;
	}

	public Customer getUsertable() {
		return this.usertable;
	}

	public void setUsertable(Customer usertable) {
		this.usertable = usertable;
	}

}