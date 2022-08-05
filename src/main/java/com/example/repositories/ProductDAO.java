package com.example.repositories;

import java.util.List;

import com.example.dto.ProductDto;
import com.example.entities.Product;




public interface ProductDAO {
	public ProductDto  getProductById(int pId);
	public List<ProductDto> getProductBySearchKeyWord(String keyword);
	public List<ProductDto> sortProduct(String by, int order);
	public List<ProductDto> filterProduct(String brand, float s, float e);
	public List<Product> getAllProducts();
}
