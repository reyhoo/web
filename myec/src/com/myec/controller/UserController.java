package com.myec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.myec.pojo.User;
import com.myec.service.UserService;
import com.myec.util.CommonsEmailUtils;
import com.myec.util.MessageUtils;

@Controller
@RequestMapping("/user")
@SessionAttributes(names="loginUser")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/sendEmail")
	@ResponseBody
	public Map<String, Object>sendEmail(String email){
		User user = userService.getByUsername(email);
		Map<String, Object>map = new HashMap<>();
//		if(user != null) {
//			map.put("result", "fail");
//			map.put("errInfo", "用户已存在");
//			return map;
//		}
		int result = CommonsEmailUtils.sendHtmlMail(email);
		if(result == 0) {
			map.put("result", "success");
			map.put("errInfo", "发送成功!");
		}else if(result == -1) {
			map.put("result", "fail");
			map.put("errInfo", "发送太频繁");
		}else if(result == -2) {
			map.put("result", "fail");
			map.put("errInfo", "邮箱格式信息错误或系统异常");
		}
		return map;
	}
	
	@RequestMapping("/regist")
	public String regist(@Valid User user,Errors errors,String emailCode,RedirectAttributes ra) {
		if(errors.hasFieldErrors()) {
			String errInfo = "";
			if(errors.hasFieldErrors("username")) {
				errInfo = errors.getFieldError("username").getDefaultMessage();
			}else if(errors.hasFieldErrors("password")) {
				errInfo = errors.getFieldError("password").getDefaultMessage();
			}
			ra.addFlashAttribute("errInfo", errInfo);
			return "redirect:/page/regist";
		}
		if(emailCode == null || "".equals(emailCode.trim())) {
			ra.addFlashAttribute("errInfo", "验证码不能为空");
			return  "redirect:/page/regist";
		}
		String code = CommonsEmailUtils.getVerifyCode(user.getUsername());
		if(code == null || !emailCode.equals(code)) {
			ra.addFlashAttribute("errInfo", "验证码不正确或邮箱未验证");
			return  "redirect:/page/regist";
		}
		synchronized (user.getUsername().intern()) {
			User u = userService.getByUsername(user.getUsername());
			if(u != null) {
				ra.addFlashAttribute("errInfo", "用户已经存在");
				return  "redirect:/page/regist";
			}
			user.setPassword(MessageUtils.md5(user.getPassword()));
			userService.regist(user);
			return "redirect:/page/login";
		}
		
	}
	@RequestMapping("/login")
	public String login(@Valid User user,Errors errors,RedirectAttributes ra,Model model) {
		if(errors.hasFieldErrors()) {
			String errInfo = "";
			if(errors.hasFieldErrors("username")) {
				errInfo = errors.getFieldError("username").getDefaultMessage();
			}else if(errors.hasFieldErrors("password")) {
				errInfo = errors.getFieldError("password").getDefaultMessage();
			}
			ra.addFlashAttribute("errInfo", errInfo);
			return "redirect:/page/login";
		}
		User u = userService.login(user.getUsername(), MessageUtils.md5(user.getPassword()));
		if(u == null) {
			ra.addFlashAttribute("errInfo", "用户信息不正确");
			return "redirect:/page/login";
		}
		model.addAttribute("loginUser", u);
		return "redirect:/page/main";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
	
}
