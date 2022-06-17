package bg.softuni.coffeeshop.model.entity.view;

public class UserViewModel {

    public UserViewModel(){}

    private String username;
    private Integer countOfOrders;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCountOfOrders() {
        return countOfOrders;
    }

    public void setCountOfOrders(Integer countOfOrders) {
        this.countOfOrders = countOfOrders;
    }
}
