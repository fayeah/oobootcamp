package parkinglot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends BaseParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Receipt park(Car car) {
        ParkingLot parkingLotWithMostAvailableSpaces = Collections.max(parkingLots, Comparator.comparing(s -> s.getAvailableSpaces()));
        return parkingLotWithMostAvailableSpaces.park(car);
    }

}
