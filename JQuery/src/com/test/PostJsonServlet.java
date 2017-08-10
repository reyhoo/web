package com.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostJsonServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long contentLenght = req.getContentLength();
		ServletInputStream in = req.getInputStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buff = new byte[1024 * 3];
		int count;
		int totalCount = 0;
		while(totalCount<contentLenght 
//				&&(count = in.read(buff))!=-1
				){
			count = in.read(buff);
			totalCount +=count;
			out.write(buff, 0, count);
		}
		String result = new String(out.toByteArray(),"UTF-8");
		resp.setContentType("text/*;charset=utf-8");
		resp.getWriter().print("{\"requestData\":"+result+"}");
		resp.getWriter().close();
	}
}
