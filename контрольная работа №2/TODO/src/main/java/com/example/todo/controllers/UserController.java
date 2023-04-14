package com.example.todo.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.todo.models.User;
import com.example.todo.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.todo.services.UserService;
import com.example.todo.services.TaskService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;


    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/{id}/tasks")
    public void addTask(@PathVariable Long id, @RequestBody Task task) {
        User user = userService.getUserById(id);
        task.setUser(user);
        taskService.create(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void addUser(@RequestBody User user) {
        userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        userService.delete(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User new_user, @PathVariable Long id) {
        try {
            User old_user = userService.getUserById(id);
            User changedUser = userService.update(old_user, new_user);
            userService.update(old_user, new_user);
            return new ResponseEntity<>(changedUser, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

