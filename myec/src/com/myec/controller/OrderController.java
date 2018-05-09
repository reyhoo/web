package com.myec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.myec.pojo.Address;
import com.myec.pojo.Order;
import com.myec.pojo.Product;
import com.myec.pojo.User;
import com.myec.service.AddrService;
import com.myec.service.OrderService;
import com.myec.service.ProductService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private AddrService addrService;
	@Autowired
	private OrderService orderService;
	@RequestMapping("/selectAddr")
	public String selectAddr(@SessionAttribute("loginUser")User user,
			@RequestParam(required=true)Long productId,Model model) {
		if(productId == null) {
			throw new RuntimeException("productId is null");
		}
		Product product = productService.getProductById(productId);
		if(product == null) {
			throw new RuntimeException("未找到产品");
		}
		if(product.getStock() <= 0) {
			throw new RuntimeException("库存不足");
		}
		System.err.println(product);
		List<Address> addrs = addrService.getUserAddresses(user.getId());
		model.addAttribute("addrList", addrs);
		model.addAttribute("productId", productId);
		return "addrSelect";
	}
	@RequestMapping("/buy")
	public String buy(@SessionAttribute("loginUser")User user,
			@RequestParam(required=true)Long productId,
			@RequestParam(required=true)Long addrId) {
		if(productId == null) {
			throw new RuntimeException("productId is null");
		}
		if(addrId == null) {
			throw new RuntimeException("addrId is null");
		}
		Address addr = addrService.getAddress(addrId, user.getId());
		if(addr == null) {
			throw new RuntimeException("未找到信息");
		}
		orderService.createOrder(user.getId(),2,productId, addr);
		return "redirect:/order/list";
	}
	@RequestMapping("/list")
	public String list(@SessionAttribute("loginUser")User user,Model model) {
		List<Order> orderList = orderService.getUserOrderList(user.getId());
		model.addAttribute("orderList", orderList);
		return "orderList";
	}
	@RequestMapping("/pay")
	public String pay(@SessionAttribute("loginUser")User user,Long id){
		if(id == null) {
			throw new RuntimeException("orderId is null");
		}
		orderService.pay(id, user.getId());
		return "redirect:/order/list";
	}
}
