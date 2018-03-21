package com.mvcdev.exe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mvcdev.exe.pojo.Role;
import com.mvcdev.exe.service.RoleService;

@Controller
@RequestMapping("/params")
public class RequestController {
//	@Autowired
	@Value("#{roleService}")
	private RoleService roleService;

	@RequestMapping(value="/requestCommon",method=RequestMethod.POST)
	public String requestCommon(Model model,@RequestParam("role_name")String roleName, String note) {
		if (roleName == null || "".equals(roleName.trim()) || note == null
				|| "".equals(note.trim())) {
			throw new RuntimeException("参数不能为空");
		}
		Role role = roleService.addRole(roleName, note);
		model.addAttribute("id", role.getId());
		return "redirect:/role/list";
	}
	@RequestMapping(value="/requestPojo",method=RequestMethod.POST)
	public String requestPojo(Role role){
		roleService.addRole(role);
		return "redirect:/role/list";
	}
	
	@RequestMapping(value="/getRole/{id}",method=RequestMethod.GET)
	public ModelAndView pathVariable(@PathVariable("id")Long id){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		Role role = roleService.getRole(id);
		if(role == null){
			mv.addObject("info", "未找到");
		}else{
			mv.addObject("role",role);
		}
		return mv;
	}
	
}
