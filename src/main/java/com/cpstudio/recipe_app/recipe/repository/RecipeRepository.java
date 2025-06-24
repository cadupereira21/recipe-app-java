package com.cpstudio.recipe_app.recipe.repository;

import com.cpstudio.recipe_app.recipe.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> , JpaSpecificationExecutor<Recipe> {

    @Query("SELECT r FROM Recipe r JOIN r.ingredients i WHERE i.id = :ingredientId")
    List<Recipe> findByIngredientId(@Param("ingredientId") final String ingredientId);

    default Recipe updateIfExists(final String recipeId, final Recipe recipe) {
        final Recipe existingRecipe = findById(recipeId).orElse(null);

        if (existingRecipe == null) {
            return null;
        }

        existingRecipe.setTitle(recipe.getTitle());
        existingRecipe.setDescription(recipe.getDescription());
        existingRecipe.setIngredients(recipe.getIngredients());
        existingRecipe.setInstructions(recipe.getInstructions());
        existingRecipe.setVegetarian(recipe.isVegetarian());
        existingRecipe.setServings(recipe.getServings());

        return save(existingRecipe);
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