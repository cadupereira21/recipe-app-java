package com.cpstudio.recipe_app.recipe.dto;

public record PartialUpdateRecipeRequest(String title, String description, String ingredients, String instructions, boolean isVegetarian, int servings) {
    // This record can be used to partially update a recipe.
    // Fields that are null will not be updated.) {
}
