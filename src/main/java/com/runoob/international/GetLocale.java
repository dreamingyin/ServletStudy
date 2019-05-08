package com.runoob.international;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetLocale extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Get client area setting
		Locale locale=req.getLocale();
		String language=locale.getLanguage();
		String country=locale.getCountry();
		
		//Setting response content
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		String title = "Setting check area";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n" +
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + language + "</h1>\n" +
	        "<h2 align=\"center\">" + country + "</h2>\n" +
	        "</body></html>");
	}
	
}
