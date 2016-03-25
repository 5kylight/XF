package pl.borkowsk.generator;

import pl.borkowsk.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tom on 25.03.16.
 */
public class Generator {
    private static int SIZE = 10;

    public static ArrayList<Meal> generateMeals() {
        ArrayList<Meal> data = new ArrayList<>(SIZE);
        Random random = new Random(SIZE);
        for (int i = 0; i < SIZE; i++) {
            data.add(new Meal("Meal " + i, Cuisine.values()[random.nextInt(Cuisine.values().length)], new BigDecimal(random.nextInt(100))));
        }
        return data;
    }

    public static ArrayList<Dessert> generateDesserts() {
        ArrayList<Dessert> data = new ArrayList<>(SIZE);
        Random random = new Random(SIZE);
        for (int i = 0; i < SIZE; i++) {
            data.add(new Dessert("Dessert " + i, new BigDecimal(random.nextInt(100))));
        }
        return data;
    }


    public static ArrayList<Additive> generateAdditives() {
        ArrayList<Additive> data = new ArrayList<>(SIZE);
        Random random = new Random(SIZE);
        for (int i = 0; i < SIZE; i++) {
            data.add(new Additive("Additive " + i, new BigDecimal(random.nextInt(100))));
        }
        return data;
    }

    public static ArrayList<Drink> generateDrinks() {
        ArrayList<Drink> data = new ArrayList<>(SIZE);
        Random random = new Random(SIZE);
        for (int i = 0; i < SIZE; i++) {
            data.add(new Drink("Additive " + i, new BigDecimal(random.nextInt(100))));
        }
        return data;
    }
}
