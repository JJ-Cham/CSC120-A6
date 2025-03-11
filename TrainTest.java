import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TrainTest {

    // Engine Tests
    /**
     * Tests the Engine constructor to verify that it initializes the correct 
     * fuel type, current fuel level, and max fuel level.
     */
    @Test
    public void testEngineConstructor() {

        //definitions
        FuelType expectedFuelType = FuelType.STEAM;
        double expectedCurrentFuelLevel = 35.0;
        double expectedMaxFuelLevel = 100.0;


        Engine engine = new Engine(expectedFuelType, expectedCurrentFuelLevel, expectedMaxFuelLevel);

        assertEquals(expectedFuelType, engine.getFuelType());
        assertEquals(expectedCurrentFuelLevel, engine.getCurrentFuel(), 0.0);
        assertEquals(expectedMaxFuelLevel, engine.getMaxFuel(), 0.0);
    }
        //fail();
    
    /**
     * Tests the go() method of the Engine class to ensure that 
     * the engine is properly initialized and fuel values are correctly set.
     */
    @Test
    public void testEngineGo() {

        FuelType expectedFuelType = FuelType.STEAM;
        double expectedCurrentFuelLevel = 35.0;
        double expectedMaxFuelLevel = 100.0;


        Engine engine = new Engine(expectedFuelType, expectedCurrentFuelLevel, expectedMaxFuelLevel);
        assertNotNull("Engine shouldn't be null.", engine);
        assertEquals("Current fuel level should be 35.0", expectedCurrentFuelLevel, engine.getCurrentFuel(), 0.0);
        assertEquals("Max fuel level should be 100.0", expectedMaxFuelLevel, engine.getMaxFuel(), 0.0);
        assertEquals("The fuel type should be set correctly", expectedFuelType, engine.getFuelType());
        //fail();
    }

    // Car Tests
    /**
     * Tests the addPassenger() method to ensure passengers can be added 
     * up to the maximum capacity and that no extra passengers can be added beyond that.
     */
    @Test
    public void testCarAddPassenger() {

        Car maxCapacity = new Car(2);

        Passenger p = new Passenger("Dawud Cham", 6);
        Passenger p2 = new Passenger("JJ Cham", 18);
        Passenger p3 = new Passenger("Nazifa Ahmed", 18);


        assertTrue("Passenger should be added", maxCapacity.addPassenger(p));
        assertTrue("Passenger should be added", maxCapacity.addPassenger(p2));
        assertFalse("Passenger should not be added", maxCapacity.addPassenger(p3));

        //fail();
    }

    /**
     * Tests the removePassenger() method to ensure passengers can be removed 
     * from the car and that no passengers can be removed if they are not on the car.
     */
    @Test
    public void testCarRemovePassenger() {
        Car maxCapacity = new Car(1);

        Passenger p = new Passenger("Dawud Cham", 6);
        Passenger p2 = new Passenger("JJ Cham", 18);

        maxCapacity.addPassenger(p);
        assertTrue("Passenger should be removed", maxCapacity.removePassenger(p));
        assertFalse("Passenger should not be removed", maxCapacity.removePassenger(p2));
        //fail();
    }

    // Passenger Tests
    /**
     * Tests the Passenger constructor to ensure that the name and age are correctly set.
     */
    @Test
    public void testPassengerBoardCarWithSpace() {
       
        Car car = new Car(2);

        Passenger p = new Passenger("Dawud Cham", 6);
        Passenger p2 = new Passenger("JJ Cham", 18);
        Passenger p3 = new Passenger("Nazifa Ahmed", 18);

        // Passenger 1 should successfully board
        p.boardCar(car);
        assertEquals("One seat should be left after the first passenger boards.", 1, car.seatsRemaining());

        // Passenger 2 should successfully board
        p2.boardCar(car);
        assertEquals("No seats should be left after the second passenger boards.", 0, car.seatsRemaining());

        // Passenger 3 should not be able to board (car is full)
        p3.boardCar(car);
        assertEquals("No seats should be available, so passenger 3 should not board.", 0, car.seatsRemaining());

        int passengersOnboard = car.getCapacity() - car.seatsRemaining();
        assertEquals("Car should have exactly 2 passengers onboard.", 2, passengersOnboard);

        //fail();
    }

    /**
     * Tests the scenario where a passenger attempts to board a car that is already full.
     * Verifies that no seats are available and the passenger cannot board.
     */
    @Test
    public void testPassengerBoardCarFull() {

        //create a car with 0 seats 
        Car car = new Car(0);

        //create a passenger 
        Passenger p1 = new Passenger("JJ Cham", 18);

        //attempt to board the passenger 
        p1.boardCar(car);
        
        //assert that the car is full and no passengers can board  
        assertEquals("No seats are available since car is full so passenger 1 should not be able to board.", 0, car.seatsRemaining());

        //fail();
    }

    // Train Tests

    /**
     * Tests the Train constructor to ensure it initializes correctly.
     * Verifies that the Engine and Cars are initialized with the correct properties.
     */
    @Test
    public void testTrainConstructor() {
        //definitions
        FuelType fuelType = FuelType.ELECTRIC;
        double fuelCapacity = 100.00;
        int nCars = 5;
        int passengerCapacity = 3;

        //create a new train 
        Train train = new Train(fuelType, fuelCapacity, nCars, passengerCapacity);

        //create engine/test the engine 
        Engine engine = train.getEngine();

        //verify that the engine's fuel type matches the input fuel type
        assertEquals("The engines fuel types should match", fuelType, engine.getFuelType());

        //verify that each car in the train has the correct passenger capacity
        assertEquals("The number of cars should match", nCars, train.getCars().size());
        for (Car car : train.getCars()) {
            assertEquals("Each car's capacity should match.", passengerCapacity, car.getCapacity());
        }

        //fail();
    }

    /**
     * Tests the Train's passenger count functionality.
     * Verifies that the total passenger count updates correctly as passengers board and leave.
     */
    @Test
    public void testTrainPassengerCount() {
        //definitions
        FuelType fuelType = FuelType.ELECTRIC;
        double fuelCapacity = 100.00;
        int nCars = 5;
        int passengerCapacity = 3;


        //create a new train and passenger 
        Train train = new Train(fuelType, fuelCapacity, nCars, passengerCapacity);
        Passenger p1 = new Passenger("JJ Cham", 18);
        Passenger p2 = new Passenger("Nazifa Ahmed", 18);

        //add passengers to cars 
        train.getCar(0).addPassenger(p1);
        train.getCar(1).addPassenger(p2);

        //verify that the total number of seats remaining is correct after adding passengers
        assertEquals("Passenger count should be 2", 13, train.seatsRemaining());

        //remove the passenger 
        train.getCar(0).removePassenger(p1);

        //verify tthat the toal number of seats is correct after removing a passenger 
        assertEquals("Total passenger count should be 1 now after removing p1.", 14, train.seatsRemaining());

        //fail();
    }

    /**
     * Tests the getCar(int i) method of the Train class.
     * Verifies that the method returns the expected Car object and that the Car's properties are correct.
     */
    @Test
    public void testTrainGetCar() {
        //define terms 
        FuelType fuelType = FuelType.ELECTRIC;
        double fuelCapacity = 100.00;
        int nCars = 5;
        int passengerCapacity = 3;

        //create a train
        Train train = new Train(fuelType, fuelCapacity, nCars, passengerCapacity);


        
        Car firstCar = train.getCar(0); //get the first car from the train 
        assertNotNull("The first car should not be null", firstCar); //check first car isn't null
        assertEquals("The first car's capacity should match", passengerCapacity, firstCar.getCapacity()); //verify that the first car's capacity matches the input passenger capacity

        //get the last car from the train
        Car lastCar = train.getCar(nCars - 1);

        
        assertNotNull("The last car should not be null.", lastCar); //check that the last car is not null
        assertEquals("The last car's capacity should match.", passengerCapacity, lastCar.getCapacity()); //check that the last car's capacity matches the input passenger capacity

        //fail();
    }

    /**
     * Tests the printManifest() method of the Train class.
     * Verifies that the method correctly prints the list of passengers onboard.
     */
    @Test
    public void testTrainPrintManifest() {
        //definitions
        FuelType fuelType = FuelType.ELECTRIC;
        double fuelCapacity = 100.00;
        int nCars = 5;
        int passengerCapacity = 3;

        //create a new train and passengers 
        Train train = new Train(fuelType, fuelCapacity, nCars, passengerCapacity);
        Passenger p1 = new Passenger("JJ Cham", 18);
        Passenger p2 = new Passenger("Nazifa Ahmed", 18);

        //add first and second passenger to cars 
        train.getCar(0).addPassenger(p1); 
        train.getCar(1).addPassenger(p2);

       //to redirect system.out to capture the printed output in the console 
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; //to save the original System.out
        System.setOut(new PrintStream(outputStream)); //to redirect System.out to outputStream 

        train.printManifest();

        //puts System.out back to its original state
        System.setOut(originalOut);

        //string to convert the captured output
        String printedOutput = outputStream.toString();

        //verify that the printed output contains the passenger names
        assertTrue("Manifest should contain JJ.", printedOutput.contains("JJ"));
        assertTrue("Manifest should contain Nazifa.", printedOutput.contains("Nazifa"));
    
        //fail();
    }
    
}
