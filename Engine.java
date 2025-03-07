public class Engine implements EngineRequirements {

    //Attributes 
    private FuelType f; //type of fuel 
    private double currentFuelLevel; //current fuel level
    private double maxFuelLevel; //max fuel level

    /**
     * Constructs an Engine object with the specified fuel type and maximum fuel level.
     * Initially, the engine is fully fueled.
     *
     * @param fuelType The type of fuel used by the engine.
     * @param maxFuelLevel The maximum amount of fuel the engine can hold.
     */
    //Constructor 
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel) {
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    /**
     * Returns the type of fuel used by the engine.
     *
     * @return The FuelType of the engine.
     */
    public FuelType getFuelType(){
        return this.f;
    }

    //Accessor Methods
        /**
     * Returns the maximum fuel level of the engine.
     *
     * @return The maximum fuel capacity.
     */
    public double getMaxFuel(){
        return this.maxFuelLevel;
    }

    /**
     * Returns the current fuel level of the engine.
     *
     * @return The current fuel level.
     */
    public double getCurrentFuel(){
        return this.currentFuelLevel;
    } 

    /**
     * Refuels the engine to its maximum fuel capacity.
     * Prints a message indicating the fuel has been replenished.
     */
    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
        System.out.println("Refueled" + this.currentFuelLevel);
    }

    //tells how much fuel is in the train and whther it can go or not
    /**
     * Moves the train by consuming fuel.
     * Reduces the fuel level and prints the remaining amount.
     * 
     * @return true if the engine still has fuel remaining, false if it is empty.
     */
    public Boolean go(){
        if (this.currentFuelLevel <= 0){
            System.out.println("Train is out of fuel, can't move." + this.currentFuelLevel);
            return false;
        }
        else { 
            this.currentFuelLevel -= 15;
            System.out.println("Train is moving with" + this.currentFuelLevel + "fuel left.");
            return true;
        }
    }


    public String toString(){
        return "FuelType: " + this.f + " Current Fuel Level: " + this.currentFuelLevel + " Max Fuel Level: " + this.maxFuelLevel;
    }
    public static void main(String[] args){
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0.0, 100.0);
        System.out.println(myEngine.getFuelType());
        System.out.println(myEngine);
    }
}