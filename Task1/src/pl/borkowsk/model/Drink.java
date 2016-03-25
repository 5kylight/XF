package pl.borkowsk.model;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by tom on 25.03.16.
 */
public class Drink implements Food {
    private String name;
    private BigDecimal price;
    private ArrayList<Additive> additives = new ArrayList<>();

    public Drink(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price.add(getAdditivesPrice());
    }


    private BigDecimal getAdditivesPrice() {
        return additives.stream().map(v -> v.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addAdditive(Additive additive) {
        additives.add(additive);
    }

    public void removeAdditive(Additive additive){
        additives.remove(additive);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", additives=" + additives +
                '}';
    }
}
