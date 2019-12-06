package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Restaurant
 */
public class Restaurant {
    private static Scanner input;
    private static ArrayList<Burger> allBurgers = new ArrayList<Burger>();

    Restaurant() {
        prepareBurgersAndToppings();
    }

    public static void displayBurger() {
        System.out.println("\n\t\t   Brampton Burgers");
        System.out.println("\t\t   ````````````````");

        int i = 1;
        System.out.println("\t----------------------------------------");
        for (Burger burger : allBurgers) {
            System.out.print(i + ".\t" + burger);
            System.out.println("\t----------------------------------------");
            i++;
        }
    }

    public static Burger selectBurger() {
        Burger burger;
        System.out.print("Select : ");

        try {
            input = new Scanner(System.in);
            int choice = input.nextInt();

            if (choice > 3 || choice < 1) {
                Error("Please select the burger show in the list");
                burger = selectBurger();
            } else {
                burger = allBurgers.get(choice - 1);
            }
        } catch (Exception e) {
            Error("Please select the burger show in the list");
            burger = selectBurger();
        }

        return burger;
    }

    public static void displayToppings(Burger selectedBurger) {

        int i = 1;
        System.out.println("\n________________________");
        System.out.println("Please Add Some Toppings");
        System.out.println("````````````````````````\n");

        for (Topping topping : selectedBurger.getToppings()) {
            System.out.print(i + ". \t" + topping);
            i++;
        }

        System.out.print("0. \tThats all \n");
    }

    public static void chooseToppings(Burger selectedBurger, ArrayList<Topping> selectedToppings) {
        System.out.print("\nChoose any " + selectedBurger.getMaxTopping() + " toppings : ");

        try {
            input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 0) {
                return;
            } else if (choice > selectedBurger.getMaxTopping()) {
                Error("\nPlease select the right topping");
                chooseToppings(selectedBurger, selectedToppings);
            } else {
                selectedToppings.add(selectedBurger.getToppings().get(choice - 1));
            }
        } catch (Exception e) {
            Error("\nPlease select the right topping");
            chooseToppings(selectedBurger, selectedToppings);
        }

        if (selectedBurger.getMaxTopping() != selectedToppings.size()) {
            chooseToppings(selectedBurger, selectedToppings);
        }
    }

    private static void Error(String error) {
        System.out.println(error);
    }

    private void prepareBurgersAndToppings() {
        Burger basicBurger = new BasicBurger();
        Burger healthyBurger = new HealthyBurger();
        Burger deluxeBurger = new DeluxeBurger();

        Topping tomato = new Topping("Tomato", 0.27);
        Topping lettuce = new Topping("Lettuce", 0.72);
        Topping cheese = new Topping("Cheese", 1.13);
        Topping carrot = new Topping("Carrot", 2.75);
        Topping egg = new Topping("Egg", 5.43);
        Topping lentils = new Topping("Lentils", 3.14);
        Topping chips = new Topping("Chips", 2.75);
        Topping drink = new Topping("Drink", 1.81);

        basicBurger.setToppings(tomato);
        basicBurger.setToppings(lettuce);
        basicBurger.setToppings(cheese);
        basicBurger.setToppings(carrot);

        healthyBurger.setToppings(basicBurger.getToppings().get(0));
        healthyBurger.setToppings(basicBurger.getToppings().get(1));
        healthyBurger.setToppings(basicBurger.getToppings().get(2));
        healthyBurger.setToppings(basicBurger.getToppings().get(3));
        healthyBurger.setToppings(egg);
        healthyBurger.setToppings(lentils);

        deluxeBurger.setToppings(chips);
        deluxeBurger.setToppings(drink);

        allBurgers.add(basicBurger);
        allBurgers.add(healthyBurger);
        allBurgers.add(deluxeBurger);
    }
}
