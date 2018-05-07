package com.myec.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myec.pojo.Address;
import com.myec.pojo.User;
import com.myec.service.AddrService;

@Controller
@RequestMapping("/addr")
public class AddrController extends BaseController{
	
	@Resource
	private AddrService addrService;
	
	@RequestMapping("/list")
	public String list(@SessionAttribute("loginUser") User user,Model model) {
		List<Address> list = addrService.getUserAddresses(user.getId());
		model.addAttribute("addrList", list);
		return "addrList";
	}
	@RequestMapping("/add")
	public String add(@SessionAttribute("loginUser") User user,
			@Valid Address address,Errors errors,RedirectAttributes ra) {
		if(errors.hasFieldErrors()) {
			String errInfo = "";
			if(errors.hasFieldErrors("addr")) {
				errInfo = errors.getFieldError("addr").getDefaultMessage();
			}else if(errors.hasFieldErrors("mobile")) {
				errInfo = errors.getFieldError("mobile").getDefaultMessage();
			}else if(errors.hasFieldErrors("nickname")) {
				errInfo = errors.getFieldError("nickname").getDefaultMessage();
			}
			ra.addFlashAttribute("errInfo", errInfo);
			return "redirect:/page/addrForm";
		}
		address.setUserId(user.getId());
		addrService.add(address);
		return "redirect:/addr/list";
	}
	@RequestMapping("/toModify")
	public String toModify(@SessionAttribute("loginUser") User user,@RequestParam Long id,Model model) {
		Address addr = addrService.getAddress(id,user.getId());
		if(addr == null) {
			throw new RuntimeException("Œ¥’“µΩ–≈œ¢");
		}
		model.addAttribute("addr", addr);
		return "addrForm";
	}
	@RequestMapping("/delete")
	public String delete(@SessionAttribute("loginUser") User user,@RequestParam Long id) {
		addrService.delete(id, user.getId());
		return "redirect:/addr/list";
	}
	@RequestMapping("/modify")
	public String modify(@SessionAttribute("loginUser") User user,@Valid Address address,Errors errors) {
		System.err.println(address);
		return "redirect:/addr/list";
	}
	
}
