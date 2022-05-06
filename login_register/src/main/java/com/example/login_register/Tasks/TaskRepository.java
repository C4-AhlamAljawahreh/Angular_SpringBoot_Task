package com.example.login_register.Tasks;

import com.example.login_register.Tasks.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {


    Task findTaskById(String _id);

    List<Task> findTaskByAssignee(String assignee);
}