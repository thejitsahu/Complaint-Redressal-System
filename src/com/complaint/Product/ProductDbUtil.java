package com.complaint.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class ProductDbUtil
{
	private DataSource dataSource;
	
	public ProductDbUtil(DataSource theDataSource)
	{
		dataSource = theDataSource;
	}
	
	public List<Product> getStudents() throws Exception
	{
		List<Product> products = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt  = null;
		ResultSet myRs    = null;
		
		try
		{
			myConn     = dataSource.getConnection();
			String sql = "select * from product order by type";
			myStmt     = myConn.createStatement();
			myRs       = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				int serialId = myRs.getInt("serialid");
				int cId = myRs.getInt("cid");
				String name = myRs.getString("name");
				String type = myRs.getString("type");
				String company = myRs.getString("company");
				String warantyDate = myRs.getString("warantydate");
				
				Product tempStudent = new Product(serialId,cId,name,type,company,warantyDate);
				products.add(tempStudent);
			}
			return products;
		}
		finally
		{
			close(myConn,myStmt,myRs);
		}		
	}
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) 
	{
		try
		{
			if (myRs!=null)
			{
				myRs.close();
			}
			if (myStmt!=null)
			{
				myStmt.close();
			}
			if (myConn!=null)
			{
				myConn.close();
			}
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	public void addProduct(Product theProduct) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			
			
			myConn = dataSource.getConnection();
			
			String sql = "insert into product"
						+"(serialid,cid,name,type,company,warantydate)"
						+"values (?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1,theProduct.getSerialId());
			myStmt.setInt(2,theProduct.getcId());
			myStmt.setString(3,theProduct.getName());
			myStmt.setString(4,theProduct.getType());
			myStmt.setString(5,theProduct.getCompany());
			myStmt.setString(6,theProduct.getWarantyDate());
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
	}

	public Product getProduct(String theSerialId) throws Exception
	{
		Product theProduct;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int productId;
		
		try
		{
			productId = Integer.parseInt(theSerialId);
			myConn = dataSource.getConnection();	
			String sql = "select * from product where serialid=?";
			myStmt	=	myConn.prepareStatement(sql);
			myStmt.setInt(1, productId);
			myRs = myStmt.executeQuery();
			if (myRs.next())
			{	
				int cId		= myRs.getInt("cid");
				String name = myRs.getString("name");
				String type = myRs.getString("type");
				String company	= myRs.getString("company");
				String warantyDate	= myRs.getString("warantydate");
				
				theProduct = new Product(productId,cId,name,type,company,warantyDate);
			}
			else
			{
				throw new Exception("Could not find student id: "+productId);
			}
			
			return theProduct;
		}
		finally
		{
			close(myConn,myStmt,myRs);
		}
	}

	public void updateProduct(Product theProduct) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
		myConn	=	dataSource.getConnection();
		String sql = "update product "
					+"set cid=?, name=?, type=?, company=?, warantydate=?"
					+"where serialid =?";
		myStmt	=	myConn.prepareStatement(sql);
		myStmt.setInt(1,theProduct.getcId());
		myStmt.setString(2,theProduct.getName());
		myStmt.setString(3,theProduct.getType());
		myStmt.setString(4,theProduct.getCompany());
		myStmt.setString(5,theProduct.getWarantyDate());
		myStmt.setInt(6,theProduct.getSerialId());
		myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
		
	}

	public void deleteProduct(String theSerialId) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			int productId = Integer.parseInt(theSerialId);
			
			myConn = dataSource.getConnection();
			
			String sql = "delete from product where serialid=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, productId);
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
		
	}
}