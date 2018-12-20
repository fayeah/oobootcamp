package dive;

public class Person {
//    private Bike bike;
    private final Car car;

    public Person() {
//        bike = new Bike();
        car = new Car();
    }

    public void goOutside() {
//        bike.drive();
        car.drive();
    }
}
