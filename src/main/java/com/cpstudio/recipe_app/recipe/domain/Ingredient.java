package com.cpstudio.recipe_app.recipe.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Ingredients")
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float quantity;

    @Column(name = "quantity_type", nullable = false)
    private QuantityType quantityType;
}
