package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.domain.Product;
import com.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product) {
		service.saveProduct(product);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.deleteProduct(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	@ResponseBody
	public ModelMap getAllProducts() {
		ModelMap model = new ModelMap();
		List<Product> products = service.getAllProducts();
		model.put("products", products);
		return model;
	}

	@RequestMapping(value = "/saveWithAjaxPost", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap saveWithAjaxPost(@ModelAttribute Product product) {
		ModelMap model = new ModelMap();
		service.saveProduct(product);
		model.put("MESSAGE", "Success");
		return model;
	}
}
