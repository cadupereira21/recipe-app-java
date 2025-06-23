package com.cpstudio.recipe_app.recipe.dto;

public record PartialUpdateRecipeRequest(String title, String description, String ingredients, String instructions) {
}
