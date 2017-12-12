package com.spring5.recipeapp.services;

import com.spring5.recipeapp.commands.RecipeCommand;
import com.spring5.recipeapp.domain.Recipe;

import java.util.Set;

public interface IRecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(long l);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
