package com.cpstudio.recipe_app.recipe.controller;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.ingredient.UpdateIngredientRequest;
import com.cpstudio.recipe_app.recipe.service.IngredientService;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientControllerImpl implements IngredientController {

    final IngredientService ingredientService;

    public IngredientControllerImpl(final IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        final List<Ingredient> ingredients = ingredientService.retrieveAll();

        return CollectionUtils.isEmpty(ingredients) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(ingredients);
    }

    @Override
    public ResponseEntity<Ingredient> createIngredient(final String recipeId, final CreateIngredientRequest request) {
        final Ingredient ingredient = ingredientService.create(recipeId, request);
        return ResponseEntity.ok(ingredient);
    }

    @Override
    public ResponseEntity<Ingredient> updateIngredient(final String ingredientId, final UpdateIngredientRequest request) {
        final Ingredient updatedIngredient = ingredientService.update(ingredientId, request);
        return ResponseEntity.ofNullable(updatedIngredient);
    }

    @Override
    public ResponseEntity<Void> deleteIngredient(String ingredientId) {
        final String deletedIngredientId = ingredientService.delete(ingredientId);
        return StringUtils.isBlank(deletedIngredientId) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok().build();
    }
}
