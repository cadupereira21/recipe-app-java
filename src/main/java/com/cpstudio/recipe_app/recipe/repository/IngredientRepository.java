package com.cpstudio.recipe_app.recipe.repository;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    default Ingredient updateIfExists(final String ingredientId, final Ingredient ingredient) {
        if (ingredient == null || StringUtils.isBlank(ingredientId) || !existsById(ingredientId)) {
            return null;
        }

        return save(ingredient);
    }

}
