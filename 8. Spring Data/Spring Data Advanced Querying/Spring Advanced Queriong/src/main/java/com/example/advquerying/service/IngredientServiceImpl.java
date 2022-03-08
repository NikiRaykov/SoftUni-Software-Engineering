package com.example.advquerying.service;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    List<Ingredient> selectNameStartingWith(String start){
        return this.ingredientRepository.findByNameStartingWith(start);
    }
}
