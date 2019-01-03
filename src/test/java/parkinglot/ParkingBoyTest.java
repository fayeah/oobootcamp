package parkinglot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ParkingBoyTest {

    @Test
    void shouldParkSuccessfulWhenParkingLot1HasAvailableSpaces() {
        Car myCar = new Car();
        ParkingLot parkingLot = new ParkingLot(5);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Receipt receipt = parkingBoy.park(myCar);

        assertNotNull(receipt);
    }

    @Test
    void shouldParkSuccessfulWhenParkingLot1HasAvailableSpaceAndParkingLot2IsAvailable() {
        Car myCar = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Receipt receipt = parkingBoy.park(myCar);

        assertNotNull(receipt);
        assertSame(myCar, parkingLot1.pick(receipt));
    }

    @Test
    void shouldParkAtParkinglot2WhenParkinglot1IsFullWhileParkinglot2IsAvailable() {
        Car myCar = new Car();
        Car car1 = new Car();

        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car1);
        Receipt receipt = parkingBoy.park(myCar);

        assertNotNull(receipt);
        assertSame(myCar, parkingLot2.pick(receipt));
    }

    @Test
    void shouldParkFailedWhenParkinglot1AndParkinglot2BothFull() {
        Car myCar = new Car();
        Car car1 = new Car();
        Car car2 = new Car();

        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car1);
        parkingBoy.park(car2);

        assertThrows(ParkingSpacesAreFullException.class, () -> parkingBoy.park(myCar));
    }
}