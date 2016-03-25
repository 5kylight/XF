package pl.borkowsk.model;

import java.math.BigDecimal;

/**
 * Created by tom on 25.03.16.
 */
public class Meal implements Food {
    private String name;
    private Cuisine cuisine;
    private BigDecimal price;

    public Meal(String name, Cuisine cuisine, BigDecimal price) {
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", cuisine=" + cuisine +
                ", price=" + price +
                '}';
    }
}
