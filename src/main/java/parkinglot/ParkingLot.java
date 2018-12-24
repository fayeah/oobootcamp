package parkinglot;

public class ParkingLot {
    private int totalSpaces = 5;

    public int getTotalSpaces() {
        return totalSpaces;
    }

    private int availableSpaces = totalSpaces;

    private boolean isSpaceAvailable = true;

    public Object getReceipt() {
        if(availableSpaces > 0) {
            availableSpaces--;
            return new Receipt();
        }
        return null;
    }
}
