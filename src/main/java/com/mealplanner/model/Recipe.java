package com.mealplanner.model;


import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity //указывает что класс является сущностью JPA для маппинга в БД
@Table(name = "recipes") //задает имя таблицы в базе данных
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String description;
    
    private int servings;
    private double calories;
    private double fats;
    private double carbs;
    @ElementCollection
    private List<String> tags;
    @ElementCollection
    private List<String> ingredients;
}
