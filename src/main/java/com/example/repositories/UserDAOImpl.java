package com.example.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.dto.CartDto;
import com.example.dto.UpdateUser;
import com.example.dto.UserSignUp;
import com.example.dto.WishlistDto;
import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.Wishlist;





@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Customer> getAllUsers() {
		Query q = null;
		String query = "from Customer";
		q = (Query) this.entityManager.createQuery(query);
		System.out.println(query);
		List<Customer> result = (List<Customer>) q.getResultList();
		for(Customer cs:result) {
			System.out.println(cs.getUserName());	
		}
		return result;
	}

	@Override
	public Customer getUserById(int uId) {
		Customer user = this.entityManager.find(Customer.class, uId);
		System.out.println("User is :"+user.getUserName());
		return user;
	}

	@Override
	public int getUserByEmailAndPassword(String email, String password) {
		Query q = null;
				String query = "select userId from Customer where userEmail=:x and userPassword=:y";
				q = (Query) this.entityManager.createQuery(query);
				q.setParameter("x", email);
				q.setParameter("y", password);
		int id = (int)q.getSingleResult();
			System.out.println(id);	
			return id;
	}

	@Override
	public Customer getUserByEmail(String email) {
		Query q = null;
		
		String query = "from Customer where userEmail=:x";
		q = (Query) this.entityManager.createQuery(query);
		q.setParameter("x", email);

Customer cs = (Customer)q.getSingleResult();
System.out.println(cs.getUserName());
return cs;
	}

	@Override
	@Transactional
	public Customer updateUser(int uId, Customer user) {
		entityManager.merge(user);
		System.out.println(user.getUserId());
		return null;
	}

	@Override
	@Transactional
	public List<CartDto> getCartOfUser(int uId) {
		float totalPrice = 0;
		List<CartDto> cartList = new ArrayList<CartDto>();
		Customer user = (Customer)this.entityManager.find(Customer.class, uId);
		List<Cart> cart = user.getCarttables();
		cart = user.getCarttables();
      //cartList.addAll(user.getCarttables());
		for(Cart c : cart)
		{
			int cId = c.getCartId();
			int pId = c.getProductstable().getProId();
			String pName = c.getProductstable().getProName();
			int cQty = c.getProductstable().getProQuantity()>=c.getCartQuantity() ? c.getCartQuantity() : 0;
			String pBrand = c.getProductstable().getProBrand();
			 float pPrice = c.getProductstable().getProPrice();
			 totalPrice += pPrice*cQty;
			String pImage1 = c.getProductstable().getProImg1();
	         System.out.println(totalPrice);
	         System.out.println(cId);
	         System.out.println(pId);
	         System.out.println(pName);
	         System.out.println(pBrand);
	         System.out.println(pPrice);
	cartList.add(new CartDto(pId,cQty,pName,pBrand,pPrice,cId,totalPrice,pImage1));
		}
		return cartList;
		
	}

	@Override
	@Transactional
	public List<WishlistDto> getWishlistOfUser(int uId) {
		List<WishlistDto> wishListDto = new ArrayList<WishlistDto>();
		Customer user = (Customer)this.entityManager.find(Customer.class, uId);
		System.out.println("User is :"+user);
		List<Wishlist> wishList = user.getWishlisttables();

		for(Wishlist w : wishList)
		{
			int wId = w.getWishlistId();
			int pId = w.getProductstable().getProId();
			String pName = w.getProductstable().getProName();
			String pBrand = w.getProductstable().getProBrand();
			float pPrice = w.getProductstable().getProPrice();
			String pImage1 = w.getProductstable().getProImg1();
	 System.out.println(pName);
	 wishListDto.add(new WishlistDto(pId,pName,pBrand,pPrice,wId,pImage1));
		}
		return wishListDto;
	}

	@Override
	@Transactional
	public int addUser(Customer newUser) {
		entityManager.persist(newUser);
		System.out.println("Added successfully");
		System.out.println("Your user_id is "+newUser.getUserId());
		return newUser.getUserId();
	}

	@Override
	public UserSignUp getUserByIdDto(int uId) {
		UserSignUp userDto ;
		Customer user = this.entityManager.find(Customer.class, uId);
		System.out.println("User is :"+user.getUserName());
		 String uName = user.getUserName();
		 String uEmail = user.getUserEmail();
		 String uPassword = user.getUserPassword();
		 String uAddress = user.getUserAddress();
		 String uMobile = user.getUserMobile();
		 String uGender = user.getUserGender();
	userDto=new UserSignUp (uName,uEmail,uPassword,uAddress,uMobile, uGender);
		return userDto;
	}

	@Override
	@Transactional
	public int addUser(UserSignUp newUser) {
		Customer user = new Customer();
		user.setUserName(newUser.getuName());
		user.setUserPassword(newUser.getuPassword());
		user.setUserAddress(newUser.getuAddress());
		user.setUserEmail(newUser.getuEmail());
		user.setUserMobile(newUser.getuPhone());
		user.setUserGender(newUser.getuGender());
		this.entityManager.persist(user);
	
		System.out.println("Added successfully");
Query q = null;
		
		String query = "from Customer where userName=:x";
		q = (Query) this.entityManager.createQuery(query);
		q.setParameter("x", user.getUserName());
	Customer c = (Customer) q.getSingleResult();
		
		//System.out.println("Your user_id is "+newUser.getUserId());
		//return newUser.getUserId();
		return c.getUserId();
	}

	@Override
	@Transactional
	public Customer updateUser(UpdateUser updateUser) {
		// TODO Auto-generated method stub
		int uId = updateUser.getuId();
		Customer existingUser = this.entityManager.find(Customer.class, uId);
		existingUser.setUserName(updateUser.getuName());
		existingUser.setUserPassword(updateUser.getuPassword());
		existingUser.setUserAddress(updateUser.getuAddress());
		existingUser.setUserEmail(updateUser.getuEmail());
		existingUser.setUserMobile(updateUser.getuPhone());
		this.entityManager.merge(existingUser);
		return existingUser;
	
	}

}
