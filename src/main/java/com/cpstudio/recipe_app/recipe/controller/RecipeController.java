package com.cpstudio.recipe_app.recipe.controller;

import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.PartialUpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.UpdateRecipeRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestMapping("/api/recipe")
@Tag(name = "Recipe Resources", description = "Endpoints for managing recipes and their ingredients")
public interface RecipeController {


    @Operation(summary = "Create a new recipe", description = "Creates a new recipe and new ingredients with the provided details.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Recipe> create(@Valid @RequestBody final CreateRecipeRequest recipe);

    @Operation(summary = "Get all recipes", description = "Retrieves a list of all recipes created.")
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Recipe>> getAllRecipes();

    @Operation(summary = "Get a recipe by ID", description = "Retrieves a specific recipe by its unique identifier.")
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Recipe> getRecipeById(@PathVariable final String id);

    @Operation(summary = "Search recipes with filters",
            description = """
                    Searches for recipes based on various filters such as:
                    
                    - Vegetarian status
                    - Amout of servings
                    - Included/excluded ingredients
                    - Instructions
                    
                    You must provide at least one filter to perform a search!
                    If more than one is provided, the results will match all specified criteria.""")
    @PostMapping(path = "/search/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Recipe>> getRecipesWithFilters(
            @RequestParam(required = false) final Optional<Boolean> isVegetarian,
            @RequestParam(required = false) final Optional<Integer> servings,
            @RequestParam(required = false) final Optional<Set<String>> includeIngredients,
            @RequestParam(required = false) final Optional<Set<String>> excludeIngredients,
            @RequestParam(required = false) final Optional<String> instruction);

    @Operation(summary = "Delete a recipe by ID", description = "Deletes a specific recipe by its unique identifier. All it's ingredients will also be deleted.")
    @DeleteMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> delete(@RequestParam final String id);

    @Operation(summary = "Update a recipe by ID", description = "Substitutes a given recipe entity with the provided details. Cannot update ingredients with this endpoint, use the ingredient endpoints instead.")
    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Recipe> update(@RequestParam final String id, @Valid @RequestBody final UpdateRecipeRequest recipe);

    @Operation(summary = "Partially update a recipe by ID", description = "Partially updates an existing recipe with the provided details. Cannot update ingredients with this endpoint, use the ingredient endpoints instead.")
    @PatchMapping(path = "/", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Recipe> partialUpdate(@RequestParam final String id, @RequestBody final PartialUpdateRecipeRequest recipe);

    @Operation(summary = "Add ingredients to a recipe", description = "Adds new ingredients to an existing recipe. If the ingredient already exists, it will be added again.")
    @PostMapping(path = "/{id}/ingredient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> addIngredientToRecipe(@PathVariable final String id, @Valid @RequestBody final Set<CreateIngredientRequest> ingredientRequest);

    @Operation(summary = "Deletes ingredients in a recipe", description = "Deletes existing ingredients in a recipe.")
    @DeleteMapping(path = "/{id}/ingredient/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteIngredientFromRecipe(@PathVariable final String id, @RequestParam final Set<String> ingredientIds);

}
