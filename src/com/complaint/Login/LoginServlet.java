package com.complaint.Login;


import java.io.IOException;
import com.complaint.User.UserDbUtil;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
		
	private UserDbUtil userDbUtil; 
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	
	
	@Override
	public void init() throws ServletException 
	{
		try
		{
			System.out.println("Hello");
			userDbUtil = new UserDbUtil(dataSource);
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String user,pass;
			boolean isAuth=false;
			user = request.getParameter("username");
			pass = request.getParameter("password");
			isAuth = userDbUtil.authenicate(user, pass);
			if(isAuth)
			{	System.out.println("Vimal");
				HttpSession session = request.getSession();
				session.setAttribute("name", user);
				response.sendRedirect("/complaint/ComplaintControllerServlet");
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("name", "");
				response.sendRedirect("/complaint/login.jsp");
			}
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}
}