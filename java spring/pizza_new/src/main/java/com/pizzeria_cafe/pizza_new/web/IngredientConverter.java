package com.pizzeria_cafe.pizza_new.web;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.HashMap;
import com.pizzeria_cafe.pizza_new.Ingredients;
import com.pizzeria_cafe.pizza_new.Ingredients.Type;;


@Component
public class IngredientConverter implements Converter<String, Ingredients> {
    private Map<String, Ingredients> ingredientMap = new HashMap<>();

    public IngredientConverter() {
        ingredientMap.put("TNBS", new Ingredients("TNBS", "Thin Dough Base", Type.DOUGH));
        ingredientMap.put("TKBS", new Ingredients("TKBS", "Thick Dough Base", Type.DOUGH));
        ingredientMap.put("HM", new Ingredients("HM", "Ham", Type.MEAT));
        ingredientMap.put("PRN", new Ingredients("PRN", "Pepperoni", Type.MEAT));
        ingredientMap.put("CHK", new Ingredients("CHK", "Chicken", Type.MEAT));
        ingredientMap.put("BCN", new Ingredients("BCN", "Bacon", Type.MEAT));
        ingredientMap.put("TMT", new Ingredients("TMT", "Tomatoes", Type.VEGGETABLES));
        ingredientMap.put("PCL", new Ingredients("PCL", "Pickles", Type.VEGGETABLES));
        ingredientMap.put("MSHR", new Ingredients("MSHR", "Mushrooms", Type.VEGGETABLES));
        ingredientMap.put("TMS", new Ingredients("TMS", "Tomato Sauce", Type.SAUCE));
        ingredientMap.put("CRS", new Ingredients("CRS", "Cream Sauce", Type.SAUCE));
    }

    @Override
    public Ingredients convert(String id) {
        return ingredientMap.get(id);
    }
}
