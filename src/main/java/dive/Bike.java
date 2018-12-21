package dive;

import Driveable.Drivable;

public class Bike implements Drivable {
    @Override
    public void drive() {
        System.out.println("biking outside");
    }
}
