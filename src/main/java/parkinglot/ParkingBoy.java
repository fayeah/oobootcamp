package parkinglot;

import java.util.List;

public class ParkingBoy {

    List<ParkingLot> parkingLots;

    ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public Receipt park(Car car) {
        Receipt receipt = new Receipt();
        for(int i = 0; i < parkingLots.size(); i++) {
            if (parkingLots.get(i).getAvailableSpaces() > 0) {
                return parkingLots.get(i).park(car);
            }
        }
        // VARIABLE USED IN LAMBDA EXPRESSION SHOULD BE FINAL OR EFFECTIVELY FINAL
//        parkingLots.forEach(parkingLot -> {
//            if (parkingLot.getAvailableSpaces() > 0) {
//                receipt = parkingLot.park(car);
//            }
//        });
        throw new ParkingSpacesAreFullException();
    }

    public Car pick(Receipt receipt) {
        for (ParkingLot parkingLot : parkingLots) {
            if (null != parkingLot.locateCar(receipt)) {
                return parkingLot.validateCarLeaving(receipt);
            }
        }
        throw new NoCarFoundByGivenReceiptException();
    }
}
