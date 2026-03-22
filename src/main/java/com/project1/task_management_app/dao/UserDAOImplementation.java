package com.project1.task_management_app.dao;
import org.springframework.stereotype.Repository;
import com.project1.task_management_app.entity.TaskUser;
import com.project1.task_management_app.exception.UpdatePassword;
import com.project1.task_management_app.exception.UserWrongDetails;
import com.project1.task_management_app.repository.UserRepository;
@Repository
public class UserDAOImplementation implements UserDAO
{
	private final UserRepository repository;
	public UserDAOImplementation (UserRepository repository)
	{
		this.repository = repository;
	}
	@Override
	public TaskUser saveUser (TaskUser user)
	{
		return repository.save (user);
	}
	@Override
	public TaskUser loginUser (String username, String password) throws UserWrongDetails
	{
		TaskUser userLogin = repository.findByUsernameAndPassword (username, password);
		if (userLogin == null)
		{
			throw new UserWrongDetails ();
		}
		return userLogin;
	}
	@Override
	public void updatePassword (Integer userId, String oldPassword, String newPassword) throws UpdatePassword
	{
		Integer check = repository.updatePassword (userId, oldPassword, newPassword);
		if (check == 0)
		{
			throw new UpdatePassword ();
		}
	}
	@Override
	public void updateUsername (Integer userId, String username)
	{
		repository.updateUsername (userId, username);
	}
	@Override
	public void updateEmail (Integer userId, String email)
	{
		repository.updateEmail (userId, email);
	}
	@Override
	public TaskUser getUserById (Integer id) throws UserWrongDetails
	{
		return repository.findById (id).orElseThrow (() -> new UserWrongDetails ());
	}
}