package com.spring5.recipeapp.repositories;

import com.spring5.recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface IUnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
