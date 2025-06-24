package com.cpstudio.recipe_app.recipe.dto.recipe;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateRecipeRequest(@NotNull String title, String description, String instructions, boolean isVegetarian, int servings, @Valid @NotEmpty List<CreateIngredientRequest> ingredients) {
}
