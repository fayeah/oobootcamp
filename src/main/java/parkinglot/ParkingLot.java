package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    private int availableSpaces;

    private Map<Receipt, Car> carSpaces = new HashMap<>();

    public ParkingLot(int totalSpaces) {
        this.availableSpaces = totalSpaces;
    }

    public Receipt park(Car car) {
        if (availableSpaces > 0) {
            availableSpaces -= 1;
            Receipt receipt = new Receipt();
            carSpaces.put(receipt, car);
            return receipt;
        }
        throw new ParkingSpacesAreFullException();
    }

    public Car pick(Receipt receipt) {
        if (contains(receipt)) {
            return carSpaces.remove(receipt);
        }
        throw new NoCarFoundByGivenReceiptException();
    }

    public boolean contains(Receipt receipt) {
        return carSpaces.containsKey(receipt);
    }
}
