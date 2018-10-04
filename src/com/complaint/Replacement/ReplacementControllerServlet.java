package com.complaint.Replacement;

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

import com.complaint.Engineer.Engineer;
import com.complaint.Engineer.EngineerDbUtil;


@WebServlet("/ReplacementControllerServlet")
public class ReplacementControllerServlet extends HttpServlet 
{
	private ReplacementDbUtil replacementDbUtil; 
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException 
	{
		try
		{
			replacementDbUtil = new ReplacementDbUtil(dataSource);
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
				case "LIST": listReplacements(request, response);
							 break;
				case "LOAD": loadReplacement(request, response); 
							 break; 
				case "UPDATE": updateReplacement(request,response);
								break;
				case "DELETE": deleteReplacement(request,response);
								break;
				default		: listReplacements(request, response);
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
			addReplacement(request,response);
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}
	}
	
	private void listReplacements(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		List<Replacement> replacements = replacementDbUtil.getReplacements();
		
		request.setAttribute("REPLACEMENT_LIST", replacements);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-replacements.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteReplacement(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String theReplacementId = request.getParameter("replacementId");
		replacementDbUtil.deleteReplacement(theReplacementId);
		listReplacements(request,response);
	}
	private void updateReplacement(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("theReplacementId"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		Replacement theReplacement = new Replacement(id,name,price);
		replacementDbUtil.updateReplacement(theReplacement);
		listReplacements(request,response);
	}
	private void loadReplacement(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String theReplacementId		=	request.getParameter("replacementId");
		Replacement theReplacement 	=	replacementDbUtil.getReplacement(theReplacementId);
		request.setAttribute("THE_REPLACEMENT", theReplacement);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-replacement-form.jsp");
		dispatcher.forward(request, response);
	}
	private void addReplacement(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String name  = request.getParameter("name");
		int price  = Integer.parseInt(request.getParameter("price"));
		Replacement theReplacement	=	new Replacement(name,price);
		replacementDbUtil.addReplacement(theReplacement); 
		
		listReplacements(request,response);
	}
}