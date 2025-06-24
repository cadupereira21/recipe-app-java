package com.cpstudio.recipe_app.recipe.service;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.UpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.mapper.RecipeMapper;
import com.cpstudio.recipe_app.recipe.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
