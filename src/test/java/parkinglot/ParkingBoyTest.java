package parkinglot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  void shouldParkFailedWhenAllParkingLotAreFull() {
    Car myCar = new Car();
    Car car1 = new Car();
    Car car2 = new Car();
    Car car3 = new Car();
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(1);
    ParkingLot parkingLot3 = new ParkingLot(1);

    ParkingBoy parkingBoy = new ParkingBoy();

    car1.park(parkingLot1);
    car2.park(parkingLot2);
    car3.park(parkingLot3);

    assertThrows(ParkingSpacesAreFullException.class, () -> parkingBoy.park(myCar, parkingLot1));
    assertThrows(ParkingSpacesAreFullException.class, () -> parkingBoy.park(myCar, parkingLot2));
    assertThrows(ParkingSpacesAreFullException.class, () -> parkingBoy.park(myCar, parkingLot3));
  }

  @Test
  void shouldPickCarSuccessfulByParkingBoyWhenMyCarIsInParkingLot1() {
    Car myCar = new Car();
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy();

    parkingLot1.assignToParkingBoy(parkingBoy);

    Receipt receipt = parkingBoy.park(myCar, parkingLot1);

    assertSame(myCar, parkingBoy.pick(receipt));
  }
}