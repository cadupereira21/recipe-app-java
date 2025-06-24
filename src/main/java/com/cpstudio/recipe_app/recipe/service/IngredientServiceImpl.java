package com.cpstudio.recipe_app.recipe.service;

import com.cpstudio.recipe_app.core.exception.BadRequestException;
import com.cpstudio.recipe_app.core.exception.ForeignKeyConstraintException;
import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.ingredient.CreateIngredientRequest;
import com.cpstudio.recipe_app.recipe.dto.ingredient.UpdateIngredientRequest;
import com.cpstudio.recipe_app.recipe.mapper.IngredientMapper;
import com.cpstudio.recipe_app.recipe.repository.IngredientRepository;
import com.cpstudio.recipe_app.recipe.repository.RecipeRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    final IngredientRepository ingredientRepository;

    final RecipeRepository recipeRepository;

    public IngredientServiceImpl(final IngredientRepository ingredientRepository, final RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Ingredient> retrieveAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> retrieveByRecipeId(String recipeId) {
        if (StringUtils.isBlank(recipeId)) {
            return null;
        }

        return recipeRepository.findById(recipeId)
                .map(Recipe::getIngredients)
                .orElse(null);
    }

    @Override
    public Ingredient update(final String ingredientId, final UpdateIngredientRequest request) {
        return ingredientRepository.updateIfExists(ingredientId, IngredientMapper.toDomain(request));
    }
}
