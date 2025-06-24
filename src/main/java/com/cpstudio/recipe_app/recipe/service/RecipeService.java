package com.cpstudio.recipe_app.recipe.service;

import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.UpdateRecipeRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface RecipeService {

    @Transactional
    public List<Recipe> retrieveAll();

    @Transactional
    public Recipe create(final CreateRecipeRequest request);

    @Transactional
    public Recipe update(final String id, final UpdateRecipeRequest request);

    @Transactional
    public void addIngredients(final String recipeId, final Set<CreateIngredientRequest> ingredients);

    @Transactional
    public void deleteIngredients(final String recipeId, final Set<String> ingredientIds);

}
