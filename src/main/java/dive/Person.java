package dive;

public class Person {
    private Bike bike;

    public Person() {
        bike = new Bike();
    }

    public void goOutside() {
        bike.drive();
    }
}
