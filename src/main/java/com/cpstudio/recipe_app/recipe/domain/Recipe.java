package com.cpstudio.recipe_app.recipe.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "recipes")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    private String description;

    private String ingredients;

    private String instructions;

}
