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
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String ele = headerNames.nextElement();
			System.out.println(ele+":"+request.getHeader(ele));
		}
		System.out.println("==============================================");
		//Ϊ�������ṩ������Ϣ
		DiskFileItemFactory factory = 
			new DiskFileItemFactory();
		//�����������ʵ��
		ServletFileUpload sfu = 
			new ServletFileUpload(factory);
		
		//��ʼ����
		try {
			sfu.setFileSizeMax(1024*200);
			//ÿһ�����������ݻ��װ��һ����Ӧ��
			//FileItem�����ϡ�
			List<FileItem> items = 
				sfu.parseRequest(request);
			//Ҫ���ֱ���
			
			String userId = null;
			FileItem fileItem = null;
			long size= 0l;
			for(int i=0;i<items.size();i++){
				FileItem item = items.get(i);
				//isFormFieldΪtrue,��ʾ�ⲻ���ļ��ϴ�����
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
				//��ô���ļ�������·��
				String path = sctx.getRealPath("upload");

				//����ļ���
				
			
				//�÷�����ĳЩƽ̨(����ϵͳ)���᷵��
				//·��+�ļ���
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
