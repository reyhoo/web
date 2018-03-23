package com.mvcdev.exe.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/uploadPage")
	public String uploadPage(){
		return "uploadPage";
	}
	
	@RequestMapping("/upload")
	public ModelAndView upload(String username,@RequestPart("f")MultipartFile file){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		String filename = file.getOriginalFilename();
		try {
			System.err.println("username:"+username);
			file.transferTo(new File("d:\\mvc\\uploads",filename));
			mv.addObject("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("success", false);
		}
		return mv;
	}
}
