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
        allBurgers.addAll(Manager.prepareBurgers());
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
        System.out.print("\nChoose any " + selectedBurger.getToppings().size() + " toppings : ");

        try {
            input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 0) {
                return;
            } else if (choice > selectedBurger.getToppings().size()) {
                Error("\nPlease select the right topping");
                chooseToppings(selectedBurger, selectedToppings);
            } else {
                selectedToppings.add(selectedBurger.getToppings().get(choice - 1));
            }
        } catch (Exception e) {
            Error("\nPlease select the right topping");
            chooseToppings(selectedBurger, selectedToppings);
        }

        if (selectedBurger.getToppings().size() != selectedToppings.size()) {
            chooseToppings(selectedBurger, selectedToppings);
        }
    }

    private static void Error(String error) {
        System.out.println(error);
    }
}
