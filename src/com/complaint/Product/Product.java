package com.complaint.Product;

public class Product 
{
	private int serialId;
	private String name;
	private String type;
	private String company;
	private String warantyDate;
	
	public Product(int serialId, String name, String type, String company, String warantyDate) 
	{
		this.serialId = serialId;
		this.name = name;
		this.type = type;
		this.company = company;
		this.warantyDate = warantyDate;
	}
	
	public Product(String name, String type, String company, String warantyDate)
	{
		this.name = name;
		this.type = type;
		this.company = company;
		this.warantyDate = warantyDate;
	}

	public int getSerialId() 
	{
		return serialId;
	}
	
	public void setSerialId(int serialId) 
	{
		this.serialId = serialId;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public String getCompany() 
	{
		return company;
	}
	
	public void setCompany(String company) 
	{
		this.company = company;
	}
	public String getWarantyDate() 
	{
		return warantyDate;
	}
	
	public void setWarantyDate(String warantyDate) 
	{
		this.warantyDate = warantyDate;
	}
}