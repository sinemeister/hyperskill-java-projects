package machine;

/**
 * Espresso Class
 */
public class Espresso {
    private final int waterForOneCup;
    private final int coffeeBeansForOneCup;
    private final int price;

    /**
     * Constructor
     * Parameterless constructor
     * Sets final class variables
     */
    public Espresso() {
        this.waterForOneCup = 250;
        this.coffeeBeansForOneCup = 16;
        this.price = 4;
    }

    /**
     * Getter
     * @return      Returns water level needed for one cup of espresso as integer
     */
    public int getWaterForOneCup() {
        return waterForOneCup;
    }

    /**
     * Getter
     * @return      Returns coffee beans level for one cup of espresso as integer
     */
    public int getCoffeeBeansForOneCup() {
        return coffeeBeansForOneCup;
    }

    /**
     * Getter
     * @return      Returns price for one cup of espresso as integer
     */
    public int getPrice() {
        return price;
    }
}
