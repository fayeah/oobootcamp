package replaceRecordWithDataClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void should_return0_given_O_blood_person() {
        assertEquals(0, new Person(BloodGroup.O).getBloodGroup().getCode());

//        assertEquals(0, new Person(BloodGroup.O).getBloodGroupCode());
    }

    @Test
    void should_return1_given_A_blood_person_is_set() {
        Person person = new Person(BloodGroup.O);
        person.setBloodGroup(1);
        person.setBloodGroup(BloodGroup.A);

//        assertEquals(1, person.getBloodGroupCode());

        assertEquals(1, person.getBloodGroup().getCode());
    }
}