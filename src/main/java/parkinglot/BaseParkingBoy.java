package parkinglot;

import java.util.List;

public abstract class BaseParkingBoy {

    protected List<ParkingLot> parkingLots;

    public BaseParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    abstract Receipt park(Car car);

    public Car pick(Receipt receipt) {
        for(ParkingLot parkingLot : parkingLots){
            if(parkingLot.contains(receipt)){
                return parkingLot.pick(receipt);
            }
        }
        throw new NoCarFoundByGivenReceiptException();
    }
}
