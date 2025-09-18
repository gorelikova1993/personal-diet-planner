package com.mealplanner.repository;

import com.mealplanner.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
