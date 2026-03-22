package com.project1.task_management_app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.project1.task_management_app.dto.SessionDTO;
import com.project1.task_management_app.exception.UserNoSession;
import com.project1.task_management_app.model.TaskDataUpdateModel;
import com.project1.task_management_app.model.TaskDurationUpdateModel;
import com.project1.task_management_app.model.TaskModel;
import com.project1.task_management_app.service.SessionService;
import com.project1.task_management_app.service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class TaskController
{
	private final TaskService taskService;
	private final SessionService sessionService;
	public TaskController (TaskService taskService, SessionService sessionService)
	{
		this.taskService = taskService;
		this.sessionService = sessionService;
	}
	@GetMapping ("/showTasks")
	public String showTasks (HttpSession session, Model model) throws UserNoSession
	{
		sessionService.checkSession (session);
		SessionDTO sessionDTO = (SessionDTO) session.getAttribute ("user");
		model.addAttribute ("tasks", taskService.getAllTasks (sessionDTO.getId ()));
		return "showTasks";
	}
	@GetMapping ("/saveTask")
	public String saveTask ()
	{
		return "saveTask";
	}
	@PostMapping ("/saveTask")
	public String saveTask (HttpSession session, TaskModel taskModel, RedirectAttributes redirectAttributes) throws UserNoSession
	{
		sessionService.checkSession (session);
		SessionDTO sessionDTO = (SessionDTO) session.getAttribute ("user");
		taskService.saveTask (sessionDTO.getId (), taskModel);
		redirectAttributes.addFlashAttribute ("message", "Task Saved!");
		return "redirect:/showTasks";
	}
	@PostMapping ("/updateData")
	public String updateData (HttpSession session, TaskDataUpdateModel taskDataUpdateModel, RedirectAttributes redirectAttributes) throws UserNoSession
	{
		sessionService.checkSession (session);
		taskService.updateData (taskDataUpdateModel.getTaskId (), taskDataUpdateModel);
		redirectAttributes.addFlashAttribute ("message", "Data Updated!");
		return "redirect:/showTasks";
	}
	@PostMapping ("/updateDuration")
	public String updateDuration (HttpSession session, TaskDurationUpdateModel taskDurationUpdateModel, RedirectAttributes redirectAttributes) throws UserNoSession
	{
		sessionService.checkSession (session);
		taskService.updateDuration (taskDurationUpdateModel.getTaskId (), taskDurationUpdateModel);
		redirectAttributes.addFlashAttribute ("message", "Duration Updated!");
		return "redirect:/showTasks";
	}
}