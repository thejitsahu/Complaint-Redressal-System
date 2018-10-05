package com.complaint.Complaint;

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

@WebServlet("/ComplaintControllerServlet")
public class ComplaintControllerServlet extends HttpServlet 
{
	private ComplaintDbUtil complaintDbUtil; 
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException 
	{
		try
		{
			complaintDbUtil = new ComplaintDbUtil(dataSource);
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
				case "LIST": listComplaints(request, response);
							 break;
				case "LOAD": loadComplaint(request, response); 
							 break; 
				case "UPDATE": updateComplaint(request,response);
								break;
				case "DELETE": deleteComplaint(request,response);
								break;
				default		: listComplaints(request, response);
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
			addComplaint(request,response);
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}
	}
	
	private void listComplaints(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		List<Complaint> complaints = complaintDbUtil.getComplaints();
		request.setAttribute("COMPLAINT_LIST", complaints);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-complaints.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteComplaint(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String theComplaintId = request.getParameter("complaintId");
		complaintDbUtil.deleteComplaint(theComplaintId);
		listComplaints(request,response);
	}
	
	private void updateComplaint(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int cId = Integer.parseInt(request.getParameter("theComplaintId"));
		String details = request.getParameter("details");
		String status  = request.getParameter("status");
		Complaint theComplaint = new Complaint(cId,details,status);
		complaintDbUtil.updateComplaint(theComplaint);
		listComplaints(request,response);
	}
	
	private void loadComplaint(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String theComplaintId		=	request.getParameter("complaintId");
		Complaint theComplaint 		=	complaintDbUtil.getComplaint(theComplaintId);
		request.setAttribute("THE_COMPLAINT", theComplaint);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-complaint-form.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void addComplaint(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String details  = request.getParameter("details");
		Complaint theComplaint	=	new Complaint(details);
		complaintDbUtil.addComplaint(theComplaint); 
		listComplaints(request,response);
		
	}
}
