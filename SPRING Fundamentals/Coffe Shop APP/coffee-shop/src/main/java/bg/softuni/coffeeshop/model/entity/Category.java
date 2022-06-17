package bg.softuni.coffeeshop.model.entity;

import bg.softuni.coffeeshop.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    public Category(){}

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private CategoryNameEnum name;


    @Column(name = "needed_time")
    private int neededTime;

    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }
}
