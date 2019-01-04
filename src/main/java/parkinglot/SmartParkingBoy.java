package parkinglot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {

    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        ParkingLot parkingLotWithMostAvailableSpaces = Collections.max(parkingLots, Comparator.comparing(s -> s.getAvailableSpaces()));
        return parkingLotWithMostAvailableSpaces.park(car);
    }

    public Car pick(Receipt receipt) {
        for(ParkingLot parkingLot : parkingLots){
            if(parkingLot.contains(receipt)){
                return parkingLot.pick(receipt);
            }
        }
        throw new NoCarFoundByGivenReceiptException();
    }
}
