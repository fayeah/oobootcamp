package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy {
    private List<BaseParkingBoy> parkingBoyList = new ArrayList<>();

    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingManager() {
        super(new ArrayList<>());
    }

    void manage(BaseParkingBoy parkingBoy) {
        parkingBoyList.add(parkingBoy);
    }

    Receipt assignParkingCarTaskToParkingBoy(Car car) {
        for (BaseParkingBoy parkingBoy : parkingBoyList) {
            if (parkingBoy.hasAvailableSpace()) {
                return parkingBoy.park(car);
            }
        }
        return this.park(car);
    }
}
