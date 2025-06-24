package com.cpstudio.recipe_app.recipe.dto.ingredient;

import com.cpstudio.recipe_app.recipe.domain.Recipe;

import java.util.List;

public record IngredientResponse(String id, String name, int quantity, List<IngredientRecipeResponse> recipes) {

}
