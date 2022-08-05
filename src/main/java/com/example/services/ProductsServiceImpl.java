package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductDto;
import com.example.repositories.ProductDAO;
@Service
public class ProductsServiceImpl implements ProductsSevice {
	@Autowired
	private ProductDAO productDAO;

	@Override
	public ProductDto getProductById(int pId) {
		// TODO Auto-generated method stub
		return productDAO.getProductById(pId);
	}

	@Override
	public List<ProductDto> getProductBySearch(String keyword) {
		// TODO Auto-generated method stub
		return productDAO.getProductBySearchKeyWord(keyword);
	}

	@Override
	public List<ProductDto> sortProduct(String by, int order) {
		// TODO Auto-generated method stub
		return this.productDAO.sortProduct(by, order);
	}
	@Override
	public List<ProductDto> filterProduct(String brand, float s, float e) {
		// TODO Auto-generated method stub
		return this.productDAO.filterProduct(brand, s, e);
	}

}
