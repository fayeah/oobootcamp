package parkinglot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParkingBoyTest {

  @Test
  void shouldParkSuccessfulWhenParkingLog1HasAvailableSpaces() {
    Car myCar = new Car();
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLot1 = new ParkingLot(5);
    parkingLots.add(parkingLot1);

    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.addParkingLots(parkingLots);

    Receipt receipt = parkingBoy.park(myCar);

    assertNotNull(receipt);
    assertSame(myCar, parkingLot1.locateCar(receipt));
  }

  @Test
  void shouldParkSuccessfulWhenParkingLot1IsFullAndParkingLot2IsAvailable() {
    Car myCar = new Car();
    Car car1 = new Car();

    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(2);
    parkingLots.add(parkingLot1);
    parkingLots.add(parkingLot2);

    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.addParkingLots(parkingLots);

    car1.park(parkingLot1);
    Receipt receipt = parkingBoy.park(myCar);

    assertNotNull(receipt);
    assertSame(myCar, parkingLot2.locateCar(receipt));
  }

  @Test
  void shouldParkFailedWhenAllParkingLotAreFull() {
    Car myCar = new Car();
    Car car1 = new Car();
    Car car2 = new Car();
    Car car3 = new Car();

    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(1);
    ParkingLot parkingLot3 = new ParkingLot(1);
    parkingLots.add(parkingLot1);
    parkingLots.add(parkingLot2);
    parkingLots.add(parkingLot3);

    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.addParkingLots(parkingLots);

    car1.park(parkingLot1);
    car2.park(parkingLot2);
    car3.park(parkingLot3);

    assertThrows(ParkingSpacesAreFullException.class, () -> parkingBoy.park(myCar));
    assertThrows(ParkingSpacesAreFullException.class, () -> parkingBoy.park(myCar));
    assertThrows(ParkingSpacesAreFullException.class, () -> parkingBoy.park(myCar));
  }

  @Test
  void shouldPickCarSuccessfulByParkingBoyWhenMyCarIsInParkingLot1() {
    Car myCar = new Car();

    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLot1 = new ParkingLot(1);
    parkingLots.add(parkingLot1);

    ParkingBoy parkingBoy = new ParkingBoy();
    parkingBoy.addParkingLots(parkingLots);

    Receipt receipt = parkingBoy.park(myCar);

    assertSame(myCar, parkingBoy.pick(receipt));
  }
}