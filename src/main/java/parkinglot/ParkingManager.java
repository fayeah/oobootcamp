package parkinglot;

import java.util.ArrayList;
import java.util.Collections;
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

    public Car pick(Receipt receipt) {
        for (BaseParkingBoy parkingBoy : parkingBoyList) {
            if (parkingBoy.contains(receipt)) {
                return parkingBoy.pick(receipt);
            }
        }
        return super.pick(receipt);
    }

    public Receipt park(Car car) {
        Collections.shuffle(parkingBoyList);
        for (BaseParkingBoy parkingBoy : parkingBoyList) {
            if (parkingBoy.hasAvailableSpace()) {
                return parkingBoy.park(car);
            }
        }
        return super.park(car);
    }
}
