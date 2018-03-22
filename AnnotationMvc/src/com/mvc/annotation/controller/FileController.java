package com.mvc.annotation.controller;

import java.io.File;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

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
	@RequestMapping("/uploadMultipartFile")
	public ModelAndView uploadMultipartFile(String name,@RequestPart("file1")MultipartFile file,@RequestPart("file2")MultipartFile file2){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		String fileName = file.getOriginalFilename();
		System.err.println("name:"+name);
		System.err.println("fileName:"+fileName);
		System.out.println("fieldName:"+file.getName());
		System.err.println("2fileName:"+file2.getOriginalFilename());
		System.out.println("2fieldName:"+file2.getName());
		file.getContentType();
		File dest = new File("d:\\hello.pdf");
		File dest2 = new File("d:\\dfsdf.png");
		try {
			file.transferTo(dest);
			file2.transferTo(dest2);
			mv.addObject("success", true);
			mv.addObject("msg","上传文件成功");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("success", false);
			mv.addObject("msg","上传文件失败");
		}
		return mv;
	}
	
}
