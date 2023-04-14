package com.example.todo.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Common_attr {
    LocalDateTime creationDate = LocalDateTime.now();
    LocalDateTime updateDate = LocalDateTime.now();
}
