package com.exam.battleship.model.entity;

import com.exam.battleship.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    public Category(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryNameEnum categoryName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryNameEnum getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryNameEnum categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
