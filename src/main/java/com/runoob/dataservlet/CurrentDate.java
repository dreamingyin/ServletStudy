package com.runoob.dataservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrentDate extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private int hitCount;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//Reset hitCount
		hitCount=0;
	}
	@SuppressWarnings("static-access")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Setting the type of response content
		resp.setContentType("text/html;charset=utf-8");
		/*String site=new String("https://www.w3cschool.cn/servlet/servlet-page-redirect.html");
		resp.setStatus(resp.SC_MOVED_TEMPORARILY);
		resp.setHeader("Location", site);*/
		hitCount++;
		PrintWriter out=resp.getWriter();
		resp.setIntHeader("Refresh", 1);
		Date date=new Date();
		SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String currentTime=simpleDate.format(date);
		String title="Display the current time";
		String docType =
			      "<!doctype html public \"-//w3c//dtd html 4.0 " +       "transitional//en\">\n";
			      out.println(docType +
			        "<html>\n" +
			        "<head><title>" + title + "</title></head>\n" +
			        "<body bgcolor=\"#f0f0f0\">\n" +
			        "<h1 align=\"center\">" + title + "</h1>\n" +
			        "<h2 align=\"center\">" + currentTime + "</h2>\n" +
			        "<h2 align=\"center\">The websites hit count:" + hitCount + "</h2>\n" +
			        "</body></html>");
	}
}
