package parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {

  @Test
  void shouldParkSuccessfullyWhenParkingSpaceIsAvailable() {
    Car car = new Car();

    ParkingLot parkingLot = new ParkingLot(5);

    Receipt receipt = parkingLot.park(car);

    assertNotNull(receipt);
  }

  @Test
  void shouldParkFailedWhenParkingSpaceIsNotAvailable() {
    Car car = new Car();

    ParkingLot parkingLot = new ParkingLot(1);

    parkingLot.park(car);

    Car myCar = new Car();

    assertThrows(ParkingSpacesAreFullException.class, () -> parkingLot.park(myCar));
  }

  @Test
  void shouldPickCarSuccessfulWhenOnlyMyCarIsInParkingLotAndIHaveReceipt() {
    Car myCar = new Car();

    ParkingLot parkingLot = new ParkingLot(1);

    Receipt receipt = parkingLot.park(myCar);

    assertSame(myCar, parkingLot.pick(receipt));
  }

  @Test
  void shouldPickCarSuccessfulWhenNotOnlyMyCarIsInParkingLot() {
    Car myCar = new Car();
    Car car1 = new Car();
    Car car2 = new Car();

    ParkingLot parkingLot = new ParkingLot(5);

    Receipt receipt = parkingLot.park(myCar);
    parkingLot.park(car1);
    parkingLot.park(car2);

    assertSame(myCar, parkingLot.pick(receipt));
  }

  @Test
  void shouldPickCarFailedWhenSameParkingReceiptIsUsedTwice() {
    Car myCar = new Car();

    ParkingLot parkingLot = new ParkingLot(5);

    Receipt receipt = parkingLot.park(myCar);

    parkingLot.pick(receipt);

    assertThrows(NoCarFoundByGivenReceiptException.class, () -> parkingLot.pick(receipt));
  }

  @Test
  void shouldPickCarFailedWhenInvalidReceiptIsUsed() {
    Car myCar = new Car();

    ParkingLot parkingLot = new ParkingLot(5);

    parkingLot.park(myCar);

    assertThrows(NoCarFoundByGivenReceiptException.class, () -> parkingLot.pick(new Receipt()));
  }
}
