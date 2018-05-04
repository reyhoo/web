package com.myec.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.myec.pojo.Address;
import com.myec.pojo.User;
import com.myec.service.AddrService;

@Controller
@RequestMapping("/addr")
public class AddrController {
	
	@Resource
	private AddrService addrService;
	
	@RequestMapping("/list")
	public String list(@SessionAttribute("loginUser") User user,Model model) {
		List<Address> list = addrService.getUserAddresses(user.getId());
		model.addAttribute("addrList", list);
		return "addrList";
	}
}
