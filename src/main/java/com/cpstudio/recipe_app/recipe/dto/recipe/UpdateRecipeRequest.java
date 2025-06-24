package com.cpstudio.recipe_app.recipe.dto.recipe;

import jakarta.validation.constraints.NotNull;

public record UpdateRecipeRequest(@NotNull String title, @NotNull String description, @NotNull String instructions, @NotNull boolean isVegetarian, @NotNull int servings) {

}
