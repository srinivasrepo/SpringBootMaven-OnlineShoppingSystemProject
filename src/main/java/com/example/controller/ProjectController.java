package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AddProduct;
import com.example.dto.CartDto;
import com.example.dto.Carts;
import com.example.dto.Login;
import com.example.dto.PlacedOrder;
import com.example.dto.ProductDto;
import com.example.dto.RetailerSignUp;
import com.example.dto.UpdateUser;
import com.example.dto.UserSignUp;
import com.example.dto.WishlistDto;
import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.services.AdminService;
import com.example.services.CustomerService;
import com.example.services.ProductsSevice;
import com.example.services.RetailerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {
	@Autowired
	CustomerService cs;
	@Autowired
	ProductsSevice ps;
	@Autowired
	AdminService as;
	@Autowired
	RetailerService rs;
	//Customer        retalted      controllers
	
	@PostMapping(path = "/userRegistration") //done
	public int addNewUser(@RequestBody UserSignUp newUser)
	{
		 
		return this.cs.addUser(newUser);
			
	}
	
	
	@PostMapping(path = "/userLogin") //done
	public int login(@RequestBody Login login)
	{
		try {
			System.out.println(login.getEmail());
			System.out.println(login.getPassword());
			
			return this.cs.login(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -100;
		}
	}
	
	@GetMapping(path = "/getAllProductsForUser")
	public List<Product>  getAllProductsForUser() {
	
		return cs.getAllProducts();
	}
	
	@GetMapping(path = "/getProductBySearch/{pSearch}") //need to check again
	public List<ProductDto> getProductBySearch(@PathVariable String pSearch)
	{
			return this.ps.getProductBySearch(pSearch);
	}
	
	@GetMapping(path = "/sortProduct/{by}/{order}") //need to check again
	public List<ProductDto> sortProduct(@PathVariable String by, @PathVariable String order)
	{
		return this.ps.sortProduct(by, Integer.parseInt(order));
	}
	@GetMapping(path = "/filterProduct/{brand}/{s}/{e}") //need to check again
	public List<ProductDto> filterProduct(@PathVariable String brand, @PathVariable String s, @PathVariable String e)
	{
		return this.ps.filterProduct(brand, Float.parseFloat(s),  Float.parseFloat(e));
	}
	@GetMapping(path = "/getProductById/{pId}") //done
	public ProductDto getProductById( @PathVariable String pId) {
		// TODO Auto-generated method stub
		return ps.getProductById(Integer.parseInt(pId));
	}
	
	
	@GetMapping(path = "/addToMyCart/{uId}/{pId}") //done
	public String addToMyCart(@PathVariable String uId, @PathVariable String pId)
	{
		boolean ok = this.cs.addToCart(Integer.parseInt(uId),Integer.parseInt(pId));
		if(ok==true) 
			return "Product Added to Cart Successfully";
		
		else 
		return "Cannot Add Product to Cart";
				
	}
	@GetMapping(path = "/getMyCart/{uId}") //need to check
	public List<CartDto> getMyCart(@PathVariable String uId)
	{
		return cs.getCartValues(Integer.parseInt(uId));
	}

	@GetMapping(path = "/updateMyCart/{cId}/{addOrMinus}") //done
	public String updateMyCart(@PathVariable String cId, @PathVariable String addOrMinus)
	{
		boolean ok = this.cs.updateCart(Integer.parseInt(cId),Integer.parseInt(addOrMinus));
		if(ok==true)
			return "Cart Updated Successfully";
	else
		return "Cannot Update Cart";
	}
	@DeleteMapping(path = "/deleteToMyCart/{cId}")//done
	public String deleteMyCart(@PathVariable String cId)
	{
		boolean ok = this.cs.deleteCart(Integer.parseInt(cId));
		if(ok==true) 
			return "Product deleted from Cart Successfully";
		
		else 
		return "No carts to delete";
				
	}
	@GetMapping(path = "/addToMyWishlist/{uId}/{pId}") //done
	public String addToMyWishlist(@PathVariable String uId, @PathVariable String pId)
	{
		boolean ok = this.cs.addToWishlist(Integer.parseInt(uId),Integer.parseInt(pId));
		if(ok==true) 
			return "Product Added to wishlist Successfully";
		
		else 
		return "Cannot Add Product to Wishlist";
				
	}
	
	@DeleteMapping(path = "/deleteToMyWishlist/{wId}") //done
	public String deleteMyWishlist(@PathVariable String wId)
	{
		boolean ok = this.cs.deleteWishlist(Integer.parseInt(wId));
		if(ok==true) 
			return "Product deleted from wishlist Successfully";
		
		else 
		return "No wishlist to delete";
				
	}
	
	@PostMapping(path = "/placeOrder/{payType}") //done
	public String placeOrder(@RequestBody List<CartDto> carts, @PathVariable String payType) 
	{
		boolean ok = this.cs.placeOrder(carts,payType);
		if(ok==true)
			return "Order Place Successfull";
		else
		return "Order Place Failure";
	}

	@GetMapping(path = "/getMyPlacedOrders/{uId}") //done
	public List<PlacedOrder> placedOrders(@PathVariable String uId)
	{
		return this.cs.getMyPlacedOrders(Integer.parseInt(uId));
	}
	

	@PutMapping(path = "/updateUser") 
	public String updateUser(@RequestBody UpdateUser updateUser)
	  {
		
			Customer ok = this.cs.updateUser(updateUser);
			return "Updated successfully";
	 }
	@GetMapping(path = "/getUserById/{uId}") //done
	public UserSignUp getUserById(@PathVariable String uId)
	{
		UserSignUp user = this.cs.getUserById(Integer.parseInt(uId));
		return user;
	}
	@GetMapping(path = "/getMyWishlist/{uId}")//done
	public List<WishlistDto> getMyWishlist(@PathVariable String uId)
	{
		return cs.getWishlistValues(Integer.parseInt(uId));
	}
	
	
	@PostMapping(path = "/addNewRetailer") 
	public String addNewRetailer(@RequestBody RetailerSignUp newRetailer)
	{
		int id =this.rs.addRetailer(newRetailer);
		return "Registred sucessfully";
	}
	
	@PostMapping(path = "/addProduct/{rId}") 
	public String addProduct(@RequestBody AddProduct product, @PathVariable String rId)
	{
	     boolean ok = this.rs.addProduct(product, Integer.parseInt(rId));
	     return "Product added succesfully";
	}
	@PutMapping(path = "/updateProduct/{pId}") 
	public String updateProduct(@RequestBody AddProduct updateProduct, @PathVariable String pId)
	{
		AddProduct ap = this.rs.updateProduct(updateProduct, Integer.parseInt(pId));
		return "Product updated succesfully";
	}
	@GetMapping(path = "/getMyProduct/{rId}")//To be changed
	public List<Product> getMyProduct(@PathVariable String rId)
	{
		return this.rs.getMyProducts(Integer.parseInt(rId));
	}

	@PutMapping(path = "/updateRetailer") 
	public RetailerSignUp updateRetailer(@RequestBody RetailerSignUp updateRetailer)
	{
		return this.rs.updateRetailer(updateRetailer);
	}
	
	// Admin related services
	
	
		@GetMapping(path = "/showAllRetailers")
		public List<RetailerSignUp> showAllRetailers()
		{
			return this.as.showAllRetailers();
		}
	@GetMapping(path = "/getAllProductsForAdmin")
	public List<Product>  getAllProductsForAdmin() {
	
		return as.getAllProducts();
	}
	@GetMapping(path = "/getAllCustomersForAdmin")
	public List<Customer>  getAllCustomers() {
	
		return as.getAllUsers();
	}
	
	@PostMapping(path = "/retailerLogin") //done
	public int retailerLogin(@RequestBody Login login)
	{
		try {
			
			return this.rs.login(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -100;
		}
	}
	
	
	
}
