package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.domain.Product;
import com.demo.service.ProductService;

@Controller
public class AppController {

	@Autowired
	private ProductService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewProductsPage(Model model) {
		List<Product> products = service.getAllProducts();
		model.addAttribute("products", products);
		return "index";
	}
}
