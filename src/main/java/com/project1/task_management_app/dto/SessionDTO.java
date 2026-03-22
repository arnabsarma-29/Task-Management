package com.project1.task_management_app.dto;
public class SessionDTO
{
	private Integer id;
	public SessionDTO (Integer id)
	{
		this.id = id;
	}
	public Integer getId ()
	{
		return id;
	}
	public void setId (Integer id)
	{
		this.id = id;
	}
}