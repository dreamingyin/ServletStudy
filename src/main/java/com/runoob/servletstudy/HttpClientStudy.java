package com.runoob.servletstudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpClientStudy extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 处理 GET 方法请求的方法
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
	      // 设置响应内容类型
	      response.setContentType("text/html;charset=utf-8");
	 
	      PrintWriter out = response.getWriter();
	    String title = "HTTP Header 请求实例";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n"+
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
	        "<tr bgcolor=\"#949494\">\n" +
	        "<th>Header 名称</th><th>Header 值</th>\n"+
	        "</tr>\n");
	 
	      Enumeration<String> headerNames = request.getHeaderNames();
	      
	      while(headerNames.hasMoreElements()) {
	         String paramName = (String)headerNames.nextElement();
	         out.print("<tr><td>" + paramName + "</td>\n");
	         String paramValue = request.getHeader(paramName);
	         out.println("<td> " + paramValue + "</td></tr>\n");
	      }
	      out.println("</table>\n</body></html>");
	  }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
