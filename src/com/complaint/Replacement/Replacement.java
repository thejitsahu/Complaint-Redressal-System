package com.complaint.Replacement;

public class Replacement 
{
	private int replaceId;
	private String productId;
	private int price;
	
	public Replacement(int replaceId, String productId, int price) 
	{
		this.replaceId = replaceId;
		this.productId = productId;
		this.price = price;
	}
	
	public Replacement(String productId, int price) 
	{
		this.productId = productId;
		this.price = price;
	}

	public int getReplaceId() 
	{
		return replaceId;
	}

	public void setReplaceId(int replaceId) 
	{
		this.replaceId = replaceId;
	}

	public String getProductId() 
	{
		return productId;
	}

	public void setProductId(String productId) 
	{
		this.productId = productId;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}
}