package com.mvc.exe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.exe.pojo.Role;
import com.mvc.exe.pojo.User;
import com.mvc.exe.service.RoleService;
import com.mvc.exe.service.UserService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/list")
	public String list(@SessionAttribute("loginUser") User user,Model model) {
		List<Role> roleList = userService.findById(user.getId()).getRoleList();
		model.addAttribute("roleList", roleList);
		return "role_list";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam Long id) {
		roleService.delete(id);
		return "redirect:/role/list";
	}
	@RequestMapping("/toUpdate")
	public String toUpdate(Long id,Model model) {
		model.addAttribute("role", roleService.findById(id));
		return "role_form";
	}
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "role_form";
	}

	@RequestMapping("/update")
	public String update(@Valid Role role,Errors errors,@SessionAttribute("loginUser") User user,Model model) {
		if(errors.hasFieldErrors()) {
			model.addAttribute("errInfo", "参数有误");
			model.addAttribute("role", roleService.findById(role.getId()));
			return "role_form";
		}
		if(!user.getId().equals(role.getUserId())) {
			model.addAttribute("errInfo", "userId不一致");
			model.addAttribute("role", roleService.findById(role.getId()));
			return "role_form";
		}
		roleService.update(role);
		return "redirect:/role/list";
	}
	
	@RequestMapping("/add")
	public String add(Long userId,@Valid Role role,Errors errors,@SessionAttribute("loginUser") User user,RedirectAttributes rs) {
		if(errors.hasFieldErrors()) {
			if(errors.hasFieldErrors("roleName")) {
				rs.addFlashAttribute("errInfo", errors.getFieldError("roleName").getDefaultMessage());
			}else if(errors.hasFieldErrors("note")) {
				rs.addFlashAttribute("errInfo", errors.getFieldError("note").getDefaultMessage());
			}else {
				rs.addFlashAttribute("errInfo", "参数异常");
			}
			return "redirect:/role/toAdd";
		}
		if(!user.getId().equals(userId)) {
			rs.addFlashAttribute("errInfo", "userId不一致");
			return "redirect:/role/toAdd";
		}
		System.err.println("add...role:"+role);
		roleService.add(userId, role);
		return "redirect:/role/list";
	}
}
