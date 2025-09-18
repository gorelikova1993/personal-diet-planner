package com.mealplanner.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;

@Data
public class RecipeDTO {
    private Long id;
    private String name;
    private String description;
    private int servings;
    private double calories;
    private double fats;
    private double carbs;
    private List<String> tags;
    private List<String> ingredients;
}
