package com.spring.mvcdev.controller;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.spring.mvcdev.pojo.PageParams;
import com.spring.mvcdev.pojo.Role;
import com.spring.mvcdev.service.RoleService;
import com.spring.mvcdev.view.ExcelExportService;
import com.spring.mvcdev.view.ExcelView;
@Controller
@RequestMapping("/params")
public class RoleController {

	@Autowired
	private RoleService roleService;
	/**
	 * 接收普通参数
	 * @param roleName
	 * @param note
	 * @return
	 */
	@RequestMapping(value="/commonParams")
//	public ModelAndView commonParams(String roleName,String note){
	public ModelAndView commonParams(@RequestParam(name="roleName",required=false)String roleName
			,@RequestParam(required=false)String note){
		System.out.println("roleName => "+roleName);
		System.out.println("note => "+note);
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
//		roleService.addRole(role);
		List<Role> roleList = roleService.getRoleList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("roleList");
		mv.addObject("roleList", roleList);
		return mv;
	}
	
	@RequestMapping("/commonParamPojo")
	public ModelAndView commonParamPojo(Role role){
		System.out.println("role => "+role);
		roleService.addRole(role);
		List<Role> roleList = roleService.getRoleList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("roleList");
		mv.addObject("roleList", roleList);
		return mv;
	}
	
	@RequestMapping("/getRole/{id}")
	public ModelAndView getRole(@PathVariable("id")Long id){
		System.out.println("id => "+id);
		Role role = roleService.getRole(id);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());;
		mv.addObject("role", role);
		return mv;
	}
	@RequestMapping("/findRoles")
	public ModelAndView findRoles(@RequestBody Role roleParams){
		System.out.println("roleParams => "+roleParams);
		List<Role> list = roleService.findRoles(roleParams);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());;
		mv.addObject(list);
		return mv;
	}
	@RequestMapping("/deleteRoles")
	public ModelAndView deleteRoles(@RequestBody List<Long>idList){
		System.out.println("idList => "+idList);
		int count = roleService.deleteRoles(idList);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());;
		mv.addObject("total",count);
		return mv;
	}
	@RequestMapping("/addRoles")
	public ModelAndView addRoles(@RequestBody List<Role>roleList){
		System.out.println("roleList => "+roleList);
		int count = roleService.addRoles(roleList);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());;
		mv.addObject("total",count);
		return mv;
	}
	@RequestMapping("/commonParams2")
	public ModelAndView commonParams2(String roleName,String note){
		System.out.println("roleName => "+roleName);
		System.out.println("note => "+note);
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		List<Role> roleList = roleService.getRoleList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("total",1);
		mv.setViewName("roleList");
		mv.addObject("roleList",roleList);
		return mv;
	}
	
	
	@RequestMapping("/showRoleJsonInfo")
	public ModelAndView showRoleJsonInfo(Long id,String roleName,String note){
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("roleName", roleName);
		mv.addObject("note", note);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	@RequestMapping("/showRoleJsonInfo2")
	public ModelAndView showRoleJsonInfo2(Role role){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("role", role);
		return mv;
	}
	
	/***
	 * 重定向方式一
	 * @param model
	 * @param roleName
	 * @param note
	 * @return
	 */
	@RequestMapping("/addRole")
	public String addRole(Model model,String roleName,String note){
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		model.addAttribute("roleName", role.getRoleName());
		model.addAttribute("note", note);
		model.addAttribute("id", role.getId());
		return "redirect:showRoleJsonInfo.do";
	}
	/**
	 * 重定向方式二
	 * @param mv
	 * @param roleName
	 * @param note
	 * @return
	 */
	@RequestMapping("/addRole2")
	public ModelAndView addRole2(ModelAndView mv,String roleName,String note){
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		mv.addObject("roleName", role.getRoleName());
		mv.addObject("note", note);
		mv.addObject("id", role.getId());
		mv.setViewName("redirect:./showRoleJsonInfo2.do");
		return mv;
	}
	
	/***
	 * 方式一和方式二都在直接把参数拼在url后面，而这个方法是通过session实现的s
	 * 给生定向传递参数
	 * @param ra
	 * @param role
	 * @return
	 */
	@RequestMapping("/addRole3")
	public String addRole3(RedirectAttributes ra,Role role){
		roleService.addRole(role);
		ra.addFlashAttribute("role", role);
		return "redirect:./showRoleJsonInfo2.do";
	}
	
	@RequestMapping("/export")
	public ModelAndView export(String fileName){
		ModelAndView mv = new ModelAndView();
		mv.setView(new ExcelView("所有角色.xls", excelExportService()));
		Role role = new Role();
		PageParams pageParams = new PageParams();
		pageParams.setLimit(10000);
		pageParams.setStart(0);
		role.setPageParams(pageParams);
		List<Role> list = roleService.findRoles(role);
		mv.addObject("roleList", list);
		return mv;
	}
	
	private ExcelExportService excelExportService(){
		return new ExcelExportService() {
			
			@Override
			public void makeWorkBook(Map<String, Object> model, Workbook workbook) {
				List<Role>list = (List<Role>) model.get("roleList");
				Sheet sheet = workbook.createSheet("所有角色");
				Row title = sheet.createRow(0);
				title.createCell(0).setCellValue("编号");
				title.createCell(1).setCellValue("名称");
				title.createCell(2).setCellValue("备注");
				
				for (int i = 0; i < list.size(); i++) {
					Role role = list.get(i);
					int rowIdx = i+1;
					Row row = sheet.createRow(rowIdx);
					row.createCell(0).setCellValue(role.getId());
					row.createCell(1).setCellValue(role.getRoleName());
					row.createCell(2).setCellValue(role.getNote());
				}
			}
		};
	}
	
}
