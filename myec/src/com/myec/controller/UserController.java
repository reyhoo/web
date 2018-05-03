package com.myec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myec.pojo.User;
import com.myec.service.UserService;
import com.myec.util.CommonsEmailUtils;
import com.myec.util.MessageUtils;
import com.myec.util.RSACoder;

@Controller
@RequestMapping("/user")
//@SessionAttributes(names="loginUser")
public class UserController extends BaseController{
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
//	@ModelAttribute
//	public void populateModel(Model model){
//		System.err.println("populateModel----");
//	}
	@ResponseBody
	@RequestMapping("/regist")
	public Map<String, Object> regist(@Valid User user,Errors errors,String enPassword,String emailCode) {
		Map<String, Object>map = new HashMap<>();
		System.err.println(user);
		if(errors.hasFieldErrors()) {
			map.put("result", "fail");
			String errInfo = "";
			if(errors.hasFieldErrors("username")) {
				errInfo = errors.getFieldError("username").getDefaultMessage();
			}else if(errors.hasFieldErrors("password")) {
				errInfo = errors.getFieldError("password").getDefaultMessage();
			}
//			ra.addFlashAttribute("errInfo", errInfo);
//			return "redirect:/page/regist";
			map.put("errInfo", errInfo);
			return map;
		}
		if(emailCode == null || "".equals(emailCode.trim())) {
			map.put("result", "fail");
			map.put("errInfo", "验证码不能为空");
			return map;
//			ra.addFlashAttribute("errInfo", "验证码不能为空");
//			return  "redirect:/page/regist";
		}
		
		if(!CommonsEmailUtils.verify(user.getUsername(), emailCode)) {
			map.put("result", "fail");
			map.put("errInfo", "验证码不正确或邮箱未验证");
			return map;
//			ra.addFlashAttribute("errInfo", "验证码不正确或邮箱未验证");
//			return  "redirect:/page/regist";
		}
		synchronized (user.getUsername().intern()) {
			User u = userService.getByUsername(user.getUsername());
			if(u != null) {
				map.put("result", "fail");
				map.put("errInfo", "用户已经存在");
				return map;
//				ra.addFlashAttribute("errInfo", "用户已经存在");
//				return  "redirect:/page/regist";
			}
			String privateKey = (String)getSession().getAttribute("privateKey");
			try {
				byte[] pass = RSACoder.decryptByPrivateKey(Base64.decodeBase64(enPassword.replaceAll("%2B", "+")), privateKey);
				user.setPassword(new String(pass,"utf-8"));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("解密失败", e);
			}
			user.setPassword(MessageUtils.md5(user.getPassword()));
			userService.regist(user);
			map.put("result", "success");
			map.put("errInfo", "注册成功");
			return map;
//			return "redirect:/page/login";
		}
		
	}
	@RequestMapping("/login")
	public String login(@Valid User user,Errors errors,String enPassword,RedirectAttributes ra,Model model) {
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
		String privateKey = (String)getSession().getAttribute("privateKey");
		try {
			byte[] pass = RSACoder.decryptByPrivateKey(Base64.decodeBase64(enPassword.replaceAll("%2B", "+")), privateKey);
			user.setPassword(new String(pass,"utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解密失败", e);
		}
		User u = userService.login(user.getUsername(), MessageUtils.md5(user.getPassword()));
		if(u == null) {
			ra.addFlashAttribute("errInfo", "用户信息不正确");
			return "redirect:/page/login";
		}
//		model.addAttribute("loginUser", u);
		getSession().setAttribute("loginUser", u);
		return "redirect:/page/main";
	}
	@RequestMapping("/logout")
	public String logout() {
		getSession().removeAttribute("loginUser");
		return "redirect:/page/login";
	}
	
}
