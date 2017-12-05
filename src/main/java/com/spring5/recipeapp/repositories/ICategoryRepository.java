package com.spring5.recipeapp.repositories;

import com.spring5.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
