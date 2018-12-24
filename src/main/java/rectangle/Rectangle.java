package rectangle;

public class Rectangle implements Shape{
    private final int height;
    private final int width;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return this.height * this.width;
    }
}
