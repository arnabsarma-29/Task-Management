package com.project1.task_management_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project1.task_management_app.entity.Task;
import jakarta.transaction.Transactional;
@Repository
public interface TaskRepository extends JpaRepository <Task, Integer>
{
	@Modifying
	@Transactional
	@Query ("UPDATE Task t SET t.data = :newData WHERE t.id = :taskId")
	Integer updateData (@Param ("taskId") Integer taskId, @Param ("newData") String newData);
	@Modifying
	@Transactional
	@Query ("UPDATE Task t SET t.duration = :newDuration WHERE t.id = :taskId")
	Integer updateDuration (@Param ("taskId") Integer taskId, @Param ("newDuration") String newDuration);
}