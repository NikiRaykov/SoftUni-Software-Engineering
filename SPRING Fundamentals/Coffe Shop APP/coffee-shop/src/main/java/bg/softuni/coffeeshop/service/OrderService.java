package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.entity.Order;
import bg.softuni.coffeeshop.model.entity.service.OrderServiceModel;
import bg.softuni.coffeeshop.model.entity.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersOrderByPriceDesc();

    void readyOrder(Long id);
}
