package com.complaint.Complaint;

public class Complaint 
{
	private int complaintId;
	private int productId;
	private int engineerId;
	private String details;
	private String status;
	
	public Complaint(int complaintId, int productId,int engineerId, String details, String status) 
	{
		this.complaintId = complaintId;
		this.productId = productId;
		this.engineerId = engineerId;
		this.details = details;
		this.status = status;
	}

	public Complaint(int productId, int engineerId,String details, String status)
	{
		this.productId = productId;
		this.engineerId = engineerId;
		this.details = details;
		this.status = status;
	}

	public int getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
