package com.project1.task_management_app.exception;
import jakarta.servlet.http.HttpSession;
public class UserNoSession extends Exception
{
	public UserNoSession ()
	{
		super ("Session Expired");
	}
	public UserNoSession (String message, HttpSession session)
	{
		session.invalidate ();
		super (message);
	}
}