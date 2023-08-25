package machine;

/**
 * Latte Class
 */
public class Latte {
    public final int waterForOneCup;
    public final int milkForOneCup;
    public final int coffeeBeansForOneCup;
    public final int price;

    /**
     * Constructor
     * Parameterless constructor
     * Sets final class variables
     */
    public Latte() {
        this.waterForOneCup = 350;
        this.milkForOneCup = 75;
        this.coffeeBeansForOneCup = 20;
        this.price = 7;
    }

    /**
     * Getter
     * @return      Returns water level needed for one cup of latte as integer
     */
    public int getWaterForOneCup() {
        return waterForOneCup;
    }

    /**
     * Getter
     * @return      Returns milk level needed for one cup of latte as integer
     */
    public int getMilkForOneCup() {
        return milkForOneCup;
    }

    /**
     * Getter
     * @return      Returns coffee beans level for one cup of latte as integer
     */
    public int getCoffeeBeansForOneCup() {
        return coffeeBeansForOneCup;
    }

    /**
     * Getter
     * @return      Returns price for one cup of latte as integer
     */
    public int getPrice() {
        return price;
    }
}
