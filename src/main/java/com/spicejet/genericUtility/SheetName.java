package com.spicejet.genericUtility;

public enum SheetName 
{
BOOKINGFLIGHT("bookingflight");
	
	private String shtName;
	//setter (constructor)
	private SheetName(String stName)
	{
		this.shtName=stName;
	}
	//getters
	public String getSheeCelltName()
	{
		return shtName.toString();
		
	}

}
