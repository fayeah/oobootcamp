package parkinglot;

public class NoCarFoundByGivenReceiptException extends RuntimeException {

  public NoCarFoundByGivenReceiptException() {
    super("NO CAR WAS FOUND BY GIVEN RECEIPT");
  }

}
