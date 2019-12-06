package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        new Restaurant();
        Bill receipt = new Bill();

        ArrayList<Topping> selectedToppings = new ArrayList<Topping>();

        Restaurant.displayBurger();
        Burger selectedBurger = Restaurant.selectBurger();
        Restaurant.displayToppings(selectedBurger);
        Restaurant.chooseToppings(selectedBurger, selectedToppings);
        receipt.generateReciept(selectedBurger, selectedToppings);
    }
}
