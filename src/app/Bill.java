package app;

import java.util.ArrayList;

/**
 * Bill
 */
public class Bill {

    private String billId;
    private Burger burger;
    private ArrayList<Topping> topings;

    public Bill(Burger burger, ArrayList<Topping> toppings) {
        this.billId = "0";
        this.burger = burger;
        this.topings = toppings;
    }

    public void generateReciept() {

        double total = calculateTotal(this.burger, this.topings);
        double tax = total * 0.15;
        double netTotal = total + tax;

        System.out.println("\n\tReciept");
        System.out.println("\t```````");
        System.out.println("1. " + this.burger.getName() + " - " + this.burger.getPrice());

        if (this.topings.size() > 0) {
            int i = 1;
            System.out.println("\nExtras : ");
            System.out.println("````````");

            for (Topping topping : this.topings) {
                System.out.print(i + ". " + topping);
                i++;
            }
        } else {
            System.out.println("\nNo extras toppings");
        }

        System.out.println("\n-----------------------------");
        System.out.print("Amount: " + String.format("%.2f", total) + "$");
        System.out.print(" + (Tax: " + String.format("%.2f", tax) + "$)");
        System.out.println("\n-----------------------------");
        System.out.println("Total: " + String.format("%.2f", netTotal) + "$");
        System.out.println("-----------------------------");
    }

    private double calculateTotal(Burger selectedBurger, ArrayList<Topping> selectedToppings) {
        double tempTotal = 0;
        tempTotal += selectedBurger.getPrice();
        for (Topping topping : selectedToppings) {
            tempTotal += topping.getPrice();
        }
        return tempTotal;
    }

}
