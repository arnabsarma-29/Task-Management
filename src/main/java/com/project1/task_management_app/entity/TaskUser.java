package com.project1.task_management_app.entity;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class TaskUser
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String email;
	private String password;
	@OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Task> tasks = new ArrayList <> ();
	public TaskUser ()
	{

	}
	public TaskUser (String username, String email, String password, List <Task> tasks)
	{
		this.username = username;
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}
	public Integer getId ()
	{
		return id;
	}
	public void setId (Integer id)
	{
		this.id = id;
	}
	public String getUsername ()
	{
		return username;
	}
	public void setUsername (String username)
	{
		this.username = username;
	}
	public String getEmail ()
	{
		return email;
	}
	public void setEmail (String email)
	{
		this.email = email;
	}
	public String getPassword ()
	{
		return password;
	}
	public void setPassword (String password)
	{
		this.password = password;
	}
	public List <Task> getTasks ()
	{
		return tasks;
	}
	public void setTasks (List <Task> tasks)
	{
		this.tasks = tasks;
	}
	public void addTask (Task task)
	{
		tasks.add (task);
		task.setUser (this);
	}
	public void removeTask (Task task)
	{
		tasks.remove (task);
		task.setUser (null);
	}
}