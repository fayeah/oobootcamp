package refactorOrganizeData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SelfEncapsulateFieldTest {

    @Test
    void shouldReturnTrueGivenNumberBetweenLowAndHigh() {
        SelfEncapsulateField selfEncapsulateField = new SelfEncapsulateField(1, 4);

        assertEquals(selfEncapsulateField.includes(3), true);
    }

    @Test
    void shouldReturnFalseGivenNumberNotBetweenLowAndHigh() {
        SelfEncapsulateField selfEncapsulateField = new SelfEncapsulateField(1, 4);

        assertEquals(selfEncapsulateField.includes(0), false);
    }

    @Test
    void shouldReturnTrueGivenNumberNotBetweenLowAndHigh() {
        SelfEncapsulateField selfEncapsulateField = new SelfEncapsulateField(1, 4);

        assertEquals(selfEncapsulateField.includes(0), false);
    }
}
