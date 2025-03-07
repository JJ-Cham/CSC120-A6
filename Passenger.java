public class Passenger implements PassengerRequirements {
    
    //Attributes 
    private String name;
    private int age; 

    /**
     * Constructor 
     * @param name - passenger's name 
     * @param age - passenger's age 
     */
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    } 

     /**
      * Boards a passenger to the car if it is not full 
      * @param c The car that the passenget is being boarded onto
      */
    public void boardCar(Car c) {
        if (c.addPassenger(this)) {
            System.out.println(this.name + " has boarded the car.");
        }

        else {
            System.out.println("This car is full. " + this.name + " cannot board the car.");
        }
        }
    
        /**
         * Passenger gets off car if they are not already on it  
         * @param c The car the passenger is getting off of. 
         */
    public void getOffCar(Car c) {
        if (c.removePassenger(this)) {
            System.out.println(this.name + " has gotten off the car.");;
        }
        
        else {
            System.out.println(this.name + " is not on board");
        }
    }

    public String toString() {
        return "Passenger: Name = " + this.name + " Age = " + this.age;
    } 

    


    public static void main(String[] args) {
        // Creates a Car with capacity 2
        Car myCar = new Car(1);
        System.out.println(myCar); // Should print: "Car Capacity: 2, Occupied Seats: 0"
    
        // Creates Passengers
        Passenger p1Passenger = new Passenger("Alice", 10);
        Passenger p2Passenger = new Passenger("Bob", 40);

        //board car 
        p1Passenger.boardCar(myCar);
        System.out.println(p1Passenger);

        p2Passenger.boardCar(myCar);
        System.out.println(p2Passenger);

        //get off car 
        p1Passenger.getOffCar(myCar);
        System.out.println(p1Passenger);

        p2Passenger.getOffCar(myCar);
        System.out.println(p2Passenger);

    }


}
