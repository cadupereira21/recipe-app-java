package com.cpstudio.recipe_app.recipe.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Recipes")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String title;

    private String description;

    @Column(nullable = false)
    private String ingredients;

    private String instructions;

    @Column(name = "is_vegetarian")
    private boolean isVegetarian;

    private int servings;

}
