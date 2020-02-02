package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        new Restaurant();

        ArrayList<Topping> selectedToppings = new ArrayList<Topping>();

        Restaurant.displayBurger();
        Burger selectedBurger = Restaurant.selectBurger();
        Restaurant.displayToppings(selectedBurger);
        Restaurant.chooseToppings(selectedBurger, selectedToppings);

        Bill receipt = new Bill(selectedBurger, selectedToppings);
        receipt.generateReciept();
    }
}
