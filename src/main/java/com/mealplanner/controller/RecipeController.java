package com.mealplanner.controller;

import com.mealplanner.dto.RecipeCreateDTO;
import com.mealplanner.dto.RecipeDTO;
import com.mealplanner.dto.RecipeUpdateDTO;
import com.mealplanner.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService service;
    
    @PostMapping("")
    public ResponseEntity<RecipeDTO> create(@RequestBody @Valid RecipeCreateDTO dto) {
        RecipeDTO created = service.create(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK) ;
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<RecipeDTO> update(@PathVariable Long id, @RequestBody @Valid RecipeUpdateDTO recipeUpdateDTO) {
        return new ResponseEntity<>(service.update(id, recipeUpdateDTO), HttpStatus.OK);
    }
    
    @GetMapping("")
    public ResponseEntity<List<RecipeDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
