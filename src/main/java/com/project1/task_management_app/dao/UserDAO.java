package com.project1.task_management_app.dao;
import com.project1.task_management_app.entity.TaskUser;
import com.project1.task_management_app.exception.UpdatePassword;
import com.project1.task_management_app.exception.UserWrongDetails;
public interface UserDAO
{
	public TaskUser saveUser (TaskUser user);
	public TaskUser loginUser (String username, String password) throws UserWrongDetails;
	public void updatePassword (Integer userId, String oldPassword, String newPassword) throws UpdatePassword;
	public void updateUsername (Integer userId, String username);
	public void updateEmail (Integer userId, String email);
	public TaskUser getUserById (Integer id) throws UserWrongDetails;
}