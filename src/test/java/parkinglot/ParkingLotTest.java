package parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingLotTest {
    @Test
    void shouldParkSuccessfullyWhenParkingSpaceIsAvailable() {
        ParkingLot parkingLot = new ParkingLot();
        assertNotNull(parkingLot.getReceipt());
    }

    @Test
    void shouldParkFailedWhenParkingSpaceIsNotAvailable() {
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 0;i< parkingLot.getTotalSpaces();i++) {
            parkingLot.getReceipt();
        }
        assertNull(parkingLot.getReceipt());
    }
}
