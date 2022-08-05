package com.example.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the PAYMENTTABLE database table.
 * 
 */
@Entity

//@NamedQuery(name="Paymenttable.findAll", query="SELECT p FROM Paymenttable p")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ordertables"})
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAYMENT_ID",length=20)
	private int paymentId;

	@Column(name="PAYMENT_AMOUNT",length=20)
	private Float paymentAmount;

	@Column(name="PAYMENT_TYPE",length=20)
	private String paymentType;

	//bi-directional many-to-one association to Ordertable
	@OneToMany(mappedBy="paymenttable",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrdersTable> ordertables;

	//bi-directional many-to-one association to Usertable
	//@ManyToOne
	//@JoinColumn(name="USER_ID")
	//private Customer usertable;

	public Payment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Float getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(Float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public List<OrdersTable> getOrdertables() {
		return this.ordertables;
	}

	public void setOrdertables(List<OrdersTable> ordertables) {
		this.ordertables = ordertables;
	}

	public OrdersTable addOrdertable(OrdersTable ordertable) {
		getOrdertables().add(ordertable);
		ordertable.setPaymenttable(this);

		return ordertable;
	}

	public OrdersTable removeOrdertable(OrdersTable ordertable) {
		getOrdertables().remove(ordertable);
		ordertable.setPaymenttable(null);

		return ordertable;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentAmount=" + paymentAmount + ", paymentType=" + paymentType
				+ ", ordertables=" + ordertables + "]";
	}

	/*public Customer getUsertable() {
		return this.usertable;
	}

	public void setUsertable(Customer usertable) {
		this.usertable = usertable;
	}
*/
}