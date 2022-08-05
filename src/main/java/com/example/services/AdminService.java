package com.example.services;

import java.util.List;

import com.example.dto.Login;
import com.example.dto.RetailerSignUp;
import com.example.entities.Customer;
import com.example.entities.Product;

public interface AdminService {
	public List<RetailerSignUp> showAllRetailers();//RetailerSignUp is dto
	public List<Product> getAllProducts();
	public List<Customer> getAllUsers();
	
	
}
