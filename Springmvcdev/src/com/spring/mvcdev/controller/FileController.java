package com.spring.mvcdev.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/file")
public class FileController {
	
	
	@RequestMapping("/uploadPage")
	public String uploadPage(){
		return "upload";
	}
	@RequestMapping("/upload")
	public ModelAndView upload(@RequestParam("info")String otherData,@RequestPart("file1")MultipartFile file){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		String fileName = file.getOriginalFilename();
		
		fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
		System.err.println(fileName);
		try {
			file.transferTo(new File("d:/mvc"+File.separator+fileName));
			mv.addObject("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("success", false);
		}
		return mv;
	}
}
