package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

  List<ParkingLot> parkingLots = new ArrayList<>();

  public void addParkingLot(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
  }

  public Receipt park(Car myCar, ParkingLot parkingLot1) {
    return myCar.park(parkingLot1);
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
