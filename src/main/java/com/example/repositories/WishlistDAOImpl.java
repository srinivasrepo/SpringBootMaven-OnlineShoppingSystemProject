package com.example.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.entities.Wishlist;



@Repository
public class WishlistDAOImpl implements WishlistDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public boolean addToWishlist(int uId, int pId) {
		Customer user = this.entityManager.find(Customer.class, uId);
		Product product = this.entityManager.find(Product.class, pId);
		Wishlist wishlist = new Wishlist();
		wishlist.setUsertable(user);
		wishlist.setProductstable(product);
		this.entityManager.persist(wishlist);
		System.out.println("Added to cart");
		return true;
	}

	@Override
	@Transactional
	public boolean deleteWishlist(int wId) {
		Wishlist wishList = this.entityManager.find(Wishlist.class, wId);
		this.entityManager.remove(wishList);
		System.out.println("Deleted Successfully");
		return true;
	}
	
	
	
}
