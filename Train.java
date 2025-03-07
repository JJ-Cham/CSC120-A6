import java.util.ArrayList;

public class Train implements TrainRequirements {

    //Attributes
    private Engine engine;
    private ArrayList <Car> cars; 

    /**
     * Constructor - intializes the Engine and Cars and stores them 
     * @param fuelType - type of fuel the engine uses 
     * @param fuelCapacity - the fuel capacity of the engine 
     * @param nCars - the number of cars in the train 
     * @param passengerCapacity - the passenger capacity of each car 
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        this.cars = new ArrayList<>(); 

        //intialize the car 
        for (int i = 0; i < nCars; i++) {
            this.cars.add(new Car(passengerCapacity)); 
        }
    } 

    /** Accessor
     *Returns the engine of the train.
     * @return the engine of the train
     */
    public Engine getEngine() {
        return this.engine;
    } 

    /** Accessor
     * Returns the ith car in the train
     * @param i - the index of the car
     * @return the car at the specific index
     */
    public Car getCar(int i) {
        return this.cars.get(i);
    }

    /** Accessor
     * Returns the maximum total capacity across all cars in the train
     * @return the total capacity of all cars combined 
     */
    public int getMaxCapacity() {
         int totalCapacity = 0; //initialize the total capacity 
         for (Car car: this.cars) { //loop through each car in the cars arraylist 
            totalCapacity += car.getCapacity(); //add the capacity to the total capacity 
         }
         return totalCapacity;
    }

    /** Accessor
     * Returns the number of remaining open seats across all cars in the train
     * @return the total number of remaining open seats 
     */
    public int seatsRemaining() {
        int openSeats = 0; //intialize the number of open seats 
        for (Car car: this.cars) { //loop through each car in the cars arraylist 
            openSeats += car.seatsRemaining(); //add the seats remaining to open seats 
        }
        return openSeats;
    } 

    /**
     * Prints a roster of all passengers on board 
     */
    public void printManifest() {
        System.out.println("Passengers Onboard: ");
        for (int i = 0; i < this.cars.size(); i++) {
            this.cars.get(i).printManifest();
        }
    }


    public static void main(String[] args) {
        Train train =  new Train(FuelType.ELECTRIC, 100, 5, 10);

        Passenger p1 = new Passenger("Alice", 30);
        Passenger p2 = new Passenger("Bob", 45);

        train.getCar(0).addPassenger(p1);
        train.getCar(1).addPassenger(p2);

        train.printManifest();

        System.out.println("Max Capacity: " + train.getMaxCapacity());
        System.out.println("Seats Remaining: " + train.seatsRemaining());


    }

}
