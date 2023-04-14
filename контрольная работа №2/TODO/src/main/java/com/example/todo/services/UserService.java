package com.example.todo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.User;
import com.example.todo.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public void create(User user){
        userRepository.save(user);
    }

    public User update(User old_user, User new_user){
        old_user.setFirstName(new_user.getFirstName());
        old_user.setLastName(new_user.getLastName());
        old_user.setMiddleName(new_user.getMiddleName());
        old_user.setLogin(new_user.getLogin());
        old_user.setBirthDate(new_user.getBirthDate());
        old_user.setTasks(new_user.getTasks());
        userRepository.save(old_user);
        return old_user;
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
