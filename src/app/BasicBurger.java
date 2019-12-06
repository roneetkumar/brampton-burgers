package app;

/**
 * BasicBurger
 */

public class BasicBurger extends Burger {
    public BasicBurger() {
        super("Basic Burger", 3.56, "White", "Chicken", 4);
    }

    public BasicBurger(String name, double price, String roll, String meat, int maxTopping) {
        super(name, price, roll, meat, maxTopping);
    }
}
