package pl.borkowsk.model;

import java.math.BigDecimal;

/**
 * Created by tom on 25.03.16.
 */
public class Additive implements Food {

    private String name;
    private BigDecimal price;

    public Additive(String name, BigDecimal price) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Additive{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
