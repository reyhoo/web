package com.myec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myec.pojo.Product;
import com.myec.pojo.User;
import com.myec.service.ProductService;
import com.myec.service.UserService;
import com.myec.util.RSAUtils;

@Controller
@RequestMapping("/page")
@SessionAttributes(names="")
public class PageController extends BaseController{
	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;
	@RequestMapping("/regist")
	public String regist() {
		String[] keys = RSAUtils.generateKeys();
		getSession().setAttribute("publicKey", keys[0]);
		getSession().setAttribute("privateKey", keys[1]);
		return "regist";
	}
	
	@RequestMapping("/login")
	public String login() {
		String[] keys = RSAUtils.generateKeys();
		getSession().setAttribute("publicKey", keys[0]);
		getSession().setAttribute("privateKey", keys[1]);
		return "login";
	}
	@RequestMapping("/main")
	public String main(Model model) {
		List<Product> list = productService.getAllProductList();
		model.addAttribute("productList", list);
		return "mainPage";
	}
	@RequestMapping("/addrForm")
	public String addrForm() {
		return "addrForm";
	}
}
