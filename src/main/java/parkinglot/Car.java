package parkinglot;

public class Car {

  private ParkingLot parkingLot;

  public Receipt park(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
    return this.parkingLot.printReceipt(this);
  }

  public Car pick(Receipt receipt) {
    return parkingLot.validateCarLeaving(receipt);
  }

}
