package com.project1.task_management_app.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.project1.task_management_app.dao.TaskDAO;
import com.project1.task_management_app.dto.TaskDTO;
import com.project1.task_management_app.entity.Task;
import com.project1.task_management_app.entity.TaskUser;
import com.project1.task_management_app.model.TaskDataUpdateModel;
import com.project1.task_management_app.model.TaskDurationUpdateModel;
import com.project1.task_management_app.model.TaskModel;
@Service
public class TaskServiceImplementation implements TaskService
{
	private TaskDAO dao;
	public TaskServiceImplementation (TaskDAO dao)
	{
		this.dao = dao;
	}
	private TaskDTO mapToDTO (Task task)
	{
		return new TaskDTO (task.getId (), task.getData (), task.getDuration ());
	}
	@Override
	public void saveTask (Integer userId, TaskModel taskModel)
	{
		TaskUser user = dao.getUserReference (userId);
		Task task = new Task ();
		task.setData (taskModel.getData ());
		task.setDuration (taskModel.getDuration ());
		task.setUser (user);
		dao.saveTask (task);
	}
	@Override
	public void updateData (Integer taskId, TaskDataUpdateModel model)
	{
		dao.updateData (taskId, model.getData ());
	}
	@Override
	public void updateDuration (Integer taskId, TaskDurationUpdateModel model)
	{
		dao.updateDuration (taskId, model.getDuration ());
	}
	@Override
	public List <TaskDTO> getAllTasks (Integer loginId)
	{
		List <Task> tasks = dao.getAllTasks (loginId);
		return tasks.stream ().map (this::mapToDTO).toList ();
	}
}