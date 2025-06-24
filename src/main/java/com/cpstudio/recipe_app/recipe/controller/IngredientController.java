package com.cpstudio.recipe_app.recipe.controller;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.ingredient.UpdateIngredientRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/ingredient")
public interface IngredientController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Ingredient>> getAllIngredients();

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ingredient> createIngredient(@RequestParam final String recipeId, @RequestBody final CreateIngredientRequest request);

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ingredient> updateIngredient(@RequestParam final String ingredientId, @RequestBody final UpdateIngredientRequest request);

    @DeleteMapping(path = "/")
    public ResponseEntity<Void> deleteIngredient(@RequestParam final String ingredientId);

}
