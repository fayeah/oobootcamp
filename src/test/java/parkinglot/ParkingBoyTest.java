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

  @Test
  void shouldParkSuccessfulWhenParkingLot1IsFullAndParkingLot2IsAvailable() {
    Car myCar = new Car();
    Car car1 = new Car();
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(2);

    ParkingBoy parkingBoy = new ParkingBoy();

    car1.park(parkingLot1);
    Receipt receipt = parkingBoy.park(myCar, parkingLot2);

    assertNotNull(receipt);
    assertSame(myCar, parkingLot2.locateCar(receipt));
  }
}