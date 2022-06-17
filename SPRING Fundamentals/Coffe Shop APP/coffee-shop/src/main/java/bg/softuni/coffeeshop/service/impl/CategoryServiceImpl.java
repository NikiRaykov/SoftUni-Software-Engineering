package bg.softuni.coffeeshop.service.impl;

import bg.softuni.coffeeshop.model.entity.Category;
import bg.softuni.coffeeshop.model.entity.enums.CategoryNameEnum;
import bg.softuni.coffeeshop.repository.CategoryRepository;
import bg.softuni.coffeeshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initData() {

        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category = new Category();
                        category.setName(categoryNameEnum);

                        switch (categoryNameEnum) {
                            case Coffee -> category.setNeededTime(2);
                            case Cake -> category.setNeededTime(10);
                            case Drink -> category.setNeededTime(1);
                            case Other -> category.setNeededTime(5);

                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
