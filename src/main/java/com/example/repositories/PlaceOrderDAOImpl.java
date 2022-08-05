package com.example.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.example.dto.CartDto;
import com.example.dto.Carts;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.dto.PlacedOrder;
import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.OrderDetails;
import com.example.entities.OrdersTable;
import com.example.entities.Payment;
import com.example.entities.Product;

@Repository
public class PlaceOrderDAOImpl implements PlaceOrderDAO {

	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	@Transactional
	public boolean placeOrder(List<CartDto> carts, String payType) {
		// TODO Auto-generated method stub
		//first get productTable, userTable from a specific Cart
		
		List<OrderDetails> orderDetailTables = new ArrayList<OrderDetails>();
		OrdersTable newOrder = null;
		Cart actualCart = null;
		Customer user = null;
		List<Cart> listOfCarts = new ArrayList<Cart>();
		for(CartDto c: carts) {
			Cart ct=  this.entityManager.find(Cart.class,carts.get(0).getcId());
			listOfCarts.add(ct);
		}
		
		actualCart = this.entityManager.find(Cart.class, carts.get(0).getcId());
		user = actualCart.getUsertable();
		newOrder = new OrdersTable();
		newOrder.setUsertable(user);
		this.entityManager.persist(newOrder);
		//newOrder = new OrdersTable();
		Payment newPayment = new Payment();
		//this.entityManager.persist(newOrder); //save the order now get orderId
		for(CartDto c : carts)
		{
			actualCart = this.entityManager.find(Cart.class, c.getcId());
			// save orderDetails first
//			if(actualCart.getCQty()==0) continue;
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrderPurchaseDate(new Date());
			Date today=new Date();
			long ltime=today.getTime()+5*24*60*60*1000;
			Date deliverDate=new Date(ltime);
			orderDetails.setOrderDeliveryDate(deliverDate);
		    orderDetails.setOrderPrice(actualCart.getProductstable().getProPrice()*actualCart.getCartQuantity());	
			orderDetails.setOrderQuantity(actualCart.getCartQuantity());//orderDetails.setOrderQuantity(actualCart.getCartQuantity());
			orderDetails.setUsertable(actualCart.getUsertable());//orderDetails.setOrdertable(newOrder);
			orderDetails.setProductstable(actualCart.getProductstable());
			orderDetails.setOrdertable(newOrder);
			//orderDetails.setProductstable(actualCart.getProductstable());
			this.entityManager.persist(orderDetails); //adding new OrderDetailsTable
			orderDetailTables.add(orderDetails); //this list is used by newOrder
    float price = orderDetails.getProductstable().getProPrice() ;
    	int quantity = orderDetails.getOrderQuantity();
    	float total = price*quantity;
    	newPayment.setPaymentAmount(total);
			Product product = actualCart.getProductstable();
			int actualProductQty = product.getProQuantity();
			int newProductQty = actualProductQty - actualCart.getCartQuantity();
			product.setProQuantity(newProductQty); 
			this.entityManager.merge(product); //updating Product qty
			this.entityManager.remove(actualCart);
			System.out.println("Cart deleted");//remove from cart as well*/
			System.out.println(orderDetails);
		
		}
	 //adding new Payment
		
		newPayment.setPaymentType(payType);
		//setOrderTable pending!
		//newPayment.setPaymentAmount(total);
		this.entityManager.persist(newPayment);
		newOrder.setOrdersdetails(orderDetailTables);
		newOrder.setPaymenttable(newPayment);
		this.entityManager.merge(newOrder); //update final OrderTable
		System.out.println(newPayment);
		System.out.println(newOrder);
		System.out.println(newPayment);
		return true;
	}
	@Override
	@Transactional
	public List<PlacedOrder> showPlacedOrders(int uId)
	{
		String pType = "";
		List<PlacedOrder> orders = new ArrayList<PlacedOrder>();
		Customer user = this.entityManager.find(Customer.class, uId);
		
//		String q = "from OrdersTable where usertable=:x";
//		Query query = (Query) this.entityManager.createQuery(q);
//		query.setParameter("x", user);
		List<OrderDetails> myOrders =user.getOrdersdetails();
	 
		
		for(OrderDetails o:myOrders)
		{
		     String pName = o.getProductstable().getProName();
			int pId =o.getProductstable().getProId(); 
			String pImage = o.getProductstable().getProImg1();
			String pBrand = o.getProductstable().getProBrand();
			float pPrice =o.getOrderPrice(); 
			int pQty =o.getOrderQuantity(); 
			String pOrderDate =o.getOrderDeliveryDate().toString(); 
			String payType= o.getOrdertable().getPaymenttable().getPaymentType();
	
			orders.add(new PlacedOrder(pName,pId, pImage, pBrand, pPrice, pOrderDate,pQty,payType));
	System.out.println(pName);
		}
		return orders;
	
}
	
	
}
