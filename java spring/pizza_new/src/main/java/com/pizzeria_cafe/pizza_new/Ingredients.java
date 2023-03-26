package com.pizzeria_cafe.pizza_new;

import lombok.Data;

@Data
public class Ingredients {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        DOUGH,
        MEAT,
        VEGGETABLES,
        SAUCE
    }
}

