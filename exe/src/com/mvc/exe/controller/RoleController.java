package com.mvc.exe.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.exe.pojo.Role;
import com.mvc.exe.pojo.User;
import com.mvc.exe.service.RoleService;
import com.mvc.exe.service.UserService;
import com.mvc.exe.util.CharacterUtil;
import com.mvc.exe.util.Const;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/list")
	public String list(@SessionAttribute("loginUser") User user,Model model) {
		roleService.deleteUselessPicFile();
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
	@ResponseBody
	@RequestMapping("/upload")
	public Map<String, Object> upload(MultipartFile file){
		Map<String, Object>map = new HashMap<>();
		if(file == null || file.isEmpty()) {
			map.put("errCode", "0001");
			map.put("errInfo", "文件不能为空");
			return map;
		}
		System.err.println(file.getOriginalFilename());
		String originalFilename = file.getOriginalFilename();
		File pFile = new File(Const.ROLE_PIC_FILE_DIR_PATH,"img");
		String filename = CharacterUtil.getRandomString(10)+(originalFilename.lastIndexOf(".")>=0?originalFilename.substring(originalFilename.lastIndexOf(".")):"");
		File f = new File(pFile,filename);
		if(!f.getParentFile().exists()) {
			f.getParentFile().mkdirs();
		}
		try {
			file.transferTo(f);
			map.put("errCode", "0000");
			map.put("errInfo", "上传成功");
			map.put("pic", "/image/img/"+filename);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errCode", "0002");
			map.put("errInfo", "上传失败:"+e.getMessage());
		}
		return map;
	}
}
