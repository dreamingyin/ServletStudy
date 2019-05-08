package com.runoob.servletstudy;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// ��ȡ��ʼ������
		String site = config.getInitParameter("Site"); 
		// �����ʼ������
		System.out.println("��վ����: " + site);
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//Get ip address of client machine 
		String ipAdress=req.getRemoteAddr();
		//Record current time and Ip address
		System.out.println("Ip address:"+ipAdress+"current time:"+new Date());
		
		chain.doFilter(req, resp);
		
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
}
