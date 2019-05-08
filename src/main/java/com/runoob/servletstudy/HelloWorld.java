package com.runoob.servletstudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		message="Hello World";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Response format
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		out.println("<h3>"+message+"</h3>");
	}
	
	private void destory() {
		// TODO Auto-generated method stub

	}

	
}
