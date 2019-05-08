package com.runoob.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloFormTest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie firstName = new Cookie("first_name", req.getParameter("first_name"));
		Cookie lastName = new Cookie("last_name", req.getParameter("last_name"));

		// Setting firstName expire time
		firstName.setMaxAge(60 * 2);
		lastName.setMaxAge(60 * 2);

		// Add response header of cookie
		resp.addCookie(firstName);
		resp.addCookie(lastName);
		// Setting response context format
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String title = "Setting up cookie instance";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>Ãû×Ö</b>£º" + URLEncoder.encode(req.getParameter("first_name"), "utf-8") + "\n" + "  <li><b>ÐÕÊÏ</b>£º"
				+ URLEncoder.encode(req.getParameter("last_name"), "utf-8") + "\n" + "</ul>\n" + "</body></html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
