package com.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println('Ò¦'+1-1);
		
		
		System.out.println(URLDecoder.decode("Ò¦ÀÚ", "iso-8859-1"));
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getCharacterEncoding());
		response.setContentType("text/html;charset=utf-8");
		System.out.println(request.getHeader("User-Agent"));
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println("name:"+name);
		System.out.println("named:"+URLDecoder.decode(name, "utf-8"));
		System.out.println("name1:"+URLEncoder.encode(name, "ISO-8859-1"));
		System.out.println("name2:"+URLDecoder.decode(URLEncoder.encode(name, "ISO-8859-1"), "utf-8"));
		
		String sex = request.getParameter("sex");
		System.out.println(sex);
		HttpSession session = request.getSession();
		session.setAttribute("name1", name);
		response.getWriter().print("name="+name);
		response.getWriter().close();
//		response.sendRedirect("http://127.0.0.1:8088/JQuery/index.jsp");
	}
	
}
