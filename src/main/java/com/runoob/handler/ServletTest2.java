package com.runoob.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest2 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		//Get a reference to the ServletContext object
		ServletContext servletContext=this.getServletContext();
		
		String name=(String) servletContext.getAttribute("name");
		out.println("½«name="+name+"Ð´ÈëServletContext");
		//The second method
		//ServletContext servletContext2=this.getServletConfig().getServletContext();
	}
}
