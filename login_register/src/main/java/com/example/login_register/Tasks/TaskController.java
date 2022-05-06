package com.example.login_register.Tasks;

import com.example.login_register.User.User;
import com.example.login_register.User.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private Logger logger =
            LoggerFactory.getLogger(TaskController.class);
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping(value = "/tasks")
    public List<Task> getAllTasks() {
        logger.info("Getting all tasks.");
        return taskRepository.findAll();
    }
    @GetMapping(value = "task/{_id}")
    public Task getTaskById(@PathVariable String _id) {
        logger.info("Getting Task with ID: {}", _id);
        return taskRepository.findTaskById(_id);
    }
    @GetMapping(value = "task/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee) {
        logger.info("Getting Task by Assignee: {}", assignee);
        return taskRepository.findTaskByAssignee(assignee);
    }
    @PostMapping(value = "task/create")
    public Task addTask(@RequestBody Task task) {
        logger.info("Saving task.");
        return taskRepository.save(task);
    }
    @PutMapping(value = "task/update/{taskId}")
    public Task updateTask(@PathVariable String taskId, @RequestBody Task task) {
        logger.info("Updating task with ID: {}", taskId);
        return taskRepository.save(task);
    }
    @DeleteMapping(value = "task/delete/{taskId}")
    public void deleteTask(@PathVariable String taskId) {
        logger.info("Deleting task with ID: {}", taskId);
        taskRepository.deleteById(taskId);
    }
}

