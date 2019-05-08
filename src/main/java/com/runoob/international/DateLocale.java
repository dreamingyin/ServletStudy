package com.runoob.international;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DateLocale extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Setting the type of response
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		//Get client setting area
		Locale locale=req.getLocale();
		String date=DateFormat.getDateTimeInstance(DateFormat.FULL
				,DateFormat.SHORT,locale).format(new Date());
		 String title = "Setting the date of the special area";
		    String docType =
		      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
		      out.println(docType +
		      "<html>\n" +
		      "<head><title>" + title + "</title></head>\n" +
		      "<body bgcolor=\"#f0f0f0\">\n" +
		      "<h1 align=\"center\">" + date + "</h1>\n" +
		      "</body></html>");
		
	}

}
