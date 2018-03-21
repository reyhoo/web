package com.spring.mvcdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.spring.mvcdev.pojo.Role;
import com.spring.mvcdev.service.RoleService;

@Controller
@RequestMapping("/attribute")
@SessionAttributes(names={"user","role"},types={Long.class})
public class AttributeController {
	@Autowired
	private RoleService roleService;

	@RequestMapping("/requestAttribute")
	public ModelAndView reqAttr(@RequestAttribute(value = "id",required=false) Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		if(id == null){
			mv.addObject("info", "ID不能为空");
			return mv;
		}
		Role role = roleService.getRole(id);
		if(role == null){
			mv.addObject("info", "未找到role");
			return mv;
		}
		mv.addObject("role",role);
		return mv;
	}
	@RequestMapping("/sessionAttributes")
	public ModelAndView sessionAttrs(Long id){
		ModelAndView mv = new ModelAndView();
		Role role = roleService.getRole(id);
		mv.addObject("role", role);
		mv.addObject("roleId", id);
		mv.addObject("user", "tom");
		mv.addObject("userr", "jerry");
		mv.setViewName("sessionAttribute");
		return mv;
	}

	@RequestMapping("/sessionAttribute")
	public ModelAndView sessionAttr(@SessionAttribute(value="id",required=false)Long id){
		
		if(id == null){
			throw new RuntimeException("id不能为空");
		}
		ModelAndView mv = new ModelAndView();
		Role role = roleService.getRole(id);
		if(role!=null){
			mv.addObject("role", role);
		}else{
			mv.addObject("info", "未找到");
		}
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
}
