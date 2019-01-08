package parkinglot;

import java.util.Collections;
import java.util.List;

public class ParkingBoy extends BaseParkingBoy {

    ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Receipt park(Car car) {
        Collections.shuffle(parkingLots);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasAvailableSpace()) {
                return parkingLot.park(car);
            }
        }
        throw new ParkingSpacesAreFullException();
    }

}
