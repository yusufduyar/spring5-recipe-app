package com.spring5.recipeapp.controllers;

import com.spring5.recipeapp.commands.RecipeCommand;
import com.spring5.recipeapp.services.IImageService;
import com.spring5.recipeapp.services.IRecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
public class ImageController {
    private final IImageService imageService;
    private final IRecipeService recipeService;

    public ImageController(IImageService imageService, IRecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{recipeId}/image")
    public String getImageForm(@PathVariable String recipeId,Model model){
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));
        model.addAttribute("recipe",recipeCommand);

        return "recipe/imageuploadform";
    }

    @PostMapping("/recipe/{recipeId}/image")
    public String handleImagePost(@PathVariable String recipeId, @RequestParam("imagefile")MultipartFile file){
        imageService.saveImageFile(Long.valueOf(recipeId),file);

        return "redirect:/recipe/"+recipeId+"/show";
    }
}
