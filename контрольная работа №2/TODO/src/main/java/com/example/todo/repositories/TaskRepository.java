package com.example.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
}
