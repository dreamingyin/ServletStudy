package com.runoob.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTrack extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//If session not exit,will create a new it
		HttpSession session=req.getSession(true);
		//Get session creation time
		Date createTime=new Date(session.getCreationTime());
		//Last time visit webiste
		Date lastTime=new Date(session.getLastAccessedTime());
		String title="Welcome to visit my website";
		Integer visitCount=new Integer(0);
		String visitCountKey = new String("visitCount");
	    String userIDKey = new String("userID");
	    String userID = new String("ABCD");
	    
	    //Check for new visitor to web page
	    if(session.isNew()) {
	    	title="Welcome to visit my website";
	    	session.setAttribute(userIDKey, userID);
	    }else {
	    	
	    	visitCount=(Integer) session.getAttribute(visitCountKey);
	    	visitCount=visitCount+1;
	    	userID=(String) session.getAttribute(userIDKey);
	    }
	    session.setAttribute(visitCountKey, visitCount);
	    
	    //Setting the type of response content
	    resp.setContentType("text/html;charset=utf-8");
	    PrintWriter out=resp.getWriter();
	    String docType =
	    	      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
	    	      out.println(docType +
	    	                "<html>\n" +
	    	                "<head><title>" + title + "</title></head>\n" +
	    	                "<body bgcolor=\"#f0f0f0\">\n" +
	    	                "<h1 align=\"center\">" + title + "</h1>\n" +
	    	                 "<h2 align=\"center\">Session 信息</h2>\n" +
	    	                "<table border=\"1\" align=\"center\">\n" +
	    	                "<tr bgcolor=\"#949494\">\n" +
	    	                "  <th>Session 信息</th><th>值</th></tr>\n" +
	    	                "<tr>\n" +
	    	                "  <td>id</td>\n" +
	    	                "  <td>" + session.getId() + "</td></tr>\n" +
	    	                "<tr>\n" +
	    	                "  <td>Creation Time</td>\n" +
	    	                "  <td>" + createTime + 
	    	                "  </td></tr>\n" +
	    	                "<tr>\n" +
	    	                "  <td>Time of Last Access</td>\n" +
	    	                "  <td>" + lastTime + 
	    	                "  </td></tr>\n" +
	    	                "<tr>\n" +
	    	                "  <td>User ID</td>\n" +
	    	                "  <td>" + userID + 
	    	                "  </td></tr>\n" +
	    	                "<tr>\n" +
	    	                "  <td>Number of visits</td>\n" +
	    	                "  <td>" + visitCount + "</td></tr>\n" +
	    	                "</table>\n" +
	    	                "</body></html>");
	    	  }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
