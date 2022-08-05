package com.example.services;

import java.util.List;

import javax.transaction.Transactional;
import com.example.dto.Carts;
import com.example.dto.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CartDto;
import com.example.dto.PlacedOrder;
import com.example.dto.UpdateUser;
import com.example.dto.UserSignUp;
import com.example.dto.WishlistDto;
import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.entities.Wishlist;
import com.example.repositories.CartDAO;
import com.example.repositories.PlaceOrderDAO;
import com.example.repositories.ProductDAO;
import com.example.repositories.UserDAO;
import com.example.repositories.WishlistDAO;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
   UserDAO user;
	@Autowired
	  CartDAO cd;
	@Autowired
	WishlistDAO wd;
	@Autowired
	PlaceOrderDAO pod;
	@Autowired
	ProductDAO pd;

	@Override
	@Transactional
	public UserSignUp getUserById(int uId) {
		// TODO Auto-generated method stub
		return this.user.getUserByIdDto(uId);
	}
	
	@Override
	public boolean addToCart(int uId, int pId) {
		// TODO Auto-generated method stub
		return this.cd.addToCart(uId, pId);
	
	}
	@Override
	public boolean updateCart(int cId, int addOrMinus) {
		// TODO Auto-generated method stub
		return this.cd.updateCart(cId, addOrMinus);
	}
	@Override
	public boolean deleteCart(int cId) {
		// TODO Auto-generated method stub
		return cd.deleteCart(cId);
	}
	@Override
	public boolean addToWishlist(int uId, int pId) {
		// TODO Auto-generated method stub
		return wd.addToWishlist(uId, pId);
	}
	@Override
	public boolean deleteWishlist(int wId) {
		// TODO Auto-generated method stub
		return wd.deleteWishlist(wId);
	}
	@Override
	@Transactional
	public List<CartDto> getCartValues(int uId) {
		return user.getCartOfUser(uId);
	}
	@Override
	public boolean placeOrder(List<CartDto> carts, String payType) {
		// TODO Auto-generated method stub
		return pod.placeOrder(carts, payType);
	}
	@Override
	public List<WishlistDto> getWishlistValues(int uId) {
		// TODO Auto-generated method stub
		return this.user.getWishlistOfUser(uId);
	}

	@Override
	public List<PlacedOrder> getMyPlacedOrders(int uId) {
		// TODO Auto-generated method stub
		return this.pod.showPlacedOrders(uId);
	}

	@Override
	public int addUser(UserSignUp newUser) {
		
		return user.addUser(newUser);
	}

	@Override
	public Customer updateUser(UpdateUser updateUser) {
		
		return user.updateUser(updateUser);
	}

	@Override
	public int login(Login login) {
		
			// TODO Auto-generated method stub
		int id = user.getUserByEmailAndPassword(login.getEmail(), login.getPassword());
		
		return id;
	

	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pd.getAllProducts();
	}

}
