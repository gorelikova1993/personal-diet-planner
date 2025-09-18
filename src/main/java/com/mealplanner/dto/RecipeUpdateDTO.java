package com.mealplanner.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class RecipeUpdateDTO {
    private String name;
    private String description;
    @Positive
    private Integer servings;
    @PositiveOrZero
    private Double calories;
    @PositiveOrZero
    private Double fats;
    @PositiveOrZero
    private Double carbs;
    @Size(min = 0)
    private List<String> tags;
    @Size(min = 0)
    private List<String> ingredients;
}
