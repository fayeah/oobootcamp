package dive;

import Driveable.Drivable;

public class Car implements Drivable {

    @Override
    public void drive() {
        System.out.println("diving a car outside");
    }
}
