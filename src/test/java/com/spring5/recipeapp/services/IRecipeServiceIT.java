package com.spring5.recipeapp.services;

import com.spring5.recipeapp.commands.RecipeCommand;
import com.spring5.recipeapp.converters.RecipeCommandToRecipe;
import com.spring5.recipeapp.converters.RecipeToRecipeCommand;
import com.spring5.recipeapp.domain.Recipe;
import com.spring5.recipeapp.repositories.IRecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IRecipeServiceIT {

    @Autowired
    IRecipeService recipeService;

    @Autowired
    private IRecipeRepository recipeRepository;

    @Autowired
    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void recipe_service_saves_recipe_command() {
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe recipe = recipes.iterator().next();
        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);

        //when
        recipeCommand.setDescription("newDescription");
        RecipeCommand savedRecipeCommand =recipeService.saveRecipeCommand(recipeCommand);

        //then
        assertNotNull(savedRecipeCommand);
        assertEquals("newDescription",savedRecipeCommand.getDescription());
        assertEquals(recipe.getId(),savedRecipeCommand.getId());
        assertEquals(recipe.getCategories().size(),savedRecipeCommand.getCategories().size());
        assertEquals(recipe.getIngredients().size(),savedRecipeCommand.getIngredients().size());

    }
}