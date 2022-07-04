package org.jk.Web_Repo.Entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MainFuncPOJO 
{
	private int id;
	@NotEmpty(message = "This is a required field")
	private String title;
	@Size(min = 10, max = 2000, message = "characters should be in a range of 10-200")
	private String description;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}	
}
