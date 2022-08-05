package com.example.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AddProduct;
import com.example.dto.Login;
import com.example.dto.RetailerSignUp;
import com.example.entities.Product;
import com.example.entities.Retailer;
import com.example.repositories.RetailerDao;
import com.example.services.AdminService;

@Service
public class RetailerServiceImpl implements RetailerService {
	@Autowired
	RetailerDao rt;

	@Override
	public int addRetailer(RetailerSignUp newRetailer) {
		// TODO Auto-generated method stub
		return rt.addRetailer(newRetailer);
	}

	@Override
	public boolean addProduct(AddProduct product, int rId) {
		// TODO Auto-generated method stub
		return rt.addProduct(product, rId);
	}

	@Override
	public RetailerSignUp updateRetailer(RetailerSignUp updateRetailer) {
		// TODO Auto-generated method stub
		return rt.updateRetailer(updateRetailer);
	}

	@Override
	public AddProduct updateProduct(AddProduct updateProduct, int pId) {
		// TODO Auto-generated method stub
		return rt.updateProduct(updateProduct, pId);
	}

	@Override
	public List<Product> getMyProducts(int rId) {
		// TODO Auto-generated method stub
		return this.rt.showMyProducts(rId);
	}

	@Override
	public int login(Login login) {
		// TODO Auto-generated method stub
		return rt.getRetailerByEmailAndPassword(login.getEmail(), login.getPassword());
	}
	

}
