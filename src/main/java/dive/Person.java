package dive;

public class Person {
    private final Drivable drivable;

    public Person(Drivable drivable) {
        this.drivable = drivable;
    }

    public void goOutside() {
        drivable.drive();
    }
}
