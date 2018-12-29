package parkinglot;

public class Car {

  private ParkingLot parkingLot;

  public Ticket park(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
    return this.parkingLot.printReceipt(this);
  }

  public Car pick(Ticket receipt) {
    return parkingLot.validateCarLeaving(receipt);
  }

}
