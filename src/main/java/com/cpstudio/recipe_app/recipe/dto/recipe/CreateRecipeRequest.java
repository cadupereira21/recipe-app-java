package com.cpstudio.recipe_app.recipe.dto.recipe;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateRecipeRequest(
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED) @NotNull String title,
        String description,
        String instructions,
        boolean isVegetarian,
        int servings,
        @Valid @NotEmpty @Schema(requiredMode = Schema.RequiredMode.REQUIRED) List<CreateIngredientRequest> ingredients) {
}
