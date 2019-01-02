package rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void shouldReturn4WhenWidth1Length2() {
        assertEquals(2, new Rectangle(1, 2).getArea());
    }

    @Test
    void shouldReturn4GivenWidth2Length2() {
        assertEquals(4, new Square(2).getArea());
    }
}