package com.runoob.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorPageHandler extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Analysis of servlet exception
		Throwable throwable=(Throwable) req.getAttribute("javax.servlet.error.exception");
		Integer statusCode=(Integer) req.getAttribute("javax.servlet.error.status_code");
		String servletName = (String)req.getAttribute("javax.servlet.error.servlet_name");
		if(servletName==null) {
			servletName="Unknown";
		}
		
		String requestUri = (String)
			      req.getAttribute("javax.servlet.error.request_uri");
			      if (requestUri == null){
			         requestUri = "Unknown";
			      }

			      // 设置响应内容类型
			      resp.setContentType("text/html");
			 
			      PrintWriter out = resp.getWriter();
			     String title = "Error/Exception Information";
			      String docType =
			      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
			      out.println(docType +
			        "<html>\n" +
			        "<head><title>" + title + "</title></head>\n" +
			        "<body bgcolor=\"#f0f0f0\">\n");

			      if (throwable == null && statusCode == null){
			         out.println("<h2>Error information is missing</h2>");
			         out.println("Please return to the <a href=\"" +             resp.encodeURL("http://localhost:8080/") +             "\">Home Page</a>.");
			      }else if (statusCode != null){
			         out.println("The status code : " + statusCode);
			      }else{
			         out.println("<h2 class='tutheader'>Error information</h2>");
			         out.println("Servlet Name : " + servletName + 
			                             "</br></br>");
			         out.println("Exception Type : " + 
			                             throwable.getClass( ).getName( ) + 
			                             "</br></br>");
			         out.println("The request URI: " + requestUri + 
			                             "<br><br>");
			         out.println("The exception message: " + 
			                                 throwable.getMessage( ));
			      }
			      out.println("</body>");
			      out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
