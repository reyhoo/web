package com.myec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myec.pojo.User;
import com.myec.util.CommonsEmailUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping("/sendEmail")
	@ResponseBody
	public Map<String, Object>sendEmail(String email){
		Map<String, Object>map = new HashMap<>();
		int result = CommonsEmailUtils.sendHtmlMail(email);
		if(result == 0) {
			map.put("result", "success");
			map.put("errInfo", "���ͳɹ�!");
		}else if(result == -1) {
			map.put("result", "fail");
			map.put("errInfo", "����̫Ƶ��");
		}else if(result == -2) {
			map.put("result", "fail");
			map.put("errInfo", "�����ʽ��Ϣ�����ϵͳ�쳣");
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
			ra.addFlashAttribute("errInfo", "��֤�벻��Ϊ��");
			return  "redirect:/page/regist";
		}
		String code = CommonsEmailUtils.getVerifyCode(user.getUsername());
		if(code == null || !emailCode.equals(code)) {
			ra.addFlashAttribute("errInfo", "��֤�벻��ȷ������δ��֤");
			return  "redirect:/page/regist";
		}
		return "redirect:/page/login";
	}
	
}
