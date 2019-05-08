package com.runoob.dataservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentLog extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String par=req.getParameter("par1");
		//Invoking two method about ServletContext.log
		ServletContext context=getServletContext();
		
		if(par==null || par.equals(""))
			//Record version by throwable parameter
			context.log("No message recevied", new IllegalStateException("Missing parameter"));
		else
			context.log("Here is the vistor's message:"+par);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		String title = "Context Log";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n" +
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<h2 align=\"center\">Messages sent</h2>\n" +
	        "</body></html>");
		
	}
	
}
