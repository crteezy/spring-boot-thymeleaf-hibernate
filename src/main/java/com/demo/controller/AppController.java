package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.domain.Product;
import com.demo.service.ProductService;

@Controller
public class AppController {

	@Autowired
	private ProductService service;
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String displayViewProductsPage(Model model) {
//		List<Product> products = service.getAllProducts();
//		model.addAttribute("products", products);
//		return "/html/index";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayViewProductsPage() {
		List<Product> products = service.getAllProducts();
		ModelAndView view = new ModelAndView("/html/index");
		view.addObject("products", products);
		return view;
	}
	
//	@RequestMapping(value = "/addNew", method = RequestMethod.GET)
//	public String displayCreateProductsPage(Model model) {
//		Product product = new Product();
//		model.addAttribute("product", product);
//		return "/html/new_product";
//	}
	
	@RequestMapping(value = "/addNew", method = RequestMethod.GET)
	public ModelAndView displayCreateProductsPage() {
		ModelAndView view = new ModelAndView("/html/new_product");
		Product product = new Product();
		view.addObject("product", product);
		return view;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView displayEditProductsPage(@PathVariable(name = "id") Long id) {
		ModelAndView view = new ModelAndView("/html/edit_product");
		Product product = service.getProduct(id);
		view.addObject("product", product);
		return view;
	}
}
