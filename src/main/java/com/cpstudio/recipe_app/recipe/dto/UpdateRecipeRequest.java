package com.cpstudio.recipe_app.recipe.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateRecipeRequest(@NotNull String title, @NotNull String description, @NotNull String ingredients, @NotNull String instructions) {
}
