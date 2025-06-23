package com.cpstudio.recipe_app.recipe.dto;

import jakarta.validation.constraints.NotNull;

public record CreateRecipeRequest(@NotNull String title, String description, @NotNull String ingredients, String instructions) {
}
