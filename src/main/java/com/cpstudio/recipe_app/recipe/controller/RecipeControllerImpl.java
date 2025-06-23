package com.cpstudio.recipe_app.recipe.controller;

import com.cpstudio.recipe_app.recipe.converter.RecipeConverter;
import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.PartialUpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.UpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.repository.RecipeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeControllerImpl implements RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeControllerImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public ResponseEntity<Recipe> create(final CreateRecipeRequest recipe) {
        final Recipe createdRecipe = recipeRepository.save(RecipeConverter.createRequestToDomain(recipe));
        return ResponseEntity.ok(createdRecipe);
    }

    @Override
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeRepository.findAll());
    }

    @Override
    public ResponseEntity<Recipe> getRecipeById(final String id) {
        final Recipe recipe = recipeRepository.findById(id).orElse(null);
        return ResponseEntity.ofNullable(recipe);
    }

    @Override
    public ResponseEntity<Void> delete(final String id) {
        recipeRepository.deleteById(id);
        return null;
    }

    @Override
    public ResponseEntity<Recipe> update(final String id, final UpdateRecipeRequest recipe) {
        final Recipe updatedRecipe = recipeRepository.updateIfExists(RecipeConverter.updateRequestToDomain(id, recipe));
        return ResponseEntity.ofNullable(updatedRecipe);
    }

    @Override
    public ResponseEntity<Recipe> partialUpdate(final String id, final PartialUpdateRecipeRequest recipe) {
        final Recipe updatedRecipe = recipeRepository.partialUpdateIfExists(RecipeConverter.partialUpdateRequestToDomain(id, recipe));
        return ResponseEntity.ofNullable(updatedRecipe);
    }
}
