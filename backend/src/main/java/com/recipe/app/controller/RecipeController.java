package com.recipe.app.controller;

import com.recipe.app.entities.Recipe;
import com.recipe.app.service.RecipeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @GetMapping("")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/search")
    public List<Recipe> getRecipesByIngredient(@RequestParam String ingredient) {
        return recipeService.getRecipesByIngredient(ingredient);
    }

    @GetMapping("/searchByName")
    public List<Recipe> searchRecipes(@RequestParam String query) {
        return recipeService.searchRecipes(query);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe) {
        return recipeService.updateRecipe(id, updatedRecipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

}