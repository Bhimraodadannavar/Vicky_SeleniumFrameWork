package com.spicejet.genericUtility;

public enum PropertyFileKeys 
{
	BROWSER("browser"),URL("url"),TIMEOUT("timeOut"),URL1("url1");
	
private String keys;
	
	//setters
	private PropertyFileKeys(String Keys)
	{
		this.keys=Keys;
	}
	
	//getters
	public String convertToString()
	{
		return keys.toString();
	}
	
	

}
