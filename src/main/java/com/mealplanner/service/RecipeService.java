package com.mealplanner.service;

import com.mealplanner.dto.RecipeCreateDTO;
import com.mealplanner.dto.RecipeDTO;
import com.mealplanner.dto.RecipeUpdateDTO;
import com.mealplanner.exception.ResourceNotFoundException;
import com.mealplanner.mapper.RecipeMapper;
import com.mealplanner.model.Recipe;
import com.mealplanner.repository.RecipeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {
    private final RecipeMapper mapper;
    private final RecipeRepository repository;
    
    @Transactional
    public RecipeDTO create(RecipeCreateDTO dto) {
        Recipe recipe = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(recipe));
    }
    
    @Transactional(readOnly = true)
    public RecipeDTO show(Long id) {
        return mapper.toDTO(
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Recipe " + id + " not found")));
    }
    
    @Transactional(readOnly = true)
    public List<RecipeDTO> getAll() {
        return repository.findAll()
                        .stream()
                        .map(mapper::toDTO)
                        .toList();
    }
    
    @Transactional
    public RecipeDTO update(Long id, RecipeUpdateDTO recipeUpdateDTO) {
        Recipe recipe = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe " + id + " not found"));
        
        mapper.update(recipe, recipeUpdateDTO);
        repository.save(recipe);
        return mapper.toDTO(recipe);
        
    }
    
    @Transactional
    public void delete(Long id) {
        var recipe = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe " + id + " not found"));
        repository.delete(recipe);
    }
}
