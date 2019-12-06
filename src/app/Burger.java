package app;

import java.util.ArrayList;

/**
 * Burger
 */
public class Burger {

    private String name;
    private Double price;
    private String roll;
    private String meat;
    private Integer maxTopping;
    private ArrayList<Topping> toppings = new ArrayList<Topping>();

    public Burger(String name, Double price, String roll, String meat, Integer maxTopping) {
        this.name = name;
        this.price = price;
        this.roll = roll;
        this.meat = meat;
        this.maxTopping = maxTopping;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the burger price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @return the maxTopping allowed in burger
     */
    public Integer getMaxTopping() {
        return maxTopping;
    }

    /**
     * @return the toppings
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    /**
     * @param topping to be added to the toppingList
     */
    public void setToppings(Topping topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return this.name + " with " + this.roll + " with " + this.meat + " :- \n\tCost: $"
                + String.format("%.2f", this.price) + "\n\tMaximum toppings: " + this.maxTopping + "\n";
    }
}
