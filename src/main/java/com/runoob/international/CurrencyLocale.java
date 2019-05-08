package com.runoob.international;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrencyLocale extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Setting the type of response 
		resp.setContentType("text/html;charset=utf=8");
		PrintWriter out=resp.getWriter();
		//Setting the special area of currency
		Locale locale=req.getLocale();
		NumberFormat nft=NumberFormat.getInstance(locale);
		String formattedCurr=nft.format(100000);
		String title="Setting the special area of currency";
		String docType =
			      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
			      out.println(docType +
			      "<html>\n" +
			      "<head><title>" + title + "</title></head>\n" +
			      "<body bgcolor=\"#f0f0f0\">\n" +
			      "<h1 align=\"center\">" + formattedCurr + "</h1>\n" +
			      "</body></html>");
	}

}
