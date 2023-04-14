package com.example.todo.services;

import java.util.List;

import com.example.todo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.Task;
import com.example.todo.repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).get();
    }

    public void create(Task task){
        taskRepository.save(task);
    }

    public Task update(Task old_task, Task new_task){
        old_task.setName(new_task.getName());
        old_task.setDescription(new_task.getDescription());
        old_task.setCategories(new_task.getCategories());
        old_task.setDone(new_task.getDone());
        old_task.setUser(new_task.getUser());
        taskRepository.save(old_task);
        return old_task;
    }

    public void delete(Task task){
        taskRepository.delete(task);
    }
}
