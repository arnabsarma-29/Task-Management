package com.project1.task_management_app.service;
import com.project1.task_management_app.exception.UserNoSession;
import jakarta.servlet.http.HttpSession;
public interface SessionService
{
	public void checkSession (HttpSession session) throws UserNoSession;	
}