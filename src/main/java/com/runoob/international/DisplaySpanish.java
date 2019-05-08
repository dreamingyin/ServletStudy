package com.runoob.international;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplaySpanish extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Setting the type
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		//Setting Spanish code
		resp.setHeader("Content-language", "es");
		
		String title="En Espa&ntilde;ol";
		String docType =
			     "<!doctype html public \"-//w3c//dtd html 4.0 " +      "transitional//en\">\n";
			     out.println(docType +
			     "<html>\n" +
			     "<head><title>" + title + "</title></head>\n" +
			     "<body bgcolor=\"#f0f0f0\">\n" +
			     "<h1>" + "En Espa&ntilde;ol:" + "</h1>\n" +
			     "<h1>" + "&iexcl;Hola Mundo!" + "</h1>\n" +
			     "</body></html>");
	}

}
