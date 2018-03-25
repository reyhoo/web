package com.gradle.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {
	
	/***
	 * 
	 * @param file
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/upload")
	public Map<String, Object>upload(@RequestParam(value="f",required=false)MultipartFile file,String name){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("success", false);
		if(file == null){
			map.put("fileName", file);
		}else{
			map.put("fileName", file.getOriginalFilename());
			
			try {
				file.transferTo(new File("D:\\mvc\\grade\\uploads",file.getOriginalFilename()));
				map.put("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		return map;
	}
}
