package com.cpstudio.recipe_app.recipe.dto.recipe;

import java.util.List;

public record RecipeResponse(String id, String name, String description, String instructions, boolean isVegetarian, int servings, List<RecipeIngredientResponse> ingredients) {
}
