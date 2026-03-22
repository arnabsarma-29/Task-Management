package com.project1.task_management_app.service;
import com.project1.task_management_app.dto.UserDTO;
import com.project1.task_management_app.exception.UpdatePassword;
import com.project1.task_management_app.exception.UserWrongDetails;
import com.project1.task_management_app.model.LoginModel;
import com.project1.task_management_app.model.UserModel;
import com.project1.task_management_app.model.UserUpdateEmailModel;
import com.project1.task_management_app.model.UserUpdatePasswordModel;
import com.project1.task_management_app.model.UserUpdateUsernameModel;
public interface UserService
{
	public void saveUser (UserModel user);
	public UserDTO loginUser (LoginModel login) throws UserWrongDetails;
	public void updatePassword (Integer userId, UserUpdatePasswordModel model) throws UpdatePassword;
	public void updateUsername (Integer userId, UserUpdateUsernameModel username);
	public void updateEmail (Integer userId, UserUpdateEmailModel model);
}