package com.project1.task_management_app.model;
public class TaskDurationUpdateModel
{
	private Integer taskId;
	private String duration;
	public Integer getTaskId ()
	{
		return taskId;
	}
	public void setTaskId (Integer taskId)
	{
		this.taskId = taskId;
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