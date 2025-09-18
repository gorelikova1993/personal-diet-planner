package com.mealplanner.mapper;

import com.mealplanner.dto.RecipeCreateDTO;
import com.mealplanner.dto.RecipeDTO;
import com.mealplanner.dto.RecipeUpdateDTO;
import com.mealplanner.model.Recipe;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    
    Recipe toEntity(RecipeCreateDTO dto);
    
    RecipeDTO toDTO(Recipe entity);
    
    List<RecipeDTO> toDTO(List<Recipe> recipes);
    
    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void update(@MappingTarget Recipe recipe,
                            RecipeUpdateDTO recipeUpdateDTO);
}
