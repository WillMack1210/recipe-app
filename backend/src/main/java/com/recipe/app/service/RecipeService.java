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

}
