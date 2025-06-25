package com.cpstudio.recipe_app.recipe.controller;

import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.mapper.RecipeMapper;
import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.PartialUpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.UpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.repository.RecipeRepository;
import com.cpstudio.recipe_app.recipe.service.RecipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
public class RecipeControllerImpl implements RecipeController {

    private final RecipeRepository recipeRepository;

    private final RecipeService recipeService;

    @Override
    public ResponseEntity<Recipe> create(final CreateRecipeRequest recipe) {
        final Recipe createdRecipe = recipeService.create(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe);
    }

    @Override
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        final List<Recipe> recipes = recipeService.retrieveAll();
        return ResponseEntity.ok(recipes);
    }

    @Override
    public ResponseEntity<Recipe> getRecipeById(final String id) {
        final Recipe recipe = recipeRepository.findById(id).orElse(null);
        return ResponseEntity.ofNullable(recipe);
    }

    @Override
    public ResponseEntity<List<Recipe>> getRecipesWithFilters(final Optional<Boolean> isVegetarian,
                                                              final Optional<Integer> servings,
                                                              final Optional<Set<String>> includeIngredients,
                                                              final Optional<Set<String>> excludeIngredients,
                                                              final Optional<String> instruction) {
        final List<Recipe> recipes = recipeService.search(isVegetarian, servings, includeIngredients, excludeIngredients, instruction);
        return CollectionUtils.isEmpty(recipes) ? ResponseEntity.notFound().build() : ResponseEntity.ok(recipes);
    }

    @Override
    public ResponseEntity<Void> delete(final String id) {
        recipeRepository.deleteById(id);
        return null;
    }

    @Override
    public ResponseEntity<Recipe> update(final String id, final UpdateRecipeRequest recipe) {
        final Recipe updatedRecipe = recipeService.update(id, recipe);
        return ResponseEntity.ofNullable(updatedRecipe);
    }

    @Override
    public ResponseEntity<Recipe> partialUpdate(final String id, final PartialUpdateRecipeRequest recipe) {
        final Recipe updatedRecipe = recipeRepository.partialUpdateIfExists(RecipeMapper.partialUpdateRequestToDomain(id, recipe));
        return ResponseEntity.ofNullable(updatedRecipe);
    }

    @Override
    public ResponseEntity<Void> addIngredientToRecipe(final String id, final Set<CreateIngredientRequest> ingredientRequest) {
        recipeService.addIngredients(id, ingredientRequest);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteIngredientFromRecipe(final String id, final Set<String> ingredientIds) {
        recipeService.deleteIngredients(id, ingredientIds);
        return ResponseEntity.ok(null);
    }
}
