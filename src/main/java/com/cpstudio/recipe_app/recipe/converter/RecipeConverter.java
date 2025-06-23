package com.cpstudio.recipe_app.recipe.converter;

import com.cpstudio.recipe_app.recipe.domain.Recipe;
import com.cpstudio.recipe_app.recipe.dto.CreateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.PartialUpdateRecipeRequest;
import com.cpstudio.recipe_app.recipe.dto.UpdateRecipeRequest;

public abstract class RecipeConverter {

    public static Recipe createRequestToDomain(final CreateRecipeRequest request) {
        if (request == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setTitle(request.title());
        recipe.setDescription(request.description());
        recipe.setIngredients(request.ingredients());
        recipe.setInstructions(request.instructions());

        return recipe;
    }

    public static Recipe updateRequestToDomain(final String id, final UpdateRecipeRequest request) {
        if (request == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setTitle(request.title());
        recipe.setDescription(request.description());
        recipe.setIngredients(request.ingredients());
        recipe.setInstructions(request.instructions());

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
        recipe.setIngredients(request.ingredients() != null ? request.ingredients() : null);
        recipe.setInstructions(request.instructions() != null ? request.instructions() : null);

        return recipe;
    }

}
