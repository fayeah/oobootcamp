package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

  private List<ParkingLot> parkingLots = new ArrayList<>();

  public void addParkingLots(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Receipt park(Car myCar) {
    for(ParkingLot parkingLot : parkingLots) {
      if(parkingLot.isAvailable()) {
        return myCar.park(parkingLot);
      }
    }
    throw new ParkingSpacesAreFullException();
  }

  public Car pick(Receipt receipt) {
    for(ParkingLot parkingLot : parkingLots) {
      if(null != parkingLot.locateCar(receipt)) {
        return parkingLot.validateCarLeaving(receipt);
      }
    }
    throw new NoCarFoundByGivenReceiptException();
  }
}
