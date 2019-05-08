package com.runoob.dataservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMail extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Sender's mailbox
		String from="yinhaoye@qq.com";
		//Recipient mailbox
		String to="15216769172@163.com";
		String myEmailSMTPHost = "smtp.qq.com";
		//If you send a email from localhost
		String myEmailPassword = "xieyrzkvzyojdebh";
		
		//Get system information
		Properties props=System.getProperties();
		 props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
	        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
	        props.setProperty("mail.smtp.auth", "true"); 
		//Setting mail server
		 final String smtpPort = "465";
	        props.setProperty("mail.smtp.port", smtpPort);
	        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.setProperty("mail.smtp.socketFactory.fallback", "false");
	        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
	        props.getProperty("mail.stmp.host", "host");
		
		//Get default session
		Session session=Session.getDefaultInstance(props);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		try{
	         // 创建一个默认的 MimeMessage 对象
			 MimeMessage message = new MimeMessage(session);
	         // 设置 From: header field of the header.
	         message.setFrom(new InternetAddress(from));
	         // 设置 To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	         // 设置 Subject: header field
	         message.setSubject("This is the Subject Line!");
	         // 现在设置实际消息
	         message.setText("This is actual message");
	         // 发送消息
	      // 4. 根据 Session 获取邮件传输对象
	         Transport transport = session.getTransport();
	  
	         // 5. 使用 邮箱账号 和 密码 连接邮件服务器
	         //    这里认证的邮箱必须与 message 中的发件人邮箱一致，否则报错
	         transport.connect(from, myEmailPassword);
	  
	         // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	         transport.sendMessage(message, message.getAllRecipients());
	         String title = "发送电子邮件";
	         String res = "成功发送消息...";
	         String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " +          "transitional//en\">\n";
	         out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n" +
	         "<p align=\"center\">" + res + "</p>\n" +
	         "</body></html>");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}

}
