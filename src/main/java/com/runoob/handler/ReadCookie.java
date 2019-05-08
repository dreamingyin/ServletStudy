package com.runoob.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie cookie=null;
		Cookie[] cookies=null;
		cookies=req.getCookies();
		
		//Setting the type of response content
		resp.setContentType("text/html;charset=utf-8");
		String title = "Reading Cookies Example";
		PrintWriter out=resp.getWriter();
		String docType =
		 "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" );
	      if( cookies != null ){
	         out.println("<h2>���� Cookies ���ƺ�ֵ</h2>");
	         for (int i = 0; i < cookies.length; i++){             cookie = cookies[i];             out.print("���ƣ�" + cookie.getName( ) + "��");             out.print("ֵ��" + cookie.getValue( )+" <br/>");
	         }
	      }else{
	          out.println(
	            "<h2 class='tutheader'>δ�ҵ� Cookies</h2>");
	      }
	      out.println("</body>");
	      out.println("</html>");
	   }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
