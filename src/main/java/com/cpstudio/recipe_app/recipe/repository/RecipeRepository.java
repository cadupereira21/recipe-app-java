package com.cpstudio.recipe_app.recipe.repository;

import com.cpstudio.recipe_app.recipe.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

    /**
     * Finds recipes based on various filters.
     *
     * @param isVegetarian          whether the recipe is vegetarian
     * @param servings              number of servings
     * @return a list of recipes matching the filters
     */
    List<Recipe> findByIsVegetarianAndServings(final boolean isVegetarian, final int servings);

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

            if (recipe.isVegetarian() != existingRecipe.isVegetarian()) {
                existingRecipe.setVegetarian(recipe.isVegetarian());
            }

            if (recipe.getServings() > 0) {
                existingRecipe.setServings(recipe.getServings());
            }

            return save(existingRecipe);
        }

        return null;
    }

}