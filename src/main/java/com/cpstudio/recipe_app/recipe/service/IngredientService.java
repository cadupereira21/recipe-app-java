package com.cpstudio.recipe_app.recipe.service;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.ingredient.UpdateIngredientRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IngredientService {

    public List<Ingredient> retrieveAll();

    public List<Ingredient> retrieveByRecipeId(final String recipeId);

    public Ingredient update(final String ingredientId, final UpdateIngredientRequest request);

}
