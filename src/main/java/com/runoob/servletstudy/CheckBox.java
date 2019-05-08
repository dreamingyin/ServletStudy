package com.runoob.servletstudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckBox extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("math:"+req.getParameter("maths"));
		out.println("<br/>");
		out.println("physics:"+req.getParameter("physics"));
		out.println("<br/>");
		out.println("chemistry:"+req.getParameter("chemistry"));
		
	}
	
	 // 处理 POST 方法请求的方法
	  public void doPost(HttpServletRequest request,
	                     HttpServletResponse response)
	      throws ServletException, IOException {
		  
		  super.doPost(request, response);
	  }
	
}
