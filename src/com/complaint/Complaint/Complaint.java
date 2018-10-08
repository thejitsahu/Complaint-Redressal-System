package com.complaint.Complaint;

public class Complaint 
{
	private int cId;
	private int uid;
	private String details;
	private String status;

	public Complaint(int uid, String details) 
	{
		this.uid = uid;
		this.details = details;
	}

	public Complaint(String details,int uid, String status)
	{
	
		this.uid = uid;
		this.details = details;
		this.status = status;
	}

	public Complaint(int cId, String details, String status)
	{
		this.cId = cId;
		this.details = details;
		this.status = status;
	}

	public Complaint(String details, String status)
	{
		this.details = details;
		this.status = status;
	}
	
	
	public Complaint(String details) 
	{
		this.details = details;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
