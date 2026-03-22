package com.project1.task_management_app.dao;
import java.util.List;
import com.project1.task_management_app.entity.Task;
import com.project1.task_management_app.entity.TaskUser;
public interface TaskDAO
{
	public TaskUser getUserReference (Integer userId);
	public void saveTask (Task task);
	public void updateData (Integer taskId, String data);
	public void updateDuration (Integer taskId, String duration);
	public List <Task> getAllTasks (Integer userId);
}