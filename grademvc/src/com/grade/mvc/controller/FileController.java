package com.grade.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@ResponseBody
	@RequestMapping("/upload")
	public Map<String, Object> upload(String roleName,@RequestParam("f") MultipartFile file){
		Map<String, Object> result = new HashMap<>();
		try {
			if(file.isEmpty()){
				result.put("roleName", roleName);
				result.put("info", "file is empty");
				result.put("success", false);
			}else{
				file.transferTo(new File(file.getOriginalFilename()));
				result.put("roleName", roleName);
				result.put("success", true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("roleName", roleName);
			result.put("success", false);
		}
		return result;
	}
}
