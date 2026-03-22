package com.project1.task_management_app.service;
import java.util.List;
import com.project1.task_management_app.dto.TaskDTO;
import com.project1.task_management_app.model.TaskDataUpdateModel;
import com.project1.task_management_app.model.TaskDurationUpdateModel;
import com.project1.task_management_app.model.TaskModel;
public interface TaskService
{
	public void saveTask (Integer userId, TaskModel taskModel);
	public void updateData (Integer taskId, TaskDataUpdateModel model);
	public void updateDuration (Integer taskId, TaskDurationUpdateModel model);
	public List <TaskDTO> getAllTasks (Integer loginId);
}