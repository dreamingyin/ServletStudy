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
		 props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
	        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
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
	         // ����һ��Ĭ�ϵ� MimeMessage ����
			 MimeMessage message = new MimeMessage(session);
	         // ���� From: header field of the header.
	         message.setFrom(new InternetAddress(from));
	         // ���� To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	         // ���� Subject: header field
	         message.setSubject("This is the Subject Line!");
	         // ��������ʵ����Ϣ
	         message.setText("This is actual message");
	         // ������Ϣ
	      // 4. ���� Session ��ȡ�ʼ��������
	         Transport transport = session.getTransport();
	  
	         // 5. ʹ�� �����˺� �� ���� �����ʼ�������
	         //    ������֤����������� message �еķ���������һ�£����򱨴�
	         transport.connect(from, myEmailPassword);
	  
	         // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	         transport.sendMessage(message, message.getAllRecipients());
	         String title = "���͵����ʼ�";
	         String res = "�ɹ�������Ϣ...";
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
