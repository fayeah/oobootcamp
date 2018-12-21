package dive;

import Driveable.Drivable;

public class Person {
//    private Bike bike;
//    private final Car car;
    private final Drivable drivable;

    public Person() {
//        bike = new Bike();
//        car = new Car();
        drivable = new Bike();
    }

    public void goOutside() {
//        bike.drive();
//        car.drive();
        drivable.drive();
    }
}
