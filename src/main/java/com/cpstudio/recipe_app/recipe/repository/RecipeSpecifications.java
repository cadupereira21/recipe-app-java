package com.cpstudio.recipe_app.recipe.repository;

import com.cpstudio.recipe_app.recipe.domain.Ingredient;
import com.cpstudio.recipe_app.recipe.domain.Recipe;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.Set;

public class RecipeSpecifications {

    public static Specification<Recipe> isVegetarian(final Boolean isVegetarian) {
        return (root, query, cb) -> isVegetarian == null
                ? null
                : cb.equal(root.get("isVegetarian"), isVegetarian);
    }

    public static Specification<Recipe> hasServings(final Integer servings) {
        return (root, query, cb) -> servings == null
                ? null
                : cb.equal(root.get("servings"), servings);
    }

    public static Specification<Recipe> containsInstruction(final String instruction) {
        return (root, query, cb) -> StringUtils.isBlank(instruction)
                ? null
                : cb.like(cb.lower(root.get("instructions")), "%" + instruction.toLowerCase() + "%");
    }

    public static Specification<Recipe> includesIngredients(final Set<String> ingredients) {
        return (root, query, cb) -> {
            if (CollectionUtils.isEmpty(ingredients)) return null;

            final Join<Recipe, Ingredient> join = root.join("ingredients");
            return join.get("id").in(ingredients);
        };
    }

    public static Specification<Recipe> excludesIngredients(final Set<String> ingredients) {
        return (root, query, cb) -> {
            if (CollectionUtils.isEmpty(ingredients)) return null;

            final Subquery<String> subquery = query.subquery(String.class);
            final Root<Recipe> subRoot = subquery.from(Recipe.class);
            final Join<Recipe, Ingredient> subJoin = subRoot.join("ingredients");

            subquery.select(subRoot.get("id")).where(subJoin.get("id").in(ingredients));

            return cb.not(root.get("id").in(subquery));
        };
    }
}

