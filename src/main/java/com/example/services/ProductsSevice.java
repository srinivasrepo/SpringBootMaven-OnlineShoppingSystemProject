package com.example.services;

import java.util.List;

import com.example.dto.ProductDto;

public interface ProductsSevice {
	public ProductDto getProductById(int pId);
	public List<ProductDto> getProductBySearch(String keyword);
	public List<ProductDto> sortProduct(String by, int order);
	public List<ProductDto> filterProduct(String brand, float s, float e);
}
