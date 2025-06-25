package com.cpstudio.recipe_app.recipe.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Recipes")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "${resources.generic.id}")
    private String id;

    @Column(nullable = false, unique = true)
    @Schema(description = "${resources.recipe.title}")
    private String title;

    @Schema(description = "${resources.recipe.description}")
    private String description;

    @Schema(description = "${resources.recipe.instructions}")
    private String instructions;

    @Column(name = "is_vegetarian")
    @Schema(description = "${resources.recipe.isVegetarian}")
    private boolean isVegetarian;

    @Schema(description = "${resources.recipe.servings}")
    private int servings;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
        name = "recipe_ingredients",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    @Schema(description = "${resources.recipe.ingredients}")
    private List<Ingredient> ingredients;

}
