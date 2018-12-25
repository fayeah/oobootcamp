package parkinglot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class ParkingBoyTest {

  @Test
  void shouldParkSuccessfulWhenParkingLog1HasAvailableSpaces() {
    Car myCar = new Car();
    ParkingLot parkingLot1 = new ParkingLot(5);
    ParkingBoy parkingBoy = new ParkingBoy();

    Receipt receipt = parkingBoy.park(myCar, parkingLot1);

    assertNotNull(receipt);
    assertSame(myCar, parkingLot1.locateCar(receipt));
  }

}