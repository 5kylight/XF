package pl.borkowsk.model;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by tom on 25.03.16.
 */
public class Order {

    private ArrayList<Food> basket = new ArrayList<>();

    public void addFood(Food food) {
        basket.add(food);
    }

    public void removeFood(Food food) {
        basket.remove(food);
    }

    public BigDecimal summary() {
        return basket.stream().map(f -> f.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        return "Your order is: \n\t " + basket.toString() +
                "\n\n\tTotal to pay: " + summary();
    }
}
