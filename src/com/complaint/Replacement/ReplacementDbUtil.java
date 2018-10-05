package com.complaint.Replacement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class ReplacementDbUtil
{
	private DataSource dataSource;
	
	public ReplacementDbUtil(DataSource theDataSource)
	{
		dataSource = theDataSource;
	}
	
	public List<Replacement> getReplacements() throws Exception
	{
		List<Replacement> replacements = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt  = null;
		ResultSet myRs    = null;
		
		try
		{
			myConn     = dataSource.getConnection();
			String sql = "select * from replacement";
			myStmt     = myConn.createStatement();
			myRs       = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				int id = myRs.getInt("rid");
				int cId = myRs.getInt("cid");
				String name = myRs.getString("name");
				int price = myRs.getInt("price");		
				Replacement tempReplacement = new Replacement(id,cId,name,price);
				replacements.add(tempReplacement);
			}
			return replacements;
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
	
	public void addReplacement(Replacement theReplacement) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			myConn = dataSource.getConnection();
			
			String sql = "insert into replacement"
						+"(name,price)"
						+"values (?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1,theReplacement.getName());
			myStmt.setInt(2,theReplacement.getPrice());
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
	}

	public Replacement getReplacement(String theReplacementId) throws Exception
	{
		Replacement theReplacement;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int replacementId;
		
		try
		{
			replacementId = Integer.parseInt(theReplacementId);
			myConn = dataSource.getConnection();	
			String sql = "select * from replacement where rid=?";
			myStmt	=	myConn.prepareStatement(sql);
			myStmt.setInt(1, replacementId);
			myRs = myStmt.executeQuery();
			if (myRs.next())
			{
				int cId = myRs.getInt("cid");
				String name = myRs.getString("name");
				int price = myRs.getInt("price");
				theReplacement = new Replacement(replacementId,cId,name,price);
			}
			else
			{
				throw new Exception("Could not find engineer id: "+replacementId);
			}
			
			return theReplacement;
		}
		finally
		{
			close(myConn,myStmt,myRs);
		}
	}

	public void updateReplacement(Replacement theReplacement) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
		myConn	=	dataSource.getConnection();
		String sql = "update replacement "
					+"set cid=?, name=?, price=?"
					+" where rid =?";
		myStmt	=	myConn.prepareStatement(sql);
		myStmt.setInt(1,theReplacement.getcId());
		myStmt.setString(2,theReplacement.getName());
		myStmt.setInt(3,theReplacement.getPrice());
		myStmt.setInt(4,theReplacement.getId());
		myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
		
	}

	public void deleteReplacement(String theReplacementId) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			int replacementId = Integer.parseInt(theReplacementId);
			
			myConn = dataSource.getConnection();
			
			String sql = "delete from replacement where rid=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, replacementId);
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
		
	}
}