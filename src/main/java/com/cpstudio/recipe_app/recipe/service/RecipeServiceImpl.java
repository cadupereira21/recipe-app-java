package com.cpstudio.recipe_app.recipe.service;

import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.recipe.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.recipe.RecipeResponse;
import com.cpstudio.recipe_app.recipe.mapper.RecipeMapper;
import com.cpstudio.recipe_app.recipe.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    final RecipeRepository recipeRepository;

    @Override
    public List<RecipeResponse> retrieveAll() {
        final List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map(RecipeMapper::toResponse).toList();
    }

    @Override
    public RecipeResponse create(final CreateRecipeRequest request) {
        final Recipe recipe = recipeRepository.save(RecipeMapper.toDomain(request));
        return RecipeMapper.toResponse(recipe);
    }

}
