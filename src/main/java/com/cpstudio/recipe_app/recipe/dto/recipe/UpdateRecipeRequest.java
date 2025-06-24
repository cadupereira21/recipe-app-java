package com.cpstudio.recipe_app.recipe.dto.recipe;

import jakarta.validation.constraints.NotNull;

public record UpdateRecipeRequest(@NotNull String title, @NotNull String description, @NotNull String ingredients, @NotNull String instructions,
                                  @NotNull boolean isVegetarian, @NotNull int servings) {
    // This record is used to update a recipe.
    // All fields are required and cannot be null.
    // The title, description, ingredients, and instructions must not be null.
    // The isVegetarian and servings fields can be set to their default values if not provided.) {
}
