import pl.borkowsk.generator.Generator;
import pl.borkowsk.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by tom on 25.03.16.
 */
public class Restaurant {
    private static ArrayList<Meal> availableMeals;
    private static ArrayList<Dessert> availableDesserts;
    private static ArrayList<Additive> availableAdditives;
    private static ArrayList<Drink> availableDrinks;
    /* Very simple version of Restaurant.
     I assume customer wants to order only one meal, dessert and drink,
      and I assume that customer would choose food properly
      (There is no invalid input checking) */

    public static void main(String[] args) {
        availableMeals = Generator.generateMeals();
        availableDesserts = Generator.generateDesserts();
        availableAdditives = Generator.generateAdditives();
        availableDrinks = Generator.generateDrinks();

        Order order = new Order();


        orderMeal(order);
        orderDessert(order);
        orderDrink(order);

        System.out.println(order);
    }

    public static void orderMeal(Order order) {
        Scanner scanner = new Scanner(System.in);

        List<Cuisine> cuisines = Arrays.asList(Cuisine.values());
        cuisines.forEach(v -> System.out.println(cuisines.indexOf(v) + " : " + v));
        System.out.println("Which cuisine do you want: ");
        Cuisine cuisine = cuisines.get(scanner.nextInt());

        List<Meal> filteredMeals = availableMeals.stream().filter(v -> v.getCuisine() == cuisine).collect(Collectors.toList());
        if (filteredMeals.isEmpty()) {
            System.out.println("Sorry, there is no meal of this cuisine");
            return;
        }

        System.out.println("Which meal do you want: ");
        filteredMeals.forEach(v -> System.out.println(filteredMeals.indexOf(v) + " : " + v));
        Meal meal = filteredMeals.get(scanner.nextInt());
        order.addFood(meal);
    }

    public static void orderDessert(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which dessert do you want: ");
        availableDesserts.forEach(v -> System.out.println(availableDesserts.indexOf(v) + " : " + v));
        Dessert dessert = availableDesserts.get(scanner.nextInt());
        order.addFood(dessert);
    }

    public static void orderDrink(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which drink do you want: ");
        availableDrinks.forEach(v -> System.out.println(availableDrinks.indexOf(v) + " : " + v));
        Drink drink = availableDrinks.get(scanner.nextInt());
        System.out.println("Do you want any additions: \n\t 0 : No \n\t 1 : Yes");
        if(scanner.nextInt() > 0) {
            System.out.println("Which addition do you want: ");
            availableAdditives.forEach(v -> System.out.println(availableAdditives.indexOf(v) + " : " + v));
            drink.addAdditive(availableAdditives.get(scanner.nextInt()));
        }

        order.addFood(drink);
    }
}
