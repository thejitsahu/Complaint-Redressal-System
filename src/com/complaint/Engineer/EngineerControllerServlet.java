package com.complaint.Engineer;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/EngineerControllerServlet")
public class EngineerControllerServlet extends HttpServlet 
{
	private EngineerDbUtil engineerDbUtil; 
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException 
	{
		try
		{
			engineerDbUtil = new EngineerDbUtil(dataSource);
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
			case "LIST": listEngineers(request, response);
						 break;
			case "LOAD": loadEngineer(request, response); 
						 break; 
			case "UPDATE": updateEngineer(request,response);
							break;
			case "DELETE": deleteEngineer(request,response);
							break;
			default		: listEngineers(request, response);
		}
		
	}
	catch(Exception exc)
	{
		throw new ServletException(exc);
	}
}
private void listEngineers(HttpServletRequest request, HttpServletResponse response) throws Exception
{
	List<Engineer> engineers = engineerDbUtil.getEngineers();
	
	request.setAttribute("ENGINEER_LIST", engineers);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/list-engineers.jsp");
	dispatcher.forward(request, response);
}

private void deleteEngineer(HttpServletRequest request, HttpServletResponse response) throws Exception 
{
	String theEngineerId = request.getParameter("engineerId");
	engineerDbUtil.deleteEngineer(theEngineerId);
	listEngineers(request,response);
	
}
private void updateEngineer(HttpServletRequest request, HttpServletResponse response) throws Exception
{
	int id = Integer.parseInt(request.getParameter("theEngineerId"));
	int cId = Integer.parseInt(request.getParameter("cId"));
	String name = request.getParameter("name");
	Engineer theEngineer = new Engineer(id,cId,name);
	engineerDbUtil.updateEngineer(theEngineer);
	listEngineers(request,response);
}
private void loadEngineer(HttpServletRequest request, HttpServletResponse response) throws Exception 
{
	String theEngineerId		=	request.getParameter("engineerId");
	Engineer theEngineer 		=	engineerDbUtil.getEngineer(theEngineerId);
	request.setAttribute("THE_ENGINEER", theEngineer);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/update-engineer-form.jsp");
	dispatcher.forward(request, response);
	
}
private void addEngineer(HttpServletRequest request, HttpServletResponse response) throws Exception 
{
	String name  = request.getParameter("name");
	Engineer theEngineer	=	new Engineer(name);
	engineerDbUtil.addEngineer(theEngineer); 
	
	listEngineers(request,response);
	
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	try
	{
		addEngineer(request,response);
	}
	catch(Exception exc)
	{
		throw new ServletException(exc);
	}
}

}



