package com.runoob.servletstudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloForm extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ������Ӧ��������
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "ʹ�� GET ������ȡ������";
        // ��������
        String name =new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        out.println("name:"+request.getParameter("name"));
        out.println("url:"+request.getParameter("url"));
    }
    
    // ���� POST ��������ķ���
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
