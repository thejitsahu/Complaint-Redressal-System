package com.complaint.HomePage;

public class Home 
{
	private int cid;
	private String details;
	private String status;
	private int serialId;
	private String name;
	private String type;
	private String company;
	private String warantyDate;
	private String rname;
	private int price;
	private String ename;
	
	public Home(int cid, String details, String status, int serialId, String name, String type, String company,
			String warantyDate, String rname, int price, String ename) 
	{
		this.cid = cid;
		this.details = details;
		this.status = status;
		this.serialId = serialId;
		this.name = name;
		this.type = type;
		this.company = company;
		this.warantyDate = warantyDate;
		this.rname = rname;
		this.price = price;
		this.ename = ename;
	}

	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid) 
	{
		this.cid = cid;
	}

	public String getDetails() 
	{
		return details;
	}

	public void setDetails(String details) 
	{
		this.details = details;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
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

	public String getRname() 
	{
		return rname;
	}

	public void setRname(String rname) 
	{
		this.rname = rname;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}

	public String getEname() 
	{
		return ename;
	}

	public void setEname(String ename) 
	{
		this.ename = ename;
	}
}