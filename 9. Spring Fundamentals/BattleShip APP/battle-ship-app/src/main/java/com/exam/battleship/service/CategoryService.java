package com.exam.battleship.service;

import com.exam.battleship.model.entity.Category;
import com.exam.battleship.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategory();

    Category findByName(CategoryNameEnum categoryNameEnum);
}
