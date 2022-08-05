package com.example.repositories;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dto.AddProduct;
import com.example.dto.RetailerSignUp;
import com.example.dto.UserSignUp;
import com.example.entities.Admin;
import com.example.entities.Customer;
import com.example.entities.Product;
import com.example.entities.Retailer;

@Repository
public interface RetailerDao {
	public  int addRetailer(RetailerSignUp  rt);//done
	//public RetailerSignUp getRetailerById(int rid);//done
	public void addAdmin(Admin ad);
	public boolean addProduct( AddProduct product, int RetailerId);//done
	public int getRetailerByEmailAndPassword(String email,String Password);//done
	public RetailerSignUp updateRetailer(RetailerSignUp retailer);//done
	public AddProduct updateProduct(AddProduct updateProduct, int pId);//done
	public List<Product> showMyProducts(int retailerId);//done
	public Retailer getRetailerByEmail(String email) ;//done
	public List<RetailerSignUp> showAllRetailers ();
	
	
}
