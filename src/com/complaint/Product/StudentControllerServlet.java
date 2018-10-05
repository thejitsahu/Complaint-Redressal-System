package com.complaint.Product;

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




@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private ProductDbUtil productDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException 
	{
		try
		{
			productDbUtil = new ProductDbUtil(dataSource);
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
				case "LIST": listProducts(request, response);
							 break;
				case "LOAD": loadProduct(request, response); 
							 break; 
				case "UPDATE": updateProduct(request,response);
								break;
				case "DELETE": deleteProduct(request,response);
								break;
				default		: listProducts(request, response);
			}
			
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}
	}
	private void listProducts(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		List<Product> students = productDbUtil.getStudents();
		
		request.setAttribute("PRODUCT_LIST", students);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-products.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String theProductId = request.getParameter("productId");
		productDbUtil.deleteProduct(theProductId);
		listProducts(request,response);
		
	}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("theProductId"));
		int cId = Integer.parseInt(request.getParameter("cId"));
		String name = request.getParameter("name");
		String type  = request.getParameter("type");
		String company     = request.getParameter("company");
		String warantyDate = request.getParameter("warantyDate");
		
		Product theProduct = new Product(id,cId,name,type,company,warantyDate);
		productDbUtil.updateProduct(theProduct);
		listProducts(request,response);
	}
	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String theProductId		=	request.getParameter("productId");
		Product theProduct 		=	productDbUtil.getProduct(theProductId);
		request.setAttribute("THE_PRODUCT", theProduct);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-product-form.jsp");
		dispatcher.forward(request, response);
		
	}
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		int serialId = Integer.parseInt(request.getParameter("serialId"));
		String name  = request.getParameter("name");
		String type     = request.getParameter("type");
		String company     = request.getParameter("company");
		String warantyDate     = request.getParameter("warantyDate");
		
		Product theProduct	=	new Product(serialId,name,type,company,warantyDate);
		
		productDbUtil.addProduct(theProduct); 
		
		listProducts(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			addProduct(request,response);
		}
		catch(Exception exc)
		{
			throw new ServletException(exc);
		}
	}
}



