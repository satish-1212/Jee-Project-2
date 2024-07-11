package com.tap;

import javax.servlet.http.HttpServlet;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
//import org.apache.tomcat.util.http.parser.Cookie;
//import javax.servlet.http.Cookie;

public class HomePage  extends HttpServlet
{
	private static final long serialVersionUID =1L;
	
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		//String name = req.getParameter("username");
		HttpSession session=req.getSession();
		String name =(String)session.getAttribute("username");
		
	//	Cookie[] cookie  = req.getCookies();
	//	for(Cookie c : cookie)
		//{
		//	System.out.println(c.getName() + ":" + c.getValue());
	//	}
		
		 PrintWriter out  = resp.getWriter();
		 out.println(name +",Welcome to Tap Academy");
     }
}