package com.runoob.dataservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataAccess extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Connection conn=null;
	Statement stat=null;
	ResultSet result=null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String username="root";
		final String password="09091995aq";
		String urls="jdbc:mysql://localhost:3306/runoob";
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
	      String title = "数据库结果";
	      String docType =
	        "<!doctype html public \"-//w3c//dtd html 4.0 " +          "transitional//en\">\n";
	         out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(urls, username, password);
			stat=conn.createStatement();
			String sql="select * from websites";
			result=stat.executeQuery(sql);
			while(result.next()) {
				int id=result.getInt("id");
				String name=result.getString("name");
				String url=result.getString("url");
				int alexa=result.getInt("alexa");
				String coutry=result.getString("country");
				out.print("ID: " + id + ",");
	            out.print("Name: " + name + ",");
	            out.print("Url: " + url + ",");
	            out.print("Alexa: " + alexa + ",");
	            out.print("Coutry: " + coutry);
	            out.println("</br>");
	            System.out.println("Id:"+id+"--->"+"name:"+name+"--->"
	            			+"url:"+url+"-->"+"Alexa:"+alexa+"--->"+"country:"+coutry);
			}
			out.println("</body></html>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				result.close();
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
