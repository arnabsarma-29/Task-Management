package com.project1.task_management_app.model;
public class UserUpdatePasswordModel
{
	private String oldPassword;
	private String newPassword;
	public UserUpdatePasswordModel (String oldPassword, String newPassword)
	{
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	public String getOldPassword ()
	{
		return oldPassword;
	}
	public void setOldPassword (String oldPassword)
	{
		this.oldPassword = oldPassword;
	}
	public String getNewPassword ()
	{
		return newPassword;
	}
	public void setNewPassword (String newPassword)
	{
		this.newPassword = newPassword;
	}	
}