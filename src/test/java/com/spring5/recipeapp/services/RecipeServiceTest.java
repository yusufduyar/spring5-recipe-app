package com.spring5.recipeapp.services;

import com.spring5.recipeapp.domain.Recipe;
import com.spring5.recipeapp.repositories.IRecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceTest {
    RecipeService recipeService;

    @Mock
    IRecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeService(recipeRepository);
    }

    @Test
    public void getRecipes() throws Exception {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();
    }

}