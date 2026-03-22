package com.project1.task_management_app.service;
import org.springframework.stereotype.Service;
import com.project1.task_management_app.exception.UserNoSession;
import jakarta.servlet.http.HttpSession;
@Service
public class SessionServiceImplementation implements SessionService
{
	@Override
	public void checkSession (HttpSession session) throws UserNoSession
	{
		if (session == null || session.getAttribute ("user") == null)
		{
			throw new UserNoSession ();
		}
	}
}