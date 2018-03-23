package com.grade.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grade.mvc.pojo.Role;

@Controller
@RequestMapping("/page")
public class PageController {
	@RequestMapping("/form")
	public String form(){
		return "form";
	}
	@RequestMapping("/roleList")
	public String pageRoleList(RedirectAttributes ra, String name){
		ra.addAttribute("name", name);
		Role role = new Role();
		role.setId(100l);
		role.setRoleName("redirect");
		role.setNote("redirecÖÐ¹útnote");
		ra.addFlashAttribute("role", role);
		return "redirect:/role/list";
	}
}
