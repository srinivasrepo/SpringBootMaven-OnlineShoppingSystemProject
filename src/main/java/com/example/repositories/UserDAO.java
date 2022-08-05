package com.example.repositories;

import java.util.List;

import com.example.dto.CartDto;
import com.example.dto.UpdateUser;
import com.example.dto.UserSignUp;
import com.example.dto.WishlistDto;
import com.example.entities.Cart;
import com.example.entities.Customer;
import com.example.entities.Wishlist;




public interface UserDAO {
	public List<Customer> getAllUsers(); //done
	public Customer getUserById(int uId); //done
	public int getUserByEmailAndPassword(String email, String password);//done(doubt)
	public Customer getUserByEmail(String email);//done
	public Customer updateUser(int uId, Customer user);//done
	public List<CartDto> getCartOfUser(int uId);//done
	public List<WishlistDto> getWishlistOfUser(int uId);//done
	public int addUser(Customer newUser);//done
	public UserSignUp getUserByIdDto(int uId);
	public int addUser(UserSignUp newUser);
	public Customer updateUser(UpdateUser updateUser);
}
