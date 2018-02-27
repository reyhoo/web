package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filePath = getServletContext().getRealPath("0_13114307082z1x.gif");
		System.err.println(filePath);
		File file = new File(filePath);
		response.setContentType("image/gif");
		response.addHeader("Content-Type", "image/gif");
		response.addHeader("Content-Disposition", "inline;filename="+file.getName());
		response.addHeader("Content-Length", file.length()+"");
		InputStream in = new FileInputStream(file);
		int count ;
		byte[] buf = new byte[1024*3];
		while((count=in.read(buf))!=-1){
			response.getOutputStream().write(buf,0,count);
		}
		response.getOutputStream().flush();
	}

}
