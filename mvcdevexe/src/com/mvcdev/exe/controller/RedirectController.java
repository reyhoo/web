package com.mvcdev.exe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mvcdev.exe.pojo.Role;
import com.mvcdev.exe.service.RoleService;


@Controller
@RequestMapping("/redirect")
public class RedirectController {

	@Value("#{roleService}")
	private RoleService roleService;
	
	
	@RequestMapping("/showRoleJsonInfo")
	public ModelAndView showRoleJsonInfo(@RequestParam(required=false,defaultValue="default_roleName") String roleName,@RequestParam(required=false,defaultValue="default_note") String note,
			@RequestParam(required=false,defaultValue="-1") Long id){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("roleName", roleName);
		mv.addObject("note", note);
		mv.addObject("id", id);
		return mv;
	}
	
	@RequestMapping("/showRoleJsonInfo2")
	public ModelAndView showRoleJsonInfo(Role role){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		if(role == null){
			mv.addObject("info", "������");
		}else{
			mv.addObject(role);
		}
		return mv;
	}
	
	@RequestMapping("/addRole")
	public String addRole(Model model,String roleName,String note){
		Role role = roleService.addRole(roleName,note);
		model.addAttribute("id", role.getId());
		model.addAttribute("roleName", role.getRoleName());
		model.addAttribute("note", role.getNote());
		return "redirect:/redirect/showRoleJsonInfo";
	}
	@RequestMapping("/addRole2")
	public ModelAndView addRole(ModelAndView mv,Role role){
		roleService.addRole(role);
		mv.addObject("roleName", role.getRoleName());
		mv.addObject("note", role.getNote());
		mv.addObject("id", role.getId());
		mv.setViewName("redirect:/redirect/showRoleJsonInfo2");
		return mv;
	}
	
	@RequestMapping("/addRole3")
	public String addRole3(RedirectAttributes ra,Role role){
		roleService.addRole(role);
		ra.addFlashAttribute("role", role);
		return "redirect:/redirect/showRoleJsonInfo2";
	}
	
}
