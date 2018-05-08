package com.myec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.myec.pojo.Product;
import com.myec.pojo.User;
import com.myec.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list")
	public String list(@SessionAttribute("loginUser") User user,Model model) {
		List<Product> list = productService.getProductListByUserId(user.getId());
		model.addAttribute("productList", list);
		return "productList";
	}
}
