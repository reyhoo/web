package com.mvcdev.exe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mvcdev.exe.pojo.Role;
import com.mvcdev.exe.service.RoleService;

@Controller
@RequestMapping("/attr")
@SessionAttributes(names={"user","id"},types=Role.class)
public class AttributeController {

	@Autowired
	private RoleService roleService;
	@RequestMapping("/requestAttr")
	public ModelAndView requestAttribute(@RequestAttribute(value="id",required=false)Long id){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		if(id == null){
			mv.addObject("info", "id不能为空");
			return mv;
		}
		Role role = roleService.getRole(id);
		if(role == null){
			mv.addObject("info", "未找到");
			return mv;
		}
		mv.addObject(role);
		return mv;
	}
	@RequestMapping("/sessionAttrs/{id}")
	public ModelAndView sessionAttrs(@PathVariable("id")Long id){
		ModelAndView mv = new ModelAndView();
		if(id == null){
			mv.setView(new MappingJackson2JsonView());
			mv.addObject("info", "id不能为空");
			return mv;
		}
		Role role = roleService.getRole(id);
		if(role == null){
			mv.setView(new MappingJackson2JsonView());
			mv.addObject("info", "未找到");
			return mv;
		}
		mv.setViewName("redirect:/attr/sessionAttr");
		mv.addObject("role", role);
		mv.addObject("id", role.getId());
		mv.addObject("user", role.getRoleName());
		return mv;
	}
	@RequestMapping("/sessionAttr")
	public String sessionAttr(){
		return "sessionAttr";
	}
	@RequestMapping("/getCookieAndHeader")
	public String getCookieAndHeader(Model model,@RequestHeader(value="User-Agent",required=false,defaultValue="default")String userAgent,
			@CookieValue(value="JSESSIONID",required=false,defaultValue="myjsessionid")String jsessionid){
		model.addAttribute("userAgent", userAgent);
		model.addAttribute("jsessionid", jsessionid);
		return "cookieAndHeader";
	}
}
