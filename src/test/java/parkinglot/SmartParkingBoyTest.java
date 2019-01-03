package parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {
    @Test
    void shouldParkSuccessfullyWhenOneParkinglotIsAvailable() {
        Car myCar = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Receipt receipt = smartParkingBoy.park(myCar);
        assertNotNull(receipt);
    }

    @Test
    void shouldParkAtParkinglot1WhenParkinglot1HasMoreAvailableSpacesThanParkinglot2() {
        Car myCar = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Receipt receipt = smartParkingBoy.park(myCar);

        assertNotNull(receipt);
        assertSame(myCar, parkingLot1.pick(receipt));
    }

    @Test
    void shouldParkAtParkinglot1WhenParkinglot2HasMoreAvailableSpacesThanParkinglot1() {
        Car myCar = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Receipt receipt = smartParkingBoy.park(myCar);

        assertNotNull(receipt);
        assertSame(myCar, parkingLot2.pick(receipt));
    }

    @Test
    void shouldParkFailedWhenBothParkinglotAreFull() {
        Car myCar = new Car();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);

        assertThrows(ParkingSpacesAreFullException.class, () -> smartParkingBoy.park(myCar));
    }

    @Test
    void shouldParkFailedWhenBothParkinglotHaveTheSameAvailableSpaces() {
        Car myCar = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Receipt receipt = smartParkingBoy.park(myCar);

        assertNotNull(receipt);
        assertSame(myCar, parkingLot1.pick(receipt));
    }

}
