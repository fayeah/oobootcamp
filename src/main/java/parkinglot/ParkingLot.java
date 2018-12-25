package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

  private int totalSpaces;

  private int availableSpaces;

  private Map<Receipt, Car> carSlots;

  public ParkingLot(int totalSpaces) {
    this.carSlots = new HashMap<>();
    this.totalSpaces = totalSpaces;
    this.availableSpaces = totalSpaces;
  }

  public Receipt printReceipt(Car car) {
    if (availableSpaces > 0) {
      availableSpaces--;
      Receipt receipt = new Receipt();
      carSlots.put(receipt, car);
      return receipt;
    } else {
      throw new ParkingSpacesAreFullException();
    }
  }

  public Car validateCarLeaving(Receipt receipt) {
    resetSpace();
    if(carSlots.containsKey(receipt)) {
      return carSlots.remove(receipt);
    } else {
      throw new NoCarFoundByGivenReceiptException();
    }
  }

  private void resetSpace() {
    availableSpaces++;
  }
}
