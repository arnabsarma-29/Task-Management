package com.project1.task_management_app.exception;
public class UserWrongDetails extends Exception
{
	public UserWrongDetails ()
	{
		super ("Wrong Credentials");
	}
	public UserWrongDetails (String message)
	{
		super (message);
	}
}