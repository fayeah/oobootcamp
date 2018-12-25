package parkinglot;

public class ParkingSpacesAreFullException extends RuntimeException {
  public ParkingSpacesAreFullException() {
    super("NO SPACE IS AVAILABLE");
  }
}
