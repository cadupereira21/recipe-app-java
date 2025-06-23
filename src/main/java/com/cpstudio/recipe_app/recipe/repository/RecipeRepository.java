package com.cpstudio.recipe_app.recipe.repository;

import com.cpstudio.recipe_app.recipe.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

    default Recipe updateIfExists(final Recipe recipe) {
        if (recipe == null || !existsById(recipe.getId())) {
            return null;
        }
        return save(recipe);
    }

    default Recipe partialUpdateIfExists(final Recipe recipe) {
        if (recipe == null || !existsById(recipe.getId())) {
            return null;
        }

        final Recipe existingRecipe = findById(recipe.getId()).orElse(null);

        if (existingRecipe != null) {
            if (recipe.getTitle() != null) {
                existingRecipe.setTitle(recipe.getTitle());
            }

            if (recipe.getDescription() != null) {
                existingRecipe.setDescription(recipe.getDescription());
            }

            if (recipe.getIngredients() != null) {
                existingRecipe.setIngredients(recipe.getIngredients());
            }

            if (recipe.getInstructions() != null) {
                existingRecipe.setInstructions(recipe.getInstructions());
            }

            return save(existingRecipe);
        }

        return null;
    }

}