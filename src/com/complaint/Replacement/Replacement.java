package com.complaint.Replacement;

public class Replacement 
{
	private int id;
	private int cId;
	private String name;
	private int price;
	
	public Replacement(int id, String name, int price)
	{
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Replacement(String name, int price)
	{
		this.name = name;
		this.price = price;
	}
	

	public Replacement(int id, int cId, String name, int price)
	{
		this.id = id;
		this.cId = cId;
		this.name = name;
		this.price = price;
	}



	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}