package com.runoob.servletstudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayHandler extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		String title = "HTTP Header 请求实例 - w3cschool教程实例";
		String docType =
				"<!DOCTYPE html> \n";
				out.println(docType +
				"<html>\n" +
				"<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"+
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
				"<tr bgcolor=\"#949494\">\n" +
				"<th>Header 名称</th><th>Header 值</th>\n"+
				"</tr>\n");
		Enumeration<String> headerName=req.getHeaderNames();
		while(headerName.hasMoreElements()) {
			
			String paramName=headerName.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n");
			String paramValue=req.getHeader(paramName);
			out.println("<td> " + paramValue + "</td></tr>\n");
		}
		
		out.println("</table>\n</body></html>");
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
