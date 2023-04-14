package com.example.todo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private Boolean done;

    @ManyToMany(mappedBy = "task")
    private Set<Category> categories;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
}
