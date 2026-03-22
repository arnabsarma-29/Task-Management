package com.project1.task_management_app.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.project1.task_management_app.entity.Task;
import com.project1.task_management_app.entity.TaskUser;
import com.project1.task_management_app.repository.TaskRepository;
import com.project1.task_management_app.repository.UserRepository;
@Repository
public class TaskDAOImplementation implements TaskDAO
{
	private final TaskRepository taskRepository;
	private final UserRepository userRepository;
	public TaskDAOImplementation (TaskRepository taskRepository, UserRepository userRepository)
	{
		this.taskRepository = taskRepository;
		this.userRepository = userRepository;
	}
	@Override
	public TaskUser getUserReference (Integer userId)
	{
		return userRepository.getReferenceById (userId);
	}
	@Override
	public void saveTask (Task task)
	{
		taskRepository.save (task);
	}
	@Override
	public void updateData (Integer taskId, String data)
	{
		taskRepository.updateData (taskId, data);
	}
	@Override
	public void updateDuration (Integer taskId, String duration)
	{
		taskRepository.updateDuration (taskId, duration);
	}
	@Override
	public List <Task> getAllTasks (Integer userId)
	{
		return taskRepository.findAll ();
	}
}