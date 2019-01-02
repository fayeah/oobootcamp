import drive.Car;
import drive.Person;

// main 即为IoC容器，在DI概念中称为注射器
public class main {
    public static void main(String[] args) {
        Car car = new Car();
        Person person = new Person(car);
        person.goOutside();
    }
}
