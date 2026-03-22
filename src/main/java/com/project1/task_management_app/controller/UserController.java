package com.project1.task_management_app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project1.task_management_app.dto.SessionDTO;
import com.project1.task_management_app.dto.UserDTO;
import com.project1.task_management_app.exception.UpdatePassword;
import com.project1.task_management_app.exception.UserNoSession;
import com.project1.task_management_app.exception.UserWrongDetails;
import com.project1.task_management_app.model.LoginModel;
import com.project1.task_management_app.model.UserModel;
import com.project1.task_management_app.model.UserUpdateEmailModel;
import com.project1.task_management_app.model.UserUpdatePasswordModel;
import com.project1.task_management_app.model.UserUpdateUsernameModel;
import com.project1.task_management_app.service.SessionService;
import com.project1.task_management_app.service.UserService;
import jakarta.servlet.http.HttpSession;
@Controller
public class UserController
{
	private final UserService userService;
	private final SessionService sessionService;
	public UserController (UserService userService, SessionService sessionService)
	{
		this.userService = userService;
		this.sessionService = sessionService;
	}
	@GetMapping ("/welcome")
	public String welcome ()
	{
		return "welcome";
	}
	@GetMapping ("/register")
	public String register ()
	{
		return "register";
	}
	@PostMapping ("/register")
	public String register (UserModel userModel, RedirectAttributes redirectAttributes)
	{
		userService.saveUser (userModel);
		redirectAttributes.addFlashAttribute ("message", "User Registered Successfully!");
		return "redirect:/login";
	}
	@GetMapping ("/login")
	public String login ()
	{
		return "login";
	}
	@PostMapping ("/login")
	public String login (LoginModel login, HttpSession session) throws UserWrongDetails
	{
		UserDTO userDTO = userService.loginUser (login);
		SessionDTO sessionDTO = new SessionDTO (userDTO.getId ());
		session.setAttribute ("user", sessionDTO);
		return "redirect:/home";
	}
	@GetMapping ("/home")
	public String home (HttpSession session) throws UserNoSession
	{
		sessionService.checkSession (session);
		return "home";
	}
	@GetMapping ("/settings")
	public String settings (HttpSession session) throws UserNoSession
	{
		sessionService.checkSession (session);
		return "settings";
	}
	@PostMapping ("/settings/updatePassword")
	public String updatePassword (HttpSession session, UserUpdatePasswordModel updatePasswordModel, RedirectAttributes redirectAttributes) throws UserNoSession, UpdatePassword
	{
		sessionService.checkSession (session);
		SessionDTO sessionDTO = (SessionDTO) session.getAttribute ("user");
		userService.updatePassword (sessionDTO.getId (), updatePasswordModel);
		session.invalidate ();
		redirectAttributes.addFlashAttribute ("message", "Password Updated!");
		return "redirect:/login";
	}
	@PostMapping ("/settings/updateUsername")
	public String updateUsername (HttpSession session, UserUpdateUsernameModel userUpdateUsernameModel, RedirectAttributes redirectAttributes) throws UserNoSession
	{
		sessionService.checkSession (session);
		SessionDTO sessionDTO = (SessionDTO) session.getAttribute ("user");
		userService.updateUsername (sessionDTO.getId (), userUpdateUsernameModel);
		redirectAttributes.addFlashAttribute ("message", "Username Changed Successfully!");
		return "redirect:/settings";
	}
	@PostMapping ("/settings/updateEmail")
	public String userEmail (HttpSession session, UserUpdateEmailModel userUpdateUsernameModel, RedirectAttributes redirectAttributes) throws UserNoSession
	{
		sessionService.checkSession (session);
		SessionDTO sessionDTO = (SessionDTO) session.getAttribute ("user");
		userService.updateEmail (sessionDTO.getId (), userUpdateUsernameModel);
		redirectAttributes.addFlashAttribute ("message", "Email Changed Successfully!");
		return "redirect:/settings";
	}
	@GetMapping ("/logout")
	public String logout (HttpSession session, RedirectAttributes redirectAttributes)
	{
		session.invalidate ();
		redirectAttributes.addFlashAttribute ("message", "Logout!");
		return "redirect:/login";
	}
}