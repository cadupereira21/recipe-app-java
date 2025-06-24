package com.cpstudio.recipe_app.recipe.service;

import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.UpdateRecipeRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecipeService {

    @Transactional
    public List<Recipe> retrieveAll();

    @Transactional
    public Recipe create(final CreateRecipeRequest request);

    @Transactional
    public Recipe update(final String id, final UpdateRecipeRequest request);

}
