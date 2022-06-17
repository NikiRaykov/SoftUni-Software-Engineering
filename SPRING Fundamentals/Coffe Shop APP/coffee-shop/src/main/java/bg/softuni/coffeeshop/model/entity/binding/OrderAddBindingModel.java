package bg.softuni.coffeeshop.model.entity.binding;

import bg.softuni.coffeeshop.model.entity.enums.CategoryNameEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {

    public OrderAddBindingModel(){}

    @Length(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    private String name;

    @DecimalMin(value = "0", message = "The price must be positive.")
    private BigDecimal price;

    @PastOrPresent(message = "Order time cannot be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;

    @NotNull(message = "You must select the category.")
    private CategoryNameEnum category;

    @Length(min = 5, message = "Description size must be minimum 5 characters.")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
