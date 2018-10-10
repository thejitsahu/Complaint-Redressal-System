package com.complaint.HomePage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class HomeDbUtil 
{	
	private DataSource dataSource;
	public HomeDbUtil(DataSource theDataSource)
	{
		dataSource = theDataSource;
	}
	
	public List<Home> getHome(int userId) throws Exception
	{
		List<Home> homes = new ArrayList<>();
		
		Connection myConn = null;
		PreparedStatement myStmt  = null;
		ResultSet myRs    = null;
		
		try
		{
			myConn     =dataSource.getConnection();
			String sql = "SELECT complaint.cid,complaint.uid,complaint.details,complaint.status,product.serialid,product.name,product.type,product.company,product.warantydate, "
					+"replacement.rname,replacement.price,engineer.ename "
					+"FROM complaint " 
					+"LEFT JOIN product "
					+"ON product.cid=complaint.cid "
					+"LEFT JOIN replacement "
					+"ON replacement.cid=complaint.cid "
					+"LEFT JOIN engineer "	
					+"ON engineer.cid=complaint.cid "
					+ "WHERE uid=?";
			myStmt     = myConn.prepareStatement(sql);
			myStmt.setInt(1,userId);
			myRs       = myStmt.executeQuery();
			
			while(myRs.next())
			{
				int cid = myRs.getInt("cid");
				String details = myRs.getString("details");
				String status = myRs.getString("status");
				int serialid = myRs.getInt("serialid");
				String name = myRs.getString("name");
				String type = myRs.getString("type");
				String company = myRs.getString("company");
				String warantyDate = myRs.getString("warantyDate");
				String rname = myRs.getString("rname");
				int price = myRs.getInt("price");
				String ename = myRs.getString("ename");
				Home tempHome = new Home(cid,details,status,serialid,name,type,company,warantyDate,rname,price,ename);
				homes.add(tempHome);
			}
			return homes;
		}
		finally
		{
			close(myConn,myStmt,myRs);
		}		
	}
	
	public List<Home> getHome() throws Exception
	{
		List<Home> homes = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt  = null;
		ResultSet myRs    = null;
		
		try
		{
			myConn     =dataSource.getConnection();
			String sql = "SELECT complaint.cid,complaint.details,complaint.status,product.serialid,product.name,product.type,product.company,product.warantydate, "
					+"replacement.rname,replacement.price,engineer.ename "
					+"FROM complaint " 
					+"LEFT JOIN product "
					+"ON product.cid=complaint.cid "
					+"LEFT JOIN replacement "
					+"ON replacement.cid=complaint.cid "
					+"LEFT JOIN engineer "	
					+"ON engineer.cid=complaint.cid ";
			myStmt     = myConn.createStatement();
			
			myRs       = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				int cid = myRs.getInt("cid");
				String details = myRs.getString("details");
				String status = myRs.getString("status");
				int serialid = myRs.getInt("serialid");
				String name = myRs.getString("name");
				String type = myRs.getString("type");
				String company = myRs.getString("company");
				String warantyDate = myRs.getString("warantyDate");
				String rname = myRs.getString("rname");
				int price = myRs.getInt("price");
				String ename = myRs.getString("ename");
				Home tempHome = new Home(cid,details,status,serialid,name,type,company,warantyDate,rname,price,ename);
				homes.add(tempHome);
			}
			return homes;
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
}