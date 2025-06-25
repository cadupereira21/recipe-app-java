package com.cpstudio.recipe_app.recipe.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Ingredients")
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "${resources.generic.id}")
    private String id;

    @Column(nullable = false)
    @Schema(description = "${resources.ingredient.name}")
    private String name;

    @Column(nullable = false)
    @Schema(description = "${resources.ingredient.quantity}")
    private float quantity;

    @Column(name = "quantity_type", nullable = false)
    @Schema(description = "${resources.ingredient.quantityType}")
    private QuantityType quantityType;
}
