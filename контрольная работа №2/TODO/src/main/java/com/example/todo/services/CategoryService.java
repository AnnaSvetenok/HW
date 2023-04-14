package com.example.todo.services;

import java.util.List;

import com.example.todo.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.Category;
import com.example.todo.repositories.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).get();
    }

    public void create(Category category){
        categoryRepository.save(category);
    }

    public Category update(Category old_category, Category new_category){
        old_category.setName(new_category.getName());
        old_category.setTasks(new_category.getTasks());
        categoryRepository.save(old_category);
        return old_category;
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }
}
