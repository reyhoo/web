package com.test;


import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession();
		System.out.println("==================start======================");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String ele = headerNames.nextElement();
			System.out.println(ele+":"+request.getHeader(ele));
		}
		System.out.println("==============================================");
		//为解析类提供配置信息
		DiskFileItemFactory factory = 
			new DiskFileItemFactory();
		//创建解析类的实例
		ServletFileUpload sfu = 
			new ServletFileUpload(factory);
		
		//开始解析
		try {
			sfu.setFileSizeMax(1024*200);
			//每一个表单域中数据会封装到一个对应的
			//FileItem对象上。
			List<FileItem> items = 
				sfu.parseRequest(request);
			//要区分表单域
			
			String userId = null;
			FileItem fileItem = null;
			long size= 0l;
			for(int i=0;i<items.size();i++){
				FileItem item = items.get(i);
				//isFormField为true,表示这不是文件上传表单域
				if(item.isFormField()){
					String paramName = item.getFieldName();
					String paramValue = item.getString("utf-8");
					System.out.println(paramName+":"+paramValue);
					if("userId".equals(paramName)){
						userId = paramValue;
					}
				}else{
					String paramName = item.getFieldName();
					if(!"file1".equals(paramName)){
						continue;
					}
					size = item.getSize();
					if(size<=0){
						continue;
					}
					fileItem = item;
					
					
				}
			}
			if(userId == null || userId.trim().equals("")){
				response.getWriter().print("{\"result\":\"fail\",\"resultInfo\":\"no userId\"}");
				System.out.println("{\"result\":\"fail\",\"resultInfo\":\"no userId\"}");
			}else if(fileItem == null){
				response.getWriter().print("{\"result\":\"fail\",\"resultInfo\":\"no file\"}");
				System.out.println("{\"result\":\"fail\",\"resultInfo\":\"no file\"}");
			}else{
				String fileName = fileItem.getName();
				System.out.println("fileName:"+fileName);
				
				ServletContext sctx = 
					getServletContext();
				//获得存放文件的物理路径
				String path = sctx.getRealPath("upload");

				//获得文件名
				
			
				//该方法在某些平台(操作系统)，会返回
				//路径+文件名
				if(fileName == null || fileName.trim().equals("")||!fileName.contains(".")){
					fileName = System.currentTimeMillis()+"";
				}else{
					fileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
				}
			
				System.out.println("finalFileName:"+fileName);
				File file = new File(path , fileName);

				System.out.println("size:"+size);
				fileItem.write(file);
				response.getWriter().print("{\"result\":\"success\"}");
				System.out.println("{\"result\":\"success\"}");
			}
			System.out.println("====================end======================");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}
