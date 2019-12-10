package app;

import java.util.ArrayList;

/**
 * Burger
 */
public class Burger {
    private Integer id;
    private String name;
    private Double price;
    private String roll;
    private String meat;
    private ArrayList<Topping> toppings = new ArrayList<Topping>();

    public Burger(Integer id, String name, Double price, String roll, String meat) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.roll = roll;
        this.meat = meat;
        Manager.prepareToppings(this);
    }

    public Integer getId() {
        return id;
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
                + String.format("%.2f", this.price) + "\n\tMaximum toppings: " + this.getToppings().size() + "\n";
    }
}
