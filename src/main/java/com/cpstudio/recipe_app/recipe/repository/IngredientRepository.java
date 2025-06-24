package com.cpstudio.recipe_app.recipe.repository;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    default Ingredient updateIfExists(final String ingredientId, final Ingredient ingredient) {
        final Ingredient existingIngredient = findById(ingredientId).orElse(null);

        if (existingIngredient == null) {
            return null;
        }

        existingIngredient.setName(ingredient.getName());
        existingIngredient.setQuantity(ingredient.getQuantity());
        existingIngredient.setQuantityType(ingredient.getQuantityType());

        return save(existingIngredient);
    }

}
