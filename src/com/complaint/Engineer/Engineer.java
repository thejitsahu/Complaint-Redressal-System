package com.complaint.Engineer;

public class Engineer 
{
	private int id;
	private String name;

	public Engineer(int id, String name) 
	{
		this.id = id;
		this.name = name;
	}
	public Engineer(String name) 
	{
		this.name = name;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
}
