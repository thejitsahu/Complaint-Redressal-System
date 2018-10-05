package com.complaint.Complaint;

public class Complaint 
{
	private int cId;
	private String details;
	private String status;

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
