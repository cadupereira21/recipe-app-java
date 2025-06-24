package com.cpstudio.recipe_app.recipe.mapper;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.ingredient.IngredientRecipeResponse;
import com.cpstudio.recipe_app.recipe.dto.ingredient.IngredientResponse;
import com.cpstudio.recipe_app.recipe.dto.recipe.RecipeIngredientResponse;
import com.cpstudio.recipe_app.recipe.dto.ingredient.UpdateIngredientRequest;

public class IngredientMapper {

    public static Ingredient toDomain(final CreateIngredientRequest request) {
        if (request == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setName(request.name());
        ingredient.setQuantity(request.quantity());

        return ingredient;
    }

    public static Ingredient toDomain(final UpdateIngredientRequest request) {
        if (request == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setName(request.name());
        ingredient.setQuantity(request.quantity());

        return ingredient;
    }

    public static IngredientResponse toResponse(final Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }

        return new IngredientResponse(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getQuantity(),
                ingredient.getRecipes().stream().map(IngredientMapper::toRecipeResponse).toList()
        );
    }

    public static IngredientRecipeResponse toRecipeResponse(final Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        return new IngredientRecipeResponse(
                recipe.getId(),
                recipe.getTitle()
        );
    }
}
