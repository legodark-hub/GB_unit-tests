package seminar2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VehicleTest {

    @Test
    public void testCarIsInstanceOfVehicle() {
        Vehicle car = new Car("Лада", "2109", 2000);
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarHasFourWheels() {
        Car car = new Car("Лада", "2109", 2000);
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void testMotorcycleHasTwoWheels() {
        Motorcycle motorcycle = new Motorcycle("ИЖ", "Планета-5", 2000);
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    public void testCarTestDrive() {
        Car car = new Car("Лада", "2109", 2000);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    public void testMotorcycleTestDrive() {
        Motorcycle motorcycle = new Motorcycle("ИЖ", "Планета-5", 2000);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    public void testCarPark() {
        Car car = new Car("Лада", "2109", 2000);
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void testMotorcyclePark() {
        Motorcycle motorcycle = new Motorcycle("ИЖ", "Планета-5", 2000);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }

}
