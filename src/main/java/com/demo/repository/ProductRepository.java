package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
