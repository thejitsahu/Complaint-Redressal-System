package com.complaint.User;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet 
{
	private UserDbUtil userDbUtil; 
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException 
	{
		try
		{
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
			String theCommand = request.getParameter("command");
			if(theCommand == null)
			{
				theCommand = "LIST";
			}
			switch(theCommand)
			{
				case "LIST": listUsers(request, response);
							 break;
				case "LOAD": loadUser(request, response); 
							 break; 
				case "UPDATE": updateUser(request,response);
								break;
				case "DELETE": deleteUser(request,response);
								break;
				default		: listUsers(request, response);
			}
			
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			addUser(request,response);
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}
	}
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		List<User> users = userDbUtil.getUsers();
		
		request.setAttribute("USER_LIST", users);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-users.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String theUserId = request.getParameter("userId");
		userDbUtil.deleteUser(theUserId);
		listUsers(request,response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("theUserId"));
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User theUser = new User(id,email,name,password);
		userDbUtil.updateUser(theUser);
		HttpSession session = request.getSession();
		String admin = (String)session.getAttribute("name");
		if(admin.equals("vimal"))
		{	
			listUsers(request,response);
		}
		else
		{
			response.sendRedirect("/complaint/HomeControllerServlet");
		}
	}
	
	private void loadUser(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String theUserId		=	request.getParameter("userId");
		User theUser 	=	userDbUtil.getUser(theUserId);
		request.setAttribute("THE_USER", theUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String name  = request.getParameter("name");
		String email  = request.getParameter("email");
		String password1  = request.getParameter("password1");
		String password2  = request.getParameter("password2");
		HttpSession session = request.getSession();
		String admin = (String)session.getAttribute("name");
		if(password1.equals(password2))
		{
			
			User theUser	=	new User(email,name,password1);
			userDbUtil.addUser(theUser); 
			if(admin.equals("vimal"))
			{
				listUsers(request,response);
			}
			else if(admin.equals(""))
			{
				response.sendRedirect("/complaint/login.jsp");
			}
		}

	}
}
