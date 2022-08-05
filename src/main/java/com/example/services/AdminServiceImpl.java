package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Login;
import com.example.dto.RetailerSignUp;
import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.repositories.ProductDAO;
import com.example.repositories.RetailerDao;
import com.example.repositories.UserDAO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired//to auto route to retailetrDao 
	RetailerDao rd;
	@Autowired
	ProductDAO pd;
	@Autowired
	UserDAO ud;

	@Override
	public List<RetailerSignUp> showAllRetailers() {
		// TODO Auto-generated method stub
		return rd.showAllRetailers();
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pd.getAllProducts();
	}

	@Override
	public List<Customer> getAllUsers() {
		// TODO Auto-generated method stub
		return ud.getAllUsers();
	}

	
	
 
	
}
