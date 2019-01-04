package parkinglot;

import java.util.List;

public class ParkingBoy extends BaseParkingBoy{

    ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Receipt park(Car car) {
        for (int i = 0; i < parkingLots.size(); i++) {
            if (parkingLots.get(i).getAvailableSpaces() > 0) {
                return parkingLots.get(i).park(car);
            }
        }
        throw new ParkingSpacesAreFullException();
    }

}
