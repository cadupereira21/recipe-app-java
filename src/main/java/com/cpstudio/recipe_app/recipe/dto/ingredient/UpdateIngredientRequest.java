package com.cpstudio.recipe_app.recipe.dto.ingredient;

import jakarta.validation.constraints.NotNull;

public record UpdateIngredientRequest(@NotNull String name, @NotNull int quantity) {
}
