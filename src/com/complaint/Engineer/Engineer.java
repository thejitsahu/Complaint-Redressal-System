package com.complaint.Engineer;

public class Engineer 
{
	private int eId;
	private int cId;
	private String name;

	public Engineer(int eId, String name) 
	{
		this.eId = eId;
		this.name = name;
	}
	
	public Engineer(String name) 
	{
		this.name = name;
	}
		
	public Engineer(int eId, int cId, String name) 
	{
		this.eId = eId;
		this.cId = cId;
		this.name = name;
	}
	
	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
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
