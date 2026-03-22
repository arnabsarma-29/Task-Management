package com.project1.task_management_app.exception;
public class UpdatePassword extends Exception
{
	public UpdatePassword ()
	{
		super ("Incorrect Old Password");
	}
	public UpdatePassword (String passwordMessage)
	{
		super (passwordMessage);
	}
}