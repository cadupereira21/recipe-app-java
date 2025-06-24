package com.cpstudio.recipe_app.recipe.controller;

import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.PartialUpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.UpdateRecipeRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/api/recipe")
public interface RecipeController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipe> create(@Valid @RequestBody final CreateRecipeRequest recipe);

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Recipe>> getAllRecipes();

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable final String id);

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<List<Recipe>> getRecipesWithFilters(@RequestParam(required = false) final boolean isVegetarian, @RequestParam(required = false) final int servings);

    @DeleteMapping(path = "/")
    public ResponseEntity<Void> delete(@RequestParam final String id);

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Recipe> update(@RequestParam final String id, @Valid @RequestBody final UpdateRecipeRequest recipe);

    @PatchMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Recipe> partialUpdate(@RequestParam final String id, @RequestBody final PartialUpdateRecipeRequest recipe);

    @PostMapping(path = "/{id}/ingredient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addIngredientToRecipe(@PathVariable final String id, @Valid @RequestBody final Set<CreateIngredientRequest> ingredientRequest);

    @DeleteMapping(path = "/{id}/ingredient/")
    public ResponseEntity<Void> deleteIngredientFromRecipe(@PathVariable final String id, @RequestParam final Set<String> ingredientIds);

}
