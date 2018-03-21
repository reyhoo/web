package com.mvcdev.exe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mvcdev.exe.pojo.Role;
import com.mvcdev.exe.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping("/list")
	public String getList(Model model, Long id) {
		if (id != null) {
			model.addAttribute("id", id);
		}
		model.addAttribute("roleList", roleService.getRoleList());
		return "roleList";
	}

	@RequestMapping(value = "/getRole/{id}", method = RequestMethod.GET)
	public ModelAndView pathVariable(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		Role role = roleService.getRole(id);
		if (role == null) {
			mv.addObject("info", "Œ¥’“µΩ");
		} else {
			mv.addObject("role", role);
		}
		return mv;
	}

}
