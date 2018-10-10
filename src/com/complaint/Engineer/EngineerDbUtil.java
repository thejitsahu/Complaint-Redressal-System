package com.complaint.Engineer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class EngineerDbUtil
{
	private DataSource dataSource;
	
	public EngineerDbUtil(DataSource theDataSource)
	{
		dataSource = theDataSource;
	}
	
	public List<Engineer> getEngineers() throws Exception
	{
		List<Engineer> engineers = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt  = null;
		ResultSet myRs    = null;
		
		try
		{
			myConn     = dataSource.getConnection();
			String sql = "select * from engineer";
			myStmt     = myConn.createStatement();
			myRs       = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				int id = myRs.getInt("eid");
				int cid = myRs.getInt("cid");
				String name = myRs.getString("ename");
						
				Engineer tempEngineer = new Engineer(id,cid,name);
				engineers.add(tempEngineer);
			}
			return engineers;
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
	
	public void addEngineer(Engineer theEngineer) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			myConn = dataSource.getConnection();
			
			String sql = "insert into engineer"
						+"(ename)"
						+"values (?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1,theEngineer.getName());
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
	}

	public Engineer getEngineer(String theEngineerId) throws Exception
	{
		Engineer theEngineer;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int engineerId;
		
		try
		{
			engineerId = Integer.parseInt(theEngineerId);
			myConn = dataSource.getConnection();	
			String sql = "select * from engineer where eid=?";
			myStmt	=	myConn.prepareStatement(sql);
			myStmt.setInt(1, engineerId);
			myRs = myStmt.executeQuery();
			if (myRs.next())
			{
				String name = myRs.getString("ename");
				int cid = myRs.getInt("cid");
				theEngineer = new Engineer(engineerId,cid,name);
			}
			else
			{
				throw new Exception("Could not find engineer id: "+engineerId);
			}
			
			return theEngineer;
		}
		finally
		{
			close(myConn,myStmt,myRs);
		}
	}

	public void updateEngineer(Engineer theEngineer) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
		myConn	=	dataSource.getConnection();
		String sql = "update engineer "
					+"set ename=?, cid=? "
					+" where eid = ?";
		myStmt	=	myConn.prepareStatement(sql);
		myStmt.setString(1,theEngineer.getName());
		myStmt.setInt(2,theEngineer.getcId());
		myStmt.setInt(3,theEngineer.geteId());
		myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
		
	}

	public void deleteEngineer(String theEngineerId) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			int engineerId = Integer.parseInt(theEngineerId);
			
			myConn = dataSource.getConnection();
			
			String sql = "delete from engineer where eid=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, engineerId);
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
		
	}
}