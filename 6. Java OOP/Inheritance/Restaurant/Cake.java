package restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {

    final static double CAKE_GRAMS = 250;
    final static double CAKE_CALORIES = 1000;
    final static BigDecimal CAKE_PRICE = BigDecimal.valueOf(5);

    public Cake(String name, BigDecimal price, double grams, double calories) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}
