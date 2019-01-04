package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy {
    private BaseParkingBoy parkingBoy;

    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingManager() {
        super(new ArrayList<>());
    }

    void manage(BaseParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    Receipt assignParkingCarTaskToParkingBoy(Car car) {
        if (parkingBoy.hasAvailableSpace()) {
            return parkingBoy.park(car);
        }
        return this.park(car);
    }
}
