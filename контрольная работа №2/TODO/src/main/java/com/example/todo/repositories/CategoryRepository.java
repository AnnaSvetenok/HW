package com.example.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
