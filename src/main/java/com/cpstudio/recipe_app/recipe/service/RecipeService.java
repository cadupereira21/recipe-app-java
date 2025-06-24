package com.cpstudio.recipe_app.recipe.service;

import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.RecipeResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecipeService {

    @Transactional
    public List<RecipeResponse> retrieveAll();

    @Transactional
    public RecipeResponse create(final CreateRecipeRequest request);

}
