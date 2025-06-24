package com.cpstudio.recipe_app.recipe.dto.ingredient;

import com.cpstudio.recipe_app.recipe.domain.QuantityType;
import jakarta.validation.constraints.NotNull;

public record UpdateIngredientRequest(@NotNull String name, @NotNull int quantity, @NotNull QuantityType quantityType) {
}
