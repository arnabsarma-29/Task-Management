package com.project1.task_management_app.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
@ControllerAdvice
public class UserException
{
	@ExceptionHandler (UserWrongDetails.class)
	public String handleLoginError (UserWrongDetails e, RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute ("message", e.getMessage ());
		return "redirect:/login";
	}
	@ExceptionHandler (UserNoSession.class)
	public String handleNoSession (UserNoSession e, RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute ("message", e.getMessage ());
		return "redirect:/login";
	}
	@ExceptionHandler (UpdatePassword.class)
	public String handleWrongPassword (UpdatePassword e, RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute ("message", e.getMessage ());
		return "redirect:/settings";
	}
	@ExceptionHandler (Exception.class)
	public String handleGeneralException (Exception e, HttpSession session, RedirectAttributes redirectAttributes)
	{
		System.err.println (e.getMessage ());
		if (session != null)
		{
			session.invalidate();
		}
		redirectAttributes.addFlashAttribute ("message", "500 Server Error!");
		return "redirect:/login";
	}
}