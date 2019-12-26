package com.demo.service;

import java.util.List;

import com.demo.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	void saveProduct(Product product);

	Product getProduct(Long id);

	void deleteProduct(Long id);
}
