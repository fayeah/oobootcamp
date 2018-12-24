package rectangle;

public class Square implements Shape {

    private final int width;

    public Square(int width) {
        this.width = width;
    }

    @Override
    public int getArea() {
        return this.width * this.width;
    }
}
