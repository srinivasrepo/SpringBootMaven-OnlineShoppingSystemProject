package com.example.services;

import java.util.List;

import com.example.dto.AddProduct;
import com.example.dto.Login;
import com.example.dto.RetailerSignUp;
import com.example.entities.Product;

public interface RetailerService {
	public int addRetailer(RetailerSignUp newRetailer);
	public int login(Login login);
	public boolean addProduct(AddProduct product, int rId);
	public RetailerSignUp updateRetailer(RetailerSignUp updateRetailer);
	public AddProduct updateProduct(AddProduct updateProduct, int pId);
	public List<Product> getMyProducts(int rId);

}
