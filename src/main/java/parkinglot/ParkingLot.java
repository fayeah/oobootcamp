package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

  private int availableSpaces;

  private Map<Receipt, Car> carSpaces;

  public ParkingLot(int totalSpaces) {
    this.carSpaces = new HashMap<>();
    this.availableSpaces = totalSpaces;
  }

  public boolean isAvailable() {
    return availableSpaces > 0;
  }

  public Receipt printReceipt(Car car) {
    if (availableSpaces > 0) {
      availableSpaces--;
      Receipt receipt = new Receipt();
      carSpaces.put(receipt, car);
      return receipt;
    } else {
      throw new ParkingSpacesAreFullException();
    }
  }

  public Car validateCarLeaving(Receipt receipt) {
    resetSpace();
    if(carSpaces.containsKey(receipt)) {
      return carSpaces.remove(receipt);
    } else {
      throw new NoCarFoundByGivenReceiptException();
    }
  }

  public Car locateCar(Receipt receipt) {
    return carSpaces.getOrDefault(receipt, null);
  }

  private void resetSpace() {
    availableSpaces++;
  }
}
