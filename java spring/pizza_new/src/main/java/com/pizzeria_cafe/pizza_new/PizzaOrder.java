package com.pizzeria_cafe.pizza_new;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PizzaOrder {

    @NotBlank(message = "Наименование доставки обязательно для заполнения")
    private String deliveryName;

    @NotBlank(message = "Улица доставки обязательно для заполнения")
    private String deliveryStreet;

    @NotBlank(message = "Город доставки обязательно для заполнения")
    private String deliveryCity;

    @CreditCardNumber
    private String ccNumber;

    @Digits(integer=3, fraction=0, message="Неправильный CVV")
    private String ccCVV;

    @Digits(integer=11, fraction=0, message="Неправильный номер")
    private String ccPhoneNumber;

    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }
}
