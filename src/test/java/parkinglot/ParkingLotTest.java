package parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {

  @Test
  void shouldParkSuccessfullyWhenParkingSpaceIsAvailable() {
    Car car = new Car();

    ParkingLot parkingLot = new ParkingLot(5);

    Ticket receipt = car.park(parkingLot);

    assertNotNull(receipt);
  }

  @Test
  void shouldParkFailedWhenParkingSpaceIsNotAvailable() {
    Car car = new Car();

    ParkingLot parkingLot = new ParkingLot(1);

    car.park(parkingLot);

    Car myCar = new Car();

    assertThrows(ParkingSpacesAreFullException.class, () -> myCar.park(parkingLot));
  }

  @Test
  void shouldPickCarSuccessfulWhenOnlyMyCarIsInParkingLotAndIHaveReceipt() {
    Car myCar = new Car();

    ParkingLot parkingLot = new ParkingLot(1);

    Ticket receipt = myCar.park(parkingLot);

    assertSame(myCar, myCar.pick(receipt));
  }

  @Test
  void shouldPickCarSuccessfulWhenNotOnlyMyCarIsInParkingLot() {
    Car myCar = new Car();
    Car car1 = new Car();
    Car car2 = new Car();

    ParkingLot parkingLot = new ParkingLot(5);

    Ticket receipt = myCar.park(parkingLot);
    car1.park(parkingLot);
    car2.park(parkingLot);

    assertSame(myCar, myCar.pick(receipt));
  }

  @Test
  void shouldPickCarFailedWhenSameParkingReceiptIsUsedTwice() {
    Car myCar = new Car();

    ParkingLot parkingLot = new ParkingLot(5);

    Ticket receipt = myCar.park(parkingLot);

    myCar.pick(receipt);

    assertThrows(NoCarFoundByGivenReceiptException.class, () -> myCar.pick(receipt));
  }
}
