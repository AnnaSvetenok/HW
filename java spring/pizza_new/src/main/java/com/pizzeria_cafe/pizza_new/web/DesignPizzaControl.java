package com.pizzeria_cafe.pizza_new.web;

import com.pizzeria_cafe.pizza_new.Pizza;
import com.pizzeria_cafe.pizza_new.PizzaOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

import com.pizzeria_cafe.pizza_new.Ingredients;
import com.pizzeria_cafe.pizza_new.Ingredients.Type;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.Errors;

@Slf4j
@Controller
@SessionAttributes("PizzaOrder")
@RequestMapping("/design")
public class DesignPizzaControl {

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredients> ingredients = Arrays.asList(
                new Ingredients("TNBS", "Thin Dough Base", Type.DOUGH),
                new Ingredients("TKBS", "Thick Dough Base", Type.DOUGH),
                new Ingredients("HM", "Ham", Type.MEAT),
                new Ingredients("PRN", "Pepperoni", Type.MEAT),
                new Ingredients("CHK", "Chicken", Type.MEAT),
                new Ingredients("BCN", "Bacon", Type.MEAT),
                new Ingredients("TMT", "Tomatoes", Type.VEGGETABLES),
                new Ingredients("PCL", "Pickles", Type.VEGGETABLES),
                new Ingredients("MSHR", "Mushrooms", Type.VEGGETABLES),
                new Ingredients("TMS", "Tomato Sauce", Type.SAUCE),
                new Ingredients("CRS", "Cream Sauce", Type.SAUCE)

        );
        Type[] types = Ingredients.Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name="PizzaOrder")
    public PizzaOrder order(){
        return new PizzaOrder();
    }

    @ModelAttribute(name="Pizza")
    public Pizza pizza(){
        return new Pizza();
    }

    private Iterable<Ingredients> filterByType(
            List<Ingredients> ingredients, Type type
    ){
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processPizza(
            @Valid Pizza pizza, Errors errors, @ModelAttribute PizzaOrder pizzaOrder
    ){
        if (errors.hasErrors()){
            return "design";
        }
        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza: {}", pizza);
        return "redirect:/orders/current";
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }
}
