package com.spring5.recipeapp.services;

import com.spring5.recipeapp.domain.Recipe;

import java.util.Set;

public interface IRecipeService {

    Set<Recipe> getRecipes();
}
