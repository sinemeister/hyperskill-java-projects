package machine;

import java.util.ArrayList;

/**
 * CoffeeMaker Class
 */
public class CoffeeMaker {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private final ArrayList<String> missingIngredients;

    /**
     * Constructor
     * Parameterless constructor
     * Initializes class variables
     */
    public CoffeeMaker() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
        this.missingIngredients = new ArrayList<>();
    }

    /**
     * Getter
     * @return      Returns current water level in the machine as int
     */
    public int getWater() {
        return water;
    }

    /**
     * Setter
     * Increments current water level by value if value is non-negative integer
     * @param water     Added water as int
     */
    public void setWater(int water) {
        if (water >= 0) {
            this.water += water;
        }
    }

    /**
     * Getter
     * @return      Returns current milk level in the machine as int
     */
    public int getMilk() {
        return milk;
    }

    /**
     * Setter
     * Increments current milk level by value if value is non-negative integer
     * @param milk      Added milk as int
     */
    public void setMilk(int milk) {
        if (milk >= 0) {
            this.milk += milk;
        }
    }

    /**
     * Getter
     * @return      Returns current coffee beans level in the machine as int
     */
    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    /**
     * Setter
     * Increments current coffee beans level by value if value is non-negative integer
     * @param coffeeBeans       Added coffee beans as int
     */
    public void setCoffeeBeans(int coffeeBeans) {
        if (coffeeBeans >= 0) {
            this.coffeeBeans += coffeeBeans;
        }
    }

    /**
     * Getter
     * @return      Returns current disposable cups level in the machine as int
     */
    public int getDisposableCups() {
        return disposableCups;
    }

    /**
     * Setter
     * Increments current disposable cups level by value if value is non-negative integer
     * @param disposableCups        Added disposable cups as int
     */
    public void setDisposableCups(int disposableCups) {
        if (disposableCups >= 0) {
            this.disposableCups += disposableCups;
        }
    }

    /**
     * Getter
     * @return      Returns current money in the machine as integer
     */
    public int getMoney() {
        return money;
    }

    /**
     * Setter
     * Sets money in the machine to a value if value is non-negative integer
     * @param money     Money value to be set as integer
     */
    public void setMoney(int money) {
        if (money >= 0) {
            this.money = money;
        }
    }

    /**
     * If user wants to buy a coffee checks the ingredients and checks if successful
     * Otherwise passes missing ingredients
     * @param userChoice        User choice to buy which coffee as integer
     * @return                  Returns true if user can buy coffee, false otherwise
     */
    public boolean buy(int userChoice) {
        if (userChoice == 1) {
            Espresso espresso = new Espresso();
            if (!(getWater() >= espresso.getWaterForOneCup())) {
                missingIngredients.add("water");
            } else if (!(getCoffeeBeans() >= espresso.getCoffeeBeansForOneCup())) {
                missingIngredients.add("coffee beans");
            } else if (disposableCups < 1) {
                missingIngredients.add("disposable cups");
                findMissingIngredient();
            } else {
                this.water -= espresso.getWaterForOneCup();
                this.coffeeBeans -= espresso.getCoffeeBeansForOneCup();
                this.disposableCups--;
                this.money += espresso.getPrice();
                return true;
            }
        } else if (userChoice == 2) {
            Latte latte = new Latte();
            if (!(getWater() >= latte.getWaterForOneCup())) {
                missingIngredients.add("water");
            } else if (!(getMilk() >= latte.getMilkForOneCup())) {
                missingIngredients.add("milk");
            } else if (!(getCoffeeBeans() >= latte.getCoffeeBeansForOneCup())) {
                missingIngredients.add("coffee beans");
            } else if (disposableCups < 1) {
                missingIngredients.add("disposable cups");
                findMissingIngredient();
            } else {
                this.water -= latte.getWaterForOneCup();
                this.milk -= latte.getMilkForOneCup();
                this.coffeeBeans -= latte.getCoffeeBeansForOneCup();
                this.disposableCups--;
                this.money += latte.getPrice();
                return true;
            }
        } else if (userChoice == 3) {
            Cappuccino cappuccino = new Cappuccino();
            if (!(getWater() >= cappuccino.getWaterForOneCup())) {
                missingIngredients.add("water");
            } else if (!(getMilk() >= cappuccino.getMilkForOneCup())) {
                missingIngredients.add("milk");
            } else if (!(getCoffeeBeans() >= cappuccino.getCoffeeBeansForOneCup())) {
                missingIngredients.add("coffee beans");
            } else if (coffeeBeans < 1) {
                missingIngredients.add("disposable cups");
                findMissingIngredient();
            } else {
                this.water -= cappuccino.getWaterForOneCup();
                this.milk -= cappuccino.getMilkForOneCup();
                this.coffeeBeans -= cappuccino.getCoffeeBeansForOneCup();
                this.disposableCups--;
                this.money += cappuccino.getPrice();
                return true;
            }
        }
        return false;
    }

    /**
     * Fills the machine with the corresponding values
     * @param addWater          Water level to be added as integer
     * @param addMilk           Milk level to be added as integer
     * @param addCoffeeBeans    Coffee Beans level to be added as integer
     * @param addCups           Disposable Cups level to be added as integer
     */
    public void fill(int addWater, int addMilk, int addCoffeeBeans, int addCups) {
        setWater(addWater);
        setMilk(addMilk);
        setCoffeeBeans(addCoffeeBeans);
        setDisposableCups(addCups);
    }

    /**
     * Informs user about the current state of the machine
     * @return      Formatted string literal about machine ingredients and properties
     */
    public String getCurrentState() {
        return String.format("The coffee machine has:\n" +
                             "%d ml of water\n" +
                             "%d ml of milk\n" +
                             "%d g of coffee beans\n" +
                             "%d disposable cups\n" +
                             "$%d of money", getWater(), getMilk(), getCoffeeBeans(),
                             getDisposableCups(), getMoney());
    }

    /**
     * Finds missing ingredients if user cannot buy a coffee in case the machine is short of one or more ingredients
     * @return      String literal representation of the missing ingredients text
     */
    public String findMissingIngredient() {
        StringBuilder missingIngredientsText = new StringBuilder("Sorry not enough ");

        for (int i = 0; i < missingIngredients.size(); i++) {
            if (i == missingIngredients.size() - 1) {
                missingIngredientsText.append(missingIngredients.get(i)).append("!");
                break;
            }
            missingIngredientsText.append(missingIngredients.get(i)).append(", ");
        }
        missingIngredients.clear();
        return missingIngredientsText.toString();
    }
}

