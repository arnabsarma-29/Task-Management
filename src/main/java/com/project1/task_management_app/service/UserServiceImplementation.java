package com.project1.task_management_app.service;
import org.springframework.stereotype.Service;
import com.project1.task_management_app.dao.UserDAO;
import com.project1.task_management_app.dto.UserDTO;
import com.project1.task_management_app.entity.TaskUser;
import com.project1.task_management_app.exception.UpdatePassword;
import com.project1.task_management_app.exception.UserWrongDetails;
import com.project1.task_management_app.model.LoginModel;
import com.project1.task_management_app.model.UserModel;
import com.project1.task_management_app.model.UserUpdateEmailModel;
import com.project1.task_management_app.model.UserUpdatePasswordModel;
import com.project1.task_management_app.model.UserUpdateUsernameModel;
@Service
public class UserServiceImplementation implements UserService
{
	private UserDAO dao;
	public UserServiceImplementation (UserDAO dao)
	{
		this.dao = dao;
	}
	@Override
	public void saveUser (UserModel user)
	{
		TaskUser taskUser = new TaskUser ();
		taskUser.setUsername (user.getUsername ());
		taskUser.setEmail (user.getEmail ());
		taskUser.setPassword (user.getPassword ());
		dao.saveUser (taskUser);
	}
	@Override
	public UserDTO loginUser (LoginModel login) throws UserWrongDetails
	{
		TaskUser user = dao.loginUser (login.getUsername (), login.getPassword ());
		return new UserDTO (user.getId (),user.getUsername (), user.getEmail ());
	}
	@Override
	public void updatePassword (Integer userId, UserUpdatePasswordModel model) throws UpdatePassword
	{
		dao.updatePassword (userId, model.getOldPassword (), model.getNewPassword ());
	}
	@Override
	public void updateUsername (Integer userId, UserUpdateUsernameModel username)
	{
		dao.updateUsername (userId, username.getUsername ());
	}
	@Override
	public void updateEmail (Integer userId, UserUpdateEmailModel model)
	{
		dao.updateEmail (userId, null);
	}
}