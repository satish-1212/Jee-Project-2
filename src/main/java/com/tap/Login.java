package com.tap;

import javax.servlet.http.HttpServlet;
//import org.apache.tomcat.util.http.parser.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
//import javax.servlet.annotation.*;
//import javax.servlet.http.Cookie;

import java.io.IOException;
import java.io.PrintWriter;
// @WebServlet(urlPatterns = "/login2",initParams =@WebInitParam(name ="password",value="root"))

public class Login  extends HttpServlet
{
	private static final long serialVersionUID =1L;
	static int count = 2;
	
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		String name=req.getParameter("username");
		String password=req.getParameter("password");
		resp.setContentType("text/html");
		HttpSession session=req.getSession();
		session.setAttribute("username", name);
		//Cookie c1 = new Cookie("username",name);
		//Cookie c2 = new Cookie("password",password);
		//resp.addCookie(c1);
		//resp.addCookie(c2);
		
		ServletConfig config = getServletConfig();
		String actualPassword = config.getInitParameter("password");
		
		
		
		
		if( password.equals(actualPassword))
		{
			resp.sendRedirect("homePage");
		//	RequestDispatcher rd1 = req.getRequestDispatcher("homePage");
		//	rd1.forward(req, resp);
			
		}
		else if(count>0)
		{
			PrintWriter out = resp.getWriter();
			out.println(count-- +"  attempts left");
			RequestDispatcher rd2 = req.getRequestDispatcher("/index.html");
			rd2.include(req, resp);
			
		}
		else
		{
			resp.sendRedirect("blocked.html");
			//RequestDispatcher rd3 = req.getRequestDispatcher("/blocked.html");
			//rd3.include(req, resp);
		}
	
		
		
	
	}
}