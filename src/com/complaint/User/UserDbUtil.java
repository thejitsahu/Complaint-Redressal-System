package com.complaint.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class UserDbUtil
{
	private DataSource dataSource;
	
	public UserDbUtil(DataSource theDataSource)
	{
		dataSource = theDataSource;
	}
	
	public List<User> getUsers() throws Exception
	{
		List<User> users = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt  = null;
		ResultSet myRs    = null;
		
		try
		{
			myConn     = dataSource.getConnection();
			String sql = "select * from user";
			myStmt     = myConn.createStatement();
			myRs       = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				int id = myRs.getInt("id");
				String email = myRs.getString("email");
				String name = myRs.getString("username");
				User tempUser = new User(id,email,name);
				users.add(tempUser);
			}
			return users;
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
	public void addUser(User theUser) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			myConn = dataSource.getConnection();
			
			String sql = "insert into user"
						+"(email,username,password)"
						+" values (?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1,theUser.getEmail());
			myStmt.setString(2,theUser.getUsername());
			myStmt.setString(3,theUser.getPassword());
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
	}

	public User getUser(String theUserId) throws Exception
	{
		User theUser;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int userId;
		
		try
		{
			userId = Integer.parseInt(theUserId);
			myConn = dataSource.getConnection();	
			String sql = "select * from user where id=?";
			myStmt	=	myConn.prepareStatement(sql);
			myStmt.setInt(1, userId);
			myRs = myStmt.executeQuery();
			if (myRs.next())
			{
				String email = myRs.getString("email");
				String name = myRs.getString("username");
				String password = myRs.getString("password");
				theUser = new User(userId,email,name,password);
			}
			else
			{
				throw new Exception("Could not find engineer id: "+userId);
			}
			
			return theUser;
		}
		finally
		{
			close(myConn,myStmt,myRs);
		}
	}
	
	public void updateUser(User theUser) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
		myConn	=	dataSource.getConnection();
		String sql = "update user "
					+"set email=?, username=?, password=?"
					+" where id =?";
		myStmt	=	myConn.prepareStatement(sql);
		myStmt.setString(1,theUser.getEmail());
		myStmt.setString(2,theUser.getUsername());
		myStmt.setString(3,theUser.getPassword());
		myStmt.setInt(4,theUser.getId());
		myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
	}
	
	public void deleteUser(String theUserId) throws Exception
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try
		{
			int userId = Integer.parseInt(theUserId);
			
			myConn = dataSource.getConnection();
			
			String sql = "delete from user where id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, userId);
			
			myStmt.execute();
		}
		finally
		{
			close(myConn,myStmt,null);
		}
		
	}
	
	public boolean authenicate(String username,String password) throws Exception
	{
		User theUser;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String userName,passWord;
		boolean auth=false;
		try
		{
			System.out.println("THanos");
			userName = username;
			passWord = password;
			myConn = dataSource.getConnection();	
			String sql = "select username,password from user where username=?";
			myStmt	=	myConn.prepareStatement(sql);
			myStmt.setString(1, userName);
			myRs = myStmt.executeQuery();
			if (myRs.next())
			{
				String name = myRs.getString("username");
				String pass = myRs.getString("password");
				theUser = new User(name,pass);
				if(userName.equals(name)&& passWord.equals(pass))
				{
					auth = true;
				}
			}
			else
			{
//				throw new Exception("Could not find user id: "+userName);
				return false;
			}
			return auth;
		}
		finally
		{
			close(myConn,myStmt,myRs);
		}
	}
}