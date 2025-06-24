package com.cpstudio.recipe_app.recipe.mapper;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.ingredient.UpdateIngredientRequest;

public class IngredientMapper {

    public static Ingredient toDomain(final CreateIngredientRequest request) {
        if (request == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setName(request.name());
        ingredient.setQuantity(request.quantity());
        ingredient.setQuantityType(request.quantityType());

        return ingredient;
    }

    public static Ingredient toDomain(final UpdateIngredientRequest request) {
        if (request == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setName(request.name());
        ingredient.setQuantity(request.quantity());
        ingredient.setQuantityType(request.quantityType());

        return ingredient;
    }
}
