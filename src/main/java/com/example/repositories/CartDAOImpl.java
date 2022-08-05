package com.example.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.repositories.CartDAO;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public boolean addToCart(int uId, int pId)
	{
		Customer user =this.entityManager.find(Customer.class, uId);
		Product product = this.entityManager.find(Product.class, pId);
		Cart cart = new Cart();
		cart.setCartQuantity(1); //by default set qty as 1
		cart.setUsertable(user);
		cart.setProductstable(product);
		this.entityManager.persist(cart);
		System.out.println(cart.getProductstable().getProName()+" added successfully");
		//System.out.println(cart.getUsertable().getUserId());
		System.out.println(cart.getCartId());
		return true;
	}
	
	@Override
	@Transactional
	public boolean updateCart(int cId, int addOrMinus)
	{	
		if(addOrMinus==1)
	        {
		       Cart cart = this.entityManager.find(Cart.class, cId);
		       int productQty = cart.getProductstable().getProQuantity();
		       if(cart.getCartQuantity()+1 <= productQty)
		           {
			                  //update it!
			          int oldQty = cart.getCartQuantity();
			          int newQty = oldQty+1;
			          cart.setCartQuantity(newQty);
			          this.entityManager.merge(cart);
			          System.out.println(cart.getCartId());
			          return true;
		}
		return false;
	}
	if(addOrMinus == -1)
	{
		Cart cart = this.entityManager.find(Cart.class, cId);
		if(cart.getCartQuantity()-1 >= 1)
		{
			//update it!
			int oldQty = cart.getCartQuantity();
			int newQty = oldQty-1;
			cart.setCartQuantity(newQty);
			this.entityManager.merge(cart);
			 System.out.println(cart.getCartId());
			return true;
		}
	}
	return false;
	}
	
	@Override
	@Transactional
	public boolean deleteCart(int cId) 
	{
		Cart cart = this.entityManager.find(Cart.class, cId);
		this.entityManager.remove(cart);
		System.out.println(cart.getProductstable().getProName()+"deleted");
		return true;
	}

	
}
