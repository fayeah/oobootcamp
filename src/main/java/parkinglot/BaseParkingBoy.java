package parkinglot;

import java.util.List;

public abstract class BaseParkingBoy {

    protected List<ParkingLot> parkingLots;

    public BaseParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    abstract Receipt park(Car car);

    public Car pick(Receipt receipt) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.contains(receipt)) {
                return parkingLot.pick(receipt);
            }
        }
        throw new NoCarFoundByGivenReceiptException();
    }

    protected  boolean contains(Receipt receipt){
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.contains(receipt)) {
                return true;
            }
        }
        return false;
    }

    protected boolean hasAvailableSpace() {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasAvailableSpace()) {
                return true;
            }
        }
        return false;
    }
}
