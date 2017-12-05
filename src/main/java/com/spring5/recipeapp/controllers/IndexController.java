package com.spring5.recipeapp.controllers;

import com.spring5.recipeapp.domain.Category;
import com.spring5.recipeapp.domain.UnitOfMeasure;
import com.spring5.recipeapp.repositories.ICategoryRepository;
import com.spring5.recipeapp.repositories.IUnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private ICategoryRepository categoryRepository;
    private IUnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(ICategoryRepository categoryRepository, IUnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional =categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id is :"+ categoryOptional.get().getId());
        System.out.println("UnitOfMeasure Id is :"+ unitOfMeasure.get().getId());
        return "index";
    }
}
