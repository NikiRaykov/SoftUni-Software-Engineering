package com.exam.battleship.repository;

import com.exam.battleship.model.entity.Category;
import com.exam.battleship.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryName(CategoryNameEnum categoryNameEnum);
}
