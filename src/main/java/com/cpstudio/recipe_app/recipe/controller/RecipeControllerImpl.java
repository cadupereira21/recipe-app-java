package com.cpstudio.recipe_app.recipe.controller;

import com.cpstudio.recipe_app.recipe.dto.recipe.RecipeResponse;
import com.cpstudio.recipe_app.recipe.mapper.RecipeMapper;
import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.PartialUpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.UpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.repository.RecipeRepository;
import com.cpstudio.recipe_app.recipe.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RecipeControllerImpl implements RecipeController {

    private final RecipeRepository recipeRepository;

    private final RecipeService recipeService;

    @Override
    public ResponseEntity<RecipeResponse> create(final CreateRecipeRequest recipe) {
        final RecipeResponse createdRecipe = recipeService.create(recipe);
        return ResponseEntity.ok(createdRecipe);
    }

    @Override
    public ResponseEntity<List<RecipeResponse>> getAllRecipes() {
        final List<RecipeResponse> recipes = recipeService.retrieveAll();
        return ResponseEntity.ok(recipes);
    }

    @Override
    public ResponseEntity<Recipe> getRecipeById(final String id) {
        final Recipe recipe = recipeRepository.findById(id).orElse(null);
        return ResponseEntity.ofNullable(recipe);
    }

    @Override
    public ResponseEntity<List<Recipe>> getRecipesWithFilters(final boolean isVegetarian, final int servings) {
        final List<Recipe> recipes = recipeRepository.findByIsVegetarianAndServings(isVegetarian, servings);
        return CollectionUtils.isEmpty(recipes) ? ResponseEntity.notFound().build() : ResponseEntity.ok(recipes);
    }

    @Override
    public ResponseEntity<Void> delete(final String id) {
        recipeRepository.deleteById(id);
        return null;
    }

    @Override
    public ResponseEntity<Recipe> update(final String id, final UpdateRecipeRequest recipe) {
        final Recipe updatedRecipe = recipeRepository.updateIfExists(RecipeMapper.toDomain(id, recipe));
        return ResponseEntity.ofNullable(updatedRecipe);
    }

    @Override
    public ResponseEntity<Recipe> partialUpdate(final String id, final PartialUpdateRecipeRequest recipe) {
        final Recipe updatedRecipe = recipeRepository.partialUpdateIfExists(RecipeMapper.partialUpdateRequestToDomain(id, recipe));
        return ResponseEntity.ofNullable(updatedRecipe);
    }
}
