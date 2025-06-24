package com.cpstudio.recipe_app.recipe.service;

import com.cpstudio.recipe_app.core.exception.NotFoundException;
import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.UpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.mapper.IngredientMapper;
import com.cpstudio.recipe_app.recipe.mapper.RecipeMapper;
import com.cpstudio.recipe_app.recipe.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    final RecipeRepository recipeRepository;

    final IngredientService ingredientService;

    @Override
    public List<Recipe> retrieveAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe create(final CreateRecipeRequest request) {
        return recipeRepository.save(RecipeMapper.toDomain(request));
    }

    @Override
    public Recipe update(final String id, final UpdateRecipeRequest request) {
        final List<Ingredient> ingredients = ingredientService.retrieveByRecipeId(id);

        return recipeRepository.updateIfExists(id, RecipeMapper.toDomain(id, request, ingredients));
    }

    @Override
    public void addIngredients(final String recipeId, final Set<CreateIngredientRequest> ingredients) {
        final Recipe recipe = retrieveById(recipeId);

        recipe.getIngredients().addAll(
                ingredients.stream()
                        .map(IngredientMapper::toDomain)
                        .toList()
        );

        recipeRepository.save(recipe);
    }

    @Override
    public void deleteIngredients(final String recipeId, final Set<String> ingredientIds) {
        final Recipe recipe = retrieveById(recipeId);

        recipe.getIngredients().removeIf(ingredient -> ingredientIds.contains(ingredient.getId()));

        recipeRepository.save(recipe);
    }

    private Recipe retrieveById(final String recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new NotFoundException("Recipe with id " + recipeId + " not found"));
    }

}
