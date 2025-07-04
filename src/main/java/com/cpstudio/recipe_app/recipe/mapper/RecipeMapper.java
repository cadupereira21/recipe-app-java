package com.cpstudio.recipe_app.recipe.mapper;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.recipe.*;

import java.util.List;

public abstract class RecipeMapper {

    public static Recipe toDomain(final CreateRecipeRequest request) {
        if (request == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setTitle(request.title());
        recipe.setDescription(request.description());
        recipe.setInstructions(request.instructions());
        recipe.setVegetarian(request.isVegetarian());
        recipe.setServings(request.servings());
        recipe.setIngredients(request.ingredients().stream().map(IngredientMapper::toDomain).toList());

        return recipe;
    }

    public static Recipe toDomain(final String id, final UpdateRecipeRequest request, final List<Ingredient> ingredients) {
        if (request == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setTitle(request.title());
        recipe.setDescription(request.description());
        recipe.setInstructions(request.instructions());
        recipe.setVegetarian(request.isVegetarian());
        recipe.setServings(request.servings());
        recipe.setIngredients(ingredients);

        return recipe;
    }

    public static Recipe partialUpdateRequestToDomain(final String id, final PartialUpdateRecipeRequest request) {
        if (request == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setTitle(request.title() != null ? request.title() : null);
        recipe.setDescription(request.description() != null ? request.description() : null);
        recipe.setInstructions(request.instructions() != null ? request.instructions() : null);
        recipe.setVegetarian(request.isVegetarian());
        recipe.setServings(request.servings());

        return recipe;
    }

}
