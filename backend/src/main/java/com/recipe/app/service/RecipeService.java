package com.recipe.app.service;
import org.springframework.stereotype.Service;
import java.util.List;

import com.recipe.app.entities.Recipe;
import com.recipe.app.repository.RecipeRepository;

@Service
public class RecipeService {
   
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Recipe existingRecipe = recipeRepository.findById(id).orElse(null);
        if (existingRecipe != null) {
            existingRecipe.setName(updatedRecipe.getName());
            existingRecipe.setIngredients(updatedRecipe.getIngredients());
            existingRecipe.setMethod(updatedRecipe.getMethod());
            return recipeRepository.save(existingRecipe);
        }
        return null;
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<Recipe> searchRecipes(String query) {
        return recipeRepository.findByNameContainingIgnoreCase(query);
    }

    public List<Recipe> getRecipesByIngredient(String ingredient) {
        return recipeRepository.findByIngredientsContainingIgnoreCase(ingredient);
    }

}
