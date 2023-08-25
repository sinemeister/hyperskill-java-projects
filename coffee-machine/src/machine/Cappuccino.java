package machine;

/**
 * Cappuccino Class
 */
public class Cappuccino {
    private final int waterForOneCup;
    private final int milkForOneCup;
    private final int coffeeBeansForOneCup;
    private final int price;

    /**
     * Constructor
     * Parameterless constructor
     * Sets final class variables
     */
    public Cappuccino() {
        this.waterForOneCup = 200;
        this.milkForOneCup = 100;
        this.coffeeBeansForOneCup = 12;
        this.price = 6;
    }

    /**
     * Getter
     * @return      Returns water level needed for one cup of cappuccino as integer
     */
    public int getWaterForOneCup() {
        return waterForOneCup;
    }

    /**
     * Getter
     * @return      Returns milk level needed for one cup of cappuccino as integer
     */
    public int getMilkForOneCup() {
        return milkForOneCup;
    }

    /**
     * Getter
     * @return      Returns coffee beans level needed for one cup of cappuccino as integer
     */
    public int getCoffeeBeansForOneCup() {
        return coffeeBeansForOneCup;
    }

    /**
     * Getter
     * @return      Returns the price for one cup of cappuccino as integer
     */
    public int getPrice() {
        return price;
    }
}
