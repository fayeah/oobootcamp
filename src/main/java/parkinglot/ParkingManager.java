package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends BaseParkingBoy {
    private BaseParkingBoy parkingBoy;

    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingManager() {
        super(new ArrayList<>());
    }

    @Override
    Receipt park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.park(car);
        }
        return null;
    }

    void manage(BaseParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    Receipt assignParkingCarTaskToParkingBoy(Car car) {
        return parkingBoy.park(car);
    }
}
