package com.exam.battleship.service.impl;

import com.exam.battleship.model.entity.Category;
import com.exam.battleship.model.entity.enums.CategoryNameEnum;
import com.exam.battleship.repository.CategoryRepository;
import com.exam.battleship.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategory() {

        if (categoryRepository.count() == 0){

            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category = new Category();
                        category.setCategoryName(categoryNameEnum);

                        switch (categoryNameEnum){
                            case CARGO -> category.setDescription("This ship is CARGO");
                            case BATTLE -> category.setDescription("This ship is BATTLESHIP");
                            case PATROL ->category.setDescription("This ship is PATROL");
                        }

                        categoryRepository.save(category);

                    });



        }
    }

    @Override
    public Category findByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByCategoryName(categoryNameEnum).orElse(null);
    }
}
