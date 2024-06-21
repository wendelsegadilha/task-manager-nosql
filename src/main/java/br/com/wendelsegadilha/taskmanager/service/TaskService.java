package br.com.wendelsegadilha.taskmanager.service;

import br.com.wendelsegadilha.taskmanager.model.Task;
import br.com.wendelsegadilha.taskmanager.model.User;
import br.com.wendelsegadilha.taskmanager.repository.TaskRepository;
import br.com.wendelsegadilha.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(String id) {
        return this.taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task save(Task task) {
        var user = this.userService.findById(task.getUser().getId());
        task.setUser(user);
        return taskRepository.save(task);
    }

    public void delete(String id) {
        taskRepository.deleteById(id);
    }

    public void completed(String id) {
        Task task = this.findById(id);
        task.setCompleted(true);
        this.save(task);
    }
}
