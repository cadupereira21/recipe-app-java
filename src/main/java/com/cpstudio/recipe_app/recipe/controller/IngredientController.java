package com.cpstudio.recipe_app.recipe.controller;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.dto.ingredient.UpdateIngredientRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ingredient Resources", description = "Endpoints for managing ingredients in recipes")
@RequestMapping("/api/ingredient")
public interface IngredientController {

    @Operation(summary = "Retrieve all ingredients", description = "Fetches a list of all ingredients available in the system.")
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Ingredient>> getAllIngredients();

    @Operation(summary = "Update an ingredient", description = "Updates the details of an existing ingredient identified by its ID.")
    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Ingredient> updateIngredient(@RequestParam final String ingredientId, @RequestBody final UpdateIngredientRequest request);

}
