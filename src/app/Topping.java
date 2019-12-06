package app;

/**
 * Ingredient
 */
public class Topping {

    String name;
    double price;

    public Topping(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name + " : $" + String.format("%.2f", this.price) + "\n";
    }
}
