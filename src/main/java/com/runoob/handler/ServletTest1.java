package com.runoob.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest1 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 resp.setContentType("text/html;charset=utf-8");
		    PrintWriter out = resp.getWriter();
		    // 获取ServletContext对象的引用
		    // 第一种方法

		    ServletContext servletContext = this.getServletContext();
		    // 第二种方法
		    // ServletContext servletContext2 = this.getServletConfig().getServletContext();
		    servletContext.setAttribute("name", "小明");
		    String name=(String) servletContext.getAttribute("name");
		    out.println("将 name=小明  写入了ServletContext");
		    out.append(name);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
