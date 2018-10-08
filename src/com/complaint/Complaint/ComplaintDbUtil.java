package com.complaint.Complaint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ComplaintDbUtil 
{
private DataSource dataSource;
	
	public ComplaintDbUtil(DataSource theDataSource)
	{
		dataSource = theDataSource;
	}
	
	public List<Complaint> getComplaints() throws Exception
	{
		List<Complaint> complaints = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt  = null;
		ResultSet myRs    = null;
		
		try
		{
			myConn     = dataSource.getConnection();
			String sql = "select * from complaint";
			myStmt     = myConn.createStatement();
			myRs       = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				int id = myRs.getInt("cid");
				String details = myRs.getString("details");
				String status = myRs.getString("status");
						
				Complaint tempComplaint = new Complaint(id,details,status);
				complaints.add(tempComplaint);
			}
			return complaints;
		}
		finally
		{
			close(myConn,myStmt,myRs);
		}		
	}
	public List<Complaint> getComplaints(int uid) throws Exception
	{
		List<Complaint> complaints = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt  = null;
		ResultSet myRs    = null;
		
		try
		{
			myConn     = dataSource.getConnection();
			String sql = "select * from complaint where uid="+uid;
			myStmt     = myConn.createStatement();
			myRs       = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				int id = myRs.getInt("cid");
				String details = myRs.getString("details");
				String status = myRs.getString("status");
						
				Complaint tempComplaint = new Complaint(id,details,status);
				complaints.add(tempComplaint);
			}
			return complaints;
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
	
	public void addComplaint(Complaint theComplaint) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			myConn = dataSource.getConnection();
			
			String sql = "insert into complaint"
						+"(uid,details)"
						+"values (?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1,theComplaint.getUid());
			myStmt.setString(2,theComplaint.getDetails());
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
	}
	
	public Complaint getComplaint(String theComplaintId) throws Exception
	{
		Complaint theComplaint;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int complaintId;
		
		try
		{
			complaintId = Integer.parseInt(theComplaintId);
			myConn = dataSource.getConnection();	
			String sql = "select * from complaint where cid=?";
			myStmt	=	myConn.prepareStatement(sql);
			myStmt.setInt(1, complaintId);
			myRs = myStmt.executeQuery();
			if (myRs.next())
			{
				int cId = myRs.getInt("cid");
				String details = myRs.getString("details");
				String status = myRs.getString("status");
				
				theComplaint = new Complaint(cId,details,status);
			}
			else
			{
				throw new Exception("Could not find engineer id: "+complaintId);
			}
			
			return theComplaint;
		}
		finally
		{
			close(myConn,myStmt,myRs);
		}
	}

	public void updateComplaint(Complaint theComplaint) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
		myConn	=	dataSource.getConnection();
		String sql = "update complaint "
					+"set details=?, status=? "
					+" where cid = ?";
		myStmt	=	myConn.prepareStatement(sql);
		myStmt.setString(1,theComplaint.getDetails());
		myStmt.setString(2,theComplaint.getStatus());
		myStmt.setInt(3,theComplaint.getcId());
		myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
		
	}

	public void deleteComplaint(String theComplaintId) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			int complaintId = Integer.parseInt(theComplaintId);
			
			myConn = dataSource.getConnection();
			
			String sql = "delete from complaint where cid=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, complaintId);
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
		
	}
	
}

