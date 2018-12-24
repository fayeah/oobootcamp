package length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthTest {

    @Test
    void shouldReturn1WhenInputLengthIsBiggerThanTargetWithUnit() {
        Length length = new Length(10, Unit.KILOMETER);
        Length target = new Length(10, Unit.METER);

        LengthComparator lengthComparator = new LengthComparator();

        assertEquals(1, lengthComparator.compare(length, target));
    }

    @Test
    void shouldReturn1WhenInputUnitIsKmITargetWithUnit() {
        Length length = new Length(10, Unit.METER);
        Length target = new Length(10, Unit.MILLIMETER);

        LengthComparator lengthComparator = new LengthComparator();

        assertEquals(1, lengthComparator.compare(length, target));
    }
}
