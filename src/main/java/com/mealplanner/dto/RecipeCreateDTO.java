package com.mealplanner.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class RecipeCreateDTO {
    @NotBlank
    private String name;
    private String description;
    @Positive
    private int servings;
    @PositiveOrZero
    private double calories;
    @PositiveOrZero
    private double fats;
    @PositiveOrZero
    private double carbs;
    @NotNull
    @NotEmpty
    private List<String> tags;
    @NotNull
    @NotEmpty
    private List<String> ingredients;
}
