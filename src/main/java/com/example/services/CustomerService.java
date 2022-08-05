package com.example.services;
import java.util.List;

import com.example.dto.CartDto;
import com.example.dto.Carts;
import com.example.dto.Login;
import com.example.dto.PlacedOrder;
import com.example.dto.UpdateUser;
import com.example.dto.UserSignUp;
import com.example.dto.WishlistDto;
import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.entities.Wishlist;
public interface CustomerService {
	public int addUser(UserSignUp newUser);
	public int login(Login login);
	public List<CartDto> getCartValues(int uId); 
	public UserSignUp getUserById(int uId);
	public List<WishlistDto> getWishlistValues(int uId);
	public boolean addToCart(int uId, int pId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCart(int cId) ;
	public boolean addToWishlist(int uId, int pId);
	public boolean deleteWishlist(int wId) ;
	public boolean placeOrder(List<CartDto> carts, String payType); 
	public List<PlacedOrder> getMyPlacedOrders(int uId);
	public Customer updateUser(UpdateUser updateUser);
	public List<Product> getAllProducts();
}
