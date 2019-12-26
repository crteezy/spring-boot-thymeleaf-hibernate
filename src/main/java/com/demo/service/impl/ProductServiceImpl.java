package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Product;
import com.demo.repository.ProductRepository;
import com.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		repo.save(product);
	}

	@Override
	public Product getProduct(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}

}
