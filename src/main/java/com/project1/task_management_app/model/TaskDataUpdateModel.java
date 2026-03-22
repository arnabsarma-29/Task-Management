package com.project1.task_management_app.model;
public class TaskDataUpdateModel
{
	private Integer taskId;
	private String data;
	public Integer getTaskId ()
	{
		return taskId;
	}
	public void setTaskId (Integer taskId)
	{
		this.taskId = taskId;
	}
	public String getData ()
	{
		return data;
	}
	public void setData (String data)
	{
		this.data = data;
	}
}