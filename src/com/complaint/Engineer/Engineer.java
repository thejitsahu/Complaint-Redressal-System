package com.complaint.Engineer;

public class Engineer 
{
	private int id;
	private int cId;
	private int name;
	public Engineer(int id, int cId, int name) 
	{
		this.id = id;
		this.cId = cId;
		this.name = name;
	}
	public Engineer(int cId, int name) 
	{
		this.cId = cId;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
}
