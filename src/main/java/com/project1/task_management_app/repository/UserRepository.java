package com.project1.task_management_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project1.task_management_app.entity.TaskUser;
import jakarta.transaction.Transactional;
@Repository
public interface UserRepository extends JpaRepository <TaskUser, Integer>
{
	TaskUser findByUsernameAndPassword (String username, String password);
	@Modifying
	@Transactional
	@Query ("UPDATE TaskUser u SET u.password = :newPassword WHERE u.password = :oldPassword AND u.id = :userId")
	Integer updatePassword (Integer userId, String oldPassword, String newPassword);
	@Modifying
	@Transactional
	@Query ("UPDATE TaskUser u SET u.username = :newUsername WHERE u.id = :userId")
	Integer updateUsername (Integer userId, String newUsername);
	@Modifying
	@Transactional
	@Query ("UPDATE TaskUser u SET u.email = :newEmail WHERE u.id = :userId")
	Integer updateEmail (Integer userId, String newEmail);
}