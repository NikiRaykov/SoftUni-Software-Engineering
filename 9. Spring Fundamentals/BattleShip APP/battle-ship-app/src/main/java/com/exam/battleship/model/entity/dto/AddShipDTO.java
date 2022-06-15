package com.exam.battleship.model.entity.dto;

import com.exam.battleship.model.entity.enums.CategoryNameEnum;
import com.exam.battleship.model.entity.service.ShipServiceModel;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class AddShipDTO {

    public AddShipDTO(){}

    @Length(min = 2, max = 10, message = "The name must be between 2 and 10 characters.")
    private String name;

    @Min(value = 0, message = "The power must be positive.")
    private Integer power;

    @Min(value = 0, message = "The health must be positive.")
    private Integer health;

    @PastOrPresent(message = "Created date cannot be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @NotNull(message = "You must select the category.")
    private CategoryNameEnum category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
