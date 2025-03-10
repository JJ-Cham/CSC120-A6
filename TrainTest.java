import static org.junit.Assert.*;
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

    @Test
    public void testPassengerBoardCarFull() {
        //fail();
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        //fail();
    }

    @Test
    public void testTrainPassengerCount() {
        //fail();
    }

    @Test
    public void testTrainGetCar() {
        //fail();
    }

    @Test
    public void testTrainPrintManifest() {
        //fail();
    }
    
}
