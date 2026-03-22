package com.project1.task_management_app.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Task
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String data;
	private String duration;
	@ManyToOne
	private TaskUser user;
	public Task ()
	{

	}
	public Task (String data, String duration, TaskUser user)
	{
		this.data = data;
		this.duration = duration;
		this.user = user;
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
	public TaskUser getUser ()
	{
		return user;
	}
	public void setUser (TaskUser user)
	{
		this.user = user;
	}
}