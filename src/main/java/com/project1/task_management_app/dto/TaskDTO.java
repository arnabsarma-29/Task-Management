package com.project1.task_management_app.dto;
public class TaskDTO
{
	private Integer id;
	private String data;
	private String duration;
	public TaskDTO (Integer id, String data, String duration)
	{
		this.id = id;
		this.data = data;
		this.duration = duration;
	}
	public Integer getId ()
	{
		return id;
	}
	public void setId (Integer id)
	{
		this.id = id;
	}
	public String getData ()
	{
		return data;
	}
	public void setData (String data)
	{
		this.data = data;
	}
	public String getDuration ()
	{
		return duration;
	}
	public void setDuration (String duration)
	{
		this.duration = duration;
	}
}