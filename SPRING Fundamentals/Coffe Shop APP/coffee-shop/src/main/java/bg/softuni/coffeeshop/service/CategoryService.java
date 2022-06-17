package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.entity.Category;
import bg.softuni.coffeeshop.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initData();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
