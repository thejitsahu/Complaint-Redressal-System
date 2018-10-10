package com.complaint.HomePage;

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

import com.complaint.Engineer.Engineer;

@WebServlet("/HomeControllerServlet")
public class HomeControllerServlet extends HttpServlet 
{
	private HomeDbUtil homeDbUtil; 
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException 
	{
		try
		{
			homeDbUtil = new HomeDbUtil(dataSource);
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		String admin=(String)session.getAttribute("name");
		try
		{
			if(admin.equals("vimal"))
			{
				List<Home> homes=homeDbUtil.getHome();
				request.setAttribute("HOME_LIST", homes);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-homes.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				List<Home> homes=homeDbUtil.getHome(uid);
				request.setAttribute("HOME_LIST", homes);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-homes.jsp");
				dispatcher.forward(request, response);
			}
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}
	}
}